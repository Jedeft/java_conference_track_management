package com.jedeft.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jedeft on 2017/2/25.
 */
public class DateUtil {
    /**
     * add minute to time
     * @param time
     * @param minute
     * @return
     * @throws ParseException
     */
    public static String addTime(String time, int minute) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        Date date = sdf.parse(time);
        return sdf.format(new Date(date.getTime() + minute * 60 * 1000));
    }
}
