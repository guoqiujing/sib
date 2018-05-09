package cn.myzqu.dao;

import cn.myzqu.pojo.AnswerSheet;

public interface AnswerSheetMapper {
    int deleteByPrimaryKey(String id);

    int insert(AnswerSheet record);

    int insertSelective(AnswerSheet record);

    AnswerSheet selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AnswerSheet record);

    int updateByPrimaryKey(AnswerSheet record);
}