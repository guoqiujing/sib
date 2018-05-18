package cn.myzqu.dao;

import cn.myzqu.pojo.Favorite;

import java.util.List;

public interface FavoriteMapper {
    /**
     * 取消收藏题目
     * @param id
     * @return
     */
    int deleteById(String id);

    int insertById(Favorite favorite);//收藏题目

    Favorite selectById(String id);//查询题目的收藏状态

    /**
     * 用户查看收藏的所有题目
     * @param userId
     * @return
     */
    List<Favorite> selectByUserId(String userId);

    Favorite judgeFavorite(String userId,String questionId);//判断是否收藏该题目;
}