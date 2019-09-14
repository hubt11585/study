package demo.practice;

/**
 * ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
 */
public class Subject82 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,5,6,7,9,10};
        System.out.println(new Subject82().searchInsert(arr,8));
    }

    public int searchInsert(int[] nums, int target) {
        if(nums.length < 0){
            return 0;
        }
        int size = this.search(0,nums.length-1,nums,target);
        if(nums[size] == target){
            return size;
        }else{
            if(nums[size] > target){
                return size;
            }else{
                return size+1;
            }
        }
    }

    /**
     * Binary search ���ֲ��ҷ�
     * @param left
     * @param right
     * @return
     */
    public int search(int left, int right,int[] nums, int target) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        if(right <= -1){
            return left;
        }
        if(left >= nums.length){
            return right;
        }
        return left <= right? left :right;
    }
}
