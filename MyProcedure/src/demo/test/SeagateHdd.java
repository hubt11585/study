package demo.test;

public class SeagateHdd implements SataHdd, fixHdd {
    @Override
    public void writeData(String data) {
        System.out.println("д��ɹ�");
    }

    @Override
    public String readData() {
        return "����";
    }

    @Override
    public boolean doFix() {
        return true;
    }
}
