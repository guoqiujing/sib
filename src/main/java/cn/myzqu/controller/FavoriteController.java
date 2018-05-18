package cn.myzqu.controller;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.Favorite;
import cn.myzqu.service.FavoriteService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by Chrky on 2018/5/18.
 */
@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    /**
     * 收藏题目
     * @param favorite
     * @return
     */
    @PostMapping("/info")
    public Result addFavorite(@Valid Favorite favorite)
    {
        if(favoriteService.add(favorite))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.FAVORITE_ERROR);
    }
    /**
     * 取消收藏题目
     * @param id
     * @return
     */
    @DeleteMapping("/info")
    public Result cancelFavorite(@RequestParam String id) {
        //取消收藏
        if (favoriteService.deleteById(id))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.FAVORITE_CANCEL_ERROR);
    }

    /**
     * 用户查看收藏的所有题目
     * @param userId
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/info/way/user")
    public Result getFavoriteByUserId(@RequestParam String userId,
                                      @RequestParam(value="page",defaultValue = "1") Integer page,
                                      @RequestParam(value = "size",defaultValue = "10") Integer size) {
        PageDTO pageDTO = favoriteService.findByUserId(userId,page,size);
        if (pageDTO==null)
            return ResultVOUtil.error(ResultEnum.FAVORITE_EMPTY);
        else
            return ResultVOUtil.success(pageDTO);
    }

    /**
     * 根据收藏表id查看收藏记录
     * @param id
     * @return
     */
    @GetMapping("/info/way/id")
    public Result getFavoriteById(@RequestParam String id)
    {
        //创建favorite对象
        Favorite favorite=favoriteService.findStateById(id);
        if(favorite==null)
            return ResultVOUtil.error(ResultEnum.FAVORITE_EMPTY);
        else
            return ResultVOUtil.success(favorite);
    }
}
