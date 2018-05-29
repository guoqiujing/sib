package cn.myzqu.utils;

import cn.myzqu.pojo.ChoiceQuestion;
import cn.myzqu.service.ChoiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 的川 on 2018/5/29.
 */
public class BatchUtil {


    public static List readQeustionByWord(String filePath){
        String result = PdfUtil.getTextFromPdf(filePath);
        //获取每道题目
        String[] res = result.split("((\n" +
                ")|\n" +
                ")[\\s\t ]*(\\1)");
        //解析每道题目的每一项,并存储到List中
        List row = new ArrayList();
        for(int i=0;i<res.length;i++){
            List item = new ArrayList();
            String que = res[i];
            String[] arr = que.split("#");
            for(int j=0;j<arr.length;j++){
                System.out.println(j+":"+arr[j]);
                item.add(arr[j]);
            }
            row.add(item);
        }
        return row;
    }

}
