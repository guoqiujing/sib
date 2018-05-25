package cn.myzqu.service.impl;

import cn.myzqu.dao.PointsMapper;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.exception.CustomException;
import cn.myzqu.pojo.Points;
import cn.myzqu.service.PointsService;
import cn.myzqu.utils.KeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Chrky on 2018/5/22.
 */
@Service
public class PointsServiceImpl implements PointsService {

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private PointsMapper pointsMapper;

    @Override
    public Boolean Register(String userId) {
        Points points=new Points();
        points.setId(KeyUtil.getUUID());
        points.setUserId(userId);
        points.setValue(100);
        points.setNote("用户注册");
        //用户注册获得积分
        if(pointsMapper.insert(points)>0)
            return true;
        else
            return false;
    }

    @Override
    public Points SignByUser(String userId) {
        //查询该用户今天是否已签到
        return pointsMapper.SignByUser(userId);
    }

    @Override
    public Boolean Sign(String userId) {
        //查询该用户今日是否已签到
        if(SignByUser(userId)!=null)
            throw new CustomException(ResultEnum.POINT_SIGN_EXIST);
        Points points=new Points();
        points.setId(KeyUtil.getUUID());
        points.setUserId(userId);
        points.setValue(5);
        points.setNote("用户签到");
        //用户签到
        if(pointsMapper.insert(points)>0)
            return true;
        else
            return false;
    }
}
