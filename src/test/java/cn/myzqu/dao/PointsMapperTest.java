package cn.myzqu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Chrky on 2018/5/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PointsMapperTest {
    @Test
    public void selectUserByTime() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("userId","1");
        map.put("first","2018-05-23 16:53:50");
        map.put("end","2018-05-25 15:58:10");
        System.out.print(pointsMapper.selectUserByTime(map));
    }

    @Test
    public void selectByUser() throws Exception {
        System.out.print(pointsMapper.selectByUser());
    }

    @Test
    public void selectByUserId() throws Exception {
        String userId="1";
        System.out.print(pointsMapper.selectByUserId(userId));
    }

    @Test
    public void shareCount() throws Exception {
        String userId="1";
        System.out.print(pointsMapper.shareCount(userId));
    }

    @Autowired
    private PointsMapper pointsMapper;

    @Test
    public void signByUser() throws Exception {
        String userId="1";
        System.out.print(pointsMapper.signByUser(userId));
    }

}