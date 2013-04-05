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
<table class="table table-bordered">
    <thead>
    <tr>
        <th align="center">#</th>
        <th align="center">상품명</th>
        <th align="center">상품가격</th>
        <th align="center">수량</th>
        <th align="center">등록일</th>
        <th align="center">상태</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
    <tr>
        <td align="center">${product.productId}</td>
        <td align="center"><a href="/admin/product/detail?productId=${product.productId}">${product.productName}</a></td>
        <td align="center">${product.price}</td>
        <td align="center">${product.quantity}</td>
        <td align="center">${product.createdDate}</td>
        <td align="center">${product.status}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<button class="btn btn-large btn-primary" type="button" onclick="location.href='/admin/product/insertForm'">등록</button>
<%@ include file="/admin/footer.jsp"%>
</div>
</body>
</html>