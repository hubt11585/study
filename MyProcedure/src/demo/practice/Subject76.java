package demo.practice;

/**
 * ��������������������dividend�ͳ���divisor�������������Ҫ��ʹ�ó˷��������� mod �������
 * ���ر�����dividend���Գ���divisor�õ����̡�
 */
public class Subject76 {
    public static void main(String[] args) {
        int dividend = 2147483647;
        int divisor = 3;
        System.out.println(2147483647/3);
        System.out.println(new Subject76().divide(dividend,divisor));
    }

    /**
     * ʵ�ֳ�����ͨ�������ķ�ʽ
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        //�ų�һЩ������
        if(dividend == 0 || divisor == Integer.MIN_VALUE){
            return 0;
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
        //�����ԭ���������
        String s0 = Integer.toBinaryString(dividend);
        String s1 = Integer.toBinaryString(divisor);
        System.out.println(s0);
        System.out.println(s1);
        if(dividend > 0 && divisor > 0){
            for (int i = 1; i < s1.length(); i++) {
                if(s0.charAt(i) == '1'){
                   result =result + dividend >>> i;
                }
            }
        }
        if(dividend < 0 && divisor < 0){

        }
        if(dividend > 0 && divisor < 0) {

        }
        if(dividend < 0 && divisor > 0) {

        }
        return result;
    }
}
