package kisaki.web.entiy;

import java.io.Serializable;

public class BackgroundImg  implements Serializable {
    private String imgUrl;
    private long id;
    private String imgName;
    private String userId;
    private String userName;
    private String userLogoUrl;

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
