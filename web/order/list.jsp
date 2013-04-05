<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp"%>
</head>
<body>
<div class="container">
<%@ include file="/menu.jsp"%>
<br><br>
<table class="table table-bordered">
    <thead>
    <tr>
        <th align="center">주문번호</th>
        <th align="center">상품명</th>
        <th align="center">수량</th>
        <th align="center">결제금액</th>
        <th align="center">주문일</th>
        <th align="center">상태</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders}">
    <tr>
        <td align="center"><a href="/order/detail?orderId=${order.orderId}">${order.orderId}</a></td>
        <td align="center"><a href="/order/detail?orderId=${order.orderId}">${order.productName}</a></td>
        <td align="center">${order.quantity}</td>
        <td align="center">${order.payment}</td>
        <td align="center">${order.createdDate}</td>
        <td align="center">${order.status}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<%@ include file="/footer.jsp"%>
</div>
</body>
</html>