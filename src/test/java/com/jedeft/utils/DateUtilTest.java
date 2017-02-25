package com.jedeft.utils;

import org.junit.Test;


import java.text.ParseException;

import static com.jedeft.utils.DateUtil.addTime;
import static org.junit.Assert.*;
/**
 * Created by jedeft on 2017/2/25.
 */
public class DateUtilTest {
    @Test
    public void testAddTime(){
        try {
            String result = DateUtil.addTime("09:00",60);
            assertEquals("10:00", result);
        } catch (ParseException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
