package cn.myzqu.service.impl;

import cn.myzqu.dao.RatingMapper;
import cn.myzqu.pojo.Rating;
import cn.myzqu.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据统计实现类
 * Created by xiraly on 2018/5/21.
 */
@Service
public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    private RatingMapper ratingMapper;

    public double reckonStareLevel(String questionId){
        double sum = 0;
        //调用ratingMapper的selectByQuestionId查询该题目的所有用户星级评价的记录
        List<Rating> list = ratingMapper.selectByQuestionId(questionId);
        //判断是否有用户星级评定记录
        if(list.size()>0){
            //有则计算星级平均数
            for (int i=0;i<list.size();i++) {
                sum = sum + list.get(i).getStarLevel();
            }
            sum = sum/list.size();
            //返回星级平均数
            return sum;
        }
        //没有则返回默认星级 0

        return sum;
    }

}
