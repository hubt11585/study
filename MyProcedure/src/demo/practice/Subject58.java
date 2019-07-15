package demo.practice;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点?(i,?ai) 。在坐标内画 n 条垂直线，垂直线 i?的两个端点分别为?(i,?ai) 和 (i, 0)。找出其中的两条线，使得它们与?x?轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且?n?的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class Subject58 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(arr));
    }

    /**
     * 求最大面积
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int maxArea = 0; //最大面积
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
     * 计算最大面积
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
