package demo.practice;

/**
 * ����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
 * ����㷨ʱ�临�Ӷȱ�����O(log n) ����
 * ��������в�����Ŀ��ֵ������[-1, -1]��
 */
public class Subject81 {
    public static void main(String[] args) {
        int[] arr = new int[]{1};
        System.out.println(new Subject81().searchRange(arr,1));
    }

    /**
     * ���ֲ��ҷ�
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int pivot = -1;
        boolean flag = false;
        while (left <= right) {
            pivot = (left + right) / 2;
            if (nums[pivot] == target) {
                flag = true;
                break;
            } else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        if(!flag){
            pivot = -1;
        }
        if(pivot != -1){
            int leftTmp = pivot;
            int rightTmp = pivot;
            while(leftTmp >= 0){
                leftTmp = leftTmp-1;
                if(leftTmp < 0 || nums[leftTmp] != target){
                    break;
                }
            }
            while(rightTmp <=  nums.length-1){
                rightTmp = rightTmp+1;
                if(rightTmp > nums.length-1  ||nums[rightTmp] != target){
                    break;
                }
            }
            return new int[]{leftTmp+1,rightTmp-1};
        }else{
            return new int[]{-1,-1};
        }
    }
}
