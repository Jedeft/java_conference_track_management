package com.jedeft.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jedeft on 2017/2/25.
 */
public class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

    private static Object lock = new Object();

    /**
     * add minute to time
     *
     * @param time
     * @param minute
     * @return
     * @throws ParseException
     */
    public static String addTime(String time, int minute) throws ParseException {
        Date date = null;
        String result = null;
        synchronized (lock) {
            date = sdf.parse(time);
            result = sdf.format(new Date(date.getTime() + minute * 60 * 1000L));
        }
        return result;
    }
}
