package cn.myzqu.service.impl;

import cn.myzqu.dao.BuyMapper;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.exception.CustomException;
import cn.myzqu.pojo.Buy;
import cn.myzqu.service.BuyService;
import cn.myzqu.service.PointsService;
import cn.myzqu.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chrky on 2018/6/7.
 */
@Service
public class BuyServiceImpl implements BuyService {

    @Autowired
    private BuyMapper buyMapper;

    @Autowired
    private PointsService pointsService;


    @Override
    public Boolean buyBank(Buy buy) {
        String userId=buy.getUser();
        String bankId=buy.getBank();
        int points=buy.getPoint();
        //判断用户是否购买过该题库
        if(findByUser(userId,bankId)!=null)
            throw new CustomException(ResultEnum.BANK_BUY_EXIST);
        //购买题库
        if(buyMapper.insertSelective(buy)>0) {
            //添加到积分记录
            pointsService.buyBank(userId,points);
            return true;
        }
            else
            return false;
    }

    @Override
    public Buy findByUser(String userId, String bankId) {
        //查询是否已购买该题库
      return buyMapper.selectByUser(userId,bankId);
    }
}
