package cn.myzqu.dto;

import cn.myzqu.pojo.QuestionBank;
import lombok.Data;

/**
 * Created by Chrky on 2018/5/11.
 */
public class BankDTO extends QuestionBank
{
    //已通过审核题目数
    private int count;

    //总题目数
    private int countAll;

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

    @Override
    public String toString() {
        return "BankDTO [count=" + count + ",countAll="+countAll+", toString()=" + super.toString() + "]";
    }
}
