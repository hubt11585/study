package demo.design.command.imp;

import demo.design.command.inf.Command;

public class Invoker {
    // �����߳���һ���������
    Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    // ִ������
    public void excuteCommmand() {
        command.excute();
    }

    // ��������
    public void undoCommand() {
        command.unDo();
    }
}
