package cn.myzqu.dao;

import cn.myzqu.dto.BankDTO;
import cn.myzqu.pojo.QuestionBank;

import java.util.List;
import java.util.Map;

public interface QuestionBankMapper {

    /**
     * 根据题库id删除题库信息
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 创建题库
     * @param questionBank
     * @return
     */
    int insert(QuestionBank questionBank);

    /**
     * 根据题库id修改题库信息
     * @param questionBank
     * @return
     */
    int updateById(QuestionBank questionBank);

    /**
     * 题库排序综合显示(练习人数，评价星级，否则更新时间)
     * @param Map
     * @return
     */
    List<BankDTO> selectSort(Map<String ,Object> Map);

    /**
     * 综合查询(根据题库id，用户id，类名名称，题库标题)
     * @param Map
     * @return
     */
    List<BankDTO> select(Map<String,Object> Map);

    /**
     * 根据题库id查询题库
     * @param id
     * @return
     */
    QuestionBank selectById(String id);

    /**
     * 根据题库标题查询题库
     * @param title
     * @return
     */
    QuestionBank selectByTitle(String title);

    /**
     * 根据用户id查询题库
     * @param userId
     * @return
     */
    List<BankDTO> selectByUserId(String userId);

    /**
     * 根据类目名称查询题库
     * @param name
     * @return
     */
    List<BankDTO> selectByTypeName(String name);

    /**
     * 根据题库id查询题库的题目数目
     * @param id
     * @return
     */
    int countChoiceByBank(String id);

    /**
     * 用户根据题库标题模糊查询题库
     * @param title
     * @return
     */
    List<BankDTO> searchByTitle(String title);

    int countAllChoiceByBank();

    /**
     * 根据题库id练习人数+1
     * @param id
     * @return
     */
    int insertPractiseByBankId(String id);

    List<QuestionBank> selectAllBank();//显示所有题库

    List<QuestionBank> selectGreatBank();//显示推荐题库
}