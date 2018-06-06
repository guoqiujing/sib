package cn.myzqu.dto;

import cn.myzqu.pojo.Points;

/**
 * Created by Chrky on 2018/6/6.
 */
public class PointsDTO extends Points{

    //用户积分总数
    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "PointsDTO{" +
                "points=" + points +
                "} " + super.toString();
    }
}
