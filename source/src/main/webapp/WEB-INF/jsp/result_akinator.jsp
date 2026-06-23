<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FanTable | おすすめメニュー診断結果</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/result_akinator.css">
</head>
<body>

<main>
    <div class="page-title">おすすめメニュー診断</div>

    <div class="result-container">

        <p class="result-hint">あなたにおすすめのバーガーは...</p>

        <div class="result-card">

            <div class="burger">
                <img src="/b1/images/hamburger/buns_top.png" class="buns_top">

                <div class="stack-area">

                    <c:if test="${menu.vege3.id ne 0}">
                        <section class="vegetable3">
                            <img src="${menu.vege3.image}" data-type="${menu.vege3.id}">
                        </section>
                    </c:if>

                    <c:if test="${menu.top3.id ne 0}">
                        <section class="topping3">
                            <img src="${menu.top3.image}" data-type="${menu.top3.id}">
                        </section>
                    </c:if>

                    <c:if test="${menu.patty3.id ne 0}">
                        <section class="patty3">
                            <img src="${menu.patty3.image}" data-type="${menu.patty3.id}">
                        </section>
                    </c:if>

                    <c:if test="${menu.vege2.id ne 0}">
                        <section class="vegetable2">
                            <img src="${menu.vege2.image}" data-type="${menu.vege2.id}">
                        </section>
                    </c:if>

                    <c:if test="${menu.top2.id ne 0}">
                        <section class="topping2">
                            <img src="${menu.top2.image}" data-type="${menu.top2.id}">
                        </section>
                    </c:if>

                    <c:if test="${menu.patty2.id ne 0}">
                        <section class="patty2">
                            <img src="${menu.patty2.image}" data-type="${menu.patty2.id}">
                        </section>
                    </c:if>

                    <c:if test="${menu.vege1.id ne 0}">
                        <section class="vegetable1">
                            <img src="${menu.vege1.image}" data-type="${menu.vege1.id}">
                        </section>
                    </c:if>

                    <c:if test="${menu.top1.id ne 0}">
                        <section class="topping1">
                            <img src="${menu.top1.image}" data-type="${menu.top1.id}">
                        </section>
                    </c:if>

                    <c:if test="${menu.patty1.id ne 0}">
                        <section class="patty1">
                            <img src="${menu.patty1.image}" data-type="${menu.patty1.id}">
                        </section>
                    </c:if>

                </div>

                <img src="/b1/images/hamburger/buns_bottom.png" class="buns_bottom">
            </div>

            <h2 class="burger-title">${menu.name}</h2>

            <!-- <p class="burger-price">
                ￥${menu.price}
            </p>  -->

        </div>

        <button type="button"
                class="button"
                onclick="location.href='${pageContext.request.contextPath}/akinator'">
            もう一度診断する
        </button>

    </div>
</main>

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

        const bottom =
            stack.parentElement.querySelector(".buns_bottom");

        bottom.style.position = "absolute";
        bottom.style.top = currentTop + "px";

        const burger =
            stack.closest(".burger");

        burger.style.height = currentTop + "px";
    });
});
</script>

</body>
</html>