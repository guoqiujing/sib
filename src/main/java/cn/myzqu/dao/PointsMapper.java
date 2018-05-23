package cn.myzqu.dao;

import cn.myzqu.pojo.Points;

import java.util.List;

public interface PointsMapper {
    int deleteByPrimaryKey(String id);

    /**
     * 添加用户积分记录
     * @param points
     * @return
     */
    int insert(Points points);

    Points SignByUser(String userId);//查询该用户今天是否已签到

    Points selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Points record);

    int updateByPrimaryKey(Points record);
}