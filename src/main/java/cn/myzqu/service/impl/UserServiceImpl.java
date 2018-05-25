package cn.myzqu.service.impl;

import cn.myzqu.dao.UserMapper;
import cn.myzqu.dto.PageDTO;
import cn.myzqu.dto.UserDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.exception.CustomException;
import cn.myzqu.pojo.User;
import cn.myzqu.service.UserService;
import cn.myzqu.utils.KeyUtil;
import cn.myzqu.utils.MD5Util;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.List;

/**
 * 用户服务接口实现类
 * Created by 的川 on 2018/5/8.
 */
@Service
public class UserServiceImpl implements UserService{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean login(String code, String password) {
        //查找用户名是否存在
        User user = userMapper.selectById(code);
        if(user==null) throw new CustomException(ResultEnum.LOGIN_FAIL);
        //获取数据库中的密码和秘钥
        String salt = user.getSalt();
        String encryptPassword = user.getPassword();
        //对传进来的passsword进行加密
        password = MD5Util.encrypt(password,salt);
        //和数据库中的密码进行对比
        if(encryptPassword.equals(password)||password==encryptPassword)
            return true;
        return false;
    }

    @Override
    public Boolean checkPassword(String id,String password) {
        //查找用户名是否存在
        User user = userMapper.selectById(id);
        if(user==null) throw new CustomException(ResultEnum.USER_NOT_EXIST);
        //获取数据库中的密码和秘钥
        String salt = user.getSalt();
        String encryptPassword = user.getPassword();
        //对传进来的passsword进行加密
        password = MD5Util.encrypt(password,salt);
        //和数据库中的密码进行对比
        if(encryptPassword.equals(password)||password==encryptPassword)
            return true;
        return false;
    }

    @Override
    public UserDTO findByWxId(String wxid) {
        UserDTO userDTO = new UserDTO();
        User user = userMapper.selectByWxid(wxid);
        //判断是否用户存在
        //1.不存在返回null
        if(StringUtils.isEmpty(user)) return null;
        //2.存在，复制user的属性值到userDTO
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }

    @Override
    public UserDTO findById(String id) {
        UserDTO userDTO = new UserDTO();
        //根据用户id查找用户
        User user = userMapper.selectById(id);
        //判断用户是否已经存在
        //1.不存在返回null
        if(StringUtils.isEmpty(user)){
            return null;
        }
        //2.存在，复制user到userDTO
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }

    @Override
    public PageDTO findAll(int pageNum, int pageSize) {
        //使用PageHelper插件实现分页
        //注意：下面这两条语句必须紧跟，保证分页安全
        Page page = PageHelper.startPage(pageNum,pageSize);
        List<UserDTO> list = userMapper.selectAll();
        //判断list是否有数据,没有数据返回null
        if(list.isEmpty()) return null;
        //获取总记录数
        int total = (int)page.getTotal();
        //获取总页数
        int pages = page.getPages();
        //封装数据到分页类PageDTO
        PageDTO pageDTO = new PageDTO(list,total,pageSize,pageNum,pages);
        return pageDTO;
    }

    @Override
    public Boolean add(User user) {
        //生成用户唯一id
        String id = KeyUtil.getUUID();
        user.setId(id);
        //检查用户名是否存在,存在抛出异常
        String name = user.getName();
        if(checkId(id)){
            throw new CustomException(ResultEnum.USER_NAME_EXIST);
        }
        //检查微信openid是否已经存在
        String wxid = user.getWxid();
        if(findByWxId(wxid)!=null){
            throw new CustomException(ResultEnum.WXID_EXITS);
        }
        //加密密码流程
        //1.获取随机秘钥
        String salt = KeyUtil.getSalt();
        user.setSalt(salt);
        //2.加密,获得加密后的密码
        String eccryptPassword = MD5Util.encrypt(user.getPassword(),salt);
        user.setPassword(eccryptPassword);
        //插入数据
        int result =  userMapper.insert(user);
        if(result>0){
            userMapper.userPointByRegister(user.getId());
            return true;
        }
        return false;
    }

    @Override
    public Boolean batchAdd(List<User> users) {
        for(User user :users){
            int result =  userMapper.insert(user);
            if(result<=0){
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean checkId(String id) {
        //调用dao查询
        User user = userMapper.selectById(id);
        //判断用户是否已经存在
        // 不存在返回false
        if(StringUtils.isEmpty(user)){
            return false;
        }
        return true;
    }

    @Override
    public Boolean lock(String id) {
        //检查用户id是否存在,不存在抛出异常
        if(!checkId(id)){
            throw new CustomException(ResultEnum.USER_NOT_EXIST);
        }
        User user = new User();
        user.setId(id);
        //设置lock为true，表示锁定账号
        user.setLocked(true);
        //更新数据
        int result = userMapper.updateById(user);
        if(result>0) return true;
        return false;
    }

    @Override
    public Boolean unLock(String id) {
        //检查用户id是否存在,不存在抛出异常
        if(!checkId(id)){
            throw new CustomException(ResultEnum.USER_NOT_EXIST);
        }
        User user = new User();
        user.setId(id);
        //设置lock为false，表示解除锁定账号
        user.setLocked(false);
        //更新数据
        int result = userMapper.updateById(user);
        if(result>0) return true;
        return false;
    }

    @Override
    public Boolean update(User user) {
        String id = user.getId();
        //检查用户id是否存在,不存在抛出异常
        if(!checkId(id)){
            throw new CustomException(ResultEnum.USER_NOT_EXIST);
        }
        int result = userMapper.updateById(user);
        if(result>0) return true;
        return false;
    }

    @Override
    public Boolean updatePassword(String id, String password) {
        //检查用户id是否存在,不存在抛出异常
        if(!checkId(id)){
            throw new CustomException(ResultEnum.USER_NOT_EXIST);
        }
        User user = new User();
        user.setId(id);
        //获取随机密码
        String salt = KeyUtil.getSalt();
        user.setSalt(salt);
        //加密密码
        password = MD5Util.encrypt(password,salt);
        user.setPassword(password);
        //向数据库更新数据
        int result = userMapper.updateById(user);
        if(result>0){
            return true;
        }
        return false;
    }


}
