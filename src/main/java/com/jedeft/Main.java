package com.jedeft;

import com.jedeft.utils.FileUtil;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

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
            List<String> lineList = FileUtil.loadFile(args[0]);
            for (String line : lineList) {
                System.out.println(line);
            }
        } catch (IOException e) {
            logger.error(e);
            System.exit(-1);
        }
    }
}
