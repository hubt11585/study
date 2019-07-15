package demo.practice;

/**
 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ����?(i,?ai) ���������ڻ� n ����ֱ�ߣ���ֱ�� i?�������˵�ֱ�Ϊ?(i,?ai) �� (i, 0)���ҳ����е������ߣ�ʹ��������?x?�Ṳͬ���ɵ�����������������ˮ��
 * ˵�����㲻����б��������?n?��ֵ����Ϊ 2��
 * ͼ�д�ֱ�ߴ����������� [1,8,6,2,5,4,8,3,7]���ڴ�����£������ܹ�����ˮ����ʾΪ��ɫ���֣������ֵΪ 49��
 */
public class Subject58 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(arr));
    }

    /**
     * ��������
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int maxArea = 0; //������
        int left = 0;
        int right = height.length-1;
        int leftvalue = 0;
        int rightvalue = 0;
        while (left < right){
            if(height[left] < height[right]){
                if(height[left] > leftvalue && height[left]*(right-left) > maxArea){
                    maxArea = height[left]*(right-left);
                }
                leftvalue = height[left];
                left++;
            }else{
                if( height[right] > rightvalue && height[right] * (right - left) > maxArea) {
                    maxArea = height[right] * (right - left);
                }
                rightvalue = height[right];
                right--;
            }
        }
        return maxArea;
    }

    /**
     * ����������
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int tmp0 = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[i] > tmp0){
                tmp0 = height[i];
            }else{
                continue;
            }
            for (int j = height.length-1; j >= 0 && j>i ; j--) {
                if(height[j] >= height[i]){
                    if(height[i]*(j-i) > maxArea){
                        maxArea = height[i]*(j-i);
                        break;
                    }
                }
            }
        }
        tmp0 = 0;
        for (int i = height.length-1; i >=0 ; i--) {
            if(height[i] > tmp0){
                tmp0 = height[i];
            }else{
                continue;
            }
            for (int j = 0; j < height.length && i>j; j++) {
                if(height[j] >= height[i]){
                    if(height[i]*(i-j) > maxArea){
                        maxArea = height[i]*(i-j);
                        break;
                    }
                }
            }
        }
        return maxArea;
    }
}
