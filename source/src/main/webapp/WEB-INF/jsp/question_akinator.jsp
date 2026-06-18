<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>おすすめメニュー診断</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/question_akinator.css">
</head>
<body>

    <div class="page-title">おすすめメニュー診断</div>

    <!-- 質問メインコンテンツエリア -->
    <div class="question-container">
        <h2 class="question-title">Q.今日の気分は？</h2>
        
        <div class="options-text">
            <p>A.パティはビーフ</p>
            <p>B.パティはチキン</p>
        </div>

        <!-- 【仕様共通化】安全なコンテキストパス付きのサーブレットURLへPOST送信 -->
        <form action="${pageContext.request.contextPath}/AkinatorQuestionResultServlet" method="POST" class="btn-row">
            <button type="submit" name="answer" value="A" class="btn-opt btn-beef">A.ビーフ</button>
            <button type="submit" name="answer" value="B" class="btn-opt btn-chicken">B.チキン</button>
        </form>
    </div>

    <!-- 指定された固定形式の共通フッターナビゲーション -->
    <footer>
        <nav>
            <ul>
                <li><a href="/b1/HomeServlet"><img src="/b1/images/home.png" class="footer_icon"><br>ホーム</a></li>
                <li><a href="/b1/custom"><img src="/b1/images/custom.png" class="footer_icon"><br>カスタム</a></li>
                <li><a href="/b1/contest"><img src="/b1/images/contest.png" class="footer_icon"><br>コンテスト</a></li>
                <li class="nowpage"><a href="/b1/akinator"><img src="/b1/images/akinator_red.png" class="footer_icon"><br>診断</a></li>
                <li><a href="/b1/mydata"><img src="/b1/images/mydata.png" class="footer_icon"><br>マイデータ</a></li>
            </ul>
        </nav>
    </footer>

</body>
</html>
