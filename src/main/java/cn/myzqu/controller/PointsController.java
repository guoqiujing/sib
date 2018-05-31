package cn.myzqu.controller;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.Points;
import cn.myzqu.service.PointsService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by Chrky on 2018/5/23.
 */
@RestController
@RequestMapping("/points")
public class PointsController {

    @Autowired
    private PointsService pointsService;

    /**
     * 用户分享小程序
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
     * 浏览用户积分记录
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/info/User")
    public Result getPointsByUser( @RequestParam(value = "page",defaultValue = "1") Integer page,
                                   @RequestParam(value = "size", defaultValue = "10") Integer size)
    {
        PageDTO pageDTO=pointsService.find(page,size);
        if(pageDTO==null)
            return ResultVOUtil.error(ResultEnum.POINT_NOT_EXIST);
        else
            return ResultVOUtil.success(pageDTO);
    }

    /**
     * 根据用户id和时间段查询积分记录
     * @param condition
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/info/way/time")
    public Result getUserPointsByTime(@RequestParam Map<String, Object> condition,
                                      @RequestParam(value = "page", defaultValue = "1") Integer page,
                                      @RequestParam(value = "size", defaultValue = "10") Integer size)
    {
        PageDTO pageDTO=pointsService.selectUserByTime(condition,page,size);
        if(pageDTO==null)
            return ResultVOUtil.error(ResultEnum.POINT_NOT_EXIST);
        else
            return ResultVOUtil.success(pageDTO);
    }

    /**
     * 批量增加用户积分
     * @param points
     * @return
     */
    @PostMapping("/info")
    public Result addUsersPoints(@RequestBody List<Points> points)
    {
        if(pointsService.addUser(points))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.POINT_ADD_FAIL);
    }
}
