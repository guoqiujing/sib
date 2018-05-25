package cn.myzqu.controller;

import cn.myzqu.file.ReadExcel;
import cn.myzqu.pojo.ChoiceQuestion;
import cn.myzqu.service.ChoiceQuestionService;
import cn.myzqu.utils.FileUtil;
import cn.myzqu.utils.ListToPojo;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * 文件上传下载控制器
 * Created by 的川 on 2018/5/18.
 */
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private ChoiceQuestionService choiceQuestionService ;

    // 上传文件会自动绑定到MultipartFile中
    @PostMapping(value = "/upload/excel")
    public Result uploadExcel(HttpServletRequest request,  @RequestParam("bankId") String bankId,
                              @RequestParam("userId") String userId,
                              @RequestParam("file") MultipartFile file) throws Exception {
        System.out.println("上传的题库id为："+ bankId);
        String filePath = FileUtil.uploadFile(file, request);
        StringBuffer stringBuffer = new StringBuffer();
        if (filePath == "" || filePath == null) {
            System.out.println("上传文件路径为空");
        } else {
            List list = ReadExcel.start(filePath);
            List<ChoiceQuestion> choiceQuestions = ListToPojo.listToChoiceQuestion(list,bankId,userId);
            for(ChoiceQuestion choiceQuestion :choiceQuestions){
                Boolean result = choiceQuestionService.add(choiceQuestion);
                stringBuffer.append("添加题目：");
                stringBuffer.append(choiceQuestion.getQuestion());
                if(result) {
                    stringBuffer.append("成功\n");
                }
                stringBuffer.append("失败\n");
            }
        }
        return ResultVOUtil.success(stringBuffer);

    }
}
