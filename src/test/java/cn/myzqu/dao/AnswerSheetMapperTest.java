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
    public void deleteById() throws Exception {
    }

    @Test
    public void insert() throws Exception {

        AnswerSheet answerSheet = new AnswerSheet();
        answerSheet.setId(KeyUtil.getUUID());
        answerSheet.setUserId("123");
        answerSheet.setBankId("1");
        answerSheet.setQuestionId(KeyUtil.getUUID());
        answerSheet.setAnswer("A");
        answerSheet.setIstrue(true);
        dao.insert(answerSheet);
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