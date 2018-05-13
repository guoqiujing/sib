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

    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户头像
     */
    private String icon;
    /**
     * 用户手机号码
     */
    private String phone;
    /**
     * 用户电子邮箱
     */
    private String email;
    /**
     * 用户微信id
     */
    private String wxid;
    /**
     * 用户积分
     */
    private Integer value;
    /**
     * 用户状态
     */
    private Boolean locked;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date createTime;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date updateTime;


}
