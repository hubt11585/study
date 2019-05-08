package demo.design.command.imp;

import demo.design.command.inf.Command;

public class ConcreteCommand implements Command {

    // 持有一个接受者Receiver的引用，绑定一个特定的操作
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
