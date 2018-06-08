package cn.myzqu.service.impl;

import cn.myzqu.dao.CategoryMapper;
import cn.myzqu.dto.CategoryDTO;
import cn.myzqu.enums.CategoryLevelEnum;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.exception.CustomException;
import cn.myzqu.pojo.Category;
import cn.myzqu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 题库类目服务接口实现类
 * Created by 的川 on 2018/5/9.
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Boolean add(String name, Integer parentId) {
        //判断是否已经存在该题库类目
        if(findByName(name)!=null) throw new CustomException(ResultEnum.CATEGORY_EXITS);
        Category category = new Category();
        String parentIds = CategoryLevelEnum.TOP.getCode()+"";
        //判断新增的类目是否为顶级类目
        if(StringUtils.isEmpty(parentId)) {
            parentId = CategoryLevelEnum.TOP.getCode();
        }
        else {
            //查找父类字符
            parentIds = findParentIds(parentId);
            parentIds = parentIds + "/" + parentId;
        }
        category.setName(name);
        category.setParentId(parentId);
        category.setParentIds(parentIds);
        //插入记录到数据库
        int result = categoryMapper.insert(category);
        if(result>0) return true;
        return false;
    }

    @Override
    public String findParentIds(Integer id) {
        Category category = categoryMapper.selectById(id);
        if(StringUtils.isEmpty(category)){
            return null;
        }
        return category.getParentIds();
    }

    @Override
    public List<CategoryDTO> findTopCategories() {
        List<CategoryDTO> categories = categoryMapper.selectByParentId(CategoryLevelEnum.TOP.getCode());
        return categories;
    }

    @Override
    public List<CategoryDTO> findLowerCategories(Integer parentId) {
        List<CategoryDTO> categories = categoryMapper.selectByParentId(parentId);
        return categories;
    }

    /**
     * 根据题库名称查找题库
     *
     * @param name
     * @return
     */
    @Override
    public Category findByName(String name) {
        return categoryMapper.selectByName(name);
    }


    @Override
    public List<CategoryDTO> findAll() {
        //查找顶级类目
        List<CategoryDTO> topList = findTopCategories();
        int topListSize = topList.size();
        for(int i=0;i<topListSize;i++) {
            //查找一级类目
            List<CategoryDTO> lowerList = findLowerCategories(topList.get(i).getId());
            int lowerListSize = lowerList.size();
            for (int j =0;j<lowerListSize;j++) {
                //查找二级类目
                List<CategoryDTO> categories = findLowerCategories(lowerList.get(j).getId());
                lowerList.get(j).setLowerCategories(categories);
            }
            topList.get(i).setLowerCategories(lowerList);
        }
        return topList;
    }

//    @Override
//    public List<CategoryDTO> findAll() {
//        //定义一个顶级List接收
//        List<CategoryDTO> topResult = new ArrayList<>();
//        //查找顶级类目
//        List<CategoryDTO> topList = findTopCategories();
//        for(CategoryDTO topCategory:topList) {
//            //定义一个一级List接收
//            List<CategoryDTO> firstResult = new ArrayList<>();
//            //查找一级类目
//            List<CategoryDTO> lowerList = findLowerCategories(topCategory.getId());
//            for (CategoryDTO lowerCategory : lowerList) {
//                //查找二级类目
//                List<CategoryDTO> categories = findLowerCategories(lowerCategory.getId());
//                CategoryDTO lowerCategoryDTO = new CategoryDTO();
//                BeanUtils.copyProperties(lowerCategory,lowerCategoryDTO);
//                lowerCategoryDTO.setLowerCategories(categories);
//                firstResult.add(lowerCategoryDTO);
//            }
//            CategoryDTO topCategoryDTO = new CategoryDTO();
//            BeanUtils.copyProperties(topCategory,topCategoryDTO);
//            topCategoryDTO.setLowerCategories(firstResult);
//            topResult.add(topCategoryDTO);
//        }
//        return topResult;
//    }

}
