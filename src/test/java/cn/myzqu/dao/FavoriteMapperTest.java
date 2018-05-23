package cn.myzqu.dao;

import cn.myzqu.pojo.Favorite;
import cn.myzqu.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Chrky on 2018/5/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FavoriteMapperTest {
    @Test
    public void judgeFavorite() throws Exception {
        //Map<String,Object> map=new HashMap<>();
        //map.put("userId","1");
        //map.put("questionId","2");
        String userId="1";
       String questionId="2";
        System.out.print(favoriteMapper.judgeFavorite(userId,questionId));
    }

    @Test
    public void insertById() throws Exception {
        Favorite favorite=new Favorite();
        favorite.setId(KeyUtil.getUUID());
        favorite.setUserId("1");
        favorite.setQuestionId("2");
        System.out.print(favoriteMapper.insertById(favorite));
    }

    @Test
    public void selectById() throws Exception {
        String id="3";
        System.out.print(favoriteMapper.selectById(id));
    }

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Test
    public void selectByUserId() throws Exception {
        String id="1";
        System.out.print(favoriteMapper.selectByUserId(id));
    }

}