package demo.practice;

/**
 * ������17��
 * ��Ŀ�����ӳ������⣺���ӵ�һ��ժ�����ɸ����ӣ���������һ�룬����񫣬�ֶ����һ���ڶ��������ֽ�ʣ�µ����ӳԵ�һ�룬
 * �ֶ����һ�����Ժ�ÿ�����϶�����ǰһ��ʣ�µ�һ����һ��������10���������ٳ�ʱ����ֻʣ��һ�������ˡ����һ�칲ժ�˶��١�
 */
public class Subject17 {
    public static void main(String[] args) {
        System.out.println(peachNum(10));
    }

    public static int peachNum(int days){
        if(days == 1){
            return 1;
        }else if(days > 1){
            return (peachNum(days-1) + 1) * 2;
        }
        return 0;
    }
}
