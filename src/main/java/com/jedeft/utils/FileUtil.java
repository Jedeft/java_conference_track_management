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
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while ((line = br.readLine()) != null) {
            lineList.add(line);
        }
        return lineList;
    }
}
