<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp"%>
</head>
<body>
<style type="text/css">
    body {
        background-color: #f5f5f5;
    }
    .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
        -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
        box-shadow: 0 1px 2px rgba(0,0,0,.05);
    }
    .form-signin .form-signin-heading,
    .form-signin .checkbox {
        margin-bottom: 10px;
    }
    .form-signin input[type="text"],
    .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
    }

</style>
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
<div class="container">
    <%@ include file="/menu.jsp"%>
    <br><br>
        <form class="form-signin" name=form method="post" action="/member/login" onsubmit="return checkText(this)">
            <h2 class="form-signin-heading">Please sign in</h2>
            <input type="text" class="input-block-level" name="id" placeholder="ID" value="${idSave}">
            <input type="password" class="input-block-level" name="password" placeholder="Password">
            <label class="checkbox">
            <input type="checkbox" name="idsave" checked> ID 저장
            </label>
            <button class="btn btn-large btn-primary" type="submit">로그인</button> <button class="btn btn-large btn-primary" type="button" onclick="location.href='/member/memberForm'">회원가입</button>
        </form>
    </div>
<%@ include file="/footer.jsp"%>
</body>
</html>