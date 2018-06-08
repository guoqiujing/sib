package cn.myzqu.service.impl;

import cn.myzqu.dao.MessageMapper;
import cn.myzqu.dto.CommentDTO;
import cn.myzqu.dto.MessageDTO;
import cn.myzqu.dto.PageDTO;
import cn.myzqu.pojo.Comment;
import cn.myzqu.pojo.Message;
import cn.myzqu.service.MessageService;
import cn.myzqu.utils.KeyUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 反馈信息服务实现类
 * Created by xiraly on 2018/6/7.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 添加用户反馈记录
     * @param record
     * @return
     */
    @Override
    public Boolean addMessageRecord(Message record){

        record.setCreateTime(new Date());
        //调用MessageMapper的insert方法把用户评论记录插入到数据库
        if(messageMapper.insert(record)>0)
            //成功则返回true
            return true;
        else
            //失败则返回false
            return false;
    }

    /**
     * 根据接收者用户id查询该用户的接收到的反馈记录
     * @param userId
     * @return
     */
    @Override
    public PageDTO findByUserId(String userId, int pageNum, int pageSize){
        //使用PageHelper插件实现分页
        //注意：下面这两条语句必须紧跟，保证分页安全
        Page page = PageHelper.startPage(pageNum,pageSize);
        //调用messageMapper的selectByUserId方法查询该接收者用户收到的反馈信息
        List<MessageDTO> list = messageMapper.selectByUserId(userId);
        //判断是否为空
        if(list.isEmpty())
            //没有数据，则返回null
            return null;

        //获取总记录数
        int total = (int)page.getTotal();
        //获取总页数
        int pages = page.getPages();
        //封装数据到分页类PageDTO
        PageDTO pageDTO = new PageDTO(list,total,pageSize,pageNum,pages);
        return pageDTO;
    }
}
