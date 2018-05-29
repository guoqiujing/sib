package cn.myzqu.utils;

import cn.myzqu.pojo.ChoiceQuestion;
import cn.myzqu.pojo.QuestionBank;
import cn.myzqu.pojo.User;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 的川 on 2018/5/22.
 */
public  class ListToPojo {


    public static List<ChoiceQuestion> listToChoiceQuestion(List list,String bankId,String userId){
        List<ChoiceQuestion> choiceQuestions = new ArrayList<>();
        for(int i=0;i<list.size();i++) {
            List row = (List) list.get(i);
            ChoiceQuestion choiceQuestion = new ChoiceQuestion();
            choiceQuestion.setBankId(bankId);
            choiceQuestion.setUserId(userId);
            choiceQuestion.setQuestion((String)row.get(0));
            choiceQuestion.setChoiceA((String)row.get(1));
            choiceQuestion.setChoiceB((String)row.get(2));
            choiceQuestion.setChoiceC((String)row.get(3));
            choiceQuestion.setChoiceD((String)row.get(4));
            choiceQuestion.setAnswer((String)row.get(5));
            if(row.size()<6)
                choiceQuestion.setAnalysis((String)row.get(6));
            choiceQuestions.add(choiceQuestion);
        }
        return choiceQuestions;
    }

    /**
     * list转换成List<User>
     * @param list
     * @return
     */
    public static List<User> listToUser(List list){

        List<User> users = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            List row  = (List)list.get(i);
            User user = new User();
            user.setId(KeyUtil.getUUID());
            user.setName((String)row.get(0));
            user.setNickname((String)row.get(1));
            user.setIcon((String)row.get(2));
            user.setPhone((String)row.get(3));
            user.setEmail((String)row.get(4));
            user.setPassword((String)row.get(5));
            user.setSalt((String)row.get(6));
            user.setWxid((String)row.get(7));
            users.add(user);
            for (int j=0;j<row.size();j++){
                System.out.println(i+":"+j+":" +row.get(j));
            }
        }
        return users;
    }
}
