package cn.myzqu.service.impl;

import cn.myzqu.dao.ChoiceQuestionMapper;
import cn.myzqu.dao.RatingMapper;
import cn.myzqu.dto.ChoiceDTO;
import cn.myzqu.pojo.ChoiceQuestion;
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
    @Autowired
    private ChoiceQuestionMapper choiceQuestionMapper;

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

    /**
     * 计算题库星级平均值
     * @param bankId
     * @return
     */
    public double reckonBankStareLevel(String bankId){
        double sum = 0;
        //调用choiceQuestionMapper的selectByBankId方法查询出这个题库的所有题目
        List<ChoiceDTO> list = choiceQuestionMapper.selectByBankId(bankId);
        //判断是否有题目
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
