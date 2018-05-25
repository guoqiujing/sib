package cn.myzqu.dao;

import cn.myzqu.dto.UserDTO;
import cn.myzqu.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 根据用户id删除用户
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 新插入一条用户信息
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 根据用户id更新用户信息
     * @param record
     * @return
     */
    int updateById(User record);


    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    User selectById(String id);

    /**
     * 根据用户名查询用户信息
     * @param name
     * @return
     */
    User selectByName(String name);

    /**
     * 根据用户微信id查询用户信息
     * @param wxid
     * @return
     */
    User selectByWxid(String wxid);

    /**
     * 查询所有用户信息
     * @return
     */
    List<UserDTO> selectAll();

    /**
     * 综合查询用户信息
     * @param user
     * @return
     */
    List<UserDTO> select(User user);

    /**
     * 用户注册获得100积分
     * @param id
     * @return
     */
    int userPointByRegister(String id);

    //int userPointBySign(String id);
}