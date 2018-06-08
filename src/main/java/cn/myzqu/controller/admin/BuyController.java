package cn.myzqu.controller.admin;

import cn.myzqu.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chrky on 2018/6/7.
 */
@RestController("AdminBuyController")
@RequestMapping("admin/buy")
public class BuyController {

    @Autowired
    private BuyService buyService;


}
