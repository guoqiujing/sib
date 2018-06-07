package cn.myzqu.dao;

import cn.myzqu.pojo.Buy;

public interface BuyMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(Buy buy);//购买题库

    Buy selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Buy record);

    int updateByPrimaryKey(Buy record);

    Buy selectByUser(String userId,String bankId);//判断是否购买题库
}