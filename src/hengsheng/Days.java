package hengsheng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangsy
 * @date 2020/9/13 22:24
 */
public class Days {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(days(date));
    }

    /**
     *
     * @param date  当前日期
     * @return
     */
    public static int days(Date date) throws ParseException {
        int year = date.getYear() + 1900;
        long time = date.getTime();
        long startTime = new SimpleDateFormat("yyyyMMdd").parse(year + "0101").getTime();
        return (int) (time - startTime)/(1000*60*60*24);
    }
}
