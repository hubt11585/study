package demo.practice;

/**
 * 【程序39】
 * 题目：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
 */
public class Subject39 {

    private static int count = 0;  //分桃次数
    private static int tmp = 0;    //桃子数量

    public static void main(String[] args) {
        averagePeachTot();
    }

    /**
     * 循环获取桃子总数
     */
    private static void averagePeachTot() {
        int frequency = 4;
        while(true){
            if(count == 6){
                System.out.println(tmp);
                break;
            }
            count =0;
            averagePeach(frequency);
            frequency+=4;
        }
    }

    /**
     * 平分桃子
     */
    private static void averagePeach(int num) {
        count++;
        if(num%4 == 0 && count<=5){
            tmp = num + 1 + num/4;
            averagePeach( tmp);
        }
    }
}
