package cn.myzqu.controller.user;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.dto.PointsDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.service.PointsService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chrky on 2018/5/23.
 */
@RestController
@RequestMapping("/points")
public class PointsController {

    @Autowired
    private PointsService pointsService;

    /**
     * 用户分享小程序获取积分
     * @param userId
     * @return
     */
    @PostMapping("/share")
    public Result shareApp(@RequestParam String userId)
    {
        if(pointsService.shareApp(userId))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.QUESTION_SHARE_FAIL);
    }

    /**
     * 根据用户id查询个人积分记录
     * @param userId
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/info")
    public Result getPointsByUserId(@RequestParam String userId,
                                    @RequestParam(value = "page",defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size)
    {
        PageDTO pageDTO=pointsService.findByUserId(userId,page,size);
        if (pageDTO == null)
            return ResultVOUtil.error(ResultEnum.POINT_NOT_EXIST);
        else
            return ResultVOUtil.success(pageDTO);
    }

    /**
     * 根据用户id查询该用户的积分记录，layui table使用
     * @param userId
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public Result getPointsByUser(@RequestParam String userId,
                                    @RequestParam(value = "page",defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size)
    {
        PageDTO pageDTO=pointsService.findByUserId(userId,page,size);
        if (pageDTO!=null){
            return ResultVOUtil.success(pageDTO.getRows(),pageDTO.getTotal());
        }
        return ResultVOUtil.error(ResultEnum.POINT_NOT_EXIST);
    }


    /**
     * 根据用户id查询用户积分
     * @param userId
     * @return
     */
    @GetMapping("/points")
    public Result calUserPoints(@RequestParam String userId)
    {
        PointsDTO pointsDTO=pointsService.calUserPoints(userId);
        if(pointsDTO!=null)
            return ResultVOUtil.success(pointsDTO);
        else
            return ResultVOUtil.error(ResultEnum.POINT_USER_FALL);
    }
}
