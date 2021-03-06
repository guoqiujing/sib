package cn.myzqu.controller.user;

import cn.myzqu.dto.BankDTO;
import cn.myzqu.dto.BuyDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.Buy;
import cn.myzqu.service.BuyService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Chrky on 2018/6/7.
 */
@RestController
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    private BuyService buyService;

    /**
     * 检查用户是否用户该题库使用权
     * @param userId 用户id
     * @param bankId 题库id
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
    public Result buyBank(@Valid @RequestBody Buy buy)
    {
        if(buyService.buyBank(buy))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.BANK_BUY_FAIL);
    }

    /**
     * 根据用户id查询购买记录
     * @param userId
     * @return
     */
    @GetMapping("/record")
    public Result buyRecord(@RequestParam String userId)
    {
        List<BuyDTO> bankDTOList=buyService.findBuyByUser(userId);
        if(bankDTOList.isEmpty())
            return ResultVOUtil.error(ResultEnum.BUY_BANK_EMPTY);
        else
            return ResultVOUtil.success(bankDTOList);
    }
}
