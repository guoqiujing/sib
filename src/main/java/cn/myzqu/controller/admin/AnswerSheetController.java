package cn.myzqu.controller.admin;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.service.AnswerSheetService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 答题控制处理器
 * Created by 的川 on 2018/5/10.
 */
@RestController("AdminAnswerSheetController")
@RequestMapping("admin/answerSheet")
public class AnswerSheetController {

    @Autowired
    private AnswerSheetService answerSheetService;


    /**
     * 多条件分页查询
     * @param condition，说明 userId：用户id,answerIsTrue:答案是对还是错
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public Result getList(@RequestParam Map<String,Object> condition,
                          @RequestParam(value="page",defaultValue = "1") Integer page,
                          @RequestParam(value = "size",defaultValue = "10") Integer size){
        System.out.println(condition.get("userId"));
        PageDTO data = answerSheetService.findByCondition(condition,page,size);
        if (data!=null) return ResultVOUtil.success(data.getRows(),data.getTotal());
        return  ResultVOUtil.error(ResultEnum.ANSWERSHEETLIST_EMPTY);
    }

}
