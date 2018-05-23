package cn.myzqu.dao;

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
public class PointsMapperTest {

    @Autowired
    private PointsMapper pointsMapper;

    @Test
    public void signByUser() throws Exception {
        String userId="1";
        System.out.print(pointsMapper.SignByUser(userId));
    }

}