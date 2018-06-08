package cn.myzqu.controller.user;

import cn.myzqu.dto.CategoryDTO;
import cn.myzqu.service.CategoryService;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 题库类型控制器
 * Created by 的川 on 2018/5/9.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 获得所有可见题库类目
     * @return
     */
    @GetMapping("/list")
    public Result list(){
        List<CategoryDTO> categoryDTOList = categoryService.findAll();
        return ResultVOUtil.success(categoryDTOList);
    }

}
