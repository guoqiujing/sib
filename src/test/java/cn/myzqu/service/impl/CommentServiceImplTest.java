package cn.myzqu.service.impl;

import cn.myzqu.pojo.Comment;
import cn.myzqu.service.CommentService;
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
public class CommentServiceImplTest {
    @Autowired
    private CommentService commentService;

    @Test
    public void addComment() throws Exception {
        Comment record = new Comment();
        record.setUserId("7dbd4f571744460199a140a8df35604a");
        record.setQuestionId("323232");
        record.setBankId("4545");
        record.setContent("2344444444444444");
        if(commentService.addCommentRecord(record))
            System.err.println("success");
        else
            System.err.println("false");
    }

    @Test
    public void findByQuestionId() throws Exception {
    }

}