package cn.myzqu.dao;

import cn.myzqu.dto.UserDTO;
import cn.myzqu.pojo.User;
import cn.myzqu.pojo.UserRole;
import cn.myzqu.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 的川 on 2018/6/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleMapperTest {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserMapper userMapper;


    @Test
    public void deleteById() throws Exception {

    }

    @Test
    public void insert() throws Exception {

        //遍历所有用户
        List<UserDTO> userDTOS = userMapper.selectAll();
        for(UserDTO userDTO : userDTOS){
            UserRole userRole = new UserRole();
            userRole.setId(KeyUtil.getUUID());
            userRole.setRoleName("user");
            userRole.setUserId(userDTO.getId());
            if(userRoleMapper.insert(userRole)>0){
                System.out.println(userDTO.getId()+"插入成功");
            }else {
                System.out.println(userDTO.getId()+"插入失败");
            }
        }

    }

    @Test
    public void selectById() throws Exception {

    }

    @Test
    public void selectByUserId() throws Exception {
        UserRole userRole = userRoleMapper.selectByUserId("ed75ea689030458ea3c5001e372da412");
        System.out.println(userRole.getRoleName());
    }

    @Test
    public void updateById() throws Exception {

    }

}