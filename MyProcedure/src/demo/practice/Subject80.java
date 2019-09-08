package demo.practice;

/**
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 * ( ���磬����[0,1,2,4,5,6,7]���ܱ�Ϊ[4,5,6,7,0,1,2])��
 * ����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻�-1��
 * ����Լ��������в������ظ���Ԫ�ء�
 * ����㷨ʱ�临�Ӷȱ�����O(logn) ����
 *
 * ʾ�� 1:
 * ����: nums = [4,5,6,7,0,1,2], target = 0
 * ���: 4
 *
 * ʾ��2:
 * ����: nums = [4,5,6,7,0,1,2], target = 3
 * ���: -1
 */
public class Subject80 {

    int [] nums;
    int target;

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new Subject80().search(nums,0));
    }

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int n = nums.length;

        if (n == 0)
            return -1;
        if (n == 1)
            return this.nums[0] == target ? 0 : -1;

        /**
         * �ҵ���ת�ڵ�
         */
        int rotate_index = find_rotate_index(0, n - 1);

        // if target is the smallest element
        if (nums[rotate_index] == target)
            return rotate_index;
        // if array is not rotated, search in the entire array
        if (rotate_index == 0)
            return search(0, n - 1);
        if (target < nums[0])
            // search in the right side
            return search(rotate_index, n - 1);
        // search in the left side
        return search(0, rotate_index);
    }

    /**
     * ����ת�ڵ�
     * @param left
     * @param right
     * @return
     */
    public int find_rotate_index(int left, int right) {
        if (nums[left] < nums[right])
            return 0;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

    /**
     * Binary search ���ֲ��ҷ�
     * @param left
     * @param right
     * @return
     */
    public int search(int left, int right) {
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
        return -1;
    }
}
