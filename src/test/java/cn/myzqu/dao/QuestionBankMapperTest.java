package cn.myzqu.dao;

import cn.myzqu.pojo.QuestionBank;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Chrky on 2018/5/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionBankMapperTest {
    @Test
    public void updateById() throws Exception {
        QuestionBank questionBank=questionBankMapper.selectById("1");
        questionBank.setIntro("世界第哦啊就");
        questionBankMapper.updateById(questionBank);
    }

    @Autowired
    private QuestionBankMapper questionBankMapper;

    @Test
    public void selectByTitle() throws Exception {
        String title="1";
        System.out.println(questionBankMapper.selectByTitle(title));
    }

}