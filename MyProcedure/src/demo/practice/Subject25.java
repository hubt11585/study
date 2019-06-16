package demo.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * ������25��
 * ��Ŀ��һ��5λ�����ж����ǲ��ǻ���������12321�ǻ���������λ����λ��ͬ��ʮλ��ǧλ��ͬ��
 */
public class Subject25 {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int num = 12321;
        palindromeNumber(num);
        if(list.get(0) == list.get(4) && list.get(1) == list.get(3)){
            System.out.println("���֣�"+num+")�ǻ�����");
        }else{
            System.out.println("���֣�"+num+")���ǻ�����");
        }

        /***�ڶ��ַ�ʽ**/
        char[] arr = (num+"").toCharArray();
        if(arr[0]==arr[4] && arr[1]==arr[3]){
            System.out.println("���֣�"+num+")�ǻ�����");
        }else{
            System.out.println("���֣�"+num+")���ǻ�����");
        }
    }

    /**
     * �ж�num�Ƿ��ǻ�����
     * @param num
     */
    private static void palindromeNumber(int num) {
        int lenght =  (num+"").length()-1;
        int numTmp = 0;
        if(num < 10){
            numTmp =num;
        }else{
            numTmp = num/(int)Math.pow(10,lenght);
            int tmp =num - numTmp*(int)Math.pow(10,lenght);
            palindromeNumber(tmp);
        }
        list.add(numTmp);
    }
}
