<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FanTable | おすすめメニュー診断</title>
    <!-- スタイルシートの読み込み（安全なcontextPath付き） -->
    <link rel="stylesheet" href="/b1/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/akinator.css">
</head>
<body>

<main>
    <div class="page-title">おすすめメニュー診断</div>

    <!-- 画面中央のメインコンテンツエリア -->
    <div class="main-content">
        
        <p class="intro-text">
            あなたの今日の気分にあった<br>
            バーガーを見つけましょう
        </p>

        <!-- おすすめメニュー診断の大赤カード -->
        <form action="${pageContext.request.contextPath}/akinator" method="POST">
            <button type="submit" class="diagnostic-card"> 
	            <div class="card-title">おすすめメニュー診断</div>
	            <div class="diag-btn">診断する</div>
            </button>
        </form>

    </div>
</main>

    <!-- 共通フッター：グループ作成の画像ナビゲーションバー（4番目の診断をアクティブ表示） -->
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
                <li class="nowpage"><a href="/b1/akinator">
                		<img src="/b1/images/akinator_red.png" class="footer_icon"><br>診断
                	</a></li>
                <li><a href="/b1/mydata">
                	<img src="/b1/images/mydata.png" class="footer_icon"><br>マイデータ
                	</a></li>
            </ul>
        </nav>
    </footer>

</body>
</html>
