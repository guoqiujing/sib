package cn.myzqu.service;

/**
 * 数据统计类接口
 * Created by xiraly on 2018/5/21.
 */
public interface StatisticsService {

    /**
     * 计算题目星级平均值
     * @param questionId
     * @return
     */
    double reckonStareLevel(String questionId);

    /**
     * 计算题库星级平均值
     * @param bankId
     * @return
     */
    double reckonBankStareLevel(String bankId);
}
