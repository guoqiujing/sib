package cn.myzqu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 的川 on 2018/6/6.
 */
@Controller
public class NavController {

    @RequestMapping("user/{htmlName}")
    public String showPage(@PathVariable("htmlName") String htmlName)
    {
        System.out.println(htmlName);
        return "/user/"+htmlName;
    }

    @RequestMapping("admin/{htmlName}")
    public String admin(@PathVariable("htmlName") String htmlName)
    {
        System.out.println(htmlName);
        return "/admin/"+htmlName;
    }
}
