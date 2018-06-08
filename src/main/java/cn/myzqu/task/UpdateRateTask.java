package cn.myzqu.task;

import cn.myzqu.service.ChoiceQuestionService;
import cn.myzqu.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 定时更新题目，题库星级评价
 * Created by 的川 on 2018/6/9.
 */
@Service
public class UpdateRateTask {

    @Autowired
    private ChoiceQuestionService choiceQuestionService;

    @Autowired
    private QuestionBankService questionBankService;


    /**
     * 定时更新所有题目的综合星级评价
     * 5点11点17点23点50分定时更新
     */
    @Scheduled(cron = "0 50 5,11,17,23 * * ?")
    public void updateAllQuestionRate(){
        choiceQuestionService.updateChoiceRating();
    }

    /**
     * 定时更新所有题库的综合星级评价
     * 6点12点18点0点定时更新
     */
    @Scheduled(cron = "0 0 0,6,12,18 * * ?")
    public void updateAllBankRate(){
        questionBankService.updateBankRating();
    }

}
