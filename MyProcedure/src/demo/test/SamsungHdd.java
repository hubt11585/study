package demo.test;

public class SamsungHdd implements SataHdd {
    @Override
    public void writeData(String data) {
        System.out.println("д��ɹ�");
    }

    @Override
    public String readData() {
        return "����";
    }
}
