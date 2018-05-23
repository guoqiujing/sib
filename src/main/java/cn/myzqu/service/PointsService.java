package cn.myzqu.service;

import cn.myzqu.pojo.Points;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * Created by Chrky on 2018/5/22.
 */
public interface PointsService {

    Boolean Register(String userId);//用户注册获得积分

    Boolean Sign(String userId);//用户签到

    Points SignByUser(String userId);//查询该用户今天是否已签到
}
