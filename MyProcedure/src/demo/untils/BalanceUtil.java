package demo.untils;

import java.math.BigDecimal;

public class BalanceUtil {

    /**
     * 汉语中数字大写
     */
    private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆",
            "伍", "陆", "柒", "捌", "玖" };
    /**
     * 汉语中货币单位大写，这样的设计类似于占位符
     */
    private static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元",
            "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾",
            "佰", "仟" };
    /**
     * 特殊字符：整
     */
    private static final String CN_FULL = "整";
    /**
     * 特殊字符：负
     */
    private static final String CN_NEGATIVE = "负";
    /**
     * 金额的精度，默认值为2
     */
    private static final int MONEY_PRECISION = 2;
    /**
     * 特殊字符：零元整
     */
    private static final String CN_ZEOR_FULL = "零元" + CN_FULL;

    public static void main(String[] args) {
        System.out.printf(balanceToCnCapitalized("200308989.1"));
    }

    /**
     * 把输入的金额转换为汉语中人民币的大写
     * @param amount 输入的金额
     * @return 对应的汉语大写
     */
    public static String balanceToCnCapitalized(String amount) {

        BigDecimal numberOfMoney = new BigDecimal(amount);

        /************* 用于存放转化后的中文大写**********/
        StringBuffer sb = new StringBuffer();

        /******* 判断金额是正数，负数或者是0*************/
        int signum = numberOfMoney.signum();

        /******* 如果金额为0，则直接返回“零元整”*************/
        if (signum == 0) {
            return CN_ZEOR_FULL;
        }

        /*****这里先对金额进行移位（移动MONEY_PRECISION位），然后再对金额四舍五入, 其中BigDecimal.ROUND_HALF_UP 就是四舍五入的含义
         * 举例： 111.111   变成   11111
         *       111.115    变成   11112 ******/
        long number = numberOfMoney.movePointRight(MONEY_PRECISION)
                .setScale(0, BigDecimal.ROUND_HALF_UP).abs().longValue();

        /****** 获取最后两位，就是输入金额的小数位 ******/
        long scale = number % 100;

        /****** 每次取最后一位存入numUnit ********/
        int numUnit = 0;

        /****** 从后往前第几个数字 ********/
        int numIndex = 0;

        /********遇到零时判断是否需要加零，true 不需要，false 需要***********/
        boolean getZero = false;
        // 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
        if (!(scale > 0)) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
            sb.insert(0, CN_FULL);
        }
        if ((scale > 0) && (!(scale % 10 > 0))) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
            sb.insert(0, CN_FULL);
        }

        /******** 连续零的数量 *********/
        int zeroSize = 0;
        while (true) {
            if (number <= 0) break;
            // 每次获取到最后一个数
            numUnit = (int) (number % 10);
            if (numUnit > 0) {
                /******** 遇到千万，千亿，千兆，并且前面已经存在超过3个0，需要加上单位万，亿或者兆************/
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
                }
                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
                }
                if ((numIndex == 17) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[14]);
                }
                sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                getZero = false;
                zeroSize = 0;
            } else {
                ++zeroSize;
                if (!(getZero) && !(numIndex == 2 || numIndex == 6 || numIndex == 10 || numIndex == 14)) {
                    sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                }
                if (numIndex == 2) {
                    if (number > 0) {
                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                    }
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                }
                getZero = true;
            }
            number = number / 10;
            ++numIndex;
        }
        /*********** 负数就在最前面追加特殊字符：负*****************/
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }
        return sb.toString();
    }
}
