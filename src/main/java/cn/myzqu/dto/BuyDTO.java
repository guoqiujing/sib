package cn.myzqu.dto;

import cn.myzqu.pojo.Buy;

/**
 * Created by Chrky on 2018/6/8.
 */
public class BuyDTO extends Buy{

    //题库标题
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BuyDTO{" +
                "title='" + title + '\'' +
                "} " + super.toString();
    }
}
