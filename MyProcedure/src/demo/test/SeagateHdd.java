package demo.test;

public class SeagateHdd implements SataHdd, fixHdd {
    @Override
    public void writeData(String data) {
        System.out.println("写入成功");
    }

    @Override
    public String readData() {
        return "数据";
    }

    @Override
    public boolean doFix() {
        return true;
    }
}
