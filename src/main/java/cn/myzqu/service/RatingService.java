package cn.myzqu.service;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.pojo.Rating;

/**
 * 用户评定星级接口
 * Created by xiraly on 2018/5/22.
 */
public interface RatingService {

    /**
     * 添加用户评定星级记录
     * @param record  用户星级评价记录
     * @return
     */
    Boolean addRatingRecord(Rating record);

    /**
     * 根据用户id和题目id查找并判断用户是否已经评过星级
     * @param userId  用户id
     * @param questionId  题目id
     * @return
     */
    Rating findByUserId(String userId,String questionId);

    /**
     * 查找并分页显示所有用户星级评价记录
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDTO findAllRating(int pageNum, int pageSize);
}
