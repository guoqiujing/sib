package cn.myzqu.service.impl;


import cn.myzqu.dao.ChoiceQuestionMapper;
import cn.myzqu.dao.FavoriteMapper;
import cn.myzqu.dao.PointsMapper;
import cn.myzqu.dao.RatingMapper;
import cn.myzqu.dto.ChoiceDTO;
import cn.myzqu.dto.PageDTO;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.exception.CustomException;
import cn.myzqu.pojo.ChoiceQuestion;
import cn.myzqu.pojo.Favorite;
import cn.myzqu.service.ChoiceQuestionService;
import cn.myzqu.utils.KeyUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Chrky on 2018/5/14.
 */
@Service
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ChoiceQuestionMapper choiceQuestionMapper;

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Autowired
    private RatingMapper ratingMapper;

    @Override
    public ChoiceQuestion findById(String id) {
        //根据题目id查询题目
        return choiceQuestionMapper.selectById(id);
    }

    @Override
    public ChoiceQuestion findByQuestion(String question) {
        //根据题目查询题目详情
        return choiceQuestionMapper.selectByQuestion(question);
    }

    @Override
    public Boolean add(ChoiceQuestion choiceQuestion) {
        //判断该题目是否存在
        String question=choiceQuestion.getQuestion();
        if((findByQuestion(question))!=null)
            throw new CustomException(ResultEnum.QUESTION_IS_EXIST);
        //生成主键
        choiceQuestion.setId(KeyUtil.getUUID());
        //创建题目
        int result=choiceQuestionMapper.insert(choiceQuestion);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteById(String id) {
        //判断是否该题目是否存在
        if(findById(id)==null)
            throw new CustomException(ResultEnum.QUESTION_NOT_EXIST);
        int result=choiceQuestionMapper.deleteById(id);
        if(result>0)
            return true;
        else
            return false;
    }

    @Override
    public List<ChoiceDTO> findByBankId(String id,String userId) {
        //根据题库id查询题目
        List<ChoiceDTO> choiceDTOS= choiceQuestionMapper.selectByBankId(id);
        for(int i=0;i<choiceDTOS.size();i++)
        {
            ChoiceDTO choiceDTO=choiceDTOS.get(i);
            if(favoriteMapper.judgeFavorite(userId,choiceDTO.getId())!=null)
                choiceDTO.setFavoriteState("已收藏");
            else
                choiceDTO.setFavoriteState("未收藏");
            if(ratingMapper.selectByUserId(userId,choiceDTO.getId())!=null)
                choiceDTO.setRatingState("已评级");
            else
                choiceDTO.setRatingState("未评级");
        }
        return choiceDTOS;
    }

    @Override
    public Boolean updateById(ChoiceQuestion choiceQuestion) {
        //修改题目信息
        if (choiceQuestionMapper.updateById(choiceQuestion) > 0)
            return true;
        else
            return false;
    }

    @Override
    public PageDTO find(Map<String, Object> map, int pageNum, int pageSize) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        //综合查询
        List<ChoiceDTO> choiceDTOS  =choiceQuestionMapper.select(map);
        if(choiceDTOS.isEmpty()) return null;
        int total = (int)page.getTotal();
        int pages = page.getPages();
        PageDTO pageDTO = new PageDTO(choiceDTOS,total,pageSize,pageNum,pages);
        return pageDTO;
    }

    @Override
    public PageDTO findSort(Map<String, Object> map, int pageNum, int pageSize) {
        Page page = PageHelper.startPage(pageNum,pageSize);
        //综合排序
        List<ChoiceDTO> choiceDTOS=choiceQuestionMapper.selectSort(map);
        if(choiceDTOS.isEmpty()) return null;
        int total = (int)page.getTotal();
        int pages = page.getPages();
        PageDTO pageDTO = new PageDTO(choiceDTOS,total,pageSize,pageNum,pages);
        return pageDTO;
    }

    @Override
    public Boolean check(ChoiceQuestion choiceQuestion) {
        //修改审核信息
        if(choiceQuestionMapper.updateById(choiceQuestion)>0)
            return true;
        else
            return false;
    }
}
