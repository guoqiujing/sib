package cn.myzqu.utils;

import cn.myzqu.pojo.ChoiceQuestion;
import cn.myzqu.service.ChoiceQuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 的川 on 2018/5/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BatchUtilTest {

    @Autowired
    private ChoiceQuestionService choiceQuestionService ;

    @Test
    public void batchAdd() throws Exception {

        String filePath = "F:\\大学\\大三下\\大三下-软件项目\\共享题库\\1.pdf";
        String userId = "82e705688305435382df908076ba3e66";
        String bankId = "ff2a4d84a2b5401daa60a9784bc5c304";

        List list = BatchUtil.readQeustionByWord(filePath);
        List<ChoiceQuestion> choiceQuestions = ListToPojo.listToChoiceQuestion(list,bankId,userId);
        for(ChoiceQuestion choiceQuestion :choiceQuestions){
            System.out.println(choiceQuestion.toString());
            Boolean result = choiceQuestionService.add(choiceQuestion);
            if(result) {
                System.out.println("成功\n");
            }else{
                System.out.println("失败\n");
            }
        }
    }

}