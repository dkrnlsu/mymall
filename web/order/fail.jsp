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
    <div align="center">주문 중 오류가 발생했습니다.<br><br>다시 주문해 주세요.</div>
    <%@ include file="/footer.jsp"%>
</div>
</body>
</html>
