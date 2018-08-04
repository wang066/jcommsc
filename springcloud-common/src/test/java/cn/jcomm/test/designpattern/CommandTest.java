package cn.jcomm.test.designpattern;

/**
 * @author: jowang
 * @date: 2018-07-07 21:42
 * @description: 命令模式
 */
public class CommandTest {
    public static void main(String[] args) {
        // 创建接收者
        Receiver receiver = new Receiver();
        // 创建命令对象，设定它的接收者
        Command command = new ConcreteCommand(receiver);
        // 创建调用者，把命令对象设置进去
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        // 调用者调用命令
        invoker.invoke();
    }
}


interface Command {

    /**
     * 执行命令
     */
    public void execute();
}

class ConcreteCommand implements Command {

    /**
     * 持有相应的接收者对象
     */
    private Receiver receiver = null;

    /**
     * 构造方法，传入相应的接收者对象
     *
     * @param receiver 相应的接收者对象
     */
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        // 通常会转调接收者对象的相应方法，让接收者来真正执行功能
        receiver.action();
    }
}

class Receiver {

    /**
     * 示意方法，真正执行命令相应的操作
     */
    public void action() {
        System.out.println("接收者开始行动。。。");
    }
}

class Invoker {

    /**
     * 持有命令对象
     */
    private Command command = null;

    /**
     * 设置调用者持有的命令对象
     *
     * @param command 命令对象
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 示意方法，调用命令执行请求
     */
    public void invoke() {
        command.execute();
    }
}
