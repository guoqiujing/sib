package cn.myzqu.service.impl;


import cn.myzqu.dao.ChoiceQuestionMapper;
import cn.myzqu.dto.ChoiceDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.exception.CustomException;
import cn.myzqu.pojo.ChoiceQuestion;
import cn.myzqu.pojo.QuestionBank;
import cn.myzqu.service.ChoiceQuestionService;
import cn.myzqu.utils.KeyUtil;
import cn.myzqu.utils.ResultVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by Chrky on 2018/5/14.
 */
@Service
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ChoiceQuestionMapper choiceQuestionMapper;

    @Override
    public ChoiceQuestion findById(String id) {
        //根据题目id查询题目
        return choiceQuestionMapper.selectById(id);
    }

    @Override
    public ChoiceQuestion findByQuestion(String question) {
        //根据题目查询题目详情
        return choiceQuestionMapper.selectByQuestion(question);
    }

    @Override
    public Boolean add(ChoiceQuestion choiceQuestion) {
        //判断该题目是否存在
        String question=choiceQuestion.getQuestion();
        if((findByQuestion(question))!=null)
            throw new CustomException(ResultEnum.QUESTION_IS_EXIST);
        //生成主键
        choiceQuestion.setId(KeyUtil.getUUID());
        //创建题目
        int result=choiceQuestionMapper.insert(choiceQuestion);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(String id) {
        //判断是否该题目是否存在
        if(findById(id)==null)
            throw new CustomException(ResultEnum.QUESTION_NOT_EXIST);
        int result=choiceQuestionMapper.deleteById(id);
        if(result>0)
            return true;
        else
            return false;
    }

    @Override
    public List<ChoiceDTO> findByBankId(String id) {
        //根据题库id查询题目
        return choiceQuestionMapper.selectByBankId(id);
    }

    @Override
    public Boolean updateById(ChoiceQuestion choiceQuestion) {
        //修改题目信息
        if (choiceQuestionMapper.updateById(choiceQuestion) > 0)
            return true;
        else
            return false;
    }
}
