package demo.design.command.inf;

public interface Command {
    //执行操作
    public void excute();
    //撤销操作
    public void unDo();
}
