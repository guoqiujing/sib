package cn.myzqu.dto;

import cn.myzqu.pojo.ChoiceQuestion;

/**
 * Created by Chrky on 2018/5/14.
 */
public class ChoiceDTO extends ChoiceQuestion{

    //题库标题
    private String title;

    //题目收藏状态
    private String favoriteState;

    //题目评级状态
    private String ratingState;

    //题目评级
    private Double rating;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getFavoriteState() {
        return favoriteState;
    }

    public void setFavoriteState(String favoriteState) {
        this.favoriteState = favoriteState;
    }

    public String getRatingState() {
        return ratingState;
    }

    public void setRatingState(String ratingState) {
        this.ratingState = ratingState;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        {
            return "BankDTO [title=" + title + ",favoriteState="+favoriteState+",ratingState="+ratingState+",rating="+rating+", toString()=" + super.toString() + "]";
        }
    }
}
