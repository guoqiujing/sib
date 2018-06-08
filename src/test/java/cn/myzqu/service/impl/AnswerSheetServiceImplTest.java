package cn.myzqu.service.impl;

import cn.myzqu.pojo.AnswerSheet;
import cn.myzqu.service.AnswerSheetService;
import cn.myzqu.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by xiraly on 2018/6/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerSheetServiceImplTest {
    @Autowired
    private AnswerSheetService answerSheetService;

    @Test
    public void add() throws Exception {
        AnswerSheet answerSheet = new AnswerSheet();
        answerSheet.setUserId("0381bd9111fa4999a85922eb8075b293");
        answerSheet.setBankId("5dcc37b441824641b1e7e825eed79c21");
        answerSheet.setQuestionId("030d16f2cf41467b9b79ad57356468a6");
        answerSheet.setAnswer("C");
        answerSheet.setIstrue(true);
        boolean a = answerSheetService.add(answerSheet);
        System.err.println(a);
    }

}