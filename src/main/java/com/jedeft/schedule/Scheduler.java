package com.jedeft.schedule;

import com.jedeft.utils.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jedeft on 2017/2/24.
 */
public class Scheduler {
    /**
     * @param filePath input filePath
     * @throws IOException
     */
    public static void ScheduleConference(String filePath) throws IOException {
        List<String> lineList = FileUtil.loadFile(filePath);
        List<Talk> talkList = fillTalkList(lineList);
        for (Talk talk : talkList) {
            System.out.println(talk);
        }
    }

    /**
     * @param lineList data from file lines
     * @return
     */
    public static List<Talk> fillTalkList(List<String> lineList) {
        List<Talk> talkList = new ArrayList<>();
        Talk talk = null;
        for (String line : lineList) {
            talk = new Talk(line, 0);
            String[] wordArray = line.split(" ");
            talk.parseDuration(wordArray[wordArray.length - 1]);
            talkList.add(talk);
        }
        return talkList;
    }

    /**
     * get unScheduled talk duration
     * @param talkList
     * @return
     */
    public static int getTotalDuration(List<Talk> talkList) {
        int totalDuration = 0;
        for (Talk talk : talkList) {
            if (!talk.isSchedule()) {
                totalDuration += talk.getDuration();
            }
        }
        return totalDuration;
    }

    /**
     * set talks scheduled whitch contained from scheduledList
     *
     * @param totalList     all totalks
     * @param scheduledList be sheduled talks
     */
    public static void setListSchedule(List<Talk> totalList, List<Talk> scheduledList) {
        for (int i = 0; i < totalList.size(); i++) {
            if (scheduledList.contains(totalList.get(i))) {
                totalList.get(i).setSchedule(true);
            }
        }
    }
}
