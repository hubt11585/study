package demo.practice;

/**
 * ����һ��δ������������飬�ҳ�����û�г��ֵ���С����������
 */
public class Subject88 {
    public static void main(String[] args) {
        int[] arrInt = new int[]{-1,-9,1,2,4,6,9,8};
        int number = new Subject88().firstMissingPositive(arrInt);
        System.out.println(number);
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // �������
        int contains = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                contains++;
                break;
            }
        }
        if (contains == 0)
            return 1;

        // nums = [1]
        if (n == 1)
            return 2;

        // �� 1 �滻������0��
        // �ʹ��� n ����
        // ��ת���Ժ�nums ֻ�����
        // ����
        for (int i = 0; i < n; i++)
            if ((nums[i] <= 0) || (nums[i] > n))
                nums[i] = 1;

        // ʹ�����������ַ�����Ϊ�����
        // ���磬��� nums[1] �Ǹ�����ʾ�������г��������� `1`
        // ��� nums[2] ������ ��ʾ���� 2 û�г���
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            // ���������һ������ a - �ı�� a ��Ԫ�صķ���
            // ע���ظ�Ԫ��ֻ�����һ��
            if (a == n)
                nums[0] = - Math.abs(nums[0]);
            else
                nums[a] = - Math.abs(nums[a]);
        }

        // ���ڵ�һ���������±�
        // ���ǵ�һ��ȱʧ����
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n + 1;
    }
}
