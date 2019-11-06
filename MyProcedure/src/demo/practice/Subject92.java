package demo.practice;

/**
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 * ���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�
 */
public class Subject92 {

    public static void main(String[] args) {
        int[] arrInt = new int[]{2,3,1,1,4,2,1};
        System.out.println(new Subject92().jump(arrInt));
    }

    public int jump(int[] nums) {
        //С�ڵ���1�Ķ�����Ҫ��
        int lengths = nums.length;
        if(lengths <= 1){
            return 0;
        }
        int reach = 0;  //��ǰ���ߵ���Զ����
        int nextreach = nums[0];
        int step = 0;  //��Ҫ����
        for(int i = 0;i<lengths;i++){
            //̰���㷨���ģ���һ���ǲ��ǿ��Ա���һ���õ����ಽ����������ȡ���µ�·�ߡ�
            nextreach = Math.max(i+nums[i],nextreach);
            if(nextreach >= lengths-1) return (step+1);
            if(i == reach){
                step++;
                reach = nextreach;
            }
        }
        return step;
    }
}
