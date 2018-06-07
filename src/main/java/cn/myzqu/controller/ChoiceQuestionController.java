package cn.myzqu.controller;

import cn.myzqu.dto.ChoiceDTO;
import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.ChoiceQuestion;
import cn.myzqu.service.ChoiceQuestionService;
import cn.myzqu.service.PointsService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
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

    @Autowired
    private PointsService pointsService;

    /**
     * 添加题目
     *
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
     * 根据题目id删除题目
     * @param id
     * @return
     */
    @DeleteMapping("/info/{id}")
    public Result deleteChoice(@PathVariable(value="id") String id) {
        //删除题目
        if (choiceQuestionService.deleteById(id))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.QUESTION_DELETE_FAIL);
    }

    /**
     * 根据题目id查询题目
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
     * 根据题目id修改题目
     * @param choiceQuestion
     * @return
     */
    @PutMapping("/info")
    public Result updateChoice(ChoiceQuestion choiceQuestion) {
        //修改题目信息
        if (choiceQuestionService.updateById(choiceQuestion))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(ResultEnum.QUESTION_UPDATE_FAIL);
    }

    /**
     * 根据题库id查询题目
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
     * 综合查询(根据题目id，题目，答案，分析,用户id，题库标题模糊搜索）
     * @param condition 与上面注释对应说明:id question answer analysis userId title
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/info")
    public Result get(@RequestParam Map<String, Object> condition,
                      @RequestParam(value = "page", defaultValue = "1") Integer page,
                      @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageDTO pageDTO = choiceQuestionService.find(condition, page, size);
        if (pageDTO == null)
            return ResultVOUtil.error(ResultEnum.QUESTION_NOT_EXIST);
        else
            return ResultVOUtil.success(pageDTO);

    }

    /**
     * 题目综合显示
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
     * 修改审核信息
     *
     * @param choiceQuestion
     * @return
     */
    @PutMapping("/info/check")
    public Result checkChoice(ChoiceQuestion choiceQuestion) {
        //审核题目信息
        if (choiceQuestionService.check(choiceQuestion)) {
            pointsService.checkChoice(choiceQuestion.getUserId());
            return ResultVOUtil.success();
        } else
            return ResultVOUtil.error(ResultEnum.QUESTION_CHECK_FAIL);
    }

    /**
     * 用户题库管理根据题库id查看题目
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
     * 根据用户id查询题目
     * @param id
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list/way/user")
    public Map<String,Object> getByUid(@RequestParam String id,
                                       @RequestParam(value="page",defaultValue = "1") Integer page,
                                       @RequestParam(value = "size",defaultValue = "10") Integer size) {
        PageDTO pageDTO = choiceQuestionService.findByUserId(id,page,size);
        Map<String,Object> result = new HashMap<>();
        if(pageDTO!=null){
            result.put("code",0);
            result.put("data",pageDTO.getRows());
            result.put("count",pageDTO.getTotal());
            return result;
        }
        result.put("code",525);
        result.put("msg","没有查询到题目");
        return result;
    }
}
