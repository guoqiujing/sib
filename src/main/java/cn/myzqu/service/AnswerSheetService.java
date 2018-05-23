package cn.myzqu.service;

import cn.myzqu.dto.AnswerSheetDTO;
import cn.myzqu.dto.PageDTO;
import cn.myzqu.dto.QuestionCountDTO;
import cn.myzqu.pojo.AnswerSheet;

import java.util.List;
import java.util.Map;

/**
 * 答题类服务接口
 * Created by 的川 on 2018/5/11.
 */
public interface AnswerSheetService {

    /**
     * 新增一条答题记录
     * @param answerSheet
     * @return
     */
    Boolean add(AnswerSheet answerSheet);

    /**
     * 根据id查询答题记录
     * @param id
     * @return
     */
    AnswerSheet find(String id);

    /**
     * 根据用户id查询答题记录
     * @param userId
     * @return
     */
    List<AnswerSheetDTO> findByUserId(String userId);

    /**
     * 根据用户id查询题目数量信息
     * @param userId
     * @return
     */
    QuestionCountDTO findCount(String userId);

    /**
     * 根据用户id查询错题记录
     * @param userId
     * @return
     */
    List<AnswerSheetDTO> findFaultByUserId(String userId);

    /**
     * 根据自定义条件分页查询
     * @param condition
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDTO findByCondition(Map<String,Object> condition,int pageNum, int pageSize);



}
