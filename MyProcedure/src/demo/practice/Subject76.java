package demo.practice;

/**
 * ��������������������dividend�ͳ���divisor�������������Ҫ��ʹ�ó˷��������� mod �������
 * ���ر�����dividend���Գ���divisor�õ����̡�
 */
public class Subject76 {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor =  -1;
        System.out.println(-2147483648/2);
        System.out.println(new Subject76().divide(dividend,divisor));
    }

    /**
     * ʵ�ֳ�����ͨ����ʽ�ķ�ʽ
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        //�ų�һЩ������
        if(dividend == 0){
            return 0;
        }
        if(divisor == Integer.MIN_VALUE){
            if(dividend > Integer.MIN_VALUE){
                return 0;
            }else{
                return 1;
            }
        }

        if(divisor == 1){
            return dividend;
        }
        if(divisor == -1){
            if(dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }else{
                return -dividend;
            }
        }
        int result = 0;
        String s0 = String.valueOf(dividend);
        String s1 = String.valueOf(divisor);
        boolean flag = false;
        if(s0.charAt(0) == '-'){
            flag = true;
        }else{
            s0 = "-"+s0;
        }

        if(s1.charAt(0) == '-'){
            if(flag){
                flag = false;
            }else{
                flag = true;
            }
        }else{
            s1 = "-"+s1;
            divisor = -divisor;
        }
        int side = s1.length()-1;
        if(side > s0.length()-1){
            return 0;
        }
        int dividend0 = Integer.parseInt(s0.substring(0,side+1)); //��ʱ����
        while(true){
            side++;
            int num = dividend0 - divisor;
            int i = 0;
            while(num <= 0){
                i++;
                num = num - divisor;
            }
            result = Integer.parseInt(result+"0") + i;
            if(side >= s0.length()){
                break;
            }else{
                dividend0 = Integer.parseInt((num+divisor)+ "" +s0.charAt(side));
                if(dividend0 > 0){
                    dividend0 = -dividend0;
                }
            }
        }

        if(flag){
            return -result;
        }else{
            return result;
        }
    }
}
