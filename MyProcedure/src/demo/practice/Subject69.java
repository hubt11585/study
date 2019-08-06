package demo.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� n �����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
 */
public class Subject69 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }

    /**
     * �ݹ����
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        if(n == 1){
            List<String> list = new ArrayList<>();
            list.add("()");
            return list;
        }else{
            List<String> list = generateParenthesis(n-1);
            int sizes = list.size();
            List<String> newList = new ArrayList<>();
            for (int i = 0; i < sizes; i++) {
                String tmp = list.get(i);
                char[] arr = tmp.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    String tmp0 = tmp.substring(0,j);
                    String tmp1 = tmp.substring(j,tmp.length());
                    String tmp2 = tmp0 + "()" +tmp1;
                    if(!newList.contains(tmp2)){
                        newList.add(tmp2);
                    }
                }
            }
            return newList;
        }
    }
}
