package mymall.entity;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 2
 * Time: 오후 6:16
 * To change this template use File | Settings | File Templates.
 */
public class User {

    private String userId;
    private String userPw;
    private String userName;
    private int cyberMoney;
    private String phone;
    private String zipCode;
    private String addr;
    private String createdDate;

    public User () {}

    public User(String userId, String userPw, String userName, int cyberMoney, String phone, String zipCode, String addr, String createdDate) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.cyberMoney = cyberMoney;
        this.phone = phone;
        this.zipCode = zipCode;
        this.addr = addr;
        this.createdDate = createdDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCyberMoney() {
        return cyberMoney;
    }

    public void setCyberMoney(int cyberMoney) {
        this.cyberMoney = cyberMoney;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

}
