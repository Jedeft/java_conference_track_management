package com.jedeft.schedule;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jedeft on 2017/2/25.
 */
public class TalkTest {
    @Test
    public void testParseDuration() {
        Talk talk = new Talk();
        talk.parseDuration("15min");
        assertEquals(15, talk.getDuration());
        talk.parseDuration("lightning");
        assertEquals(5, talk.getDuration());
    }
}
