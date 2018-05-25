package cn.myzqu.dao;

import cn.myzqu.pojo.Points;

import java.util.List;
import java.util.Map;

public interface PointsMapper {
    int deleteByPrimaryKey(String id);

    /**
     * 添加用户积分记录
     * @param points
     * @return
     */
    int insert(Points points);

    /**
     * 查询该用户今天是否已签到
     * @param userId
     * @return
     */
    Points signByUser(String userId);

    Points selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Points record);

    int updateByPrimaryKey(Points record);

    /**
     * 分享次数
     * @param userId
     * @return
     */
    int shareCount(String userId);

    /**
     * 根据用户id查询个人积分记录
     * @param userId
     * @return
     */
    List<Points> selectByUserId(String userId);

    /**
     * 浏览所有用户积分记录
     * @return
     */
    List<Points> selectByUser();

    /**
     * 根据用户id和时间段查询积分记录
     * @param map
     * @return
     */
    List<Points> selectUserByTime(Map<String,Object> map);
}