<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FanTable │コンテスト応募履歴</title>

<link rel="stylesheet" href="/b1/css/common.css">
<link rel="stylesheet" href="/b1/css/result_contest.css">
<link rel="stylesheet" href="/b1/css/view_contest.css">
</head>

<body>

<header>
    <div class="main">
        <h1>コンテスト応募履歴</h1>
    </div>
</header>

<main>

<div class="container">

<c:forEach var="v" items="${contestList}">

    <div class="card">

        <form action="edit.html">

            <div class="burger">
                <img src="/b1/images/hamburger/buns_top.png" class="buns_top">

                <div class="stack-area">

                    <c:if test="${v.vege3 ne 0}">
                        <section class="vegetable3">
                            <img src="/b1/images/hamburger/${v.vege3}.png"
                                 data-type="${v.vege3}">
                        </section>
                    </c:if>

                    <c:if test="${v.topping3 ne 0}">
                        <section class="topping3">
                            <img src="/b1/images/hamburger/${v.topping3}.png"
                                 data-type="${v.topping3}">
                        </section>
                    </c:if>

                    <c:if test="${v.patty3 ne 0}">
                        <section class="patty3">
                            <img src="/b1/images/hamburger/${v.patty3}.png"
                                 data-type="${v.patty3}">
                        </section>
                    </c:if>


                    <c:if test="${v.vege2 ne 0}">
                        <section class="vegetable2">
                            <img src="/b1/images/hamburger/${v.vege2}.png"
                                 data-type="${v.vege2}">
                        </section>
                    </c:if>

                    <c:if test="${v.topping2 ne 0}">
                        <section class="topping2">
                            <img src="/b1/images/hamburger/${v.topping2}.png"
                                 data-type="${v.topping2}">
                        </section>
                    </c:if>

                    <c:if test="${v.patty2 ne 0}">
                        <section class="patty2">
                            <img src="/b1/images/hamburger/${v.patty2}.png"
                                 data-type="${v.patty2}">
                        </section>
                    </c:if>


                    <c:if test="${v.vege1 ne 0}">
                        <section class="vegetable1">
                            <img src="/b1/images/hamburger/${v.vege1}.png"
                                 data-type="${v.vege1}">
                        </section>
                    </c:if>

                    <c:if test="${v.topping1 ne 0}">
                        <section class="topping1">
                            <img src="/b1/images/hamburger/${v.topping1}.png"
                                 data-type="${v.topping1}">
                        </section>
                    </c:if>

                    <c:if test="${v.patty1 ne 0}">
                        <section class="patty1">
                            <img src="/b1/images/hamburger/${v.patty1}.png"
                                 data-type="${v.patty1}">
                        </section>
                    </c:if>

                </div>

                <img src="/b1/images/hamburger/buns_bottom.png" class="buns_bottom">
            </div>

            <div class="content">
                <h2>${v.name}</h2>
                <p>登録日：${v.created_at}</p>
                <p>得票数<!-- ：${v.voteCount} --></p>
            </div>

        </form>
    </div>

</c:forEach>

</div>

</main>

<footer>
    <nav>
        <ul>
            <li><a href="/b1/home"><img src="/b1/images/home.png" class="footer_icon"><br>ホーム</a></li>
            <li><a href="/b1/custom"><img src="/b1/images/custom.png" class="footer_icon"><br>カスタム</a></li>
            <li class="nowpage"><a href="/b1/contest"><img src="/b1/images/contest_red.png" class="footer_icon"><br>コンテスト</a></li>
            <li><a href="/b1/akinator"><img src="/b1/images/akinator.png" class="footer_icon"><br>診断</a></li>
            <li><a href="/b1/mydata"><img src="/b1/images/mydata.png" class="footer_icon"><br>マイデータ</a></li>
        </ul>
    </nav>
</footer>

<script>
"use strict";

const thickness = {
    3: 12,
    4: 16,
    5: -2,
    6: -4,
    7: 10,
    8: 9,
    9: 9,
    10: 8
};

window.addEventListener("load", () => {

    document.querySelectorAll(".stack-area").forEach(stack => {

        const ingredients = stack.querySelectorAll("img");

        let currentTop = 28;

        ingredients.forEach((img, index) => {
            const type = img.dataset.type;
            const thick = thickness[type] || 15;

            img.style.position = "absolute";
            img.style.top = currentTop + "px";
            img.style.zIndex = 500 - index;

            currentTop += thick;
        });

        const bottom = stack.parentElement.querySelector(".buns_bottom");
        bottom.style.position = "absolute";
        bottom.style.top = currentTop + "px";

        const burger = stack.closest(".burger");
        burger.style.height = currentTop + "px";
    });

});
</script>

</body>
</html>
