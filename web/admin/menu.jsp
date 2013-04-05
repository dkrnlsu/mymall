<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="masthead">
    <h3 class="muted">MyMall 관리자시스템</h3>
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container">
                <ul class="nav">
                    <li ${productMenuEffect}><a href="/admin/product/list">상품관리</a></li>
                    <li ${orderMenuEffect}><a href="/admin/order/list">주문관리</a></li>
                    <li><a href="/admin/logout">로그아웃</a></li>
                </ul>
            </div>
        </div>
    </div><!-- /.navbar -->
</div>