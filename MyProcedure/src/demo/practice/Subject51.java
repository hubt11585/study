package demo.practice;

/**
 * ����������СΪ m �� n ����������nums1 ��nums2��
 * �����ҳ������������������λ��������Ҫ���㷨��ʱ�临�Ӷ�ΪO(log(m + n))��
 * ����Լ���nums1��nums2����ͬʱΪ��
 */
public class Subject51 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{1,2};
        double arr = findMedianSortedArrays(nums1,nums2);
        System.out.println(arr);
    }

    public static int PartSort(int arr[], int low, int high) {
        int data = arr[low];
        /**һ�α����ķ�������շ� ����һ��data��arr[low]���������������λ���ڿ�*/
        while (low < high) {
            while (low < high && arr[high] >= data) {
                high--;
            }
            arr[low] = arr[high];
            /**��high��Ҳ���Ǻ�����ǰ���� �ҵ��ȼ�ֵС������ ���뵽ǰ�����µĿ��� highλ�ٴ����¿���*/
            while (low < high && arr[low] <= data) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = data;
        /**ѭ���˳��� low��high�غ� ������ֵ������low������low����*/
        return low;
    }


    /**
     * ��������
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int arr[], int low, int high) {
        if(low<high) {
            //��ֹ����ջ����쳣
            int index = PartSort(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    /**
     * Ѱ����λ��
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        int[] arr = new int[a+b];
        double result = 0.0;
        if(a >= 2 && b >=2 ){
            if(nums1[0] <= nums1[1] && nums2[0] <= nums2[1] ){
                if(nums1[0] >= nums2[0]){
                    for (int i = 0; i < b; i++) {
                        arr[i] = nums2[i];
                    }
                    for (int i = 0; i < a; i++) {
                        arr[i+b] = nums1[i];
                    }
                }else{
                    for (int i = 0; i < a; i++) {
                        arr[i] = nums1[i];
                    }
                    for (int i = 0; i < b; i++) {
                        arr[i+a] = nums2[i];
                    }
                }
            }else if(nums1[0] >= nums1[1] && nums2[0] >= nums2[1]){
                if(nums1[a-1] <= nums2[b-1]){
                    for (int i = 0; i < a; i++) {
                        arr[i] = nums1[a-i-1];
                    }
                    for (int i = 0; i < b; i++) {
                        arr[i+a] = nums2[b-i-1];
                    }
                }else{
                    for (int i = 0; i < b; i++) {
                        arr[i] = nums1[b-i-1];
                    }
                    for (int i = 0; i < a; i++) {
                        arr[i+b] = nums2[a-i-1];
                    }
                }
            }else if(nums1[0] <= nums1[1] && nums2[0] >= nums2[1]){
                if(nums1[0] <= nums2[b-1]){
                    for (int i = 0; i < a; i++) {
                        arr[i] = nums1[i];
                    }
                    for (int i = 0; i < b; i++) {
                        arr[i+a] = nums2[b-i-1];
                    }
                }else{
                    for (int i = 0; i < b; i++) {
                        arr[i] = nums2[i];
                    }
                    for (int i = 0; i < a; i++) {
                        arr[i+b] = nums1[a-1-i];
                    }
                }
            }else if(nums1[0] >= nums1[1] && nums2[0] <= nums2[1]){
                if(nums1[a-1] <= nums2[0]){
                    for (int i = 0; i < a; i++) {
                        arr[i] = nums1[a-1-i];
                    }
                    for (int i = 0; i < b; i++) {
                        arr[i+a] = nums2[i];
                    }
                }else{
                    for (int i = 0; i < b; i++) {
                        arr[i] = nums2[i];
                    }
                    for (int i = 0; i < a; i++) {
                        arr[i+b] = nums1[a-1-i];
                    }
                }
            }
        }else{
            for (int i = 0; i < a; i++) {
                arr[i] = nums1[i];
            }
            for (int i = 0; i < b; i++) {
                arr[i+a] = nums2[i];
            }
        }
        int right = arr.length-1;
        int left = 0;

        quickSort(arr,left,right);

        int tmp = arr.length;
        if(tmp % 2 == 0){
            result = (arr[tmp/2] + arr[tmp/2 - 1]) / 2.0;
        }else{
            result = arr[tmp/2];
        }
        return result;
    }
}
