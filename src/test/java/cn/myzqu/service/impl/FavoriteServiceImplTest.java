package cn.myzqu.service.impl;

import cn.myzqu.pojo.Favorite;
import cn.myzqu.service.FavoriteService;
import cn.myzqu.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Chrky on 2018/5/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FavoriteServiceImplTest {

    @Autowired
    private FavoriteService favoriteService;

    @Test
    public void deleteById() throws Exception {
    }

   /* @Test
    public void add() throws Exception {
        Favorite favorite=new Favorite();
        favorite.setId(KeyUtil.getUUID());
        favorite.setUserId("1");
        favorite.setQuestionId("2");
        System.out.print(favoriteService.add(favorite));
    }*/

    @Test
    public void findStateById() throws Exception {
        String id="1";
        System.out.println(favoriteService.findStateById(id));
    }

    @Test
    public void findByUserId() throws Exception {
    }

}