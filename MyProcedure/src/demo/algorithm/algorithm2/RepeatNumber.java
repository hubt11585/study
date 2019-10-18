package demo.algorithm.algorithm2;

/**
 * �жϴ���1,С��63�������Ƿ�����ظ����֡�
 *
 * �㷨�߼����Ȼ�ȡ8 ������λ(1 << arrInt[i]) �õ�2������100000000  ��
 * ����������8��ʱ�� 100000000 >> 8 λ���õ������ָ�λ�ͻ���1�� ֻҪ�õ���λΪ1 �ͱ�ʾ�ظ��ˡ�
 * ������Int�����ʹ�С���ƣ�ֻ���жϵ�С��64������
 *
 * ��Ӧ����������Ϸ��
 */
public class RepeatNumber {
    public static void main(String[] args) {
        int[] arrInt = new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,32,62,62,63};
        boolean flag= repeatNumberMethod(arrInt);
        System.out.println(flag);
    }

    public static boolean repeatNumberMethod(int[] arrInt){
        int boxCnt = 0;
        for (int i = 0; i < arrInt.length; i++) {
            if ((boxCnt >> arrInt[i]) % 2 == 1) {
                return false;
            } else {
                boxCnt = boxCnt + (1 << arrInt[i]);
            }
        }
        return true;
    }
}
