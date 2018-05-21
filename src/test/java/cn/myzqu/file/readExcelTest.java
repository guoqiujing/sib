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
            in = new FileInputStream(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ReadExcel.start(in,filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}