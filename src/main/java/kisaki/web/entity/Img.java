package kisaki.web.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;

public class Img implements Serializable {
    private String imgUrl;
    private long id;
    private String imgName;
    private String userId;
    private String userName;
    private String userLogoUrl;
    private int img_height;
    private int img_width;
    private double img_size;
    private String imgContext;
    private int imgHaveSeen;
    private int ImgHaveCollected;
    private Date imgPushDate;

    public Date getImgPushDate() {
        return imgPushDate;
    }

    public void setImgPushDate(Date imgPushDate) {
        this.imgPushDate = imgPushDate;
    }

    public int getImgHaveSeen() {
        return imgHaveSeen;
    }

    public void setImgHaveSeen(int imgHaveSeen) {
        this.imgHaveSeen = imgHaveSeen;
    }

    public int getImgHaveCollected() {
        return ImgHaveCollected;
    }

    public void setImgHaveCollected(int imgHaveCollected) {
        ImgHaveCollected = imgHaveCollected;
    }

    public String getImgContext() {
        return imgContext;
    }

    public void setImgContext(String imgContext) {
        this.imgContext = imgContext;
    }

    public int getImg_height() {
        return img_height;
    }

    public void setImg_height(int img_height) {
        this.img_height = img_height;
    }

    public int getImg_width() {
        return img_width;
    }

    public void setImg_width(int img_width) {
        this.img_width = img_width;
    }

    public double getImg_size() {
        return img_size;
    }

    public void setImg_size(double img_size) {
        this.img_size = img_size;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLogoUrl() {
        return userLogoUrl;
    }

    public void setUserLogoUrl(String userLogoUrl) {
        this.userLogoUrl = userLogoUrl;
    }

    public String getImgUrl() {

        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
