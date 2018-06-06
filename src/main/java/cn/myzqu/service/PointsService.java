package cn.myzqu.service;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.dto.PointsDTO;
import cn.myzqu.pojo.Points;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Map;

/**
 * Created by Chrky on 2018/5/22.
 */
public interface PointsService {

    /**
     * 用户注册获得积分
     * @param userId
     * @return
     */
    Boolean register(String userId);

    /**
     * 用户签到
     * @param userId
     * @return
     */
    Boolean sign(String userId);

    /**
     * 用户上传题目审核后加分
     * @param userId
     * @return
     */
    Boolean checkChoice(String userId);

    /**
     * 用户分享小程序
     * @param userId
     * @return
     */
    Boolean shareApp(String userId);

    /**
     * 根据用户id查询个人积分记录
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDTO findByUserId(String userId,int pageNum, int pageSize);

    /**
     * 浏览用户积分记录
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDTO find(int pageNum, int pageSize);

    /**
     * 根据用户id和时间段查询积分记录
     * @param map
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDTO selectUserByTime(Map<String,Object> map,int pageNum, int pageSize);

    Boolean addUser(List<Points> points);//批量增加用户积分

    Boolean ChoiceByGrade(String userId);//用户评级题目后增加积分

    PointsDTO calUserPoints(String userId);//计算用户积分
}
