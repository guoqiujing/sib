package cn.myzqu.service.impl;

import cn.myzqu.dto.UserDTO;
import cn.myzqu.file.ReadExcel;
import cn.myzqu.pojo.User;
import cn.myzqu.service.UserService;
import cn.myzqu.utils.ListToPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by 的川 on 2018/5/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Test
    public void calUserValue() throws Exception {
        userService.calUserValue();
    }

    @Test
    public void add() throws Exception {

    }

    @Test
    public void batchAdd() throws Exception {
        String filePath = "D:/user.xlsx";
        List list = ReadExcel.start(filePath);
        List<User> users = ListToPojo.listToUser(list);
        userService.batchAdd(users);
        System.out.println(users);
    }

    @Autowired
    private UserService userService;

    @Test
    public void findByWxId() throws Exception {

        //
        String wxid = "111";
        UserDTO userDTO = userService.findByWxId(wxid);
        System.out.println(userDTO);


    }

}