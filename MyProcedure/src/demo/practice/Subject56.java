package demo.practice;

/**
 * ������56��
 * �ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
 */
public class Subject56 {
    public static void main(String[] args) {
        int x = 1;
        boolean flag = isPalindrome(x);
        System.out.println(flag);
    }

    /**
     * �ж�x�Ƿ��ǻ�����
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x < 10){
            return true;
        }
        int newi = 0;
        int num = x;
        while(true){
            if(newi>0){
                newi = newi*10;
            }
            int i = num%10 ;
            newi = newi+i;
            num = num/10;
            if(num <= 9){
                newi = newi*10+num;
                break;
            }
        }
        if(newi == x){
            return true;
        }else{
            return false;
        }
    }
}
