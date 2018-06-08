package cn.myzqu.service;

import cn.myzqu.dto.PageDTO;
import cn.myzqu.pojo.QuestionBank;

import java.util.Map;

/**
 * Created by Chrky on 2018/5/10.
 */
public interface QuestionBankService
{
    /**
     * 创建题库
     * @param questionBank
     * @return
     */
    Boolean add(QuestionBank questionBank);

    /**
     * 根据题库id删除题库信息
     * @param id
     * @return
     */
    Boolean deleteById(String id);

    /**
     * 根据题库id修改题库
     * @param questionBank
     * @return
     */
    Boolean updateById(QuestionBank questionBank);

    /**
     * 根据题库id或题库标题或用户id或类目名称查询题库信息
     * @param Map id or title or userId or categoryName
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDTO find(Map<String,Object> Map,int pageNum, int pageSize);

    /**
     * 根据练习人数或星级评价排序题库
     * @param condition 说明:frequency 按人数排序 star_level按星级排序 否则按更新时间排序
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDTO findSort(String condition,int pageNum, int pageSize);

    /**
     * 根据题库id查询题库
     * @param id
     * @return
     */
    QuestionBank findById(String id);

    /**
     * 根据题库标题查询题库
     * @param title
     * @return
     */
    QuestionBank findByTitle(String title);

    /**
     * 根据用户id查询题库
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDTO findByUserId(String userId,int pageNum, int pageSize);

    /**
     * 根据类目名称查询题库
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDTO findByTypeName(String name,int pageNum, int pageSize);

    /**
     * 用户根据题库标题模糊查询题库
     * @param title
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDTO searchByTitle(String title,int pageNum, int pageSize);

    /**
     * 批量更新题库评分
     * @return
     */
    Boolean updateBankRating();

    PageDTO findAllBank(int pageNum, int pageSize);//浏览所有题库

    Boolean check(QuestionBank questionBank);//审核题库

    PageDTO findGreatBank(int pageNum, int pageSize);//显示推荐题库
}
