package cn.myzqu.dao;

import cn.myzqu.pojo.Rating;

public interface RatingMapper {
    int deleteByPrimaryKey(String id);

    int insert(Rating record);

    int insertSelective(Rating record);

    Rating selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Rating record);

    int updateByPrimaryKey(Rating record);
}