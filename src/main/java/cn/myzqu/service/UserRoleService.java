package cn.myzqu.service;

import cn.myzqu.pojo.UserRole;

/**
 * Created by 的川 on 2018/6/13.
 */

public interface UserRoleService {

    /**
     * 根据用户id获取角色
     * @param userId
     * @return
     */
    UserRole findByUserId(String userId);
}
