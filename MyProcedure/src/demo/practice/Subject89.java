package demo.practice;

/**
 * 【程序89】
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。感谢 Marcos 贡献此图。
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
