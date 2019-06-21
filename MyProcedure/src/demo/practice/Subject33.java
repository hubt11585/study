package demo.practice;

/**
 * ������33��
 * ��Ŀ���������飬�������һ��Ԫ�ؽ�������С�������һ��Ԫ�ؽ�����������顣
 */
public class Subject33 {

    public static void main(String[] args) {
        int[] arr = new int[]{44,56,89,32,11,78,55,82,02,68,44,27};
        printArray(arr);
        deal(arr);
    }

    private static void deal(int[] arr) {
        int maxNum = arr[0];    //�����
        int minNum = arr[0];    //��С��
        int maxPosition = 0;    //������������λ�á�
        int minPosition = 0;    //��С���������λ�á�
        for (int i = 1; i <  arr.length; i++) {
            if(arr[i] > maxNum){
                maxNum = arr[i];
                maxPosition = i;
            }
            if(arr[i] < minNum){
                minNum = arr[i];
                minPosition = i;
            }
        }

        /*********�������飨�������һ��Ԫ�ؽ�������С�������һ��Ԫ�أ�************/
        int tmp = 0;
        tmp = arr[0];
        arr[0] = arr[maxPosition];
        arr[maxPosition] = tmp;

        tmp = arr[arr.length-1];
        arr[arr.length-1] = arr[minPosition];
        arr[minPosition] = tmp;

        /*********��ӡ����***********/
        printArray(arr);
    }

    /**
     * ��ӡ����
     * @param arr
     */
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
