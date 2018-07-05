package cn.jcomm.common;

/**
 * 分布式ID生成器
 *
 */
public class IDGenerator {

    private final long twepoch = 1288834974657L;//唯一时间随机量
    private final long workerIdBits = 5L;//机器码字节数
    private final long datacenterIdBits = 5L;//数据字节数
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);//最大机器ID
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);//最大数据ID
    private final long sequenceBits = 12L;
    private final long workerIdShift = sequenceBits;//机器码数据左移位数，就是后面计数器占用的位数
    private final long dataCenterIdShift = sequenceBits + workerIdBits;
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;//时间戳左移动位数就是机器码+计数器总字节数+数据字节数
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);//一微秒内可以产生计数，如果达到该值则等到下一微妙在进行生成

    private long workerId;//机器ID
    private long dataCenterId;//数据ID
    private long sequence = 0L;//计数从零开始
    private long lastTimestamp = -1L;//最后时间戳
    private static final IDGenerator DEFAULT_GENERATOR = new IDGenerator(0,0);

    public IDGenerator(long workerId, long dataCenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (dataCenterId > maxDatacenterId || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("dataCenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - twepoch) << timestampLeftShift) | (dataCenterId << dataCenterIdShift) | (workerId << workerIdShift) | sequence;
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    private static String getTraceId(String serviceName){
        StringBuffer sb = new StringBuffer(serviceName);
        sb.append(DEFAULT_GENERATOR.nextId());
        return sb.toString();
    }
}
