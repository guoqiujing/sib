package cn.myzqu.dao;

import cn.myzqu.pojo.Favorite;

public interface FavoriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);
}