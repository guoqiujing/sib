package cn.myzqu.controller;

import cn.myzqu.dto.ChoiceDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.ChoiceQuestion;
import cn.myzqu.service.ChoiceQuestionService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Chrky on 2018/5/14.
 */
@RestController
@RequestMapping("/choiceQuestion")
public class ChoiceQuestionController {

    @Autowired
    private ChoiceQuestionService choiceQuestionService;

    /**
     * 添加题目
     * @param choiceQuestion
     * @return
     */
    @PostMapping("/info")
    public Result addChoice(@Valid ChoiceQuestion choiceQuestion)
    {
        //添加题目
        if(choiceQuestionService.add(choiceQuestion))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.QUESTION_CREATE_FAIL);
    }

    /**
     * 根据题目id删除题目
     * @param id
     * @return
     */
    @DeleteMapping("/info")
    public Result deleteChoice(String id)
    {
        //删除题目
        if(choiceQuestionService.deleteById(id))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.QUESTION_DELETE_FAIL);
    }

    /**
     * 根据题目id查询题目
     * @param id
     * @return
     */
    @GetMapping("/infoById")
    public Result getChoiceById(String id)
    {
        //创建choice对象
        ChoiceQuestion choiceQuestion=choiceQuestionService.findById(id);
        //根据题目id查询题目
        if(choiceQuestion==null)
            return ResultVOUtil.error(ResultEnum.QUESTION_NOT_EXIST);
        else
            return ResultVOUtil.success(choiceQuestion);
    }

    /**
     * 根据题目id修改题目
     * @param choiceQuestion
     * @return
     */
    @PutMapping("/info")
    public Result updateChoice(ChoiceQuestion choiceQuestion)
    {
        //修改题目信息
        if(choiceQuestionService.updateById(choiceQuestion))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.QUESTION_UPDATE_FAIL);
    }

    /**
     * 根据题库id查询题目
     * @param id
     * @return
     */
    @GetMapping("/infoByBankId")
    public Result getChoiceByBankId(String id)
    {
        //创建choice对象
        List<ChoiceDTO> choiceDTOS=choiceQuestionService.findByBankId(id);
        //根据题库id查询题目
        if(choiceDTOS.isEmpty())
            return ResultVOUtil.error(ResultEnum.QUESTION_NOT_EXIST);
        else
            return ResultVOUtil.success(choiceDTOS);
    }
}
