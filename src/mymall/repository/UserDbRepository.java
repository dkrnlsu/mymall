package mymall.repository;

import mymall.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 2
 * Time: 오후 6:38
 * To change this template use File | Settings | File Templates.
 */
public class UserDbRepository extends DbConnect implements UserRepository {
    private static UserDbRepository instance = new UserDbRepository();

    public static UserDbRepository getInstance() {
        return instance;
    }

    private UserDbRepository() {

    }

    @Override
    public List<User> getUsers() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();
        try {
            conn = dbConnect();
            String sql = "SELECT * FROM \"tblUsers\" ORDER BY \"userId\"";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(); // select시에 추가해야 할 부분
            while(rs.next()) { // boolean 값을 던짐
                User user = new User();
                user.setUserId(rs.getString("userId"));
                user.setUserPw(rs.getString("userPw"));
                user.setUserName(rs.getString("userName"));
                user.setCyberMoney(Integer.parseInt(rs.getString("cyberMoney")));
                user.setPhone(rs.getString("phone"));
                user.setZipCode(rs.getString("zipCode"));
                user.setAddr(rs.getString("addr"));
                user.setCreatedDate(rs.getString("createdDate"));
                users.add(user);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose(rs, pstmt, conn);
        }
        return users;
    }

    @Override
    public void addUser(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbConnect();
            String sql = "INSERT INTO \"tblUsers\" (\"userId\", \"userPw\", \"userName\", \"cyberMoney\", phone, \"zipCode\", addr, \"createdDate\") " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserPw());
            pstmt.setString(3, user.getUserName());
            pstmt.setInt(4, user.getCyberMoney());
            pstmt.setString(5, user.getPhone());
            pstmt.setString(6, user.getZipCode());
            pstmt.setString(7, user.getAddr());
            pstmt.setString(8, user.getCreatedDate());
            pstmt.executeUpdate();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose(pstmt, conn);
        }
    }

    @Override
    public User getUser(String userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = new User();
        try {
            conn = dbConnect();
            String sql = "SELECT * FROM \"tblUsers\" WHERE \"userId\"=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery(); // select시에 추가해야 할 부분
            while(rs.next()) { // boolean 값을 던짐
                user.setUserId(rs.getString("userId"));
                user.setUserPw(rs.getString("userPw"));
                user.setUserName(rs.getString("userName"));
                user.setCyberMoney(Integer.parseInt(rs.getString("cyberMoney")));
                user.setPhone(rs.getString("phone"));
                user.setZipCode(rs.getString("zipCode"));
                user.setAddr(rs.getString("addr"));
                user.setCreatedDate(rs.getString("createdDate"));
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose(rs, pstmt, conn);
        }
        return user;
    }

    @Override
    public User getUser(String userId, String userPw) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = dbConnect();
            String sql = "SELECT * FROM \"tblUsers\" WHERE \"userId\"=? and \"userPw\"=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, userPw);
            rs = pstmt.executeQuery(); // select시에 추가해야 할 부분
            while(rs.next()) { // boolean 값을 던짐
                user = new User();
                user.setUserId(rs.getString("userId"));
                user.setUserPw(rs.getString("userPw"));
                user.setUserName(rs.getString("userName"));
                user.setCyberMoney(Integer.parseInt(rs.getString("cyberMoney")));
                user.setPhone(rs.getString("phone"));
                user.setZipCode(rs.getString("zipCode"));
                user.setAddr(rs.getString("addr"));
                user.setCreatedDate(rs.getString("createdDate"));
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose(rs, pstmt, conn);
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbConnect();
            String sql = "UPDATE \"tblUsers\" SET \"userPw\"=?, \"userName\"=?, phone=?, \"zipCode\"=?, addr=? WHERE \"userId\"=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserPw());
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getZipCode());
            pstmt.setString(5, user.getAddr());
            pstmt.setString(6, user.getUserId());
            pstmt.executeUpdate();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dbClose(pstmt, conn);
        }
    }

    @Override
    public void minusUserCyberMoney(String userId, int minusCyberMoney, Connection conn)  throws SQLException {
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE \"tblUsers\" SET \"cyberMoney\"=(\"cyberMoney\" - ?) WHERE \"userId\"=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, minusCyberMoney);
            pstmt.setString(2, userId);
            pstmt.executeUpdate();
        } finally {
            dbClose(pstmt);
        }
    }

    @Override
    public void plusUserCyberMoney(String userId, int minusCyberMoney, Connection conn)  throws SQLException {
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE \"tblUsers\" SET \"cyberMoney\"=(\"cyberMoney\" + ?) WHERE \"userId\"=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, minusCyberMoney);
            pstmt.setString(2, userId);
            pstmt.executeUpdate();
        } finally {
            dbClose(pstmt);
        }
    }
}
