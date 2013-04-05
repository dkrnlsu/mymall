package mymall.repository;
import mymall.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 2
 * Time: 오후 6:35
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository {

    List<User> getUsers();

    void addUser(User user);

    User getUser(String userId);

    User getUser(String userId,String userPw);

    void updateUser(User user);

    void minusUserCyberMoney(String userId, int minusCyberMoney, Connection conn) throws SQLException;

    void plusUserCyberMoney(String userId, int minusCyberMoney, Connection conn) throws SQLException;

}
