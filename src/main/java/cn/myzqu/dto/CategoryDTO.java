package cn.myzqu.dto;

import lombok.Data;

import java.util.List;


/**
 * Created by 的川 on 2018/5/10.
 */
@Data
public class CategoryDTO {

    private Integer id;

    private String name;

    private Integer ord;

    private Integer parentId;

    private String parentIds;

    private List<CategoryDTO> LowerCategories;

}
