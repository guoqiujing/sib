package cn.myzqu.dto;

import cn.myzqu.pojo.ChoiceQuestion;

/**
 * Created by Chrky on 2018/5/14.
 */
public class ChoiceDTO extends ChoiceQuestion{

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ChoiceDTO{" +
                "title='" + title + '\'' +
                "} " + super.toString();
    }
}
