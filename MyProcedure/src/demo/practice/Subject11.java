package demo.practice;

/**
 * ������11��
 * ��Ŀ����1��2��3��4�����֣�����ɶ��ٸ�������ͬ�����ظ����ֵ���λ�������Ƕ��٣�
 */
public class Subject11 {
    public static void main(String[] args) {
        FormThreeNum();
    }

    public static void FormThreeNum(){
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    System.out.println("1,2,3��4������ɵ���λ����"+i+j+k);
                }
            }
        }
    }
}
