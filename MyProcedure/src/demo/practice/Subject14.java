package demo.practice;

/**
 * 【程序14】
 * 题目：输入某年某月某日，判断这一天是这一年的第几天？
 */
public class Subject14 {
    public static void main(String[] args) {
        dayNum("2018-03-08");
        dayNum("1900-03-08");
        dayNum("2000-03-08");
        dayNum("2020-03-08");
        dayNum("2018-02-08");
        dayNum("1900-02-08");
        dayNum("2000-02-08");
        dayNum("2020-02-08");

    }

    public static void dayNum(String date){
        String[] dateStr = date.split("-");
        int dayNum = 0;
        if(leapYear(dateStr[0])){
            dayNum = month(dateStr[1] ,"1") + Integer.parseInt(dateStr[2]);
        }else{
            dayNum = month(dateStr[1] ,"0") + Integer.parseInt(dateStr[2]);
        }
        System.out.println("输入日期为该（"+dateStr[0]+"）年的第"+dayNum+"天");
    }

    /**
     * 根据年份判断闰年还是普通年
     * @param year
     * @return
     */
    public static boolean leapYear(String year){
        int years = Integer.parseInt(year);
        if((years%4 ==0 && years%100!=0) || years%400 == 0){
            return true;
        }
        return false;
    }

    /**
     * 根据月份获取天数
     * @param month
     * @param flag
     * @return
     */
    public static int month(String month,String flag){
        int dayNum = 0;
        switch (month){
            case "01": dayNum = 0; break;
            case "02": dayNum = month("01", flag) +31; break;
            case "03":
                if("0".equals(flag)) {
                    dayNum = month("02", flag) + 28;
                }else {
                    dayNum = month("02", flag) + 29;
                }
                break;
            case "04": dayNum = month("03", flag) + 31; break;
            case "05": dayNum = month("04", flag) + 30; break;
            case "06": dayNum = month("05", flag) + 31; break;
            case "07": dayNum = month("06", flag) + 30; break;
            case "08": dayNum = month("07", flag) + 31; break;
            case "09": dayNum = month("08", flag) + 31; break;
            case "10": dayNum = month("09", flag) + 30; break;
            case "11": dayNum = month("10", flag) + 31; break;
            case "12": dayNum = month("11", flag) + 30; break;
        }
        return dayNum;
    }

}
