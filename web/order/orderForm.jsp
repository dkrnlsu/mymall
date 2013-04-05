<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp"%>
</head>
<script type="text/javascript">
    function checkText(form) {
        if (form.price > form.cyberMoney) {
            alert("사이버머니가 부족합니다");
            return false;
        }
        for (var i=0; form.elements.length; i++ ) {
            if (form.elements[i].name != "" && form.elements[i].name != "memo") {
                if (form.elements[i].value == "" ) {
                    alert(form.elements[i].name + "을 입력하세요");
                    form.elements[i].focus();
                    return false;
                }
            }
        }
        return true;
    }
</script>
<body>
<div class="container">
    <%@ include file="/menu.jsp"%>
    <br><br>
    <form name=form method="post" action="/order/orderInsert" onsubmit="return checkText(this)">
    <input type="hidden" name="productId" value="${productId}">
    <input type="hidden" name="price" value="${price}">
    <input type="hidden" name="cyberMoney" value="${cyberMoney}">
    <table class="table table-bordered">
        <tr>
            <th align="center">상품명</th>
            <td align="center"><img src="/img/product/${productImage}"> <h4>${productName}</h4></td>
        </tr>
        <tr>
            <th align="center">주문수량</th>
            <td align="center"><input type="text" class="input-block-level" name="quantity" value="1" readonly></td>
        </tr>
        <tr>
            <th align="center">상품가격</th>
            <td align="center"><input type="text" class="input-block-level" name="payment" value="${price}" readonly> &nbsp;&nbsp;(사이버머니 : ${cyberMoney})</td>
        </tr>
        <tr>
            <th align="center">주문자</th>
            <td align="center">${userName}</td>
        </tr>
        <tr>
            <th align="center">받는사람</th>
            <td align="center"><input type="text" class="input-block-level" name="toName" value="${userName}"></td>
        </tr>
        <tr>
            <th align="center">받는사람 연락처</th>
            <td align="center"><input type="text" class="input-block-level" name="toPhone" value="${phone}"></td>
        </tr>
        <tr>
            <th align="center">받는사람 우편번호</th>
            <td align="center"><input type="text" class="input-block-level" name="toZipCode" value="${zipCode}"></td>
        </tr>
        <tr>
            <th align="center">받는사람 주소</th>
            <td align="center"><input type="text" class="input-block-level" name="toAddr" value="${addr}"></td>
        </tr>
        <tr>
            <th align="center">메모</th>
            <td align="center"><input type="text" class="input-block-level" name="memo"></td>
        </tr>
    </table>
    <div align=center>
        <button class="btn btn-large btn-primary" type="submit">주문</button>
        <button class="btn btn-large btn-primary" type="button" onclick="location.href='/product/list'">취소</button>
    </div>
    </form>
    <%@ include file="/footer.jsp"%>
</div>
</body>
</html>
