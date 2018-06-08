package cn.myzqu.controller.user;

import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.Rating;
import cn.myzqu.service.PointsService;
import cn.myzqu.service.RatingService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户星级评价控制层
 * Created by xiraly on 2018/5/22.
 */
@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;
    @Autowired
    private PointsService pointsService;

    /**
     * 添加用户星级评价记录（微信端
     * @param rating 星级类对象
     * @return
     */
    @PostMapping("/addRating")
    public Result addRating(@Validated @RequestBody Rating rating){
        //调用ratingService，成功则返回信息
        if(ratingService.addRatingRecord(rating)) {
            pointsService.ChoiceByGrade(rating.getUserId());
            return ResultVOUtil.success();
        }
        //失败则返回异常
        return ResultVOUtil.error(ResultEnum.ERROR);
    }

    /**
     * 判断用户是否已经评价题目星级，如果有就返回该用户的星级评价记录（微信端
     * @param userId  用户id
     * @param questionId  题目id
     * @return
     */
    @GetMapping("/getRating")
    public Result getRating(@RequestParam String userId,String questionId){
        Rating rating = ratingService.findByUserId(userId,questionId);
        //调用ratingService，查找到就返回提示信息和数据
        if(rating!=null) return ResultVOUtil.error(ResultEnum.RATING_COMPLETION,rating);
        //没有就只返回提示信息
        return ResultVOUtil.error(ResultEnum.RATING_UNCOMPLETE);
    }

}
