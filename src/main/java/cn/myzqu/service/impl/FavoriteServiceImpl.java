package cn.myzqu.service.impl;

import cn.myzqu.dao.FavoriteMapper;
import cn.myzqu.dto.FavoriteDTO;
import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.exception.CustomException;
import cn.myzqu.pojo.Favorite;
import cn.myzqu.service.FavoriteService;
import cn.myzqu.utils.KeyUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chrky on 2018/5/18.
 */
@Service
public class FavoriteServiceImpl implements FavoriteService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public Boolean deleteById(Favorite favorite) {
        //取消收藏
        if (favoriteMapper.deleteById(favorite) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean add(Favorite favorite) {
        //得到收藏的用户id
        String userId=favorite.getUserId();
        //得到用户的题目id
        String questionId=favorite.getQuestionId();
        //判断是否该题目收藏了
        if(favoriteMapper.judgeFavorite(userId,questionId)!=null)
            throw new CustomException(ResultEnum.FAVORITE_EXIST);
        favorite.setId(KeyUtil.getUUID());
        //收藏题目
        if (favoriteMapper.insertById(favorite) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Favorite findStateById(String id) {
        //根据收藏表id查看收藏记录
        return favoriteMapper.selectById(id);
    }

    @Override
    public PageDTO findByUserId(String userId,int pageNum,int pageSize) {
        //使用PageHelper插件实现分页
        //注意：下面这两条语句必须紧跟，保证分页安全
        Page page = PageHelper.startPage(pageNum,pageSize);
        //根据用户id查看用户所有收藏记录
        List<FavoriteDTO> favorites=favoriteMapper.selectByUserId(userId);
        if(favorites.isEmpty())
            return null;
        //获取总记录数
        int total = (int)page.getTotal();
        //获取总页数
        int pages = page.getPages();
        //封装数据到分页类PageDTO
        PageDTO pageDTO = new PageDTO(favorites,total,pageSize,pageNum,pages);
        return pageDTO;
    }
}
