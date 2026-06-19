<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FanTable | おすすめメニュー診断結果</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/result_akinator.css">
</head>
<body>

<main>
    <div class="page-title">おすすめメニュー診断</div>

    <!-- 診断結果表示コンテナ -->
    <div class="result-container">
        <p class="result-hint">あなたにおすすめのバーガーは...</p>

        <!-- 結果表示用の白い角丸大型カード -->
        <div class="result-card">
            <div class="burger-img-box">
                <!-- サーブレットから動的に渡された画像を表示、未定義時はグレー背景 -->
                <img src="${pageContext.request.contextPath}/images/${burgerImage}" alt="ハンバーガー" class="burger-img">
            </div>
            <!-- 動的に変化するおすすめバーガー名（赤太文字） -->
            <h2 class="burger-title">${burgerName}</h2>
        </div>

        <!-- もう一度診断するボタン（クリックで全小写の診断トップへ再ジャンプ） -->
        <button type="button" class="button" onclick="location.href='${pageContext.request.contextPath}/akinator'">
            もう一度診断する <span class="arrow">≫</span>
        </button>
    </div>
</main>

    <!-- 指定された固定形式の共通フッターナビゲーション -->
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