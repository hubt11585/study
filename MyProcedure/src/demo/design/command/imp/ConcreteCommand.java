package demo.design.command.imp;

import demo.design.command.inf.Command;

public class ConcreteCommand implements Command {

    // ����һ��������Receiver�����ã���һ���ض��Ĳ���
    Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void excute() {
        receiver.action();
    }

    @Override
    public void unDo() {
        receiver.unAction();
    }
}
