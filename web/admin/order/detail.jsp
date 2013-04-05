<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/admin/header.jsp"%>
</head>
<body>
<div class="container">
<%@ include file="/admin/menu.jsp"%>
<br><br>
<form name=form method="post" action="/admin/order/update">
<input type="hidden" name="orderId" value="${orderId}">
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
        <th align="center">고객ID</th>
        <td align="center">${userId}</td>
    </tr>
    <tr>
        <th align="center">고객명</th>
        <td align="center">${userName}</td>
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
        <td align="center">
            <input type="radio" name="status" value="E" ${statusRadio1}>주문완료 &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="status" value="S" ${statusRadio2}>발송완료 &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="status" value="C" ${statusRadio3}>주문취소
        </td>
    </tr>
</table>
<div align=center>
    <button class="btn btn-large btn-primary" type="button" onclick="location.href='/admin/order/list'">리스트</button>
    <button class="btn btn-large btn-primary" type="submit">상태변경</button>
</div>
</form>
<%@ include file="/admin/footer.jsp"%>
</div>
</body>
</html>