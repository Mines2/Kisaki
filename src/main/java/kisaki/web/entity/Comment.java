package kisaki.web.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment implements Serializable {
    private Long userId;
    private Long imgId;
    private String comment;
    private String userName;
    private Date date;
    private Long id;
    private String dataString;

    public void setDataString() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:SS");
        this.dataString = sf.format(date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImgId() {
        return imgId;
    }

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public String getStringDate() {
        SimpleDateFormat sf = new SimpleDateFormat("YYYY:MM:DD HH:MM:SS");

        return sf.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
