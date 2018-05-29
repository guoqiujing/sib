package cn.myzqu.service;

import cn.myzqu.pojo.Attendance;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Chrky on 2018/5/27.
 */
public interface AttendanceService {

    Boolean sign(Attendance attendance) throws IOException;//用户签到

    Boolean selectSignByUser(String userId);//查询是否签到

    Attendance findSignByUser(String userId);//得到用户签到状态
}
