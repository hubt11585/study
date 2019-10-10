package demo.practice;

/**
 * ����һ��δ������������飬�ҳ�����û�г��ֵ���С����������
 */
public class Subject88 {
    public static void main(String[] args) {
        int[] arrInt = new int[]{1,2,3};
        int number = new Subject88().firstMissingPositive(arrInt);
        System.out.println(number);
    }

    public int firstMissingPositive(int[] nums) {
        int lengths = nums.length;
        if(lengths <= 0){
            return 1;
        }
        QuickSort(nums,0,lengths-1);
        if(nums[0] > 1){
            return 1;
        }
        for (int i = 1; i < lengths; i++) {
            if(nums[i] > 1){
                if(nums[i] - nums[i-1] > 1){
                    if(nums[i-1] > 0){
                        return nums[i-1]+1;
                    }else{
                        return 1;
                    }
                }
            }
        }
        if(nums[nums.length-1] > 0){
            return nums[nums.length-1]+1;
        }else{
            return 1;
        }
    }

    public int PartSort(int arr[], int low, int high) {
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

    public void QuickSort(int arr[], int low, int high) {
        if(low<high) {
            //��ֹ����ջ����쳣
            int index = PartSort(arr, low, high);
            QuickSort(arr, low, index - 1);
            QuickSort(arr, index + 1, high);
        }
    }
}
