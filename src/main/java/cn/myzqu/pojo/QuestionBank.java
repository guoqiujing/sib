package cn.myzqu.pojo;

import cn.myzqu.utils.Serializer.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
@Data
public class QuestionBank {

    private String id;
    @NotEmpty(message = "题库名称不能为空")
    private String title;
    @NotEmpty(message = "题库介绍不能为空")
    private String intro;

    private String img;

    private Integer value;

    private String userId;

    private String categoryName;

    private Integer frequency;

    private Double difficulty;

    private Double starLevel;

    private Integer status;

    private Boolean available;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date createTime;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date updateTime;

}