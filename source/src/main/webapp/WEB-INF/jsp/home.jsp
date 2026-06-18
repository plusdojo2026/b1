<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ホーム</title>
    <link rel="stylesheet" href="/b1/css/common.css">
    <link rel="stylesheet" href="/b1/css/home.css">
</head>
<body>

    <h1>ホーム</h1>
    
    <main>        
        <!-- リザルトメッセージエリア -->
        <div class="result-msg">ここにリザルトメッセージが出ます</div>

        <!-- ユーザー情報表示用角丸カード -->
        <div class="user-card">
            <div class="avatar-box">
                <img src="${pageContext.request.contextPath}/images/mydata.png" alt="icon">
            </div>
            <div class="user-name">ミスターバーガー</div>
            <div class="rank-badge"><img src="/b1/images/gold.png" width="70px"></div>
        </div>

        <!-- 中央の植木鉢イラストエリア -->
        <div class="levelup">
            <div class="illustration-stage">
                <img src="/b1/images/level/level5.png" class="illustration-box">
            </div>
        </div>

        <!-- おすすめメニュー診断エリア -->
        <button class="diagnostic-card"  onclick="location.href='${pageContext.request.contextPath}/akinator'">
            <div class="diag-title">おすすめメニュー診断</div>
            <div class="diag-subtitle">今の気分に合うバーガーは？</div>
            <span class="diag-btn">診断する</span>
        </button>
    </main>

    <!-- 共通フッター：画像ナビゲーションバー（1番目のホームをアクティブ表示） -->
    <footer>
        <nav>
            <ul>
                <li class="nowpage"><a href="/b1/home">
                		<img src="/b1/images/home_red.png" class="footer_icon"><br>ホーム
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
                <li><a href="/b1/mydata">
                	<img src="/b1/images/mydata.png" class="footer_icon"><br>マイデータ
                	</a></li>
            </ul>
        </nav>
    </footer>

</body>
</html>
