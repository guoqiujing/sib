package cn.myzqu.dao;

import cn.myzqu.dto.AnswerSheetDTO;
import cn.myzqu.pojo.AnswerSheet;

import java.util.List;
import java.util.Map;

public interface AnswerSheetMapper {
    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 插入一条新记录
     * @param record
     * @return
     */
    int insert(AnswerSheet record);

    /**
     * 根据id更新记录
     * @param record
     * @return
     */
    int updateById(AnswerSheet record);

    /**
     * 根据id查询记录
     * @param id
     * @return
     */
    AnswerSheet selectById(String id);

    /**
     * 综合查询答题记录
     * @param map
     * @return
     */
    List<AnswerSheetDTO> select(Map<String,Object> map);



}