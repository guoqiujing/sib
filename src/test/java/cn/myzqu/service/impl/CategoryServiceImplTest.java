package cn.myzqu.service.impl;

import cn.myzqu.dto.CategoryDTO;
import cn.myzqu.pojo.Category;
import cn.myzqu.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 的川 on 2018/5/10.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void add() throws Exception {

//        String name = "计算机类";
//        Integer parentId = null;
//        categoryService.add(name,parentId);

          String name = null;
          Integer parentId = null;

          name="计算机水平考试";
          parentId = 1000;
          categoryService.add(name,parentId);

            name="计算机等级考试";
            parentId = 1000;
            categoryService.add(name,parentId);

        name="初级程序员";
        parentId = 1001;
        categoryService.add(name,parentId);
        name="初级网络管理员";
        parentId = 1001;
        categoryService.add(name,parentId);

        name="中级软件设计师";
        parentId = 1001;
        categoryService.add(name,parentId);

        name="中级网络工程师";
        parentId = 1001;
        categoryService.add(name,parentId);

        name="中级软件测试师";
        parentId = 1001;
        categoryService.add(name,parentId);

        name="计算机一级";
        parentId = 1002;
        categoryService.add(name,parentId);

        name="计算机二级";
        parentId = 1002;
        categoryService.add(name,parentId);

//        String name = "一级计算机基础";
//        Integer parentId = 13;
//        categoryService.add(name,parentId);
//
//        name = "二级计算机基础";
//        parentId = 13;
//        categoryService.add(name,parentId);
    }

    @Test
    public void findParentIds() throws Exception {

        int id = 4;
        String parentIds = categoryService.findParentIds(id);
        System.out.println(parentIds);
    }

    @Test
    public void findTopCategories() throws Exception {

        List<CategoryDTO> list = categoryService.findTopCategories();
        for(CategoryDTO category : list){
            System.out.println(category.getId());
        }
    }

    @Test
    public void findLowerCategories() throws Exception {
        List<CategoryDTO> list = categoryService.findLowerCategories(11);
        for(CategoryDTO category : list){
            System.out.println(category.toString());
        }
    }

}