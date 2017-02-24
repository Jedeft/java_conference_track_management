package com.jedeft;

import com.jedeft.utils.FileUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by jedeft on 2017/2/24.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please input fileName params");
            System.exit(-1);
        }
        try {
            List<String> lineList = FileUtil.loadFile("input.txt");
            for (String line : lineList) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            System.exit(-1);
        }
    }
}
