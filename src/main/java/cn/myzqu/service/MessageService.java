package cn.myzqu.service;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.pojo.Message;

/**
 * 反馈信息服务接口
 * Created by xiraly on 2018/6/7.
 */
public interface MessageService {

    /**
     * 添加用户反馈记录
     * @param record
     * @return
     */
    Boolean addMessageRecord(Message record);

    /**
     * 根据接收者用户id查询接收的反馈
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDTO findByUserId(String userId, int pageNum, int pageSize);
}
