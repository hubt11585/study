package demo.test;

public class SamsungHdd implements SataHdd {
    @Override
    public void writeData(String data) {
        System.out.println("写入成功");
    }

    @Override
    public String readData() {
        return "数据";
    }
}
