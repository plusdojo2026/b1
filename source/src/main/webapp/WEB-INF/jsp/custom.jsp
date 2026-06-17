<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FanTable │ カスタム</title>
    <link rel="stylesheet" href="/b1/css/common.css">
    <link rel="stylesheet" href="/b1/css/custom.css">
</head>
<body>
    <header>
    <div class="custom">
        <h1>カスタム</h1>
    </div>
    </header>

    <main>
    
    <button class="button" onclick="location.href='/b1/mymenuregist'">オリジナルバーガーを作る<span class="arrow">≫</span></button>
	<button class="button" onclick="location.href='/b1/mymenuview'">マイメニューを見る<span class="arrow">≫</span></button>

    </main>

    <footer>
        <nav>
            <ul>
                <li><a href="/b1/home">
                		<img src="/b1/images/home.png" class="footer_icon"><br>ホーム
                	</a></li>
                <li class="nowpage"><a href="/b1/custom">
                		<img src="/b1/images/custom_red.png" class="footer_icon"><br>カスタム
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