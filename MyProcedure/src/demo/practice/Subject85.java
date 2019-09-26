package demo.practice;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1被读作"one 1"("一个一") , 即11。
 * 11 被读作"two 1s"("两个一"）, 即21。
 * 21 被读作"one 2", "one 1"（"一个二","一个一"), 即1211。
 * 给定一个正整数 n（1 ≤n≤ 30），输出报数序列的第 n 项。
 */
public class Subject85 {

    public static void main(String[] args) {
        System.out.println(new Subject85().countAndSay(6));
    }

    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }else{
            String str = countAndSay(n-1);
            char[] chArr = str.toCharArray();
            StringBuilder strTmp = new StringBuilder("");
            char ch = chArr[0] ;
            int count = 0;
            for (int i = 0; i < chArr.length; i++) {
                if(ch == chArr[i]){
                    count++;
                }else{
                    strTmp.append(count).append(ch);
                    ch = chArr[i];
                    count = 1;
                }
            }
            strTmp.append(count).append(ch);
            return strTmp.toString();
        }
    }
}
