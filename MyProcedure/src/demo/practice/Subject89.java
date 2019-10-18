package demo.practice;

/**
 * ������89��
 * ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 * ������������ [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ������л Marcos ���״�ͼ��
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
        //�ұ߽�����ˮ��
        unit = unit + trapRight(height,side);
        //��߽�����ˮ��
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

        //�����м���ڶ��ٵ�λ
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
        //�����м���ڶ��ٵ�λ
        unit = trapUnit(height, sideTmp,side);
        if(maxTmp > 0 && sideTmp != 0) {
            unit += trapLeft(height, sideTmp);
        }
        return unit;
    }

    /**
     * �����м���Դ��ڶ��ٵ�λ��ˮ
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
