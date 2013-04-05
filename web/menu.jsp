<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="masthead">
    <h3 class="muted">MyMall</h3>
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container">
                <ul class="nav">
                    <li ${productMenuEffect}><a href="/product/list">상품</a></li>
                    <li ${orderMenuEffect}><a href="/order/list">주문현황</a></li>
                    <c:if test="${sessionScope.memberLogin eq null || empty sessionScope.memberLogin}">
                        <li><a href="/member/loginForm">로그인</a></li>
                    </c:if>
                    <c:if test="${!empty sessionScope.memberLogin}">
                        <li><a href="/member/logout">로그아웃</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div><!-- /.navbar -->
</div>