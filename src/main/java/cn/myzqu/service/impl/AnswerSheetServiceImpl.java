package cn.myzqu.service.impl;

import cn.myzqu.dao.AnswerSheetMapper;
import cn.myzqu.dao.QuestionBankMapper;
import cn.myzqu.dto.*;
import cn.myzqu.pojo.AnswerSheet;
import cn.myzqu.service.AnswerSheetService;
import cn.myzqu.utils.KeyUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 答题类服务接口实现类
 * Created by 的川 on 2018/5/13.
 */
@Service
public class AnswerSheetServiceImpl implements AnswerSheetService {

    @Autowired
    private AnswerSheetMapper answerSheetMapper;
    @Autowired
    private QuestionBankMapper questionBankMapper;

    @Override
    public Boolean add(AnswerSheet answerSheet) {
        //生成记录id
        answerSheet.setId(KeyUtil.getUUID());
        //调用answerSheetMapper插入记录,成功返回true
        if (answerSheetMapper.insert(answerSheet)>0) {
            questionBankMapper.insertPractiseByBankId(answerSheet.getBankId());
            return true;
        }
        //否则返回false
        return false;
    }

    @Override
    public AnswerSheet find(String id) {
        return null;
    }

    @Override
    public List<AnswerSheetDTO> findByUserId(String userId) {
        //整合查询条件
        Map<String,Object> condition = new HashMap<>();
        condition.put("userId",userId);
        //调用answerSheetMapper查询
        List<AnswerSheetDTO> answerSheetDTOList =answerSheetMapper.select(condition);
        return answerSheetDTOList;
    }

    @Override
    public AnswerCountDTO findCount(String userId) {
        //查询用户是否存在
        AnswerCountDTO answerCountDTO = new AnswerCountDTO();
        //查询用户所有答题数量
        Boolean isTrue = null;
        Integer all = answerSheetMapper.selectCountByUserId(userId,isTrue);
        //查询用户所有答错题数量
        isTrue = false;
        Integer error = answerSheetMapper.selectCountByUserId(userId,isTrue);
        answerCountDTO.setAll(all);
        answerCountDTO.setError(error);
        return answerCountDTO;
    }

    @Override
    public List<AnswerSheetDTO> findFaultByUserId(String userId) {
        //整合查询条件
        Map<String,Object> condition = new HashMap<>();
        condition.put("userId",userId);
        condition.put("answerIsTrue",false);
        //调用answerSheetMapper查询
        List<AnswerSheetDTO> answerSheetDTOList =answerSheetMapper.select(condition);
        return answerSheetDTOList;
    }

    @Override
    public PageDTO findByCondition(Map<String, Object> condition, int pageNum, int pageSize) {
        //使用PageHelper插件实现分页
        //注意：下面这两条语句必须紧跟，保证分页安全
        Page page = PageHelper.startPage(pageNum,pageSize);
        List<AnswerSheetDTO> answerSheetDTOList =answerSheetMapper.select(condition);
        //判断list是否有数据,没有数据返回null
        if(answerSheetDTOList.isEmpty()) return null;
        //获取总记录数
        int total = (int)page.getTotal();
        //获取总页数
        int pages = page.getPages();
        //封装数据到分页类PageDTO
        PageDTO pageDTO = new PageDTO(answerSheetDTOList,total,pageSize,pageNum,pages);
        return pageDTO;
    }
}
