package demo.untils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    /**
     * 根据时间点获取时间戳
     * @param time(HH:mm:ss)
     * @return
     */
    public static long getTimeMillis(String time) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
            return curDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取time和当前系统日期的时间戳
     * @param time
     * @return
     */
    public static long getTimeStamp(String time){
        long oneDay = 24 * 60 * 60 * 1000;
        long  initDelay = TimeUtil.getTimeMillis(time) - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;
        return initDelay;
    }

    public static void main(String[] args) {
        getTimeStamp();
    }

    public static Timestamp getTimeStamp(){
        int date = 20191111;
        int time = 0;
        String dateTmp0 = date+srtChange(time+"");
        String dateTmp = dateTmp0.substring(0,4)+"-"+dateTmp0.substring(4,6)+"-"+dateTmp0.substring(6,8)+" "
                +dateTmp0.substring(8,10)+":"+dateTmp0.substring(10,12)+":"+dateTmp0.substring(12,14);
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH24:mm:ss");
        try {
            Date curDate = dateFormat.parse(dateTmp);
            Timestamp timestamp = new Timestamp(curDate.getTime());
            return timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String srtChange(String str) {
        String tmp = "";
        for (int i = 0; i < 6-str.length() ; i++) {
            tmp = tmp+"0";
        }
        return tmp+str;
    }
}
