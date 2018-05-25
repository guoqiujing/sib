package cn.myzqu.utils;

import cn.myzqu.file.ReadExcel;
import cn.myzqu.pojo.User;
import org.junit.Test;

import java.io.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 的川 on 2018/5/22.
 */

public class ListToPojoTest {
    @Test
    public void listToUser() throws Exception {

        String filePath = "D:/user.xlsx";

            List list = ReadExcel.start(filePath);
            List<User> users = ListToPojo.listToUser(list);

            System.out.println(users);

    }

}