package cn.myzqu.controller;

import cn.myzqu.file.ReadExcel;
import cn.myzqu.utils.FileUtil;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 文件上传下载控制器
 * Created by 的川 on 2018/5/18.
 */
@RestController
@RequestMapping("file")
public class FileController {

    // 上传文件会自动绑定到MultipartFile中
    @PostMapping(value = "/upload/excel")
    public Result uploadExcel(HttpServletRequest request,  @RequestParam("bankId") int bankId,
                              @RequestParam("file") MultipartFile file) throws Exception {
        System.out.println("上传的题库id为："+ bankId);
        String filePath = FileUtil.uploadFile(file, request);
        if (filePath == "" || filePath == null) {
            System.out.println("上传文件路径为空");
        } else {
            InputStream in = new FileInputStream(new File(filePath));
            ReadExcel.start(in, filePath);
        }
        return ResultVOUtil.success();

    }
}
