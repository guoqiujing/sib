package cn.myzqu.service.impl;

import cn.myzqu.dao.PointsMapper;
import cn.myzqu.pojo.Points;
import cn.myzqu.service.PointsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Chrky on 2018/5/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PointsServiceImplTest {
    @Test
    public void choiceByGrade() throws Exception {
        String userId="1";
        pointsService.ChoiceByGrade(userId);
    }

    @Test
    public void addUser() throws Exception {
        List<Points> pointList=new ArrayList<>();
        for(int i=0;i<3;i++)
        {
            Points points=new Points();
            points.setValue(10);
            points.setUserId("1");
            pointList.add(points);
        }
        pointsService.addUser(pointList);
    }

    @Test
    public void checkChoice() throws Exception {
        String userId="2";
        System.out.print(pointsService.checkChoice(userId));
    }

    @Test
    public void signByUser() throws Exception {
        String userId="2";
        System.out.print(pointsService.signByUser(userId));
    }

    @Test
    public void register() throws Exception {
        String userId="1";
        pointsService.register(userId);
    }

    @Autowired
    private PointsService pointsService;


}