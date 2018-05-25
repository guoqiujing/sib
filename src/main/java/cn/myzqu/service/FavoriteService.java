package cn.myzqu.service;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.pojo.Favorite;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Map;

/**
 * Created by Chrky on 2018/5/18.
 */
public interface FavoriteService {
    /**
     * 取消收藏题目
     * @param favorite
     * @return
     */
    Boolean deleteById(Favorite favorite);

    /**
     * 收藏题目
     * @param favorite
     * @return
     */
    Boolean add(Favorite favorite);

    /**
     * 查询题目的收藏状态
     * @param id
     * @return
     */
    Favorite findStateById(String id);

    /**
     * 用户查看收藏的所有题目
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDTO findByUserId(String userId,int pageNum,int pageSize);
}
