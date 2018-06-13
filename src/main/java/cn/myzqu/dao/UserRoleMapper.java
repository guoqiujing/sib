package cn.myzqu.dao;

import cn.myzqu.pojo.UserRole;

public interface UserRoleMapper {

    int deleteById(String id);

    int insert(UserRole record);

    UserRole selectById(String id);

    UserRole selectByUserId(String UserId);

    int updateById(UserRole record);

}