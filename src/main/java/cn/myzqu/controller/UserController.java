package cn.myzqu.controller;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.dto.UserDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.User;
import cn.myzqu.service.UserService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 * Created by 的川 on 2018/5/8.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public Result list(@RequestParam(value="page",defaultValue = "1") Integer page,
                                        @RequestParam(value = "size",defaultValue = "10") Integer size){
        PageDTO data = userService.findAll(page,size);
        if(data==null) return ResultVOUtil.error(ResultEnum.USERLIST_EMPTY);
        return ResultVOUtil.success(data);
    }

    /**
     * 获取单个用户信息
     * @param id 用户id
     * @return
     */
    @GetMapping("/info/{id}")
    public Result getUserById(@PathVariable("id") String id){
        UserDTO userDTO = userService.findById(id);
        if(userDTO!=null){
            return ResultVOUtil.success(userDTO);
        }
        return ResultVOUtil.error(ResultEnum.USER_NOT_EXIST);
    }

    /**
     * 通过wxid获取用户信息
     * @param wxId
     * @return
     */
    @GetMapping("/info/wxid")
    public Result getUserByWxId(@RequestParam(value="wxid") String wxId){
        UserDTO userDTO = userService.findByWxId(wxId);
        if(userDTO!=null){
            return ResultVOUtil.success(userDTO);
        }
        return ResultVOUtil.error(ResultEnum.USER_NOT_EXIST);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/info")
    public Result addUser(@Validated @RequestBody  User user){
        System.out.println(user.getId());
        if(userService.add(user)){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.USER_CREATE_FAIL);
    }

    /**
     * 更新用户昵称、手机号码、电子邮箱
     * @param user
     * @return
     */
    @PutMapping("/info")
    public Result updateUser(@RequestBody  User user){
        //将可以更新的信息复制到新的对象
        User obejct = new User();
        obejct.setId(user.getId());
        obejct.setNickname(user.getNickname());
        obejct.setEmail(user.getEmail());
        obejct.setPhone(user.getPhone());
        //调用更新用户信息服务，更新信息到数据库
        if(userService.update(obejct)){
            //返回更新用户信息成功信息
            return ResultVOUtil.success();
        }
        //返回更新用户信息失败信息
        return ResultVOUtil.error(ResultEnum.USER_UPDATE_FAIL);
    }


    /**
     * 更新用户密码
     * @param id
     * @param password
     * @param newPassword
     * @return
     */
    @PutMapping("/password")
    public Result updatePassword(@RequestParam(value="id") String id,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "newPassword") String newPassword){
        //检测原密码是否正确
        if(!userService.checkPassword(id,password)) return ResultVOUtil.error(ResultEnum.PSSSWORD_ERROR);
        //更新密码
        if(userService.updatePassword(id,newPassword)) return ResultVOUtil.success();
        return ResultVOUtil.error(ResultEnum.PASSWORD_UPDATE_FAIL);

    }

}
