package cn.myzqu.dao;

import cn.myzqu.dto.BankDTO;
import cn.myzqu.pojo.QuestionBank;

import java.util.List;

public interface QuestionBankMapper {
    int deleteById(String id);//根据题库id删除题库信息

    int insert(QuestionBank questionBank);//创建题库

    BankDTO selectById(String id);//根据题库id查询题库

    int updateById(QuestionBank questionBank);//根据题库id修改题库信息

    BankDTO selectByTitle(String title);//根据题库标题查询题库

    List<BankDTO> selectByUserId(String id);//根据用户id查询题库

    List<BankDTO> selectByCategory(String name);//根据类目名称查询题库

    List<BankDTO> selectSortByNumber();//根据练习人数排序题库

    List<BankDTO> selectSortBylevel();//根据评价星级排序题库

    List<BankDTO> searchByTitle(String title);//根据题库标题模糊搜索题库

    int countChoiceByBank (String id);//计算该题库下题目数目
}