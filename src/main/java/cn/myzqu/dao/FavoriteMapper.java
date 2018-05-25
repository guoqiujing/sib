package cn.myzqu.dao;

import cn.myzqu.pojo.Favorite;

import java.util.List;
import java.util.Map;

public interface FavoriteMapper {

    /**
     * 取消收藏题目
     * @param userId questionId
     * @return
     */
    int deleteById(String userId,String questionId);

    /**
     * 收藏题目
     * @param favorite
     * @return
     */
    int insertById(Favorite favorite);

    Favorite selectById(String id);//查询题目的收藏状态

    /**
     * 用户查看收藏的所有题目
     * @param userId
     * @return
     */
    List<Favorite> selectByUserId(String userId);

    /**
     * 判断是否收藏该题目
     * @param userId
     * @param questionId
     * @return
     */
    Favorite judgeFavorite(String userId,String questionId);
}