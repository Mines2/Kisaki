package kisaki.web.entity.shiro;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable {
    private  Long id;
    private String userName;
    private String password;
    private String logoImgUrl;
    private String address;
    private int sex;
    private Date birthday;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthdayString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
        return  simpleDateFormat.format(this.birthday);
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date date) {
        this.birthday = date;
    }

    public String getLogoImgUrl() {
        return logoImgUrl;
    }

    public void setLogoImgUrl(String logoImgUrl) {
        this.logoImgUrl = logoImgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
