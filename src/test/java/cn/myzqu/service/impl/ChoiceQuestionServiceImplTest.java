package cn.myzqu.service.impl;

import cn.myzqu.service.ChoiceQuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Chrky on 2018/5/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChoiceQuestionServiceImplTest {
    @Test
    public void findById() throws Exception {
        String id="1";
        System.out.print(choiceQuestionService.findById(id));
    }

    @Autowired
    private ChoiceQuestionService choiceQuestionService;

    @Test
    public void findByBankId() throws Exception {
        String id="2";
        String userId="2";
        System.out.print(choiceQuestionService.findByBankId(id,userId));
    }

}