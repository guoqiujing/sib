package cn.myzqu.service;

import cn.myzqu.dto.CategoryDTO;
import cn.myzqu.pojo.Category;

import java.util.List;

/**
 * 题库类目服务接口
 * Created by 的川 on 2018/5/9.
 */
public interface CategoryService {

    /**
     * 新增类目
     * @param name
     * @param parentId
     * @return
     */
    Boolean add(String name,Integer parentId);

    /**
     * 查找父类目字符串
     * @param id
     * @return
     */
    String findParentIds(Integer id);

    /**
     * 查找顶级类目
     * @return
     */
    List<CategoryDTO> findTopCategories();

    /**
     * 查找下级类目
     * @param parentId
     * @return
     */
    List<CategoryDTO> findLowerCategories(Integer parentId);

    /**
     * 根据题库名称查找题库
     * @param name
     * @return
     */
    Category findByName(String name);

    /**
     * 查找所有类目
     * @return
     */
    List<CategoryDTO> findAll();


}
