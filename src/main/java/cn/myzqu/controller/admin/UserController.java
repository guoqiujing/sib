package cn.myzqu.controller.admin;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.service.UserService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 * Created by 的川 on 2018/5/8.
 */
@RestController("AdminUserController")
@RequestMapping("admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页获取所有用户
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public Result list(@RequestParam(value="page",defaultValue = "1") Integer page,
                                        @RequestParam(value = "size",defaultValue = "10") Integer size){
        PageDTO data = userService.findAll(page,size);
        if(data!=null) {
            return ResultVOUtil.success(data.getRows(),data.getTotal());
        }
        return ResultVOUtil.error(ResultEnum.USERLIST_EMPTY);
    }

}
