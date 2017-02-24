package com.jedeft.utils;

import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.*;

/**
 * Created by jedeft on 2017/2/24.
 */
public class FileUtilTest {
    @Test
    public void testLoadFile(){
        try {
            FileUtil.loadFile("input.txt");
        } catch (IOException e) {
            assertTrue(false);
            System.out.println(e);
        }

        try {
            FileUtil.loadFile("errorFile.txt");
            assertTrue(false);
        } catch (IOException e) {
            assertTrue(true);
        }
    }
}
