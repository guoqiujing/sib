package cn.myzqu.dao;

import cn.myzqu.pojo.QuestionBank;

public interface QuestionBankMapper {
    int deleteByPrimaryKey(String id);

    int insert(QuestionBank record);

    int insertSelective(QuestionBank record);

    QuestionBank selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(QuestionBank record);

    int updateByPrimaryKey(QuestionBank record);
}