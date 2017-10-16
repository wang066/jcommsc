package cn.jcomm.test.thridpack.packtest.netty.letty;

/**
 * Created by jowang on 2017/5/16 0016.
 */
public final class ServerConfig {

    private static boolean isInit = false;

    /**
     * 端口号
     */
    private static int PORT = 8080;

    /**
     * 读空闲（单位毫秒）
     */
    private static int idleReader = 30 * 1000;

    /**
     * reactor 线程数 一般指定系统线程数 0表示默认
     */
    private static int maxAcceptorThreads = 0;

    /**
     * io处理线程数 0表示吗默认
     */
    private static int maxWorkerThreads = 0;

    /**
     * 最大业务逻辑处理线程 0表示默认
     */
    private static int maxBusinessThreads = 0;

    /**
     * 最大内容长度
     */
    private static int maxContentLength = 65536;


    private ServerConfig() {

    }

    public static void load(String resoucePath) {

    }

}
