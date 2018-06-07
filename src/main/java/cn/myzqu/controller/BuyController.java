package cn.myzqu.controller;

import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.Buy;
import cn.myzqu.service.BuyService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Chrky on 2018/6/7.
 */
@RestController
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    private BuyService buyService;

    /**
     * 查询是否已购买该题库
     * @param userId
     * @param bankId
     * @return
     */
    @GetMapping("/info")
    public Result findByUser(@RequestParam String userId,@RequestParam String bankId)
    {
        Buy buy=buyService.findByUser(userId,bankId);
        if(buy!=null)
            return ResultVOUtil.success(buy);
        else
            return ResultVOUtil.error(ResultEnum.BUY_BANK_EMPTY);
    }

    /**
     * 用户购买题库
     * x-www-form
     * @param buy
     * @return
     */
    @PostMapping("/info")
    public Result buyBank(@Valid Buy buy)
    {
        if(buyService.buyBank(buy))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.BANK_BUY_FAIL);
    }
}
