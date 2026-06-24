<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新規会員登録</title>
    <!-- スタイルシートの読み込み -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/regist_user.css">
</head>
<body>

    <div class="title">FanTableへようこそ！</div>

    <!-- 💡 本地Logo图片放置处：请确认你们包里的图片名字，并把下面的 logo.png 替换掉 -->
    <div class="logo-container">
        <img src="${pageContext.request.contextPath}/images/logo.png" alt="ロゴ" class="logo-img">
    </div>

    <!-- 未入力エラーメッセージ表示エリア -->
    <div class="error-txt">${errorMessage}</div>

    <!-- 会員登録情報送信フォーム -->
    <form action="${pageContext.request.contextPath}/regist_user" method="POST">
        
        <div class="input-container">
            <!-- 占位符 placeholder 完美还原灰色提示字效果 -->
            <input type="text" name="userName" class="input-field" placeholder="ユーザー名" value="${userName}">
            <input type="text" name="phoneNumber" class="input-field" placeholder="電話番号（ハイフンなし）" value="${phoneNumber}">
            <div class="pw_wrap">
	            <input id="password" type="password" name="password" class="input-field" placeholder="パスワードを入力">
	            <button  id="pw_buttun" type="button" onclick="visible()"><img id="eye_password" src="${pageContext.request.contextPath}/images/eye_password.png" width="12" height="12"></button>
		    </div>
		    <div class="pw_wrap2">
	            <input id="password2" type="password" name="passwordConfirm" class="input-field" placeholder="パスワードを入力（確認）">
	            <button  id="pw_buttun2" type="button" onclick="visible2()"><img id="eye_password" src="${pageContext.request.contextPath}/images/eye_password.png" width="12" height="12"></button>
		    </div>
        </div>

        <!-- 同意確認チェックボックス -->
        <div class="checkbox-row">
            <input type="checkbox" name="confirmCheck" id="confirmCheck" value="yes">
            <label id="check-label" for="confirmCheck">登録内容を確認しました。</label>
        </div>

        <!-- 新規会員登録大赤按钮 -->
        <button type="submit" class="btn-submit">新規会員登録</button>
        
    </form>

   
    <!-- 底部切换登录链接 -->
        <div class="login-redirect">
    <!-- ❌ 修正前：href="${pageContext.request.contextPath}/login.jsp" -->
    <!-- ⭕ 修正后：直接找 Servlet 的路径 /login -->
    すでにアカウントをお持ちの方は、<a href="${pageContext.request.contextPath}/login">ログイン</a>
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
function visible2() {

    const password2 =
        document.getElementById("password2");

    if (password2.type === "password") {
        password2.type = "text";
    } else {
        password2.type = "password";
    }
}
</script>


</body>
</html>
