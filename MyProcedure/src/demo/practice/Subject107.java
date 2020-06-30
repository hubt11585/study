package demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给出集合?[1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定n 和k，返回第k个排列。
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class Subject107 {

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(new Subject107().getPermutation(5, i));
        }
        //System.out.println(new Subject107().getPermutation(5, 8));
    }

    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();
        int tmp = k;
        List<String> resultList = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            resultList.add(i+"");
        }

        for (int i = n; i > 0; i--) {
            int ii = 0;
            if(tmp == 0){
                for (int j = resultList.size()-1; j >= 0; j--) {
                    str = str.append(resultList.get(j));
                }
                break;
            }
            int remainder = tmp;
            while((remainder = remainder - factorial(i-1)) > 0){
                ii++;
            }
            if(remainder < 0 && ii > 0){
                remainder = remainder + factorial(i-1);
            }
            if(ii > 0){
                str = str.append(resultList.get(ii));
                resultList.remove(ii);
                tmp = remainder;
            }else{
                str = str.append(resultList.get(ii));
                resultList.remove(ii);
            }
        }
        return str.toString();
    }

    /**
     * 计算num的阶乘！
     * @param num
     * @return
     */
    public static int factorial(int num){
        if(num == 1 || num == 0){
            return 1;
        }else{
            return num*factorial(num-1);
        }
    }
}
