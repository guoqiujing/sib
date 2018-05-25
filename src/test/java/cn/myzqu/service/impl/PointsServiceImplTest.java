package cn.myzqu.service.impl;

import cn.myzqu.dao.PointsMapper;
import cn.myzqu.service.PointsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Chrky on 2018/5/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PointsServiceImplTest {
    @Test
    public void signByUser() throws Exception {
        String userId="2";
        System.out.print(pointsService.SignByUser(userId));
    }

    @Test
    public void register() throws Exception {
        String userId="1";
        pointsService.Register(userId);
    }

    @Autowired
    private PointsService pointsService;


}