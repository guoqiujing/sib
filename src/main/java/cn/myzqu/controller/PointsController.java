package cn.myzqu.controller;

import cn.myzqu.enums.ResultEnum;
import cn.myzqu.service.PointsService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chrky on 2018/5/23.
 */
@RestController
@RequestMapping("/points")
public class PointsController {

    @Autowired
    private PointsService pointsService;

    @PostMapping("/sign")
    public Result Sign(@RequestParam String userId)
    {
        if(pointsService.Sign(userId))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.POINT_SIGN_ERROR);
    }
}
