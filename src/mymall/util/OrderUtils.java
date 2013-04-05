package mymall.util;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 4
 * Time: 오후 2:04
 * To change this template use File | Settings | File Templates.
 */
public class OrderUtils {
    public String getStatusText(String status) {
        if (status.equals("C")) {
            return "주문취소";
        } else if (status.equals("S")) {
            return "발송완료";
        } else {
            return "주문완료";
        }
    }
}
