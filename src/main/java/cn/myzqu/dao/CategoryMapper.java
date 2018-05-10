package cn.myzqu.dao;

import cn.myzqu.dto.CategoryDTO;
import cn.myzqu.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteById(Integer id);

    int insert(Category record);

    int updateById(Category record);

    Category selectById(Integer id);

    Category selectByName(String name);

    List<CategoryDTO> selectByParentId(Integer parentId);
}