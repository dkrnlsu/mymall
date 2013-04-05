package mymall.util;

/**
 * Created with IntelliJ IDEA.
 * User: ojh
 * Date: 13. 4. 4
 * Time: 오후 2:04
 * To change this template use File | Settings | File Templates.
 */
public class ProductUtils {
    public String getStatusText(String status) {
        if (status.equals("1")) {
            return "판매중";
        } else {
            return "판매중지";
        }
    }
}
