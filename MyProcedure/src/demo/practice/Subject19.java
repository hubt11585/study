package demo.practice;

/**
 * ������19��
 * ��Ŀ����ӡ������ͼ�������Σ�
 */
public class Subject19 {
    public static void main(String[] args) {
        diamond(6);
    }

    /**
     * ��ӡ����
     */
    public static void diamond(int a){
        for (int i = a; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < a-i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }

        for (int i = 0; i < a ; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < a-i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}
