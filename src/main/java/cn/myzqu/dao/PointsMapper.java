package cn.myzqu.dao;

import cn.myzqu.pojo.Points;

public interface PointsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Points record);

    int insertSelective(Points record);

    Points selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Points record);

    int updateByPrimaryKey(Points record);
}