<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FanTable │ メニューコンテスト</title>
    <link rel="stylesheet" href="/b1/css/common.css">
    <link rel="stylesheet" href="/b1/css/vote_contest.css">
</head>
<body>

    <header>
    <div class="common">
        <h1>メニューコンテスト</h1>
    </div>
    </header>

    <main>
        <div class="top_contest">
            <section class="class_contest">
            <span class="choice"><a href="#">ユーザー考案</a></span>
            <span><a href="#">店主考案　</a></span>
            </section>
            <p>残り投票数：３票</p>
        </div>

        <div class="contest_menu_item">
            <h2>トリプルチーズボム</h2>
            <p class="contest_user">ミスターバーガー<img src="/b1/images/gold.png" width="60px"></p>
            <div class="burger">
                <img src="/b1/images/hamburger/buns_top.png" class="buns_top">

                <div id="stack-area">
                        <section class="vegetable3"><img src="/b1/images/hamburger/onion.png" data-type="onion"></section>
                        <section class="topping3"><img src="/b1/images/hamburger/egg.png" data-type="egg"></section>
                        <section class="patty3"><img src="/b1/images/hamburger/chicken.png" data-type="chicken"></section>

                        <section class="vegetable2"><img src="/b1/images/hamburger/tomato.png" data-type="tomato"></section>
                        <section class="topping2"><img src="/b1/images/hamburger/bacon.png" data-type="bacon"></section>
                        <section class="patty2"><img src="/b1/images/hamburger/beef.png" data-type="beef"></section>

                        <section class="vegetable1"><img src="/b1/images/hamburger/lettuce.png" data-type="lettuce"></section>
                        <section class="topping1"><img src="/b1/images/hamburger/cheese.png" data-type="cheese"></section>
                        <section class="patty1"><img src="/b1/images/hamburger/chicken.png" data-type="chicken"></section>
                </div>

                <img src="/b1/images/hamburger/buns_bottom.png" class="buns_bottom">
            </div>
            <button class="vote_button">投票する</button>
        </div>
    </main>

    <footer>
        <nav>
            <ul>
                <li><a href="/b1/HomeServlet">
                		<img src="/b1/images/home.png" class="footer_icon"><br>ホーム
                	</a></li>
                <li><a href="/b1/CustomServlet">
                		<img src="/b1/images/custom.png" class="footer_icon"><br>カスタム
                	</a></li>
                <li class="nowpage"><a href="/b1/ContestServlet">
                		<img src="/b1/images/contest_red.png" class="footer_icon"><br>コンテスト
                	</a></li>
                <li><a href="/b1/AkinatorServlet">
                		<img src="/b1/images/akinator.png" class="footer_icon"><br>診断
                	</a></li>
                <li><a href="/b1/mydata">
                	<img src="/b1/images/mydata.png" class="footer_icon"><br>マイデータ
                	</a></li>
            </ul>
        </nav>
    </footer>

    <script>
        const thickness = {
            chicken: 22,
            beef: 18,
            cheese: -2,
            lettuce: 12,
            egg: 12,
            onion: 15,
            bacon: -4,
            tomato: 16
        };

        window.addEventListener("load", () => {
            const ingredients = document.querySelectorAll("#stack-area img");

            const startTop = 40;
            let currentTop = startTop;

            ingredients.forEach((img, index) => {
                const type = img.dataset.type;
                const thick = thickness[type] || 15;

                img.style.position = "absolute";
                img.style.top = currentTop + "px";
                img.style.zIndex = 500 - index;

                currentTop += thick;
            });

            const bottom = document.querySelector(".buns_bottom");
            bottom.style.position = "absolute";
            bottom.style.top = currentTop + "px";

            const burger = document.querySelector(".burger");
            burger.style.height = (currentTop + 70) + "px"; 
        });

    </script>

</body>
</html>