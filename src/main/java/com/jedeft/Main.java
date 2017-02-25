package com.jedeft;

import com.jedeft.schedule.Scheduler;
import org.apache.log4j.Logger;

/**
 * Created by jedeft on 2017/2/24.
 */
public class Main {
    private static Logger logger = Logger.getLogger("management");

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please input filePath params !");
            System.exit(-1);
        }
        try {
            Scheduler.ScheduleConference(args[0]);
        } catch (Exception e) {
            logger.error(e);
            System.exit(-1);
        }
    }
}
