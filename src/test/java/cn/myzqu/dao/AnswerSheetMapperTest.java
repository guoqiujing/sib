package cn.myzqu.dao;

import cn.myzqu.dto.AnswerSheetDTO;
import cn.myzqu.pojo.AnswerSheet;
import cn.myzqu.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by 的川 on 2018/5/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerSheetMapperTest {


    @Autowired
    private AnswerSheetMapper dao;

    @Test
    public void selectCountByUserId() throws Exception {
        String userId = "1";
//        Boolean isTrue = true;
//        Integer result = dao.selectCountByUserId(userId,isTrue);
//        System.out.println("true:"+result);
        Boolean isTrue = false;
        System.out.println(isTrue);
        Integer result = dao.selectCountByUserId(userId,isTrue);
        System.out.println("false:"+result);

//        isTrue = null;
//        result = dao.selectCountByUserId(userId,isTrue);
//        System.out.println("all:"+result);
//        userId = "2";
//        isTrue = null;
//        result = dao.selectCountByUserId(userId,isTrue);
//        System.out.println(result);
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void insert() throws Exception {

        AnswerSheet answerSheet = new AnswerSheet();
        answerSheet.setId(KeyUtil.getUUID());
        answerSheet.setUserId("0381bd9111fa4999a85922eb8075b293");
        answerSheet.setBankId("5dcc37b441824641b1e7e825eed79c21");
        answerSheet.setQuestionId("030d16f2cf41467b9b79ad57356468a6");
        answerSheet.setAnswer("D");
        answerSheet.setIstrue(false);
        int a = dao.insert(answerSheet);
        System.err.println(a);
    }

    @Test
    public void select() throws Exception {

        Map<String,Object> map = new HashMap();
        map.put("user",123);
//        map.put("answerIsTrue",true);
        List<AnswerSheetDTO> answerSheetDTOList = dao.select(map);
        for (AnswerSheetDTO answerSheetDTO:answerSheetDTOList){
            System.out.println(answerSheetDTO.toString());
        }

    }

}