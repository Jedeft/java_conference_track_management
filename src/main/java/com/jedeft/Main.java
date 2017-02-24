package com.jedeft;

import com.jedeft.schedule.Schedule;
import org.apache.log4j.Logger;
import java.io.IOException;

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
            Schedule.ScheduleConference(args[0]);
        } catch (Exception e) {
            logger.error(e);
            System.exit(-1);
        }
    }
}
