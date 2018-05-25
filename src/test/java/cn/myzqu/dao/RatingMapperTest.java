package cn.myzqu.dao;

import cn.myzqu.pojo.Rating;
import cn.myzqu.utils.KeyUtil;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import static org.junit.Assert.*;

/**
 * Created by xiraly on 2018/5/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingMapperTest {

    @Autowired
    private RatingMapper ratingMapper;

    @Test
    public void selectAllRating() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        Rating record = new Rating();
        String id = KeyUtil.getUUID();
        record.setId(id);
        record.setUserId("23344");
        record.setBankId("33333");
        record.setQuestionId("313131");
        record.setCreateTime(new Date());
        if (ratingMapper.insert(record)>0){
            System.err.println("success");
        }
        else{
            System.err.println("fail");
        }
    }

    @Test
    public void selectByQuestionId() throws Exception {
    }

    @Test
    public void selectByUserId() throws Exception {
        String u = "2";
        String q = "22";
        Map<String,Object> map = new HashMap<>();
        map.put("userId",u);
        map.put("questionId",q);
        Rating t = ratingMapper.selectByUserId(u,q);
    }

}