package cn.myzqu.pojo;

import cn.myzqu.utils.Serializer.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class Points {
    private String id;

    private String userId;

    private Integer value;

    private String note;

    private Boolean available;

    @JsonSerialize(using= CustomDateSerializer.class)
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Points{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", value=" + value +
                ", note='" + note + '\'' +
                ", available=" + available +
                ", createTime=" + createTime +
                '}';
    }
}