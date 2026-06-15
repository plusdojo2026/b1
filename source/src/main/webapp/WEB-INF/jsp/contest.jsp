<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FanTable │ コンテスト</title>
    <link rel="stylesheet" href="/b1/css/common.css">
    <link rel="stylesheet" href="/b1/css/contest.css">
</head>
<body>

    <header>
    <div class="contest">
        <h1>コンテスト</h1>
    </div>
    </header>

    <main>
        <button class="button" onclick="location.href='/b1/servlet/ContestRegistServlet'">コンテストに応募する<span class="arrow">≫</span></button>
        <span id="space_contest">　</span>
        <button class="button" onclick="location.href='/b1/servlet/UserContestVoteServlet'">コンテストに投票する<span class="arrow">≫</span></button>
        <button class="button"onclick="location.href='/b1/servlet/UserContestViewServlet'">コンテストの結果を見る<span class="arrow">≫</span></button>
        <button class="button"onclick="location.href='/b1/servlet/JoinContestViewServlet'">コンテスト応募履歴<span class="arrow">≫</span></button>
    </main>

    <footer>
        <nav>
            <ul>
                <li><img src="/b1/images/home.png" class="footer_icon"><br>ホーム</li>
                <li><img src="/b1/images/custom.png" class="footer_icon"><br>カスタム</li>
                <li class="nowpage"><img src="/b1/images/contest_red.png" class="footer_icon"><br>コンテスト</li>
                <li><img src="/b1/images/akinator.png" class="footer_icon"><br>診断</li>
                <li><img src="/b1/images/mydata.png" class="footer_icon"><br>マイデータ</li>
            </ul>
        </nav>
    </footer>
</body>
</html>
