package demo.practice;

/**
 * ������16��
 * ��Ŀ�����9*9�ھ���
 */
public class Subject16 {

    public static void main(String[] args) {

        for (int i = 1; i <= 9 ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
            System.out.println("");
        }
    }
}
