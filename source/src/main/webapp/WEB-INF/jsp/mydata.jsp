<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>マイデータ</title>
    <style>
        body { background-color: #fcfbf4; font-family: Arial, sans-serif; padding: 20px 20px 85px 20px; margin: 0; }
        .card { background-color: white; border-radius: 20px; padding: 20px; margin-bottom: 20px; text-align: center; }
        .rank-badge { background-color: #ffff33; color: #d93333; font-weight: bold; padding: 5px 20px; border-radius: 15px; display: inline-block; }
        .label-red { background-color: #d93333; color: white; padding: 2px 5px; border-radius: 3px; }
        .btn-change { background-color: #d93333; color: white; border: none; padding: 5px 20px; border-radius: 5px; }
        .btn-logout { background-color: #3fa938; color: white; border: none; width: 100%; padding: 10px; border-radius: 5px; font-size: 16px; }
        
        /* 底部5键导航栏精简样式 */
        .bottom-nav { position: fixed; bottom: 0; left: 0; width: 100%; height: 65px; background: white; box-shadow: 0 -2px 10px rgba(0,0,0,0.1); display: flex; z-index: 999; }
        .nav-item { flex: 1; border: none; background: none; font-size: 12px; font-weight: bold; color: #7f8c8d; display: flex; flex-direction: column; justify-content: center; align-items: center; }
        .nav-item span { font-size: 20px; margin-bottom: 3px; }
        .nav-item.active { color: #d93333; } /* 第五个界面高亮红 */
    </style>
</head>
<body>

    <h2 style="text-align:center; color:#4a2c11;">マイデータ</h2>

    <!-- 用户卡片 -->
    <div class="card">
        <p>User's Rank</p>
        <div class="rank-badge">🏅 ${rankData}</div>
        <p><span class="label-red">ユーザー名</span> <strong>${nameData}</strong></p>
        <button class="btn-change" onclick="location.href='edit_mydata.jsp'">変更</button>
    </div>

    <!-- 营养素卡片 -->
    <div class="card">
        <h3>栄養素</h3>
        <p style="color: gray; font-size: 12px;">今月の摂取量 (目安)</p>
        <p>タンパク質： <strong>${proteinData}g</strong></p>
        <p>食物繊維： <strong>${fiberData}g</strong></p>
    </div>

    <button class="btn-logout" onclick="location.href='/b1/logout'">ログアウト</button>

    <!-- 底部手机五个按钮（第五个高亮红） -->
    <div class="bottom-nav">
        <button class="nav-item" onclick="location.href='/b1/home'"><span>🏠</span>ホーム</button>
        <button class="nav-item" onclick="location.href='/b1/menu'"><span>🍔</span>メニュー</button>
        <button class="nav-item" onclick="location.href='/b1/coupon'"><span>🎟️</span>クーポン</button>
        <button class="nav-item" onclick="location.href='/b1/history'"><span>📜</span>履歴</button>
        <button class="nav-item active" onclick="location.href='/b1/mydata'"><span>👤</span>マイデータ</button>
    </div>

</body>
</html>
