package cn.myzqu.controller.admin;

import cn.myzqu.service.AttendanceService;
import cn.myzqu.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Chrky on 2018/5/28.
 */
@RestController("AdminAttendanceController")
@RequestMapping("admin/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private PointsService pointsService;


}
