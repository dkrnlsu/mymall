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
<form name=form method="post" action="/admin/product/delete">
<input type="hidden" name="productId" value="${productId}">
<table class="table table-bordered">
    <tr>
        <th align="center">상품이미지</th>
        <td align="center"><img src="/img/product/${productImage}"></td>
    </tr>
    <tr>
        <th align="center">상품명</th>
        <td align="center">${productName}</td>
    </tr>
    <tr>
        <th align="center">상품가격</th>
        <td align="center">${price}</td>
    </tr>
    <tr>
        <th align="center">수량</th>
        <td align="center">${quantity}</td>
    </tr>
    <tr>
        <th align="center">등록일</th>
        <td align="center">${createdDate}</td>
    </tr>
    <tr>
        <th align="center">상태</th>
        <td align="center">${status}</td>
    </tr>
</table>
<div align=center>
    <button class="btn btn-large btn-primary" type="button" onclick="location.href='/admin/product/list'">리스트</button>
    <button class="btn btn-large btn-primary" type="button" onclick="location.href='/admin/product/updateForm?productId=${productId}'">수정</button>
    <!--button class="btn btn-large btn-primary" type="submit">삭제</button-->
</div>
</form>
<%@ include file="/admin/footer.jsp"%>
</div>
</body>
</html>
