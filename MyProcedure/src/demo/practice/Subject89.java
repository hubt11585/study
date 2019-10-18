package demo.practice;

/**
 * 【程序89】
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。感谢 Marcos 贡献此图。
 */
public class Subject89 {

    public static void main(String[] args) {
        int[] arrInt = new int[]{0,1,4,2,1,0,1,7,2,1,2,6};
        int side = new Subject89().trap(arrInt);
        System.out.println(side);
    }

    public int trap(int[] height) {
        int max = 0;
        int side =0;
        for (int i = 0; i < height.length ; i++) {
            if(height[i] > max){
                max = height[i];
                side = i;
            }
        }

        int unit = 0;
        //右边接收雨水量
        unit = unit + trapRight(height,side);
        //左边接受雨水量
        unit = unit + trapLeft(height,side);
        return unit;
    }

    public int trapRight(int[] height,int side) {
        int unit = 0;
        int maxTmp = 0;
        int sideTmp =0;
        for (int i = height.length-1 ; i >  side; i--) {
            if(height[i] > maxTmp){
                maxTmp = height[i];
                sideTmp = i;
            }
        }

        //计算中间存在多少单位
        unit = trapUnit(height,side,sideTmp);
        if(maxTmp > 0 && sideTmp != height.length-1){
            unit += trapRight(height,sideTmp);
        }
        return unit;
    }

    public int trapLeft(int[] height,int side) {
        int unit = 0;
        int maxTmp = 0;
        int sideTmp =0;
        for (int i = 0 ; i < side; i++) {
            if(height[i] > maxTmp){
                maxTmp = height[i];
                sideTmp = i;
            }
        }
        //计算中间存在多少单位
        unit = trapUnit(height, sideTmp,side);
        if(maxTmp > 0 && sideTmp != 0) {
            unit += trapLeft(height, sideTmp);
        }
        return unit;
    }

    /**
     * 计算中间可以存在多少单位雨水
     * @param height
     * @return
     */
    public int trapUnit(int[] height,int left,int right){
        int unit = 0;
        if(right-left <= 1){
            return unit;
        }

        int low =0;
        if(height[left] > height[right]){
            low = height[right];
        }else{
            low = height[left];
        }

        for (int i = left+1; i <= right-1; i++) {
            unit = unit + (low - height[i]);
        }
        return unit;
    }
}
