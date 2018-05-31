package cn.myzqu.dao;

import cn.myzqu.pojo.Attendance;

public interface AttendanceMapper {
    int deleteByPrimaryKey(String id);

    /**
     * 用户签到
     * @param attendance
     * @return
     */
    int signByUser(Attendance attendance);

    Attendance selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Attendance record);

    /**
     * 根据用户id查询今天是否签到
     * @param userId
     * @return
     */
    Attendance selectSignByUser(String userId);
}