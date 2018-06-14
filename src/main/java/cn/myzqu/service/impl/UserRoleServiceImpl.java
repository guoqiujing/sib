package cn.myzqu.service.impl;

import cn.myzqu.dao.UserRoleMapper;
import cn.myzqu.pojo.UserRole;
import cn.myzqu.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 用户角色关系接口实现类
 * Created by 的川 on 2018/6/13.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserRole findByUserId(String userId) {
        UserRole userRole = userRoleMapper.selectByUserId(userId);
        if(StringUtils.isEmpty(userRole)) return null;
        return userRole;
    }
}
