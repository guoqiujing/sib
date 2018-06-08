package cn.myzqu.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class User {

    private String id;

    private String name;

    private String nickname;

    private String icon;

    private String phone;

    private String email;
    @NotNull(message = "密码不能为空哦")
    private String password;

    private String salt;

    private String wxid;

    private Integer value;

    private Boolean locked;

    private Date createTime;

    private Date updateTime;

}