<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <link rel="stylesheet" href="/b1/css/common.css">
    <link rel="stylesheet" href="/b1/css/mydata.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>マイデータ</title>

</head>

<body>

    <h2 style="text-align:center; color:#4a2c11;">マイデータ</h2>

    <!-- 会员ランク・ユーザー情報の表示カード -->
    <div class="card">
        <p class="mydata_text">User's Rank</p>
        <div class="rank-badge"><img src="/b1/images/gold.png" width="180px"></div>
        <p><span class="label-red">ユーザー名</span> <strong>${nameData}</strong></p>
        <button class="btn-change" onclick="location.href='${pageContext.request.contextPath}/edit_mydata'">変更</button>
    </div>

    <!-- 摂取栄養素情報の表示カード -->
    <div class="card">
        <p class="mydata_text">栄養素</p>
        <p style="color: gray; font-size: 12px;">今月の摂取量 (目安)</p>
        <p>タンパク質： <strong>${proteinData}g</strong></p>
        <p>食物繊維： <strong>${fiberData}g</strong></p>
    </div>

    <!-- ログアウトボタン（レイアウト保持用に追加） -->
    <button class="btn-logout" onclick="location.href='/b1/logout'">ログアウト</button>

    <!-- 共通フッター：グループ作成の画像ナビゲーションバー -->
    <footer>
        <nav>
            <ul>
                <li><img src="/b1/images/home.png" class="footer_icon"><br>ホーム</li>
                <li><img src="/b1/images/custom.png" class="footer_icon"><br>カスタム</li>
                <li><img src="/b1/images/contest.png" class="footer_icon"><br>コンテスト</li>
                <li><img src="/b1/images/akinator.png" class="footer_icon"><br>診断</li>
                <li class="nowpage"><img src="/b1/images/mydata_red.png" class="footer_icon"><br>マイデータ</li>
            </ul>
        </nav>
    </footer>

</body>
</html>
