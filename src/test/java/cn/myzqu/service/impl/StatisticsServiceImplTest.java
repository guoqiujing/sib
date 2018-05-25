package cn.myzqu.service.impl;

import cn.myzqu.dao.RatingMapper;
import cn.myzqu.service.RatingService;
import cn.myzqu.service.StatisticsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by xiraly on 2018/5/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsServiceImplTest {
    @Autowired
    private StatisticsService statisticsService;

    @Test
    public void reckonStareLevel() throws Exception {
        String id = "1111";
        double a = statisticsService.reckonStareLevel(id);
        System.err.println(a);
    }

}