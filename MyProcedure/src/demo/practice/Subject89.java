package demo.practice;

/**
 * ������89��
 * ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 * ������������ [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ������л Marcos ���״�ͼ��
 */
public class Subject89 {

    public static void main(String[] args) {
        int[] arrInt = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int side = new Subject89().trap(arrInt);
        System.out.println(side);
    }

    public int trap(int[] height) {
        return 0;
    }
}
