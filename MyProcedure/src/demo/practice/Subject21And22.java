package demo.practice;

/**
 * ������21��
 * ��Ŀ����1+2!+3!+��+20!�ĺ�
 * ������22��
 * ��Ŀ�����õݹ鷽����5!��
 */
public class Subject21And22 {

    public static void main(String[] args) {
        long sum = factorialSum(20);
        System.out.println("1+2!+3!+��+20!֮�ͣ�"+sum);
    }

    /**
     * �׳����
     * @param num
     * @return
     */
    private static long factorialSum(int num) {
        long sum = 0;
        for (int j = 1; j <= num; j++) {
            sum = sum+factorial(j);
        }
        return sum;
    }

    /**
     * ����num�Ľ׳ˣ�
     * @param num
     * @return
     */
    public static long factorial(int num){
        if(num == 1){
            return 1;
        }else{
           return num*factorial(num-1);
        }
    }
}
