package cn.myzqu.service;

import cn.myzqu.dto.BankDTO;
import cn.myzqu.dto.PageDTO;
import cn.myzqu.pojo.QuestionBank;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

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
     * 根据题库id查询题库信息
     * @param id
     * @return
     */
    BankDTO findById(String id);

    /**
     * 根据题库标题查询题库信息
     * @param title
     * @return
     */
    BankDTO findByTitle(String title);

    /**
     * 根据用户id查询题库信息
     * @param id
     * @return
     */
    List<BankDTO> selectByUserId(String id);

    /**
     * 根据类目名称查询题库
     * @param name
     * @return
     */
    PageDTO selectByCategory(String name,int pageNum, int pageSize);

    /**
     * 根据题库标题模糊搜索题库
     * @param title
     * @return
     */
    PageDTO searchByTitle(String title,int pageNum, int pageSize);

    /**
     * 根据练习人数排序题库
     * @return
     */
    PageDTO selectSortByNumber(int pageNum, int pageSize);

    /**
     * 根据星级评价排序题库
     * @return
     */
    PageDTO selectSortBylevel(int pageNum, int pageSize);

}
