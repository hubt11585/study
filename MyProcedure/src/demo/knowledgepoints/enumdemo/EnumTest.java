package demo.knowledgepoints.enumdemo;

import demo.knowledgepoints.enumdemo.enu.EnumWeek;

public class EnumTest {
    public static void main(String[] args) {
        for (EnumWeek e : EnumWeek.values()) {
            System.out.println(e.toString());
        }

        System.out.println("----------------���Ƿָ���------------------");

        EnumWeek test = EnumWeek.TUE;
        switch (test) {
            case MON:
                System.out.println("����������һ");
                break;
            case TUE:
                System.out.println("���������ڶ�");
                break;
            case WED:
                System.out.println("������������");
                break;
            case THU:
                System.out.println("������������");
                break;
            case FRI:
                System.out.println("������������");
                break;
            case SAT:
                System.out.println("������������");
                break;
            case SUN:
                System.out.println("������������");
                break;
            default:
                System.out.println(test);
                break;
        }
    }
}
