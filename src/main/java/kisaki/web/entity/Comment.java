package kisaki.web.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment implements Serializable {
    private Long userId;
    private String comment;
    private String userName;
    private Date date;

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

    public String getDate() {
        SimpleDateFormat sf = new SimpleDateFormat("YYYY:MM:DD HH:MM:SS");



        return sf.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
