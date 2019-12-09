package demo.practice;

/**
 * ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�
 * �����������һ����������У��������������г���С�����У����������У���
 * ����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣
 * ������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
 * 1,2,3 �� 1,3,2
 * 3,2,1 �� 1,2,3
 * 1,1,5 �� 1,5,1
 */
public class Subject78 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,3,3};
        new Subject78().nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    /**
     * ��һ�����ֵ
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int lengths = nums.length;
        int size = -1;
        for (int i = lengths-1; i >= 0; i--) {
            if(i-1 >= 0 && nums[i-1] < nums[i]){
                size = i-1;
                break;
            }
        }
        //���û������ֵ��
        if(size == -1){
            for (int i = 0 ,j= lengths-1; i <= j ; i++,j--) {
                int tmp = 0;
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }else{ //����size��ߵ����ݣ����������һ����С���顣
            //�ҵ���sizeλ�ô�����е���С����
            int tmp = nums[size+1];
            int sizeExchange = size+1;
            for (int i = size+1; i < lengths ; i++) {
                //��������Ż�
                if(nums[i] <= tmp && nums[i] > nums[size]){
                    tmp = nums[i];
                    sizeExchange = i;
                }
            }
            nums[sizeExchange] = nums[size];
            nums[size] = tmp;
            //ʣ������������С��������
            for (int i = size+1 ,j= lengths-1; i <= j ; i++,j--) {
                int tmp0 = 0;
                tmp0 = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp0;
            }
        }
    }
}
