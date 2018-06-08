package cn.myzqu.service.impl;

import cn.myzqu.dao.PointsMapper;
import cn.myzqu.dto.PageDTO;
import cn.myzqu.dto.PointsDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.exception.CustomException;
import cn.myzqu.pojo.Points;
import cn.myzqu.service.PointsService;
import cn.myzqu.utils.KeyUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Chrky on 2018/5/22.
 */
@Service
public class PointsServiceImpl implements PointsService {

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private PointsMapper pointsMapper;

    @Override
    public Boolean register(String userId) {
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
    public Boolean checkChoice(String userId) {
        Points points=new Points();
        points.setId(KeyUtil.getUUID());
        points.setValue(1);
        points.setUserId(userId);
        points.setNote("用户题目审核通过");
        //用户上传题目审核
        if(pointsMapper.insert(points)>0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean shareApp(String userId) {
        //查询用户今天分享小程序次数
        if(pointsMapper.shareCount(userId)>=3)
            throw new CustomException(ResultEnum.USER_SIGN_FULL);
        Points points=new Points();
        points.setId(KeyUtil.getUUID());
        points.setValue(2);
        points.setUserId(userId);
        points.setNote("用户分享小程序");
        //用户分享小程序
        if(pointsMapper.insert(points)>0)
            return true;
        else
            return false;
    }

    @Override
    public PageDTO findByUserId(String userId, int pageNum, int pageSize) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        //根据用户id查询个人积分记录
        List<Points> points  =pointsMapper.selectByUserId(userId);
        if(points.isEmpty()) return null;
        int total = (int)page.getTotal();
        int pages = page.getPages();
        PageDTO pageDTO = new PageDTO(points,total,pageSize,pageNum,pages);
        return pageDTO;
    }

    @Override
    public PageDTO find(int pageNum, int pageSize) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        //浏览用户积分记录
        List<Points> points  =pointsMapper.selectByUser();
        if(points.isEmpty()) return null;
        int total = (int)page.getTotal();
        int pages = page.getPages();
        PageDTO pageDTO = new PageDTO(points,total,pageSize,pageNum,pages);
        return pageDTO;
    }

    @Override
    public PageDTO selectUserByTime(Map<String, Object> map, int pageNum, int pageSize) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        //根据用户id和时间段查积分记录
        List<Points> points  =pointsMapper.selectUserByTime(map);
        if(points.isEmpty()) return null;
        int total = (int)page.getTotal();
        int pages = page.getPages();
        PageDTO pageDTO = new PageDTO(points,total,pageSize,pageNum,pages);
        return pageDTO;
    }

    @Override
    public Boolean addUser(List<Points> points) {
        for (int i = 0; i < points.size(); i++) {
            Points point=points.get(i);
            point.setId(KeyUtil.getUUID());
            point.setUserId(point.getUserId());
            point.setValue(point.getValue());
            if (point.getValue() > 0)
                point.setNote("管理员派送积分");
            else
                point.setNote("管理员扣减积分");
            if(pointsMapper.insert(point)<1)
                return false;
        }
        return true;
    }

    @Override
    public Boolean ChoiceByGrade(String userId) {
        Points points=new Points();
        points.setId(KeyUtil.getUUID());
        points.setUserId(userId);
        points.setValue(1);
        points.setNote("用户题目评级");
        if(pointsMapper.insert(points)>0)
            return true;
        else
            return false;
    }

    @Override
    public PointsDTO calUserPoints(String userId) {
        PointsDTO pointsDTO=new PointsDTO();
        //计算用户积分
        int points=pointsMapper.selectUserPoints(userId);
        pointsDTO.setPoints(points);
        return pointsDTO;
    }

    @Override
    public Boolean buyBank(String userId,int point) {
        Points points=new Points();
        points.setId(KeyUtil.getUUID());
        points.setValue(-point);
        points.setUserId(userId);
        points.setNote("用户购买题库");
        //用户购买题库
        if(pointsMapper.insert(points)>0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean sign(String userId) {
        Points points=new Points();
        points.setId(KeyUtil.getUUID());
        points.setUserId(userId);
        points.setValue(5);
        points.setNote("用户签到");
        //添加到用户签到记录
        if(pointsMapper.insert(points)>0)
            return true;
        else
            return false;
    }
}
