<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/admin/header.jsp"%>
</head>
<script type="text/javascript">
    function checkText(form) {
        for (var i=0; form.elements.length; i++ ) {
            if (form.elements[i].name != "") {
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
    <%@ include file="/admin/menu.jsp"%>
    <br><br>
    <form name=form method="post" action="/admin/product/update" onsubmit="return checkText(this)">
    <input type="hidden" name="productId" value="${productId}">
    <table class="table table-bordered">
        <tr>
            <th align="center">상품이미지</th>
            <td align="center"><input type="text" class="input-block-level" name="productImage" value="${productImage}"></td>
        </tr>
        <tr>
            <th align="center">상품명</th>
            <td align="center"><input type="text" class="input-block-level" name="productName" value="${productName}"></td>
        </tr>
        <tr>
            <th align="center">상품가격</th>
            <td align="center"><input type="text" class="input-block-level" name="price" value="${price}"></td>
        </tr>
        <tr>
            <th align="center">수량</th>
            <td align="center"><input type="text" class="input-block-level" name="quantity" value="${quantity}"></td>
        </tr>
        <tr>
            <th align="center">상태</th>
            <td align="center"><input type="radio" name="status" value="1" ${statusRadio1}>판매중 &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="status" value="0" ${statusRadio2}>판매중지</td>
        </tr>
    </table>
    <div align=center>
        <button class="btn btn-large btn-primary" type="submit">수정</button>
        <button class="btn btn-large btn-primary" type="button" onclick="location.href='/admin/product/list'">리스트</button>
    </div>
    </form>
    <%@ include file="/admin/footer.jsp"%>
</div>
</body>
</html>
