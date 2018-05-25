package cn.myzqu.dao;

import cn.myzqu.pojo.Comment;
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
public class CommentMapperTest {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void insert() throws Exception {
        Comment record = new Comment();
        record.setId(KeyUtil.getUUID());
        record.setUserId("7dbd4f571744460199a140a8df35604a");
        record.setQuestionId("323232");
        record.setBankId("4545");
        record.setContent("2333333333333");
        record.setCreateTime(new Date());
        if(commentMapper.insert(record)>0)
            System.err.println("success");
        else
            System.err.println("false");
    }

    @Test
    public void selectByQuestionId() throws Exception {
        String id = "323232";
        if(commentMapper.selectByQuestionId(id).isEmpty())
            System.err.println("false");
        else
            System.err.println("success");
    }

    @Test
    public void updateById() throws Exception {
    }

}