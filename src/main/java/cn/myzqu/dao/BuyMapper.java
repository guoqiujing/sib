package cn.myzqu.dao;

import cn.myzqu.dto.BuyDTO;
import cn.myzqu.pojo.Buy;

import java.util.List;

public interface BuyMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(Buy buy);//购买题库

    Buy selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Buy record);

    int updateByPrimaryKey(Buy record);

    Buy selectByUser(String userId,String bankId);//判断是否购买题库

    List<BuyDTO> selectBuyByUser(String userId);//根据用户查看购买题库记录
}