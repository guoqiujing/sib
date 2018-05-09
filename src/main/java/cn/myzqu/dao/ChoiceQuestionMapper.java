package cn.myzqu.dao;

import cn.myzqu.pojo.ChoiceQuestion;

public interface ChoiceQuestionMapper {
    int deleteByPrimaryKey(String id);

    int insert(ChoiceQuestion record);

    int insertSelective(ChoiceQuestion record);

    ChoiceQuestion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ChoiceQuestion record);

    int updateByPrimaryKey(ChoiceQuestion record);
}