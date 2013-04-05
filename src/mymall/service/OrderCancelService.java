package mymall.service;

import mymall.repository.*;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 2
 * Time: 오후 6:38
 * To change this template use File | Settings | File Templates.
 */
public class OrderCancelService extends DbConnect {
    UserRepository userRepository = UserDbRepository.getInstance();
    OrderRepository orderRepository = OrderDbRepository.getInstance();
    ProductRepository productRepository = ProductDbRepository.getInstance();

    public boolean orderCancel(int orderId, int productId, String userId, int quantity, int payment) {
        Connection conn = null;
        boolean orderFinish = true;

        try {
            conn = dbConnect();
            conn.setAutoCommit(false);

            //1. 주문취소
            orderRepository.cancelOrder(orderId, userId);

            // 상품 재고수량 더하기
            productRepository.plusQuantity(productId, quantity, conn);

            // 고객 사이버머니 더하기
            userRepository.plusUserCyberMoney(userId, payment, conn);

            conn.commit();
            System.out.println("commit 완료");

        } catch(SQLException se) {
            orderFinish = false;
            se.printStackTrace();
            if( conn != null ) {
                try {
                    conn.rollback(); //에러발생시 rollback 처리
                } catch(SQLException sqle) {}
            }
        } catch(Exception e) {
            orderFinish = false;
            e.printStackTrace();
            if( conn != null ) {
                try {
                    conn.rollback(); //에러발생시 rollback 처리
                } catch(SQLException sqle) {}
            }
        } finally {
            try {
                conn.setAutoCommit(true); //트랜잭션 처리를 기본상태로 되돌린다.
                dbClose(conn);
            } catch(SQLException se) {

            }
        }
        return orderFinish;
    }
}