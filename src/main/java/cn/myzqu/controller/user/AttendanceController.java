package cn.myzqu.controller.user;

import cn.myzqu.enums.ResultEnum;
import cn.myzqu.pojo.Attendance;
import cn.myzqu.service.AttendanceService;
import cn.myzqu.service.PointsService;
import cn.myzqu.utils.IPUtil;
import cn.myzqu.utils.KeyUtil;
import cn.myzqu.utils.ResultVOUtil;
import cn.myzqu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * Created by Chrky on 2018/5/28.
 */
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private PointsService pointsService;

    /**
     * 用户签到
     * @param userId
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/sign")
    public Result sign(@RequestParam String userId, HttpServletRequest request) throws IOException
    {
        String ip=IPUtil.getIP(request);
        Attendance attendance=new Attendance();
      //  String address=AddressUtil.getAddressBySina(ip);
        String address = "中国";
        attendance.setId(KeyUtil.getUUID());
        attendance.setIp(ip);
        attendance.setUserId(userId);
        attendance.setAddress(address);
        //用户添加到签到记录
        if(attendanceService.sign(attendance)) {
            pointsService.sign(attendance.getUserId());
            return ResultVOUtil.success();
        }
        else
            return ResultVOUtil.error(ResultEnum.USER_SIGN_FAIL);
    }

    /**
     * 查询用户签到状态
     * @param userId
     * @return
     */
    @GetMapping("/state")
        public Result findSignByUser(@RequestParam String userId)
        {
            Attendance attendance=attendanceService.findSignByUser(userId);
            if(attendance!=null)
                return ResultVOUtil.success(attendance);
            else
                return ResultVOUtil.error(ResultEnum.USER_SIGN_NOT_EXIST);
        }
}
