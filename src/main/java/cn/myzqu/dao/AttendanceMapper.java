package cn.myzqu.dao;

import cn.myzqu.pojo.Attendance;

public interface AttendanceMapper {
    int deleteByPrimaryKey(String id);

    int signByUser(Attendance attendance);//用户签到

    Attendance selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Attendance record);

    Attendance selectSignByUser(String userId);//查询今天是否签到
}