package com.jedeft.schedule;

import com.jedeft.constant.TimeConstant;
import com.jedeft.utils.DateUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jedeft on 2017/2/25.
 */
public class Conference {
    private List<Talk> morningSession;
    private List<Talk> afternoonSession;

    public Conference() {
        this.morningSession = new ArrayList<>();
        this.afternoonSession = new ArrayList<>();
    }

    public List<Talk> getMorningSession() {
        return morningSession;
    }

    public void setMorningSession(List<Talk> morningSession) {
        this.morningSession = morningSession;
    }

    public List<Talk> getAfternoonSession() {
        return afternoonSession;
    }

    public void setAfternoonSession(List<Talk> afternoonSession) {
        this.afternoonSession = afternoonSession;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "morningSession=" + morningSession +
                ", afternoonSession=" + afternoonSession +
                '}';
    }

    /**
     * schedule morning session
     *
     * @param talkList total talks
     * @param isLast   true means only one day or last day
     */
    public void scheduleMorningSession(List<Talk> talkList, boolean isLast) {
        for (int i = 0, totalSize = talkList.size(); i < totalSize; i++) {
            List<Talk> morningSession = new ArrayList<>();
            int totalDuration = 0;
            for (int j = i, talkSize = talkList.size(); j < talkSize; j++) {
                if (talkList.get(j).isSchedule()) {
                    continue;
                }
                if (talkList.get(j).getDuration() > TimeConstant.SESSION_MIN_DURATION ||
                        (talkList.get(j).getDuration() + totalDuration > TimeConstant.SESSION_MIN_DURATION)) {
                    continue;
                }
                morningSession.add(talkList.get(j));
                totalDuration += talkList.get(j).getDuration();
                if (totalDuration == TimeConstant.SESSION_MIN_DURATION ||
                        (isLast && Scheduler.getTotalDuration(talkList) < TimeConstant.SESSION_MIN_DURATION)) {
                    break;
                }
            }
            if (totalDuration == TimeConstant.SESSION_MIN_DURATION ||
                    (isLast && Scheduler.getTotalDuration(talkList) < TimeConstant.SESSION_MIN_DURATION)) {
                this.morningSession = morningSession;
                Scheduler.setListSchedule(talkList, morningSession);
                break;
            }
        }
    }

    /**
     * schedule afternoon session
     *
     * @param talkList total talks
     */
    public void scheduleAfternoonSession(List<Talk> talkList) {
        for (int i = 0, talkSize = talkList.size(); i < talkSize; i++) {
            List<Talk> afternoonSession = new ArrayList<>();
            int totalDuration = 0;
            for (int j = i, totalSize = talkList.size(); j < totalSize; j++) {
                if (talkList.get(j).isSchedule()) {
                    continue;
                }
                if (talkList.get(j).getDuration() > TimeConstant.SESSION_MAX_DURATION ||
                        (talkList.get(j).getDuration() + totalDuration > TimeConstant.SESSION_MAX_DURATION)) {
                    continue;
                }
                afternoonSession.add(talkList.get(j));
                totalDuration += talkList.get(j).getDuration();
                if (totalDuration >= TimeConstant.SESSION_MIN_DURATION && totalDuration <= TimeConstant.SESSION_MAX_DURATION) {
                    break;
                }
            }
            // if remain total Duration less than SESSION_MIN_DURATION, ten set afternoonSession
            if (totalDuration >= TimeConstant.SESSION_MIN_DURATION && totalDuration <= TimeConstant.SESSION_MAX_DURATION ||
                    Scheduler.getTotalDuration(talkList) < TimeConstant.SESSION_MIN_DURATION) {
                this.afternoonSession = afternoonSession;
                Scheduler.setListSchedule(talkList, afternoonSession);
                break;
            }
        }
    }

    public void output() throws ParseException {
        String time = "09:00";
        for (Talk talk : this.morningSession) {
            System.out.println(time + "AM " + talk.getTopic());
            time = DateUtil.addTime(time, talk.getDuration());
        }
        System.out.println("12:00PM Lunch");
        time = "13:00";
        for (Talk talk : this.afternoonSession) {
            System.out.println(time + "PM " + talk.getTopic());
            time = DateUtil.addTime(time, talk.getDuration());
        }
        System.out.println("05:00PM Networking Event");
    }
}
