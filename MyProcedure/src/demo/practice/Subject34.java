package demo.practice;

/**
 * ������34��
 * ��Ŀ����n��������ʹ��ǰ�����˳�������m��λ�ã����m���������ǰ���m����
 */
public class Subject34 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        /**********************��ӡ����*************************/
        printArray(arr);
        int m = 6;   //ƫ����
        deviation(arr,m);
    }

    /**
     * ����arrƫ��m��Ľ��
     * @param arr
     * @param m
     */
    private static void deviation(int[] arr,int m) {
        int[] newArr = new int[m];
        int count = m-1;
        /*******************�����mΪ�����浽��������********************/
        for (int i = arr.length-1; i >= arr.length-m ; i--) {
            newArr[count--] = arr[i];
        }

        /********************�������е����������ƶ�mλ***************************/
        for (int i =  arr.length-1; i >= m; i--) {
            arr[i] = arr[i-m];
        }

        /**********************����ǰ������ݲ�������*************************/
        for (int i = 0; i < newArr.length; i++) {
            arr[i] = newArr[i];
        }

        /**********************��ӡ����*************************/
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
