package com.jedeft.bean;

import com.jedeft.config.Config;

/**
 * Created by jedeft on 2017/2/24.
 */
public class Talk {
    private String topic;
    private int duration;
    private boolean isSchedule;

    public Talk(String topic, int duration) {
        this.topic = topic;
        this.duration = duration;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isSchedule() {
        return isSchedule;
    }

    public void setSchedule(boolean schedule) {
        isSchedule = schedule;
    }

    public void parseDuration(String str) throws RuntimeException {
        if (str.contains("min")) {
            this.duration = Integer.parseInt(str.replace("min", ""));
        } else if (str.contains("lightning")) {
            this.duration = Config.LIGHTNING;
        } else {
            throw new RuntimeException("Error time : " + str);
        }
    }

    @Override
    public String toString() {
        return "Talk{" +
                "topic='" + topic + '\'' +
                ", duration=" + duration +
                ", isSchedule=" + isSchedule +
                '}';
    }
}
