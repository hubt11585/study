package demo.practice;

public class Subject58 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
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
