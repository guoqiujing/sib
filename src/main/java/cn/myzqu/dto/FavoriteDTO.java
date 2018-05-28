package cn.myzqu.dto;

import cn.myzqu.pojo.Favorite;

/**
 * Created by Chrky on 2018/5/28.
 */
public class FavoriteDTO extends Favorite{

    //题库标题
    private String title;

    //题目
    private String question;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "FavoriteDTO{" +
                "title='" + title + '\'' +
                ", question='" + question + '\'' +
                "} " + super.toString();
    }
}
