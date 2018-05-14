package cn.myzqu.service;

import cn.myzqu.dto.ChoiceDTO;
import cn.myzqu.pojo.ChoiceQuestion;

import java.util.List;

/**
 * Created by Chrky on 2018/5/14.
 */
public interface ChoiceQuestionService {

    /**
     * 根据题目id查询题目
     * @param id
     * @return
     */
    ChoiceQuestion findById(String id);

    ChoiceQuestion findByQuestion(String id);//根据题目查询题目详情

    /**
     * 添加题目
     * @param choiceQuestion
     * @return
     */
    Boolean add(ChoiceQuestion choiceQuestion);

    /**
     * 根据题目id删除题目
     * @param id
     * @return
     */
    Boolean deleteById(String id);

    /**
     * 根据题库id查询题目
     * @param id
     * @return
     */
    List<ChoiceDTO> findByBankId(String id);

    /**
     * 根据题目id修改题目
     * @param choiceQuestion
     * @return
     */
    Boolean updateById(ChoiceQuestion choiceQuestion);
}
