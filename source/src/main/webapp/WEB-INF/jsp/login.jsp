<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FanTable</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>


    <!-- Logo -->
    <div class="logo-container">
        <img src="${pageContext.request.contextPath}/images/logo.png" alt="ロゴ" class="logo-img">
    </div>

    <!-- 中央揃い -->
    <div class="main-content">
    
       <!-- 未入力エラーメッセージ -->
        <c:if test="${emptyError}">
        <div class="error-txt">電話番号、パスワードを入力してください。</div>
        </c:if>
        
        <!-- ログイン失敗（DB不一致） -->
    <c:if test="${loginError}">
        <div class="error-txt">電話番号またはパスワードに誤りがあります。</div>
    </c:if>
    
        <!-- 新規登録成功 -->
    <c:if test="${not empty sessionScope.result_message}">
        <div class="error-txt">${sessionScope.result_message}</div>
        <%session.removeAttribute("result_message");%>
    </c:if>

        <!-- ログインフォーム -->
        <form action="${pageContext.request.contextPath}/login" method="POST">
            <div class="input-container">
                <input type="text" name="phoneNumber" class="input-field" placeholder="電話番号" value="${phoneNumber}">
                <div class="pw_wrap">
		            <input id="password" type="password" name="password" class="input-field" placeholder="パスワード">
		            <button  id="pw_buttun" type="button" onclick="visible()"><img id="eye_password" src="${pageContext.request.contextPath}/images/eye_password.png" width="12" height="12"></button>
		        </div>
            </div>

            <!-- ログインボタン -->
            <button type="submit" class="btn-submit">ログイン</button>
        </form>

        <!-- 新規登録へのリンク -->
        <div class="register-redirect">
            アカウントをお持ちでない方は、<a href="${pageContext.request.contextPath}/regist_user">新規登録</a>
        </div>
        
    </div>
<script>
function visible() {

    const password =
        document.getElementById("password");

    if (password.type === "password") {
        password.type = "text";
    } else {
        password.type = "password";
    }
}
</script>
</body>
</html>
