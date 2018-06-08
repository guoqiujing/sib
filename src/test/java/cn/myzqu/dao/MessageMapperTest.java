package cn.myzqu.dao;

import cn.myzqu.dto.MessageDTO;
import cn.myzqu.pojo.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xiraly on 2018/6/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageMapperTest {
    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void insert() throws Exception {
        Message record = new Message();
        record.setSender("0381bd9111fa4999a85922eb8075b293");
        record.setBankId("306be44bc204412b986f8cd913db51cc");
        record.setQuestionId("0309682f03fd4ab4a653f63e26d5720e");
        record.setMessage("233333");
        int a = messageMapper.insert(record);
        System.err.println(a);
    }

    @Test
    public void selectByUserId() throws Exception {
        String id = "9e933d889da6458eb7fcc96aaf5ab74b";
        List<MessageDTO> list = messageMapper.selectByUserId(id);
        System.err.println(list.size());
    }

}