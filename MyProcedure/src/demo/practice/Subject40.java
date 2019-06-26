package demo.practice;

/**
 * 【程序40】
 * 题目：809*??=800*??+9*??+1    改成 809*??=800*??+9*??
 * 其中??代表的两位数,8*??的结果为两位数，9*??的结果为3位数。求??代表的两位数，及809*??后的结果, 题目错误
 */
public class Subject40 {
    public static void main(String[] args) {
        mathematicsFormula();
    }

    /**
     * 数学公式
     */
    private static void mathematicsFormula() {
        boolean flag = false;
        for (int i = 10; i < 100 ; i++) {
            if( 8*i < 100 && 9*i >100 && 809*i == 800*i+9*i){
                flag = true;
                System.out.println("??=" + i);
                System.out.println("809*?? = " + 809*i);
            }
        }
        if(!flag){
            System.out.println("为找到合适的数");
        }
    }
}
