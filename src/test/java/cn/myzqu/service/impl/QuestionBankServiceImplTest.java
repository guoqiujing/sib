package cn.myzqu.service.impl;

import cn.myzqu.dto.BankDTO;
import cn.myzqu.pojo.QuestionBank;
import cn.myzqu.service.QuestionBankService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Chrky on 2018/5/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionBankServiceImplTest {
    @Test
    public void findByTitle() throws Exception {
        String title="实打实的";
        System.out.print(questionBankService.findByTitle(title));
    }
//    @Test
//    public void searchByTitle() throws Exception {
//        String title="1";
//        System.out.print(questionBankService.searchByTitle(title));
//    }
//
//    @Test
//    public void updateById() throws Exception {
//        QuestionBank questionBank=questionBankService.findById("1");
//        questionBank.setIntro("世界121321第哦啊就");
//        questionBankService.updateById(questionBank);
//    }
//
//    @Test
//    public void selectSortBylevel() throws Exception {
//        System.out.print(questionBankService.selectSortBylevel());
//    }
//
//    @Test
//    public void selectSortByNumber() throws Exception {
//
//        System.out.print(questionBankService.selectSortByNumber());
//    }
//
//    @Test
//    public void selectByCategory() throws Exception {
//        String name="111";
//        System.out.print(questionBankService.selectByCategory(name));
//    }
//
//
//    @Test
//    public void deleteById() throws Exception {
//        String id="21212";
//        System.out.print(questionBankService.deleteById(id));
//    }
//

    private QuestionBankService questionBankService;
//
//    @Test
//    public void add() throws Exception {
//        QuestionBank questionBank=new QuestionBank();
//        questionBank.setTitle("4");
//        questionBank.setIntro("2");
//        questionBank.setImg("3");
//        questionBank.setUserId("4");
//        questionBank.setCategoryName("5");
//        System.out.print(questionBankService.add(questionBank));
//    }
//
//    @Test
//    public void findById() throws Exception {
//        String id="2";
//        System.out.print(questionBankService.findById(id));
//    }
//
//    @Test
//    public void findByTitle() throws Exception {
//        String title="2";
//        System.out.print(questionBankService.findByTitle(title));
//    }
//
//    @Test
//    public void selectByUserId() throws Exception {
//        String id="1";
//        System.out.print(questionBankService.selectByUserId(id));
//    }

}