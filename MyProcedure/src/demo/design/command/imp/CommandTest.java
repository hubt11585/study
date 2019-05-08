package demo.design.command.imp;

import demo.design.command.inf.Command;

public class CommandTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // 创建命令的接受者
        Receiver receiver = new Receiver();
        // 创建命令对象，并设定它的接受者
        Command command = new ConcreteCommand(receiver);
        // 创建命令执行者，并将相应的命令作为参数传递给Invoker
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        // Client端测试一下
        invoker.excuteCommmand();
        invoker.undoCommand();
    }
}
