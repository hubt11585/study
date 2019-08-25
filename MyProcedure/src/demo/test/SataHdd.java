package demo.test;

//串行硬盘接口
public interface SataHdd{
    //连接线的数量
    public static final int CONNECT_LINE=4;
    //写数据
    public void writeData(String data); //编译出错，接口中不能包含静态方法
    //读数据
    public String readData();
}
