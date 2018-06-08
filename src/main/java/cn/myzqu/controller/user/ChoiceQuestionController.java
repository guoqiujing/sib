package cn.myzqu.controller.user;

import cn.myzqu.dto.ChoiceDTO;
import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.ChoiceQuestion;
import cn.myzqu.service.ChoiceQuestionService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by Chrky on 2018/5/14.
 */
@RestController
@RequestMapping("/choice")
public class ChoiceQuestionController {

    @Autowired
    private ChoiceQuestionService choiceQuestionService;


    /**
     * 添加题目
     * @param choiceQuestion
     * @return
     */
    @PostMapping("/info")
    public Result addChoice(@Valid @RequestBody ChoiceQuestion choiceQuestion) {
        //添加题目
        if (choiceQuestionService.add(choiceQuestion))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.QUESTION_CREATE_FAIL);
    }

    /**
     * 根据id删除题目
     * @param id
     * @return
     */
    @DeleteMapping("/info/{id}")
    public Result deleteChoice(@PathVariable(value="id") String id) {
        System.out.println(id);
        //删除题目
        if (choiceQuestionService.deleteById(id))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.QUESTION_DELETE_FAIL);
    }

    /**
     * 根据id查询题目
     * @param id
     * @return
     */
    @GetMapping("/info/way/id")
    public Result getChoiceById(@RequestParam String id) {
        //创建choice对象
        ChoiceQuestion choiceQuestion = choiceQuestionService.findById(id);
        //根据题目id查询题目
        if (choiceQuestion == null)
            return ResultVOUtil.error(ResultEnum.QUESTION_NOT_EXIST);
        else
            return ResultVOUtil.success(choiceQuestion);
    }

    /**
     * 根据id修改题目信息
     * @param choiceQuestion
     * @return
     */
    @PutMapping("/info")
    public Result updateChoice(@RequestBody ChoiceQuestion choiceQuestion) {
        //修改题目信息
        if (choiceQuestionService.updateById(choiceQuestion))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.QUESTION_UPDATE_FAIL);
    }

    /**
     * 根据题库id查询该题库下的题目
     * @param id
     * @param userId
     * @return
     */
    @GetMapping("/info/way/bank")
    public Result getChoiceByBankId(@RequestParam String id,@RequestParam String userId) {
        //创建choice对象
        List<ChoiceDTO> choiceDTOS = choiceQuestionService.findByBankId(id,userId);
        //根据题库id查询题目
        if (choiceDTOS.isEmpty())
            return ResultVOUtil.error(ResultEnum.QUESTION_NOT_EXIST);
        else
            return ResultVOUtil.success(choiceDTOS);
    }

    /**
     * 题目综合排序
     * @param condition 说明:id 按编号排序 star_level按星级排序 否则按更新时间排序
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/info/sort")
    public Result getSort(@RequestParam Map<String, Object> condition,
                          @RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageDTO pageDTO = choiceQuestionService.findSort(condition, page, size);
        if (pageDTO == null)
            return ResultVOUtil.error(ResultEnum.QUESTION_NOT_EXIST);
        else
            return ResultVOUtil.success(pageDTO);
    }

    /**
     * 用户题库管理，根据题库id查询题库下的题目
     * @param id
     * @return
     */
    @GetMapping("/info/user/bank")
    public Result getUserChoiceByBankId(@RequestParam String id)
    {
        //创建choice对象
        List<ChoiceDTO> choiceDTOS = choiceQuestionService.findByUserBankId(id);
        //根据题库id查询题目
        if (choiceDTOS.isEmpty())
            return ResultVOUtil.error(ResultEnum.QUESTION_NOT_EXIST);
        else
            return ResultVOUtil.success(choiceDTOS);
    }

    /**
     * 根据用户id查询题目，layui table使用
     * @param id
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list/way/user")
    public Result getByUid(@RequestParam String id,
                                       @RequestParam(value="page",defaultValue = "1") Integer page,
                                       @RequestParam(value = "size",defaultValue = "10") Integer size) {
        PageDTO pageDTO = choiceQuestionService.findByUserId(id,page,size);
        if(pageDTO!=null){
            return ResultVOUtil.success(pageDTO.getRows(),pageDTO.getTotal());
        }
        return ResultVOUtil.error(ResultEnum.QUESTION_NOT_EXIST);
    }
}
