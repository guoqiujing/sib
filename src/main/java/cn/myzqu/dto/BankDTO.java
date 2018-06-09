package cn.myzqu.dto;

import cn.myzqu.pojo.QuestionBank;

/**
 * Created by Chrky on 2018/5/11.
 */
public class BankDTO extends QuestionBank
{
    //已通过审核题目数
    private int count;

    //总题目数
    private int countAll;

    //用户头像
    private String icon;

    //用户昵称
    private String nickname;

    public int getCountAll() {
        return countAll;
    }

    public void setCountAll(int countAll) {
        this.countAll = countAll;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "BankDTO{" +
                "count=" + count +
                ", countAll=" + countAll +
                ", icon='" + icon + '\'' +
                ", nickname='" + nickname + '\'' +
                "} " + super.toString();
    }
}
