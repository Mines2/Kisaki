package kisaki.web.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Active implements Serializable {
    private Long userId;
    private String context;
    private Long imgId;
    private Date date;
    private String imgUrl;
    private String userLogoUrl;
    private String userName;
    private double imgSize;
    private String imgName;

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getImgId() {
        return imgId;
    }

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd  HH:MM");
        return  simpleDateFormat.format(this.date);
    }
    public Date returnDate(){
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUserLogoUrl() {
        return userLogoUrl;
    }

    public void setUserLogoUrl(String userLogoUrl) {
        this.userLogoUrl = userLogoUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getImgSize() {
        return imgSize;
    }

    public void setImgSize(double imgSize) {
        this.imgSize = imgSize;
    }
}
