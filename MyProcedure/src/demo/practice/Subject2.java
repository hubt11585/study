package demo.practice;

/**
 * ������2��
 *  ��Ŀ���ж�101-200֮���ж��ٸ����������������������
 *
 *  ������ʲô�����������ܱ��Լ���1����������
 */
public class Subject2 {
    public static void main(String[] args) {
        getPrimeNumber(101,200);
    }

    /**
     * �ж�a��b֮���ж��ٸ�����
     * @param a
     * @param b
     */
    public static void getPrimeNumber(int a,int b){
        int sum = 0;
        if(a >= b){
            System.out.println("a���ܴ��ڵ���b��");
        }
        for(int i=a;i<=b;i++){
            if(isPrimeNumber(i)){
                sum += 1;
                System.out.println("������"+i);
            }
        }
        System.out.println("��������������"+sum);
    }

    /**
     * �ж�num�Ƿ���һ������
     * @param i
     * @return
     */
    private static boolean isPrimeNumber(int i) {
        boolean flag = true;
        for(int j=2;j <= i/2;j++){
            if(i%j == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
