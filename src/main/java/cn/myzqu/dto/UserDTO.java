package cn.myzqu.dto;
import cn.myzqu.utils.Serializer.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户数据传输类
 * Created by 的川 on 2018/5/8.
 */
@Data
public class UserDTO implements Serializable{

    private static final long serialVersionUID = -5742938557911835877L;

    private String id;

    private String nickname;

    private String icon;

    private String phone;

    private String email;

    private String wxid;

    private Integer value;

    private Boolean locked;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date createTime;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date updateTime;


}
