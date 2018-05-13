package cn.myzqu.dto;

import lombok.Data;

import java.util.List;


/**
 * 题库类型
 * Created by 的川 on 2018/5/10.
 */
@Data
public class CategoryDTO {

    /**
     * 类型编号
     */
    private Integer id;
    /**
     * 类型名称
     */
    private String name;
    /**
     * 优先级数字，值越小越优先
     */
    private Integer ord;
    /**
     * 父类目编号，本身为顶级类目，则为0
     */
    private Integer parentId;
    /**
     * 父类目编号列表，以/分割
     */
    private String parentIds;
    /**
     * 子类列表
     */
    private List<CategoryDTO> LowerCategories;

}
