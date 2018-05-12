package cn.myzqu.dto;

import cn.myzqu.pojo.QuestionBank;
import lombok.Data;

/**
 * Created by Chrky on 2018/5/11.
 */
public class BankDTO extends QuestionBank
{
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BankDTO [count=" + count + ", toString()=" + super.toString() + "]";
    }
}
