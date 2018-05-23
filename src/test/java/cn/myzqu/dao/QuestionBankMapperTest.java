package cn.myzqu.dao;

import cn.myzqu.dto.BankDTO;
import cn.myzqu.pojo.QuestionBank;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Chrky on 2018/5/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionBankMapperTest {
    @Test
    public void selectByUserId() throws Exception {
        String id="1";
        System.out.print(questionBankMapper.selectByUserId(id));
    }

    @Test
    public void selectByTypeName() throws Exception {
        String name="1";
        System.out.print(questionBankMapper.selectByTypeName(name));
    }

    @Test
    public void countChoiceByBank() throws Exception {
        String id="1";
        System.out.print(questionBankMapper.countChoiceByBank(id));
    }

    @Test
    public void select1() throws Exception {
       Map<String,Object> map=new HashMap<>();
       //map.put("title",1111);
       //map.put("213",213);
       //map.put("categoryName","是");
       //map.put("id",1);
       //map.put("userId",1);
        //questionBank.setTitle("1");
        //questionBank.setCategoryName("不是");
        //questionBank.setUserId("1");
        //questionBank.setId("22");
        System.out.print(questionBankMapper.select(map));
    }

   @Test
    public void selectSort() throws Exception {
        Map<String,Object> map=new HashMap<>();
        //map.put("frequency",1);
        map.put("star_level",1);
        System.out.print(questionBankMapper.selectSort(map));
    }/*

    @Test
    public void updateById() throws Exception {
        QuestionBank questionBank=questionBankMapper.selectById("1");
        questionBank.setIntro("世界第哦啊就");
        questionBankMapper.updateById(questionBank);
    }*/

    @Autowired
    private QuestionBankMapper questionBankMapper;

    @Test
    public void selectByTitle() throws Exception {
        String title="1";
        System.out.println(questionBankMapper.selectByTitle(title));
    }

  /*  @Test
    public void select() throws Exception {
        Map<String,Object> map = new HashMap<>();
       map.put("frequency",1);
        List<BankDTO> list = questionBankMapper.select(map);
       for(BankDTO bankDTO :list){
           System.out.println(bankDTO.toString());
       }
    }*/

}