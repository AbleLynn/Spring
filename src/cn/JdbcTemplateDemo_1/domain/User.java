package cn.JdbcTemplateDemo_1.domain;

public class User {
    private String userId;
    private String userName;
    private String uStatus;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getuStatus() {
        return uStatus;
    }

    public void setuStatus(String uStatus) {
        this.uStatus = uStatus;
    }
}
