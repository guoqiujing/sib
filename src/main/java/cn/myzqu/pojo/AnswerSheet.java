package cn.myzqu.pojo;

import cn.myzqu.utils.Serializer.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AnswerSheet {
    private String id;

    @NotNull(message = "用户名不能为空")
    private String userId;
    @NotNull(message = "答案不能为空哦")
    private String questionId;

    private String bankId;
    @NotNull(message = "答案不能为空")
    private String answer;

    private Boolean istrue;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date createTime;
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date updateTime;

}