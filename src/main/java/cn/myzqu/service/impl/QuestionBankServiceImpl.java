package cn.myzqu.service.impl;

import cn.myzqu.dao.QuestionBankMapper;
import cn.myzqu.dto.BankDTO;
import cn.myzqu.dto.PageDTO;
import cn.myzqu.dto.UserDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.exception.CustomException;
import cn.myzqu.pojo.QuestionBank;
import cn.myzqu.service.QuestionBankService;
import cn.myzqu.utils.KeyUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户服务接口实现类
 * Created by Chrky on 2018/5/10.
 */
@Service
public class QuestionBankServiceImpl implements QuestionBankService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private QuestionBankMapper questionBankMapper;

    @Override
    public Boolean add(QuestionBank questionBank) {
        String title = questionBank.getTitle();
        //根据题库标题判断题库是否存在
        if (findByTitle(title) != null) {
            throw new CustomException(ResultEnum.BANK_TITLE_EXIST);
        }
        questionBank.setId(KeyUtil.getUUID());
        //创建题库
        int result = questionBankMapper.insert(questionBank);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(String id) {
        //根据题库id查询题库信息
        if (findById(id)==null)
            throw new CustomException(ResultEnum.BANK_NOT_EXIST);
        //根据题库id删除题库信息
        if (questionBankMapper.deleteById(id) > 0)
            return true;
        return false;
    }

    @Override
    public Boolean updateById(QuestionBank questionBank) {
        //根据题库id修改题库信息
        if (questionBankMapper.updateById(questionBank)>0)
            return true;
        else
            return false;

    }

    @Override
    public QuestionBank findById(String id) {
        //根据题库id查询题库
        QuestionBank questionBank = questionBankMapper.selectById(id);
        if (StringUtils.isEmpty(questionBank)) {
            return null;
        }
        return questionBank;
    }

    @Override
    public QuestionBank findByTitle(String title) {
        //根据题库标题查询题库
        QuestionBank questionBank = questionBankMapper.selectByTitle(title);
        if (StringUtils.isEmpty(questionBank)) {
            return null;
        }
        return questionBank;
    }

    @Override
    public PageDTO findByUserId(String userId, int pageNum, int pageSize) {
        //使用PageHelper插件实现分页
        //注意：下面这两条语句必须紧跟，保证分页安全
        Page page = PageHelper.startPage(pageNum,pageSize);
        List<BankDTO> bankDTOS  = questionBankMapper.selectByUserId(userId);
        //判断bankDTOS是否有数据,没有数据返回null
        if(bankDTOS.isEmpty()) return null;
        //获取总记录数
        int total = (int)page.getTotal();
        //获取总页数
        int pages = page.getPages();
        //封装数据到分页类PageDTO
        PageDTO pageDTO = new PageDTO(bankDTOS,total,pageSize,pageNum,pages);
        return pageDTO;
    }

    @Override
    public PageDTO findByTypeName(String name, int pageNum, int pageSize) {
        //使用PageHelper插件实现分页
        //注意：下面这两条语句必须紧跟，保证分页安全
        Page page = PageHelper.startPage(pageNum,pageSize);
        List<BankDTO> bankDTOS  = questionBankMapper.selectByTypeName(name);
        //判断bankDTOS是否有数据,没有数据返回null
        if(bankDTOS.isEmpty()) return null;
        //获取总记录数
        int total = (int)page.getTotal();
        //获取总页数
        int pages = page.getPages();
        //封装数据到分页类PageDTO
        PageDTO pageDTO = new PageDTO(bankDTOS,total,pageSize,pageNum,pages);
        return pageDTO;
    }

    @Override
    public PageDTO searchByTitle(String title, int pageNum, int pageSize) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        //用户根据题库标题模糊查询题库
        List<BankDTO> bankDTOS  =questionBankMapper.searchByTitle(title);
        if(bankDTOS.isEmpty()) return null;
        int total = (int)page.getTotal();
        int pages = page.getPages();
        PageDTO pageDTO = new PageDTO(bankDTOS,total,pageSize,pageNum,pages);
        return pageDTO;
    }

    @Override
    public PageDTO findSort(String condition,int pageNum,int pageSize) {
        //封装条件
        Map<String,Object> conditionMap = new HashMap<>();
        conditionMap.put(condition,condition);
        //使用PageHelper插件实现分页
        //注意：下面这两条语句必须紧跟，保证分页安全
        Page page = PageHelper.startPage(pageNum,pageSize);
        List<BankDTO> bankDTOS  = questionBankMapper.selectSort(conditionMap);
        //判断bankDTOS是否有数据,没有数据返回null
        if(bankDTOS.isEmpty()) return null;
        //获取总记录数
        int total = (int)page.getTotal();
        //获取总页数
        int pages = page.getPages();
        //封装数据到分页类PageDTO
        PageDTO pageDTO = new PageDTO(bankDTOS,total,pageSize,pageNum,pages);
        return pageDTO;
    }

    @Override
    public PageDTO find(Map<String,Object> Map,int pageNum, int pageSize) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        //综合查询
        List<BankDTO> bankDTOS  =questionBankMapper.select(Map);
        if(bankDTOS.isEmpty()) return null;
        int total = (int)page.getTotal();
        int pages = page.getPages();
        PageDTO pageDTO = new PageDTO(bankDTOS,total,pageSize,pageNum,pages);
        return pageDTO;
    }

}