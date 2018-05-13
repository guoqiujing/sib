package cn.myzqu.dto;

import cn.myzqu.pojo.AnswerSheet;
import lombok.Data;

/**
 * Created by 的川 on 2018/5/12.
 */
@Data
public class AnswerSheetDTO extends AnswerSheet{

    /**
     * 题干
     */
    private String question;

    /**
     *  所属题库名称
     */
    private String bankTitle;

    /**
     * 所属题库类别
     */
    private String bankCategory;

    /**
     * 排序编号
     */
    private int sort;


    @Override
    public String toString() {
        return "AnswerSheetDTO{" +
                super.toString() +
                "question='" + question + '\'' +
                ", bankTitle='" + bankTitle + '\'' +
                ", sort=" + sort +
                '}';
    }
}
