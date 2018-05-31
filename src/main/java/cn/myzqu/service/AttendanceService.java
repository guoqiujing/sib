package cn.myzqu.service;

import cn.myzqu.pojo.Attendance;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Chrky on 2018/5/27.
 */
public interface AttendanceService {

    /**
     * 用户签到
     * @param attendance
     * @return
     * @throws IOException
     */
    Boolean sign(Attendance attendance) throws IOException;

    /**
     * 查询是否签到
     * @param userId
     * @return
     */
    Boolean selectSignByUser(String userId);

    /**
     * 得到用户签到状态
     * @param userId
     * @return
     */
    Attendance findSignByUser(String userId);
}
