package cn.myzqu.service.impl;

import cn.myzqu.pojo.Rating;
import cn.myzqu.service.RatingService;
import cn.myzqu.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by xiraly on 2018/5/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingServiceImplTest {
    @Autowired
    private RatingService ratingService;


    @Test
    public void addRatingRecord() throws Exception {
        Rating record = new Rating();
        record.setUserId("24444");
        record.setBankId("23333");
        record.setQuestionId("323232");
        record.setStarLevel(4.0);
        record.setCreateTime(new Date());
        System.err.println(ratingService.addRatingRecord(record));
    }

    @Test
    public void findByUserId() throws Exception {
        String u = "2";
        String q = "22";
        Rating r = ratingService.findByUserId(u,q);
        if(r!=null)
            System.err.println("2333");
        else
            System.err.println("0000");
    }

    @Test
    public void findAllRating() throws Exception {

    }

}