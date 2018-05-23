package cn.myzqu.service.impl;

import cn.myzqu.dto.UserDTO;
import cn.myzqu.service.ChoiceQuestionService;
import cn.myzqu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by 的川 on 2018/5/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

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