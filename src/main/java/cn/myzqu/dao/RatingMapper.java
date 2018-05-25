package cn.myzqu.dao;

import cn.myzqu.pojo.Rating;

import java.util.List;
import java.util.Map;

public interface RatingMapper {

    /**
     * 添加用户评定星级的记录
     * @param record
     * @return
     */
    int insert(Rating record);

    /**
     * 查询该题目的所有用户评定的星级，然后可以进行统计
     * @param questionId
     * @return
     */
    List<Rating> selectByQuestionId(String questionId);

    /**
     * 查询用户是否已经评定星级
     * @param map
     * @return
     */
    Rating selectByUserId(Map<String,Object> map);

    /**
     * 查询所有用户星级评价记录
     * @return
     */
    List<Rating> selectAllRating();
}