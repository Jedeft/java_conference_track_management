package com.jedeft.schedule;

import com.jedeft.utils.FileUtil;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by jedeft on 2017/2/24.
 */
public class ScheduleTest {
    @Test
    public void testScheduConference() {
        try {
            Schedule.ScheduleConference("input.txt");
        } catch (IOException e) {
            System.out.println(e);
            assertTrue(false);
        }

        try {
            Schedule.ScheduleConference("errorFile.txt");
            assertTrue(false);
        } catch (IOException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testFillTalkList() {
        try {
            Schedule.ScheduleConference("input.txt");
        } catch (IOException e) {
            assertTrue(false);
            System.out.println(e);
        }

        try {
            Schedule.ScheduleConference("errorFile.txt");
            assertTrue(false);
        } catch (IOException e) {
            assertTrue(true);
        }
    }
}
