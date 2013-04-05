package mymall.entity;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 2
 * Time: 오후 6:16
 * To change this template use File | Settings | File Templates.
 */
public class Order {

    private int orderId;
    private int productId;
    private String userId;
    private int quantity;
    private int payment;
    private String toName;
    private String toPhone;
    private String toZipCode;
    private String toAddr;
    private String memo;
    private String status;
    private String createdDate;
    private String userName;
    private String productName;

    public Order () {}

    public Order(int orderId, int productId, String userId, int quantity, int payment, String toName, String toPhone, String toZipCode, String toAddr, String memo, String status, String createdDate, String userName, String productName) {
        this.orderId = orderId;
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
        this.payment = payment;
        this.toName = toName;
        this.toPhone = toPhone;
        this.toZipCode = toZipCode;
        this.toAddr = toAddr;
        this.memo = memo;
        this.status = status;
        this.createdDate = createdDate;
        this.userName = userName;
        this.productName = productName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToPhone() {
        return toPhone;
    }

    public void setToPhone(String toPhone) {
        this.toPhone = toPhone;
    }

    public String getToZipCode() {
        return toZipCode;
    }

    public void setToZipCode(String toZipCode) {
        this.toZipCode = toZipCode;
    }

    public String getToAddr() {
        return toAddr;
    }

    public void setToAddr(String toAddr) {
        this.toAddr = toAddr;
    }
}
