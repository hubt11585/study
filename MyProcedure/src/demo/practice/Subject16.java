package demo.practice;

/**
 * 【程序16】
 * 题目：输出9*9口诀。
 */
public class Subject16 {

    public static void main(String[] args) {

        for (int i = 1; i <= 9 ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
            System.out.println("");
        }
    }
}
