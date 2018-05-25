package cn.myzqu.service.impl;

import cn.myzqu.dao.RatingMapper;
import cn.myzqu.dto.PageDTO;
import cn.myzqu.pojo.Rating;
import cn.myzqu.service.PointsService;
import cn.myzqu.service.RatingService;
import cn.myzqu.utils.KeyUtil;
import cn.myzqu.utils.MD5Util;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户评定星级接口实现类
 * Created by xiraly on 2018/5/22.
 */
@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingMapper ratingMapper;

    /**
     * 添加用户星级评价记录
     * @param record  用户星级评价记录
     * @return
     */
    @Override
    public Boolean addRatingRecord(Rating record){

        //生成唯一ID
        String id = KeyUtil.getUUID();
        record.setId(id);
        //调用RatingMapper的insert方法将记录添加到数据库并判断是否添加成功
        if (ratingMapper.insert(record)>0)
            //若成功就返回true
            return true;
        else
            //若失败就返回false
            return false;
    }

    /**
     * 查询用户是否已经评价星级
     * @param userId  用户id
     * @param questionId  题目id
     * @return
     */
    @Override
    public Rating findByUserId(String userId,String questionId){
        //调用RatingMapper的selectByUserId查询用户是否已经有评定星级的记录
        Rating rating = ratingMapper.selectByUserId(userId,questionId);
        //返回rating数据
        return rating;
    }

    /**
     * 查询所有用户星级评价记录并且实现分页功能
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageDTO findAllRating(int pageNum, int pageSize){
        //使用PageHelper插件实现分页
        //注意：下面这两条语句必须紧跟，保证分页安全
        Page page = PageHelper.startPage(pageNum,pageSize);
        List<Rating> list = ratingMapper.selectAllRating();
        //判断list是否有数据,没有数据返回null
        if(list.isEmpty()) return null;
        //获取总记录数
        int total = (int)page.getTotal();
        //获取总页数
        int pages = page.getPages();
        //封装数据到分页类PageDTO
        PageDTO pageDTO = new PageDTO(list,total,pageSize,pageNum,pages);
        return pageDTO;
    }
}
