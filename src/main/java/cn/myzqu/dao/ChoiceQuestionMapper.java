package cn.myzqu.dao;

import cn.myzqu.dto.ChoiceDTO;
import cn.myzqu.pojo.ChoiceQuestion;

import java.util.List;
import java.util.Map;

public interface ChoiceQuestionMapper {
    /**
     * 根据题目id删除题目
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 添加题目
     * @param choiceQuestion
     * @return
     */
    int insert(ChoiceQuestion choiceQuestion);

    /**
     * 根据题目id查询题目
     * @param id
     * @return
     */
    ChoiceQuestion selectById(String id);


    /**
     * 根据题目id修改题目
     * @param choiceQuestion
     * @return
     */
    int updateById(ChoiceQuestion choiceQuestion);

    /**
     * 根据题库id查询题目
     * @param id
     * @return
     */
    List<ChoiceDTO> selectByBankId(String id);

    /**
     * 综合查询(根据题目id，题目，答案，分析,用户id，题库标题模糊搜索）
     * @param map
     * @return
     */
    List<ChoiceDTO> select(Map<String,Object> map);

    /**
     * 根据题目查询题目详情
     * @param question
     * @return
     */
    ChoiceQuestion selectByQuestion(String question);

    List<ChoiceDTO> selectSort(Map<String,Object> map);//题目综合显示

    List<ChoiceDTO> selectByUserBankId(String id);

    List<ChoiceQuestion> selectAllChoice();//显示题目

    List<ChoiceDTO> selectByUserId(String userId);//根据用户id查询题目
}