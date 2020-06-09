package demo.untils;

import java.math.BigDecimal;

public class BalanceUtil {

    /**
     * ���������ִ�д
     */
    private static final String[] CN_UPPER_NUMBER = { "��", "Ҽ", "��", "��", "��",
            "��", "½", "��", "��", "��" };
    /**
     * �����л��ҵ�λ��д�����������������ռλ��
     */
    private static final String[] CN_UPPER_MONETRAY_UNIT = { "��", "��", "Ԫ",
            "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ",
            "��", "Ǫ" };
    /**
     * �����ַ�����
     */
    private static final String CN_FULL = "��";
    /**
     * �����ַ�����
     */
    private static final String CN_NEGATIVE = "��";
    /**
     * ���ľ��ȣ�Ĭ��ֵΪ2
     */
    private static final int MONEY_PRECISION = 2;
    /**
     * �����ַ�����Ԫ��
     */
    private static final String CN_ZEOR_FULL = "��Ԫ" + CN_FULL;

    public static void main(String[] args) {
        System.out.printf(balanceToCnCapitalized("200308989.1"));
    }

    /**
     * ������Ľ��ת��Ϊ����������ҵĴ�д
     * @param amount ����Ľ��
     * @return ��Ӧ�ĺ����д
     */
    public static String balanceToCnCapitalized(String amount) {

        BigDecimal numberOfMoney = new BigDecimal(amount);

        /************* ���ڴ��ת��������Ĵ�д**********/
        StringBuffer sb = new StringBuffer();

        /******* �жϽ��������������������0*************/
        int signum = numberOfMoney.signum();

        /******* ������Ϊ0����ֱ�ӷ��ء���Ԫ����*************/
        if (signum == 0) {
            return CN_ZEOR_FULL;
        }

        /*****�����ȶԽ�������λ���ƶ�MONEY_PRECISIONλ����Ȼ���ٶԽ����������, ����BigDecimal.ROUND_HALF_UP ������������ĺ���
         * ������ 111.111   ���   11111
         *       111.115    ���   11112 ******/
        long number = numberOfMoney.movePointRight(MONEY_PRECISION)
                .setScale(0, BigDecimal.ROUND_HALF_UP).abs().longValue();

        /****** ��ȡ�����λ�������������С��λ ******/
        long scale = number % 100;

        /****** ÿ��ȡ���һλ����numUnit ********/
        int numUnit = 0;

        /****** �Ӻ���ǰ�ڼ������� ********/
        int numIndex = 0;

        /********������ʱ�ж��Ƿ���Ҫ���㣬true ����Ҫ��false ��Ҫ***********/
        boolean getZero = false;
        // �ж������λ����һ�������������00 = 0, 01 = 1, 10, 11
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

        /******** ����������� *********/
        int zeroSize = 0;
        while (true) {
            if (number <= 0) break;
            // ÿ�λ�ȡ�����һ����
            numUnit = (int) (number % 10);
            if (numUnit > 0) {
                /******** ����ǧ��ǧ�ڣ�ǧ�ף�����ǰ���Ѿ����ڳ���3��0����Ҫ���ϵ�λ���ڻ�����************/
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
        /*********** ����������ǰ��׷�������ַ�����*****************/
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }
        return sb.toString();
    }
}
