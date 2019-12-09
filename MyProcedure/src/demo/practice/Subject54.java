package demo.practice;

/**
 * ����һ�� 32 λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת��
 */
public class Subject54 {
    public static void main(String[] args) {
        int x= 2147483641;
        int result = reverse(x);
        System.out.println(result);
        result = reverse2(x);
        System.out.println(result);
    }

    /**
     * ��ת
     * @param x
     * @return
     */
    public static int reverse(int x){
        String str = x+"";
        char[] arr = str.toCharArray();
        StringBuilder  stringBuilder =  new StringBuilder();
        if(arr[0] == '-'){
            stringBuilder.append('-');
            for (int i = arr.length-1; i >= 1; i--) {
                stringBuilder.append(arr[i]);
            }
        }else{
            for (int i = arr.length-1; i >= 0; i--) {
                stringBuilder.append(arr[i]);
            }
        }

        int result = 0;
        try {
            result = Integer.parseInt(stringBuilder.toString());
        }catch (Exception e){
            result = 0;
        }
        return result;
    }

    /**
     * ��ת2
     * @param x
     * @return
     */
    public static int reverse2(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
