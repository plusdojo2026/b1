<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FanTable │ タイトル</title>
    <link rel="stylesheet" href="/b1/css/common.css">
    <link rel="stylesheet" href="/b1/css/view_mymenu.css">
</head>
<body>
    <header>
    <div class="view_mymenu">
        <h1>カスタム</h1>
    </div>
    </header>
	<main>		
		<button class="btn-top" onclick="location.href='/b1/servlet/MymenuRegistServlet'">
		    <b>オリジナルバーガーを追加</b>
		</button>
	    <form class="ViewMymenu" action="edit.html">
	
		    <img src="/b1/images/custom.png" class="footer_icon">
		
		    <div class="menu-right">
		
		        <input id="user_id" type="text" name="Mymenu" value="サンプルバーガー1" readonly="readonly">	
		        <div class="btn-group">
		            <input class="btn-submit" type="submit" name="submit" value="編集">
		            <input class="btn-delete" type="submit" name="delete" value="削除">
		        </div>
		
		    </div>
		
		</form>
	</main>

    <footer>
        <nav>
            <ul>
                <li class="nowpage"><img src="/b1/images/home_red.png" class="footer_icon"><br>ホーム</li>
                <li><img src="/b1/images/custom.png" class="footer_icon"><br>カスタム</li>
                <li><img src="/b1/images/contest.png" class="footer_icon"><br>コンテスト</li>
                <li><img src="/b1/images/akinator.png" class="footer_icon"><br>診断</li>
                <li><img src="/b1/images/mydata.png" class="footer_icon"><br>マイデータ</li>
            </ul>
        </nav>
    </footer>

</body>
</html>