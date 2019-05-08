package demo.design.command.imp;

import demo.design.command.inf.Command;

public class CommandTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // ��������Ľ�����
        Receiver receiver = new Receiver();
        // ����������󣬲��趨���Ľ�����
        Command command = new ConcreteCommand(receiver);
        // ��������ִ���ߣ�������Ӧ��������Ϊ�������ݸ�Invoker
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        // Client�˲���һ��
        invoker.excuteCommmand();
        invoker.undoCommand();
    }
}
