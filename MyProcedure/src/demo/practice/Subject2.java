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
        int tmp = 0;
        int sum = 0;
        if(a >= b){
            System.out.println("a���ܴ��ڵ���b��");
        }
        for(int i=a;i<=b;i++){
            tmp = 0;
            for(int j=2;j<i;j++){
                if(i%j == 0){
                    tmp = 1;
                    break;
                }
            }
            if(tmp==0){
                sum += 1;
                System.out.println("������"+i);
            }
        }
        System.out.println("��������������"+sum);
    }
}
