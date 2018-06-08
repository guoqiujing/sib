package cn.myzqu.controller.admin;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.service.RatingService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户星级评价控制层
 * Created by xiraly on 2018/5/22.
 */
@RestController("AdminRatingController")
@RequestMapping("admin/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    /**
     * 查找并分页显示用户星级评价记录（管理端
     * @param page  当前页数
     * @param size  当前页数的记录条数
     * @return
     */
    @GetMapping("/getAllRating")
    public Result getAllRating(@RequestParam(value="page",defaultValue = "1") Integer page,
                               @RequestParam(value = "size",defaultValue = "10") Integer size){
        PageDTO data = ratingService.findAllRating(page,size);
        if(data==null) return ResultVOUtil.error(ResultEnum.RATING_EMPTY);
        return ResultVOUtil.success(data);
    }
}
