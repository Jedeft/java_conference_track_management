package com.jedeft.schedule;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.jedeft.schedule.Scheduler.fillTalkList;
import static com.sun.tools.internal.xjc.reader.Ring.add;
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
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

        try {
            Scheduler.ScheduleConference("errorFile.txt");
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void testFillTalkList() {
        List<String> lineList = new ArrayList<>();
        lineList.add("test topic 50min");
        List<Talk> talkList = Scheduler.fillTalkList(lineList);
        assertEquals(new Talk("test topic 50min", 50), talkList.get(0));
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
