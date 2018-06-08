package cn.myzqu.controller.user;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.Favorite;
import cn.myzqu.service.FavoriteService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Chrky on 2018/5/18.
 */
@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    /**
     * 用户收藏题目
     * @param favorite
     * @return
     */
    @PostMapping("/info")
    public Result addFavorite(@Valid @RequestBody Favorite favorite)
    {
        if(favoriteService.add(favorite))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.FAVORITE_ERROR);
    }
    /**
     * 用户取消收藏题目
     * @param favorite
     * @return
     */
    @DeleteMapping("/info")
    public Result cancelFavorite(@Valid @RequestBody Favorite favorite) {
        //取消收藏
        if (favoriteService.deleteById(favorite))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.FAVORITE_CANCEL_ERROR);
    }

    /**
     * 用户查看自己收藏的所有题目
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
     * 根据id查看收藏详情
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
