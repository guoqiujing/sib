package cn.myzqu.controller.admin;

import cn.myzqu.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chrky on 2018/5/18.
 */
@RestController("AdminFavoriteController")
@RequestMapping("admin/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;



}
