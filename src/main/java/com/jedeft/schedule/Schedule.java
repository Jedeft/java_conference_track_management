package com.jedeft.schedule;

import com.jedeft.bean.Talk;
import com.jedeft.utils.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jedeft on 2017/2/24.
 */
public class Schedule {

    public static void ScheduleConference(String filePath) throws IOException {
        List<String> lineList = FileUtil.loadFile(filePath);
        List<Talk> talkList = fillTalkList(lineList);
        for (Talk talk : talkList) {
            System.out.println(talk);
        }
    }

    /**
     * @param lineList: data from file lines
     * @return
     */
    public static List<Talk> fillTalkList(List<String> lineList) {
        List<Talk> talkList = new ArrayList<>();
        for (String line : lineList) {
            Talk talk = new Talk(line, 0);
            String[] wordArray = line.split(" ");
            try {
                talk.setDuration(wordArray[wordArray.length - 1]);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            talkList.add(talk);
        }
        return talkList;
    }
}
