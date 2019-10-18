package demo.algorithm.algorithm2;

/**
 * 判断大于1,小于63的整数是否出现重复数字。
 *
 * 算法逻辑：先获取8 根据移位(1 << arrInt[i]) 得到2进制数100000000  ，
 * 后面再遇到8的时候 100000000 >> 8 位，得到的数字各位就会是1。 只要得到个位为1 就表示重复了。
 * 受限于Int的类型大小限制，只能判断到小于64的数。
 *
 * 可应用于数独游戏。
 */
public class RepeatNumber {
    public static void main(String[] args) {
        int[] arrInt = new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,32,62,62,63};
        boolean flag= repeatNumberMethod(arrInt);
        System.out.println(flag);
    }

    public static boolean repeatNumberMethod(int[] arrInt){
        int boxCnt = 0;
        for (int i = 0; i < arrInt.length; i++) {
            if ((boxCnt >> arrInt[i]) % 2 == 1) {
                return false;
            } else {
                boxCnt = boxCnt + (1 << arrInt[i]);
            }
        }
        return true;
    }
}
