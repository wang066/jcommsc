package cn.jcomm.test.thridpack.genid;

import java.util.Random;

/**
 * Created by jowang on 2017/4/19 0019.
 * 1.单服务器id
 * <p>
 * 2.分布式id
 *
 * 【常见方法一：使用数据库的 auto_increment 来生成全局唯一递增ID】
 * 【常见方法二：单点批量ID生成服务】
 * 【常见方法三：uuid】
 * 【常见方法四：取当前毫秒数】
 * 【常见方法五：类snowflake算法】
 */
public class IDUtils {

    private static SnowFlake snowFlake = new SnowFlake(2, 3);

    private IDUtils() {

    }

    /**
     * 生成 currentTimeMillis + random 8805 8222 7475
     */
    public static long genByRandom() {
        //取当前时间的长整形值包含毫秒
        String millis = System.currentTimeMillis() + "";

        millis = millis.substring(5, millis.length());
        //加上四位随机数
        Random random = new Random();
        int end4 = random.nextInt(9999);
        //如果不足两位前面补0
        String str = String.format("%04d", end4);

        return Long.parseLong(millis + str);
    }

    /**
     * Twitter的雪花算法SnowFlake，使用Java语言实现。
     */
    public static long genBySnowFlake() {
        return snowFlake.nextId();
    }


    /**
     * twitter的snowflake算法 -- java实现
     *
     *
     * Twitter_Snowflake<br>
     * SnowFlake的结构如下(每部分用-分开):<br>
     * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000 <br>
     * 1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0<br>
     * 41位时间截(毫秒级)，注意，41位时间截不是存储当前时间的时间截，而是存储时间截的差值（当前时间截 - 开始时间截)
     * 得到的值），这里的的开始时间截，一般是我们的id生成器开始使用的时间，由我们程序来指定的（如下下面程序IdWorker类的startTime属性）。41位的时间截，可以使用69年，年T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
     * 10位的数据机器位，可以部署在1024个节点，包括5位datacenterId和5位workerId<br>
     * 12位序列，毫秒内的计数，12位的计数顺序号支持每个节点每毫秒(同一机器，同一时间截)产生4096个ID序号<br>
     * 加起来刚好64位，为一个Long型。<br>
     * SnowFlake的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞(由数据中心ID和机器ID作区分)，并且效率较高，经测试，SnowFlake每秒能够产生26万ID左右。
     *
     * @author
     * @date 2016/11/26
     */
    private static class SnowFlake {

        /**
         * 起始的时间戳
         */
        private final static long START_STMP = 1480166465631L;

        /**
         * 每一部分占用的位数
         */
        private final static long SEQUENCE_BIT = 12; //序列号占用的位数
        private final static long MACHINE_BIT = 5;   //机器标识占用的位数
        private final static long DATACENTER_BIT = 5;//数据中心占用的位数

        /**
         * 每一部分的最大值
         */
        private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
        private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);
        private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

        /**
         * 每一部分向左的位移
         */
        private final static long MACHINE_LEFT = SEQUENCE_BIT;
        private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
        private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

        private long datacenterId;  //数据中心
        private long machineId;     //机器标识
        private long sequence = 0L; //序列号
        private long lastStmp = -1L;//上一次时间戳

        public SnowFlake(long datacenterId, long machineId) {
            if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
                throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
            }
            if (machineId > MAX_MACHINE_NUM || machineId < 0) {
                throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
            }
            this.datacenterId = datacenterId;
            this.machineId = machineId;
        }

        /**
         * 产生下一个ID
         * 2017-4-19 16:19:06
         * @return
         */
        public synchronized long nextId() {
            long currStmp = getNewstmp();
            if (currStmp < lastStmp) {
                throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
            }

            if (currStmp == lastStmp) {
                //相同毫秒内，序列号自增
                sequence = (sequence + 1) & MAX_SEQUENCE;
                //同一毫秒的序列数已经达到最大
                if (sequence == 0L) {
                    currStmp = getNextMill();
                }
            } else {
                //不同毫秒内，序列号置为0
                sequence = 0L;
            }

            lastStmp = currStmp;

            return (currStmp - START_STMP) << TIMESTMP_LEFT //时间戳部分
                    | datacenterId << DATACENTER_LEFT       //数据中心部分
                    | machineId << MACHINE_LEFT             //机器标识部分
                    | sequence;                             //序列号部分
        }

        private long getNextMill() {
            long mill = getNewstmp();
            while (mill <= lastStmp) {
                mill = getNewstmp();
            }
            return mill;
        }

        /**
         * 可以改进为automic
         * @return
         */
        private long getNewstmp() {
            return System.currentTimeMillis();
        }

//        public static void main(String[] args) {
//            SnowFlake snowFlake = new SnowFlake(2, 3);
//
//            for (int i = 0; i < (1 << 12); i++) {
//                System.out.println(snowFlake.nextId());
//            }
//
//        }
    }
}
