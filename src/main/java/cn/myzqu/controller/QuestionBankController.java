package cn.myzqu.controller;

/**
 * Created by Chrky on 2018/5/10.
 */

import cn.myzqu.dto.BankDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.QuestionBank;
import cn.myzqu.service.QuestionBankService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import cn.myzqu.vo.ResultVO;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/questionBank")
public class QuestionBankController {

    @Autowired
    private QuestionBankService questionBankService;

    /**
     * 根据题库id查询题库
     *
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    public Result getQuestionBankById(@PathVariable("id") String id) {
        BankDTO BankDTO = questionBankService.findById(id);
        if (BankDTO != null) {
            return ResultVOUtil.success(BankDTO);
        }
        return ResultVOUtil.error(ResultEnum.BANK_NOT_EXIST);
    }

    /**
     * 创建题库
     *
     * @param questionBank
     * @return
     */
    @PostMapping("/info")
    public Result addQuestionBank(@Valid QuestionBank questionBank) {
        if (questionBankService.add(questionBank))
            return ResultVOUtil.success();
        return ResultVOUtil.error(ResultEnum.BANK_CREATE_FAIL);
    }

    /**
     * 根据题库id删除题库
     *
     * @param id
     * @return
     */
    @DeleteMapping("/info")
    public Result deleteQuestionBank(String id) {
        if (questionBankService.deleteById(id)) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.BANK_DELETE_FAIL);
    }

    /**
     * 根据用户id查询题库
     *
     * @param id
     * @return
     */
    @GetMapping("/infoByUserId")
    public Result getBankByUserId(@RequestParam("id") String id) {
        List<BankDTO> bankDTOS = questionBankService.selectByUserId(id);
        if (bankDTOS.isEmpty())
            return ResultVOUtil.error(ResultEnum.BANK_NOT_EXIST);
        else
            return ResultVOUtil.success(bankDTOS);
    }

    /**
     * 根据类目名称查询题库
     *
     * @param name
     * @return
     */
    @GetMapping("/infoByCategory")
    public Result getBankByCateName(@RequestParam(value = "name") String name) {
        List<BankDTO> bankDTOS = questionBankService.selectByCategory(name);
        if (bankDTOS.isEmpty())
            return ResultVOUtil.error(ResultEnum.BANK_NOT_EXIST);
        else
            return ResultVOUtil.success(bankDTOS);
    }

    /**
     * 根据练习人数排序题库
     *
     * @return
     */
    @GetMapping("/infoSortByNumber")
    public Result getBankByNumber() {
        List<BankDTO> bankDTOS = questionBankService.selectSortByNumber();
        if (bankDTOS.isEmpty())
            return ResultVOUtil.error(ResultEnum.BANK_NOT_EXIST);
        else
            return ResultVOUtil.success(bankDTOS);
    }

    /**
     * 根据星级排序题库
     *
     * @return
     */
    @GetMapping("/infoSortBylevel")
    public Result getBankBylevel() {
        List<BankDTO> bankDTOS = questionBankService.selectSortBylevel();
        if (bankDTOS.isEmpty())
            return ResultVOUtil.error(ResultEnum.BANK_NOT_EXIST);
        else
            return ResultVOUtil.success(bankDTOS);
    }

    /**
     * 修改题库信息
     * 只能用x-www-form-urlencoded
     * @param questionBank
     * @return
     */
    @PutMapping("/info")
    public Result updateQuestionbank(QuestionBank questionBank) {
        if (questionBankService.updateById(questionBank))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.BANK_UPDATE_FAIL);
    }

    /**
     * 根据题库标题模糊搜索题库
     * @param title
     * @return
     */
    @GetMapping("/infoSearch")
    public Result getBankByTitle(@RequestParam(value = "title") String title)
    {
        List<BankDTO> bankDTOS=questionBankService.searchByTitle(title);
        if(bankDTOS.isEmpty())
                return ResultVOUtil.error(ResultEnum.BANK_NOT_EXIST);
            else
                return ResultVOUtil.success(bankDTOS);
    }
}
