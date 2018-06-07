package cn.myzqu.service.impl;

import cn.myzqu.dao.BuyMapper;
import cn.myzqu.dto.PointsDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.exception.CustomException;
import cn.myzqu.pojo.Buy;
import cn.myzqu.pojo.QuestionBank;
import cn.myzqu.service.BuyService;
import cn.myzqu.service.PointsService;
import cn.myzqu.service.QuestionBankService;
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

    @Autowired
    private QuestionBankService questionBankService;


    @Override
    public Boolean buyBank(Buy buy) {
        String userId=buy.getUser();
        String bankId=buy.getBank();
        //得到购买题库所需积分
        QuestionBank questionBank=questionBankService.findById(bankId);
        int points=questionBank.getValue();
        buy.setPoint(points);
        //判断用户是否购买过该题库
        if(findByUser(userId,bankId)!=null)
            throw new CustomException(ResultEnum.BANK_BUY_EXIST);
        //判断是否够积分购买题库
        PointsDTO pointsDTO=pointsService.calUserPoints(userId);
        int now=pointsDTO.getPoints();
        if(now-points<0)
            throw new CustomException(ResultEnum.POINT_NOT_ENOUGHT);
            //购买题库
            if (buyMapper.insertSelective(buy) > 0) {
                //添加到积分记录
                pointsService.buyBank(userId, points);
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
