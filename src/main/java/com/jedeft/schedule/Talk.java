package com.jedeft.schedule;

import com.jedeft.config.TimeConstant;

/**
 * Created by jedeft on 2017/2/24.
 */
public class Talk {
    private String topic;
    private int duration;
    private boolean isSchedule;

    public Talk() {
    }

    public Talk(String topic, int duration) {
        this.topic = topic;
        this.duration = duration;
    }

    public Talk(String topic, int duration, boolean isSchedule) {
        this.topic = topic;
        this.duration = duration;
        this.isSchedule = isSchedule;
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
            this.duration = TimeConstant.LIGHTNING;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Talk talk = (Talk) o;

        if (duration != talk.duration) return false;
        return topic != null ? topic.equals(talk.topic) : talk.topic == null;
    }

    @Override
    public int hashCode() {
        int result = topic != null ? topic.hashCode() : 0;
        result = 31 * result + duration;
        return result;
    }


}
