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

<main>
    <h1>マイデータ</h1>

    <!-- 会员ランク・ユーザー情報の表示カード -->
    <div class="card">
        <p class="mydata_text">User's Rank</p>
        
       <div class="rank-badge">
    <%
        // 1. 从 request 域获取 Servlet 传过来的字符串
        String rankData = (String) request.getAttribute("rankData");
        
        // 2. 严密的防空指针判定：如果为 null，默认给个 Standard 或者空字符串，防止 500 报错
        if (rankData == null) {
            rankData = "Standard";
        }
        
        // 3. 修正拼写：全部统一使用 rankData，绝对不再报错
        if ("Bronze".equals(rankData)) {
    %>
            <img src="/b1/images/bronze.png" width="150px" alt="Bronze Rank">
    <%
        } else if ("Silver".equals(rankData)) {
    %>
            <img src="/b1/images/silver.png" width="150px" alt="Silver Rank">
    <%
        } else if ("Gold".equals(rankData)) {
    %>
            <img src="/b1/images/gold.png" width="150px" alt="Gold Rank">
    <%
        } else {
    %>
            <span style="font-weight: bold; color: #aaa;">Standard</span>
    <%
        }
    %>
</div>


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
    <button class="btn-logout" onclick="logoutConfirm()">ログアウト</button>

</main>
    <!-- 共通フッター：グループ作成の画像ナビゲーションバー -->
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
<script>
function logoutConfirm() {
    if (confirm("ログアウトしますか？")) {
        location.href = "/b1/logout";
    }
}
</script>
</body>
</html>
