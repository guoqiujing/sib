package cn.myzqu.dao;

import cn.myzqu.dto.UserDTO;
import cn.myzqu.pojo.User;

import java.util.List;

public interface UserMapper {

    User selectById(String id);

    User selectByWxid(String wxid);

    List<UserDTO> selectAll();

    int deleteById(String id);

    int insert(User record);

    int updateById(User record);
}