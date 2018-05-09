package cn.myzqu.service;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.dto.UserDTO;
import cn.myzqu.pojo.User;

/**
 * 用户服务接口
 * Created by 的川 on 2018/5/8.
 */
public interface UserService {

    /**
     * 登录处理
     * @param code
     * @param password
     * @return
     */
    Boolean login(String code,String password);

    /**
     * 核对密码是否正确
     * @param id
     * @param password
     * @return
     */
    Boolean checkPassword(String id,String password);

    /**
     * 根据微信openId查询用户信息
     * @param wxid
     * @return
     */
    UserDTO findByWxId(String wxid);

    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    UserDTO findById(String id);


    /**
     * 新增一条用户信息
     * @param user
     * @return
     */
    Boolean add(User user);

    /**
     * 锁定用户账号
     * @param id
     * @return
     */
    Boolean lock(String id);

    /**
     * 解除锁定用户账号
     * @param id
     * @return
     */
    Boolean unLock(String id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Boolean update(User user);

    /**
     * 修改账号密码
     * @param id
     * @param password
     * @return
     */
    Boolean updatePassword(String id,String password);

    /**
     * 分页查询所有用户信息
     * @param pageNum 当前页数，表示从第 pageNum 页开始查询
     * @param pageSize 每页记录数，同Mysql中的limit
     * @return
     */
    PageDTO findAll(int pageNum,int pageSize);

}
