package com.jedeft.schedule;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jedeft on 2017/2/24.
 */
public class SchedulerTest {

    List<Talk> talkList;
    List<Talk> scheduleList;
    List<Talk> expectList;
    int totalDuration;

    @Before
    public void testBefore() {
        talkList = new ArrayList<>();
        talkList.add(new Talk("golang talk 60min", 60));
        talkList.add(new Talk("java talk 60min", 60));
        scheduleList = new ArrayList<>(talkList);
        talkList.add(new Talk("ruby talk 50min", 50));
        for (Talk talk : talkList) {
            totalDuration += talk.getDuration();
        }
        expectList = new ArrayList<>();
        expectList.add(new Talk("golang talk 60min", 60, true));
        expectList.add(new Talk("java talk 60min", 60, true));
        expectList.add(new Talk("ruby talk 50min", 50, false));
    }

    @Test
    public void testScheduleConference() {
        try {
            Scheduler.ScheduleConference("input.txt");
        } catch (IOException e) {
            e.printStackTrace();
            assertTrue(false);
        }

        try {
            Scheduler.ScheduleConference("errorFile.txt");
            assertTrue(false);
        } catch (IOException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testFillTalkList() {
        try {
            Scheduler.ScheduleConference("input.txt");
        } catch (IOException e) {
            e.printStackTrace();
            assertTrue(false);
        }

        try {
            Scheduler.ScheduleConference("errorFile.txt");
            assertTrue(false);
        } catch (IOException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetTotalDuration() {
        assertEquals(totalDuration, Scheduler.getTotalDuration(talkList));
    }

    @Test
    public void testSetListSchedule() {
        Scheduler.setListSchedule(talkList, scheduleList);
        assertArrayEquals(expectList.toArray(), talkList.toArray());
    }
}
