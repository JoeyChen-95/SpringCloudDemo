package net.biancheng.c.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeUtils {
    public static boolean checkTimeConflict(Timestamp startTime1, Timestamp endTime1, Timestamp startTime2, Timestamp endTime2){
        if(startTime1.before(endTime2)&&endTime1.after(startTime2)){
            return true;//Conflict
        }
        return false;//Not conflict
    }

    public static int getTimeDifference(Timestamp timestamp1, Timestamp timestamp2){
        long t1=timestamp1.getTime();
        long t2=timestamp2.getTime();
        int hour=Math.abs((int)((t1-t2)/(1000*60*60)));
        return hour;
    }

    /**
     * 获取时间差,
     * @param endTime 结束页面
     * @param startTime 开始时间
     * @return
     */
    public static String getTimeDifferenceByString(Timestamp endTime, Timestamp startTime) {
        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        long t1 = endTime.getTime();
        long t2 = startTime.getTime();
        int hours=(int) ((t1 - t2)/(1000*60*60));
        int minutes=(int) (((t1 - t2)/1000-hours*(60*60))/60);
        int second=(int) ((t1 - t2)/1000-hours*(60*60)-minutes*60);
        hours=Math.abs(hours);
        minutes=Math.abs(minutes);
        second=Math.abs(second);
        return ""+hours+"Hours "+minutes+"Minutes "+second+"Seconds";
    }



}
