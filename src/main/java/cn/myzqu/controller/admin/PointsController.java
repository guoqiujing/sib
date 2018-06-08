package cn.myzqu.controller.admin;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.Points;
import cn.myzqu.service.PointsService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Chrky on 2018/5/23.
 */
@RestController("AdminPointsController")
@RequestMapping("admin/points")
public class PointsController {

    @Autowired
    private PointsService pointsService;


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
