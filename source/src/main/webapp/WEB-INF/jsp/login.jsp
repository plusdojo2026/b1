<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="/b1/css/common.css">
<link rel="stylesheet" href="/b1/css/login.css">
</head>
<!-- ロゴ画像 -->
<div class="top-image"></div>

<div class="bottom-content">
    
</div>

<body>
<div class="logo-area">
    <img src="/b1/images/logo.png" width="60px">
</div>

<div class="error-area">
    <span id="error_message"></span>
</div>

<div class="login-box">
    <!-- 入力欄 -->
</div>

<div class="login-box">
<form id="login_form" method="POST" action="/b1/LoginServlet">
<span id="error_message" style="color:red; display:block; width:100%; text-align:center; white-space:nowrap; margin-bottom:5px;">
          	</span>
<h2 class= "hero"></h2>
<input type="tel" name="phone" placeholder="電話番号">
<input type="password" name="pw" placeholder="パスワード">
<button type="submit" name="login">ログイン</button>

</form>
<style>


</style>
<!-- 新規登録はこちらから -->
<p id="signup-text" style="text-align:center; white-space:nowrap;">
  アカウントをお持ちでない方は<a href="/b1/servlet/UserRegistServlet" style="color:red;">新規登録</a>
</p>

</div>
</body>
<script>
let formObj = document.getElementById('login_form');
let errorMessageObj = document.getElementById('error_message');
/* [ログイン]ボタンをクリックしたときの処理 */
formObj.onsubmit = function(event) {
  if (formObj.phone.value === '' || formObj.pw.value === '') {
    errorMessageObj.textContent = '※電話番号とパスワードを入力してください！';
    event.preventDefault();
  }
};
</script>

</html>