package mymall.service;

import mymall.entity.Order;
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
public class OrderService extends DbConnect {
    UserRepository userRepository = UserDbRepository.getInstance();
    OrderRepository orderRepository = OrderDbRepository.getInstance();
    ProductRepository productRepository = ProductDbRepository.getInstance();

    public boolean order(Order order) {
        Connection conn = null;
        boolean orderFinish = true;

        try {
            conn = dbConnect();
            conn.setAutoCommit(false);

            // 고객 사이버머니 차감
            userRepository.minusUserCyberMoney(order.getUserId(), order.getPayment(), conn);
            System.out.println("사이버 머니 차감 완료");
            // 주문 테이블 저장
            orderRepository.addOrder(order, conn);
            System.out.println("주문 테이블 저장 완료");
            // 상품 재고수량 빼기
            productRepository.minusQuantity(order.getProductId(), order.getQuantity(), conn);
            System.out.println("상품 재고수량 빼기 완료");
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

