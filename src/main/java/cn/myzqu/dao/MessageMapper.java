package cn.myzqu.dao;

import cn.myzqu.dto.MessageDTO;
import cn.myzqu.pojo.Message;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 多条件模糊查询用户反馈列表（管理端
     * @return
     */
    List<MessageDTO> selectAllMessage(@Param("nickname") String nickname,@Param("bankTitle") String bankTitle,@Param("question") String question);
}