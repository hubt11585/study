package demo.design.command.imp;

public class Receiver {
    public void action() {
        System.out.println("执行一个命令");
    }

    public void unAction() {
        System.out.println("撤销一个命令");
    }
}
