<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FanTable │コンテスト結果</title>
<link rel="stylesheet" href="/b1/css/common.css">
<link rel="stylesheet" href="/b1/css/result_contest.css">
    <link rel="stylesheet" href="/b1/css/vote_contest.css">
</head>
<body>

	<header>
		<div class="main">
			<h1>コンテスト結果</h1>
		</div>
	</header>
	<main>
	
        <div class="top_contest">
            <section class="class_contest">
            <span class="choice"><a href="/b1/usercontestview">ユーザー考案</a></span>
            <span><a href="/b1/admincontestview">店主考案　</a></span>
            </section>
        </div>

		<!-- 1位 -->
		<div class="card first">

			<div class="rank-badge">第1位</div>

			<div class="info">
				<span class="brand-icon">ア </span> バーガーマスター <span class="silver">Silver</span>
				<span class="votes">12,450票</span>
			</div>

			<div class="image"></div>

			<div class="title">トリプルチーズボム</div>

		</div>

		<!-- 2位 -->
		<div class="item">
			<div class="rank">第2位</div>
			<div class="text">
				<div class="name">アボカドベーコン</div>
				<div class="brand">
					<span class="brand-icon">ア</span> ミスターバーガー
				</div>
			</div>
		</div>

		<!-- 3位 -->
		<div class="item">
			<div class="rank">第3位</div>
			<div class="text">
				<div class="name">スパイシー・チキンサンド</div>
				<div class="brand">
					<span class="brand-icon">ア</span> キング・バーガー
				</div>
			</div>
		</div>

	</main>

	<footer>
		<nav>
			<ul>
				<li><a href="/b1/home"> <img
						src="/b1/images/home.png" class="footer_icon"><br>ホーム
				</a></li>
				<li><a href="/b1/custom"> <img src="/b1/images/custom.png"
						class="footer_icon"><br>カスタム
				</a></li>
				<li class="nowpage"><a href="/b1/contest"> <img
						src="/b1/images/contest_red.png" class="footer_icon"><br>コンテスト
				</a></li>
				<li><a href="/b1/akinator"> <img
						src="/b1/images/akinator.png" class="footer_icon"><br>診断
				</a></li>
				<li><a href="/b1/mydata"> <img src="/b1/images/mydata.png"
						class="footer_icon"><br>マイデータ
				</a></li>
			</ul>
		</nav>
	</footer>

</body>
</html>