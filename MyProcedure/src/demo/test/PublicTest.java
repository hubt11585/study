package demo.test;

import java.util.ArrayList;
import java.util.List;

public class PublicTest {
    public static void main(String[] args) {
        int i = 3;
        switch (i) {
            case 1:
                System.out.println("����");
                break;
            case 2:
                System.out.println("����");
                break;
            case 5:
                System.out.println("����");
                break;
            default:
                assert false:"i��ֵ��Ч";       //���i��ֵ��������Ҫ�ģ�����;����˳�
        }
        System.out.println("��������������Ҿͱ���ӡ");
    }
}
