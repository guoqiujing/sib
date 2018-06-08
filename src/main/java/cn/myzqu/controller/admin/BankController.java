package cn.myzqu.controller.admin;

/**
 * Created by Chrky on 2018/5/10.
 */

import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.ChoiceQuestion;
import cn.myzqu.pojo.QuestionBank;
import cn.myzqu.service.QuestionBankService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController("AdminBankController")
@RequestMapping("admin/questionBank")
public class BankController {

    @Autowired
    private QuestionBankService questionBankService;


    /**
     * 根据题库id删除题库
     * @param id
     * @return
     */
    @DeleteMapping("/info/{id}")
    public Result deleteQuestionBank(@PathVariable (value="id") String id) {
        if (questionBankService.deleteById(id)) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.BANK_DELETE_FAIL);
    }


    /**
     * 根据题库id或题库标题或用户id或类目名称查询题库信息
     * @param condition  说明:  id or title or userId or categoryName
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/info")
    public Result get(@RequestParam Map<String,Object> condition,
                                    @RequestParam(value="page",defaultValue = "1") Integer page,
                                    @RequestParam(value = "size",defaultValue = "10") Integer size) {
        PageDTO pageDTO = questionBankService.find(condition,page,size);
        if (pageDTO==null)
            return ResultVOUtil.error(ResultEnum.BANK_NOT_EXIST);
        else
            return ResultVOUtil.success(pageDTO);
    }


    /**
     * 根据类目名称查询题库
     * @param name
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/info/way/type")
    public Result getTypeName(@RequestParam String name,
                              @RequestParam(value="page",defaultValue = "1") Integer page,
                              @RequestParam(value = "size",defaultValue = "10") Integer size) {
        PageDTO pageDTO = questionBankService.findByTypeName(name,page,size);
        if (pageDTO==null)
            return ResultVOUtil.error(ResultEnum.BANK_NOT_EXIST);
        else
            return ResultVOUtil.success(pageDTO);
    }

    /**
     * 用户根据题库标题模糊查询题库
     * @param title
     * @param page
     * @param size
     * @return
     */

    @GetMapping("/info/way/title")
    public Result getByTitle(@RequestParam String title,
                              @RequestParam(value="page",defaultValue = "1") Integer page,
                              @RequestParam(value = "size",defaultValue = "10") Integer size) {
        PageDTO pageDTO = questionBankService.searchByTitle(title,page,size);
        if (pageDTO==null)
            return ResultVOUtil.error(ResultEnum.BANK_NOT_EXIST);
        else
            return ResultVOUtil.success(pageDTO);
    }

    /**
     * 浏览题库信息
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public Result findAllBank(@RequestParam(value="page",defaultValue = "1") Integer page,
                              @RequestParam(value = "size",defaultValue = "10") Integer size) {
        PageDTO data = questionBankService.findAllBank(page, size);
        if (data != null) {
            return ResultVOUtil.success(data.getRows(), data.getTotal());
        }
        return ResultVOUtil.error(ResultEnum.BANK_NOT_EXIST);
    }

    /**
     * 修改审核信息 取消推荐题库
     * @param questionBank
     * @return
     */
    @PutMapping("/info/check")
    public Result checkBank(QuestionBank questionBank) {
        //审核题库信息
        if (questionBankService.check(questionBank)) {
            return ResultVOUtil.success();
        } else
            return ResultVOUtil.error(ResultEnum.BANK_CHECK_FAIL);
    }

    /**
     * 浏览推荐题库信息
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/greatList")
    public Result findGreatBank(@RequestParam(value="page",defaultValue = "1") Integer page,
                              @RequestParam(value = "size",defaultValue = "10") Integer size) {
        PageDTO data = questionBankService.findGreatBank(page, size);
        if (data != null) {
            return ResultVOUtil.success(data.getRows(), data.getTotal());
        }
        return ResultVOUtil.error(ResultEnum.BANK_NOT_EXIST);
    }
}
