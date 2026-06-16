<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ホーム</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>

    <div class="page-title">ホーム</div>
    
    <!-- リザルトメッセージエリア -->
    <div class="result-msg">ここにリザルトメッセージが出ます</div>

    <!-- ユーザー情報表示用角丸カード -->
    <div class="user-card">
        <div class="avatar-box">
            <img src="${pageContext.request.contextPath}/images/mydata.png" alt="icon">
        </div>
        <div class="user-name">${userName}</div>
        <div class="rank-badge">🏅 ${userRank}</div>
    </div>

    <!-- 中央の植木鉢イラストエリア -->
    <div class="illustration-stage">
        <div class="illustration-box">
            ここに植木鉢の<br>イラストが来ます
        </div>
    </div>

    <!-- おすすめメニュー診断エリア -->
    <div class="diagnostic-card">
        <div class="diag-title">おすすめメニュー診断</div>
        <div class="diag-subtitle">今の気分に合うバーガーは？</div>
        <button class="diag-btn" onclick="location.href='${pageContext.request.contextPath}/akinator'">診断する</button>
    </div>

    <!-- 共通フッター：画像ナビゲーションバー（1番目のホームをアクティブ表示） -->
    <footer>
        <nav>
            <ul>
                <!-- 各ボタンを押した際に対象のServletへジャンプするよう連通済み -->
                <li class="nowpage" onclick="location.href='${pageContext.request.contextPath}/home'">
                    <img src="${pageContext.request.contextPath}/images/home_red.png" class="footer_icon"><br>ホーム
                </li>
                <li onclick="location.href='${pageContext.request.contextPath}/custom'">
                    <img src="${pageContext.request.contextPath}/images/custom.png" class="footer_icon"><br>カスタム
                </li>
                <li onclick="location.href='${pageContext.request.contextPath}/contest'">
                    <img src="${pageContext.request.contextPath}/images/contest.png" class="footer_icon"><br>コンテスト
                </li>
                <li onclick="location.href='${pageContext.request.contextPath}/akinator'">
                    <img src="${pageContext.request.contextPath}/images/akinator.png" class="footer_icon"><br>診断
                </li>
                <li onclick="location.href='${pageContext.request.contextPath}/mydata'">
                    <img src="${pageContext.request.contextPath}/images/mydata.png" class="footer_icon"><br>マイデータ
                </li>
            </ul>
        </nav>
    </footer>

</body>
</html>
