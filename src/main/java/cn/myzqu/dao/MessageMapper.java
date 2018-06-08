package cn.myzqu.dao;

import cn.myzqu.dto.MessageDTO;
import cn.myzqu.pojo.Message;

import java.util.List;

public interface MessageMapper {
    /**
     * 添加反馈记录
     * @param record
     * @return
     */
    int insert(Message record);

    /**
     * 通过接收者的用户id查询反馈信息
     * @param userId
     * @return
     */
    List<MessageDTO> selectByUserId(String userId);
}