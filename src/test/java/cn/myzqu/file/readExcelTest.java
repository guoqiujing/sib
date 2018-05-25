package cn.myzqu.file;

import org.junit.Test;

import java.io.*;


/**
 * Created by 的川 on 2018/5/18.
 */

public class readExcelTest {

    @Test
    public void test1()  {
        String filePath = "D:/test.xlsx";
        InputStream in = null;
        try {
            ReadExcel.start(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}