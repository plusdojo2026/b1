<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <span class="choice"><a href="/b1/usercontestvote">ユーザー考案</a></span>
            <span><a href="/b1/admincontestvote">店主考案　</a></span>
            </section>
            <p>残り投票数：${vote}票</p>
        </div>
	
	
		<c:forEach var="v" items="${menus}" >
        <div class="contest_menu_item">
            <h2>${v.name}</h2>
            <p class="contest_user">${v.user_name}<img src="/b1/images/gold.png" width="60px"></p>
            <div class="burger">
                <img src="/b1/images/hamburger/buns_top.png" class="buns_top">

	                <div class="stack-area">
	                        <c:if test="${v.vege3.id ne '0'}">
	                        	<section class="vegetable3"><img src="${v.vege3.image}" data-type="${v.vege3.id}"></section>
	                        </c:if>
	                        <c:if test="${v.top3.id ne '0'}">
	                        	<section class="topping3"><img src="${v.top3.image}" data-type="${v.top3.id}"></section>
	                        </c:if>
	                        <c:if test="${v.patty3.id ne '0'}">
	                        	<section class="patty3"><img src="${v.patty3.image}" data-type="${v.patty3.id}"></section>
							</c:if>
	                        <c:if test="${v.vege2.id ne '0'}">
	                        <section class="vegetable2"><img src="${v.vege2.image}" data-type="${v.vege2.id}"></section>
	                        </c:if>
	                        <c:if test="${v.top2.id ne '0'}">
	                        <section class="topping2"><img src="${v.top2.image}" data-type="${v.top2.id}"></section>
	                        </c:if>
	                        <c:if test="${v.patty2.id ne '0'}">
	                        <section class="patty2"><img src="${v.patty2.image}" data-type="${v.patty2.id}"></section>
							</c:if>
	                        <c:if test="${v.vege1.id ne '0'}">
	                        <section class="vegetable1"><img src="${v.vege1.image}" data-type="${v.vege1.id}"></section>
	                        </c:if>
	                        <c:if test="${v.top1.id ne '0'}">
	                        <section class="topping1"><img src="${v.top1.image}" data-type="${v.top1.id}"></section>
	                        </c:if>
	                        <c:if test="${v.patty1.id ne '0'}">
	                        <section class="patty1"><img src="${v.patty1.image}" data-type="${v.patty1.id}"></section>
	                        </c:if>
	                        
	                </div>

                <img src="/b1/images/hamburger/buns_bottom.png" class="buns_bottom">
            </div>
            <form>
            <input type="hidden" value="${v.id}">
            <input type="submit" class="vote_button" value="投票する">
            </form>
        </div>
        </c:forEach>
    </main>

    <footer>
        <nav>
            <ul>
                <li><a href="/b1/home">
                		<img src="/b1/images/home.png" class="footer_icon"><br>ホーム
                	</a></li>
                <li><a href="/b1/custom">
                		<img src="/b1/images/custom.png" class="footer_icon"><br>カスタム
                	</a></li>
                <li class="nowpage"><a href="/b1/contest">
                		<img src="/b1/images/contest_red.png" class="footer_icon"><br>コンテスト
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

    <script>
	"use strict";
    const thickness = {
        3: 18,
   		4: 22,
        5: -2,
        6: -4,
        7: 12,
        8: 12,
        9: 16,
       	10: 15
    };

    window.addEventListener("load", () => {

        // すべての stack-area を処理（複数バーガー対応）
        document.querySelectorAll(".stack-area").forEach(stack => {

            const ingredients = stack.querySelectorAll("img");

            const startTop = 40;
            let currentTop = startTop;

            // 具材を積み上げる
            ingredients.forEach((img, index) => {
                const type = img.dataset.type;
                const thick = thickness[type] || 15;

                img.style.position = "absolute";
                img.style.top = currentTop + "px";
                img.style.zIndex = 500 - index;

                currentTop += thick;
            });

            // 下バンズの位置
            const bottom = stack.parentElement.querySelector(".buns_bottom");
            bottom.style.position = "absolute";
            bottom.style.top = currentTop + "px";

            // バーガー全体の高さを調整
            const burger = stack.closest(".burger");
            burger.style.height = (currentTop + 70) + "px";
        });

    });
    </script>

</body>
</html>