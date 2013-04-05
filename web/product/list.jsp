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
    <c:forEach var="product" items="${products}">
    <div class="row-fluid marketing">
        <div class="span3">
            <img src="/img/product/${product.productImage}">
        </div>
        <div class="span9">
            <h4>${product.productName}</h4>
            <p>가격 : ${product.price}</p>
            <button class="btn btn-small btn-primary" type="button" onclick="location.href='/order/orderForm?productId=${product.productId}'">주문하기</button>
        </div>
    </div>
    <hr>
    </c:forEach>
<br>
<%@ include file="/footer.jsp"%>
</div>
</body>
</html>