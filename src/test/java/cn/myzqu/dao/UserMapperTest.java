package cn.myzqu.dao;

import cn.myzqu.pojo.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by 的川 on 2018/5/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper dao;

    @Test
    public void deleteById() throws Exception {

        for(int i=0;i<=100;i++){
            String id = "xxxx"+i;
            int result = dao.deleteById(id);
            Assert.assertEquals(1,result);
        }
    }

    @Test
    public void insert() throws Exception {
        for(int i=0;i<=100;i++){
            User user = new User();
            user.setId("xxxx"+i);
            user.setPassword("xx");
            int result = dao.insert(user);
            Assert.assertEquals(1,result);
        }
    }


    @Test
    public void selectById() throws Exception {
    }

    @Test
    public void updateById() throws Exception {

        User user = new User();
        user.setId("xxxx1");
        user.setLocked(true);

        dao.updateById(user);

    }

    @Test
    public void selectAll() throws Exception {
//        int pageNum = 2; //页数，默认从第一页开始查询
//        int pageSize = 10; //一次查询的记录数
//     //   PageHelper.startPage(pageNum, pageSize);
//        Page page = PageHelper.startPage(pageNum,pageSize);
//        List<User> list = dao.selectAll();
////        System.out.println(page.getTotal()); //总记录数
////        System.out.println(page.getCountColumn());
////        System.out.println(page.getEndRow()); //本次查询最后一条记录号
////       System.out.println(page.getPageNum());
//        System.out.println(page.getPages());  //总页数
////        System.out.println(page.getPageSize()); //本次查询页数
////        System.out.println(page.getStartRow()); //本次查询第一天一条记录号
//        for(User user :list){
//            System.out.println(user.getId());
//        }
    }

}