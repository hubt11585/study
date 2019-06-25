package demo.practice;

/**
 * ������41��
 * ��Ŀ����0��1��2��3��4��5��6��7������ɵ�8λ����������
 */
public class Subject41 {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,5,6,7};
        compose(arr);
    }

    /**
     * ��ȡ��0��7������ɵ���������
     */
    private static void compose(int[] arr) {
        /**�����ص㣬�������ܱ�2�������ʸ�λ����1��3��5��7��9**/
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(!isParity(arr[i])){
                oddCount++;
            }
        }
        /***************��λ�Ѿ�ȷ����ʣ�µ���������������ĸ���*******************/
        int num = factorial(arr.length-1);
        /****************������*********************/
        System.out.println("�������֣�");
        printArray(arr);
        System.out.println("�ɲ���������������"+oddCount*num);

    }

    /**
     * �ж�num����������ż��
     * @param num
     * @return
     */
    private static boolean isParity(int num) {
        if(num%2 == 1){
            return false;
        }else {
            return true;
        }
    }

    /**
     * ����num�Ľ׳ˣ�
     * @param num
     * @return
     */
    public static int factorial(int num){
        if(num == 1){
            return 1;
        }else{
            return num*factorial(num-1);
        }
    }

    /**
     * ��ӡ����
     * @param arr
     */
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
