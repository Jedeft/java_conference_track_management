package com.jedeft.utils;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by jedeft on 2017/2/24.
 */
public class FileUtil {
    public static List<String> loadFile(String filePath) throws IOException {
        List<String> lineList = new ArrayList<>();
        File file = new File(filePath);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                lineList.add(line);
            }
        } finally {
            if (fr != null) {
                fr.close();
            }
            if (br != null) {
                br.close();
            }
        }
        return lineList;
    }
}
