<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>会員情報の変更</title>
    <!-- 共通のスタイルシートと、この画面専用のスタイルシートを読み込み -->
    <link rel="stylesheet" href="/b1/css/common.css">
    <link rel="stylesheet" href="/b1/css/edit_mydata.css">
</head>
<body>

    <div class="title">会員情報の変更</div>

    <!-- フォーム情報送信先 -->
    <form action="${pageContext.request.contextPath}/edit_mydata" method="POST">
        
        <!-- 入力エリアの白いカード -->
        <div class="form-card">
            <div class="input-row">
                <span class="label-red">ユーザー名</span>
                <input type="text" name="userName" class="input-field" value="${userName}">
            </div>
            <div class="input-row">
                <span class="label-red">電話番号</span>
                <input type="text" name="phoneNumber" class="input-field" value="${phoneNumber}">
            </div>
            <div class="input-row">
                <span class="label-red">パスワード</span>
                <input type="password" name="password" class="input-field" value="">
            </div>
            <div class="input-row">
                <span class="label-red">パスワード<br>(確認用)</span>
                <input type="password" name="passwordConf" class="input-field" value="">
            </div>
        </div>

        <!-- 未入力エラーメッセージ表示エリア -->
        <div class="error-txt">${errorMessage}</div>

        <!-- 会員情報を変更するボタン -->
        <button type="submit" class="btn-large btn-submit">会員情報を変更する</button>
        
    </form>

    <!-- 会员情報を削除するボタン -->
    <button type="button" class="btn-large btn-delete" onclick="location.href='${pageContext.request.contextPath}/delete_user'">会員情報を削除する</button>
	<br>
    <!-- 変更せずに戻るリンク -->
    <div class="back-link" onclick="location.href='${pageContext.request.contextPath}/mydata'">« 変更せずに戻る</div>

    <!-- 共通フッター（5番目のマイデータをアクティブ状態に維持） -->
    <footer>
        <nav>
            <ul>
                <li><a href="/b1/home">
                		<img src="/b1/images/home.png" class="footer_icon"><br>ホーム
                	</a></li>
                <li><a href="/b1/custom">
                		<img src="/b1/images/custom.png" class="footer_icon"><br>カスタム
                	</a></li>
                <li><a href="/b1/contest">
                		<img src="/b1/images/contest.png" class="footer_icon"><br>コンテスト
                	</a></li>
                <li><a href="/b1/akinator">
                		<img src="/b1/images/akinator.png" class="footer_icon"><br>診断
                	</a></li>
                <li class="nowpage"><a href="/b1/mydata">
                	<img src="/b1/images/mydata_red.png" class="footer_icon"><br>マイデータ
                	</a></li>
            </ul>
        </nav>
    </footer>

</body>
</html>
