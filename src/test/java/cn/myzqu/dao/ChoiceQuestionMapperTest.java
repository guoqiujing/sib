package cn.myzqu.dao;

import cn.myzqu.dto.ChoiceDTO;
import cn.myzqu.pojo.ChoiceQuestion;
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
 * Created by Chrky on 2018/5/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChoiceQuestionMapperTest {
    @Test
    public void selectSort() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("star_level","star_level");
        //map.put("id",1);
        List<ChoiceDTO> choiceDTOS = choiceQuestionMapper.selectSort(map);
        for(ChoiceDTO choiceDTO:choiceDTOS){
            System.out.println(choiceDTO.toString());
        }

    }

    @Test
    public void select() throws Exception {
        Map<String,Object> map=new HashMap<>();
        map.put("id",1);
        //map.put("sdd",22);
        System.out.print(choiceQuestionMapper.select(map));
    }

    @Autowired
    private ChoiceQuestionMapper choiceQuestionMapper;

    @Test
    public void selectByBankId() throws Exception {
        String id="122";
        List<ChoiceDTO> choiceQuestions=choiceQuestionMapper.selectByBankId(id);
        System.out.print(choiceQuestions);
    }

}