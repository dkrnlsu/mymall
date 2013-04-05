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
<form name=form method="post" action="/order/cancel">
<input type="hidden" name="orderId" value="${orderId}">
<input type="hidden" name="productId" value="${productId}">
<input type="hidden" name="quantity" value="${quantity}">
<input type="hidden" name="payment" value="${payment}">
<table class="table table-bordered">
    <tr>
        <th align="center">주문번호</th>
        <td align="center">${orderId}</td>
    </tr>
    <tr>
        <th align="center">상품명</th>
        <td align="center">${productName}</td>
    </tr>
    <tr>
        <th align="center">수량</th>
        <td align="center">${quantity}</td>
    </tr>
    <tr>
        <th align="center">결제금액</th>
        <td align="center">${payment}</td>
    </tr>
    <tr>
        <th align="center">주문일</th>
        <td align="center">${createdDate}</td>
    </tr>
    <tr>
        <th align="center">수신자명</th>
        <td align="center">${toName}</td>
    </tr>
    <tr>
        <th align="center">수신자 연락처</th>
        <td align="center">${toPhone}</td>
    </tr>
    <tr>
        <th align="center">수신자 주소</th>
        <td align="center">[${toZipCode}] ${toAddr}</td>
    </tr>
    <tr>
        <th align="center">메모</th>
        <td align="center">${memo}</td>
    </tr>
    <tr>
        <th align="center">상태</th>
        <td align="center">${statusText}</td>
    </tr>
</table>
<div align=center>
    <button class="btn btn-large btn-primary" type="button" onclick="location.href='/order/list'">리스트</button>
    <c:if test="${statusText=='주문완료'}">
        <button class="btn btn-large btn-primary" type="submit">주문취소</button>
    </c:if>
</div>
</form>
<%@ include file="/footer.jsp"%>
</div>
</body>
</html>