package cn.myzqu.service.impl;

import cn.myzqu.pojo.ChoiceQuestion;
import cn.myzqu.service.ChoiceQuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Chrky on 2018/5/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChoiceQuestionServiceTest {

    @Autowired
    private ChoiceQuestionService choiceQuestionService;


    @Test
    public void findById() throws Exception {
        String id="1";
        System.out.print(choiceQuestionService.findById(id));
    }

    @Test
    public void findByQuestion() throws Exception {
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void findByBankId() throws Exception {
    }

    @Test
    public void updateById() throws Exception {
    }

}