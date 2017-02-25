package com.jedeft.schedule;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.doclint.Entity.ge;
import static com.sun.tools.internal.xjc.reader.Ring.add;
import static org.junit.Assert.*;

/**
 * Created by jedeft on 2017/2/25.
 */
public class ConferenceTest {

    List<Talk> oneDay;
    List<Talk> twoDays;
    Conference oneDayExpect;
    List<Conference> twoDaysExpect;

    @Before
    public void testBefore() {
        oneDay = new ArrayList<>();
        oneDay.add(new Talk("golang talk 60min", 60));
        oneDay.add(new Talk("java talk 60min", 60));
        oneDay.add(new Talk("angular talk 50min", 50));
        oneDay.add(new Talk("ruby talk 40min", 40));
        oneDay.add(new Talk("php talk 30min", 30));
        oneDayExpect = new Conference();
        oneDayExpect.getMorningSession().add(new Talk("java talk 60min", 60));
        oneDayExpect.getMorningSession().add(new Talk("angular talk 50min", 50));
        oneDayExpect.getMorningSession().add(new Talk("ruby talk 40min", 40));
        oneDayExpect.getMorningSession().add(new Talk("php talk 30min", 30));
        oneDayExpect.getAfternoonSession().add(new Talk("golang talk 60min", 60));

        twoDays = new ArrayList<>();
        twoDays.add(new Talk("golang talk 60min", 60));
        twoDays.add(new Talk("java talk 60min", 60));
        twoDays.add(new Talk("c talk 60min", 60));
        twoDays.add(new Talk("vue talk 60min", 60));
        twoDays.add(new Talk("angular talk 50min", 50));
        twoDays.add(new Talk("ruby talk 40min", 40));
        twoDays.add(new Talk("react talk 40min", 40));
        twoDays.add(new Talk("c++ talk 30min", 30));
        twoDays.add(new Talk("php talk 30min", 30));
        twoDays.add(new Talk("python talk 25min", 25));
        twoDays.add(new Talk("scala talk 15min", 15));
        twoDays.add(new Talk("lua talk lighting", 5));
        twoDaysExpect = new ArrayList<>();
        Conference conference = new Conference();
        conference.getMorningSession().add(new Talk("golang talk 60min", 60));
        conference.getMorningSession().add(new Talk("java talk 60min", 60));
        conference.getMorningSession().add(new Talk("c talk 60min", 60));
        conference.getAfternoonSession().add(new Talk("react talk 40min", 40));
        conference.getAfternoonSession().add(new Talk("php talk 30min", 30));
        conference.getAfternoonSession().add(new Talk("python talk 25min", 25));
        conference.getAfternoonSession().add(new Talk("scala talk 15min", 15));
        conference.getAfternoonSession().add(new Talk("lua talk lighting", 5));
        twoDaysExpect.add(conference);
        conference = new Conference();
        conference.getMorningSession().add(new Talk("vue talk 60min", 60));
        conference.getMorningSession().add(new Talk("angular talk 50min", 50));
        conference.getMorningSession().add(new Talk("ruby talk 40min", 40));
        conference.getMorningSession().add(new Talk("c++ talk 30min", 30));
        twoDaysExpect.add(conference);
    }

    @Test
    public void testScheduleSession() {
        Conference conference1 = new Conference();
        conference1.scheduleMorningSession(oneDay, true);
        assertArrayEquals(oneDayExpect.getMorningSession().toArray(), conference1.getMorningSession().toArray());
        conference1.scheduleAfternoonSession(oneDay, true);
        assertArrayEquals(oneDayExpect.getAfternoonSession().toArray(), conference1.getAfternoonSession().toArray());

        List<Conference> track = new ArrayList<>();
        track.add(new Conference());
        track.add(new Conference());
        for (int i = 0; i < track.size(); i++) {
            track.get(i).scheduleMorningSession(twoDays, i == track.size());
        }
        for (int i = 0; i < 2; i++) {
            track.get(i).scheduleAfternoonSession(twoDays, i == track.size());
        }
        for (int i = 0; i < track.size(); i++) {
            assertArrayEquals(twoDaysExpect.get(i).getMorningSession().toArray(), track.get(i).getMorningSession().toArray());
            assertArrayEquals(twoDaysExpect.get(i).getAfternoonSession().toArray(), track.get(i).getAfternoonSession().toArray());
        }
    }
}
