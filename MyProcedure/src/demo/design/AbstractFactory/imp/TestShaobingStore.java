package demo.design.AbstractFactory.imp;

public class TestShaobingStore {
    public static void main(String[] args){
        //�ڹ��ݿ�һ���ձ���
        HZShaobingStore gzStore = new HZShaobingStore();
        //�۳�һ������ձ�
        gzStore.createShaobing("greens");
        gzStore.createShaobing("greens");
    }
}
