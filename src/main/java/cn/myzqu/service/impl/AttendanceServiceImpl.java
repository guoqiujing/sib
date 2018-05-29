package cn.myzqu.service.impl;

import cn.myzqu.dao.AttendanceMapper;
import cn.myzqu.enums.ResultEnum;
import cn.myzqu.exception.CustomException;
import cn.myzqu.pojo.Attendance;
import cn.myzqu.service.AttendanceService;
import cn.myzqu.utils.AddressUtil;
import cn.myzqu.utils.IPUtil;
import cn.myzqu.utils.KeyUtil;
import cn.myzqu.utils.ResultVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;


/**
 * Created by Chrky on 2018/5/27.
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public Boolean sign(Attendance attendance) throws IOException {
        //查询用户今天是否已签到
        if(selectSignByUser(attendance.getUserId()))
            throw new CustomException(ResultEnum.USER_SIGN_EXIST);
        if(attendanceMapper.signByUser(attendance)>0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean selectSignByUser(String userId) {
        //查询用户今天是否已签到
        if(attendanceMapper.selectSignByUser(userId)!=null)
            return true;
        else
            return false;
    }

    @Override
    public Attendance findSignByUser(String userId) {
        //得到用户签到状态
        return attendanceMapper.selectSignByUser(userId);
    }
}
