package cn.myzqu.service;

import cn.myzqu.pojo.Buy;

/**
 * Created by Chrky on 2018/6/7.
 */
public interface BuyService {

    Boolean buyBank(Buy buy);//用户购买题库

    Buy findByUser(String userId, String bankId);//查询是否已购买该题库
}
