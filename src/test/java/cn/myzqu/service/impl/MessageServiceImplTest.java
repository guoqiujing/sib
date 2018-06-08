package cn.myzqu.service.impl;

import cn.myzqu.dto.MessageDTO;
import cn.myzqu.dto.PageDTO;
import cn.myzqu.pojo.Message;
import cn.myzqu.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 反馈信息服务层测试类
 * Created by xiraly on 2018/6/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceImplTest {
    @Autowired
    private MessageService messageService;

    @Test
    public void addMessageRecord() throws Exception {
        Message record = new Message();
        record.setSender("0381bd9111fa4999a85922eb8075b293");
        record.setBankId("306be44bc204412b986f8cd913db51cc");
        record.setQuestionId("0309682f03fd4ab4a653f63e26d5720e");
        record.setMessage("略略略");
        Boolean a = messageService.addMessageRecord(record);
        System.err.println(a);
    }

    @Test
    public void findByUserId() throws Exception {
        String id = "9e933d889da6458eb7fcc96aaf5ab74b";
        int page=1,size=3;
        PageDTO list = messageService.findByUserId(id,page,size);
        System.err.println(list.getTotal());
    }

}