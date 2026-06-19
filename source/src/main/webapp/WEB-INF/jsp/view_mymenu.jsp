<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FanTable │ マイメニュー</title>
    <link rel="stylesheet" href="/b1/css/common.css">
    <link rel="stylesheet" href="/b1/css/view_mymenu.css">
</head>
<body>
    <header>
    <div class="view_mymenu">
        <h1>マイメニュー一覧</h1>
    </div>
    </header>
	<main>		
		<button class="button" onclick="location.href='/b1/mymenuregist'">
		    オリジナルメニューを追加<span class="arrow">≫</span>
		</button>
		
		<div class="ViewMymenu">
		
		<c:forEach var="v" items="${menus}" >
		    <form action="edit.html">
		           <div class="burger">
	                <img src="/b1/images/hamburger/buns_top.png" class="buns_top">
	
	                <div class="stack-area">
	                        
	                        <c:if test="${v.vege3 != null}">
	                        	<section class="vegetable3"><img src="${v.vege3.image}" data-type="${v.vege3.id}"></section>
	                        </c:if>
	                        <c:if test="${v.top3 != null}">
	                        	<section class="topping3"><img src="${v.top3.image}" data-type="${v.top3.id}"></section>
	                        </c:if>
	                        <c:if test="${v.patty3 != null}">
	                        	<section class="patty3"><img src="${v.patty3.image}" data-type="${v.patty3.id}"></section>
							</c:if>
	     
	                        <c:if test="${v.vege2 != null}">
	                        <section class="vegetable2"><img src="${v.vege2.image}" data-type="${v.vege2.id}"></section>
	                        </c:if>
	                        <c:if test="${v.top2 != null}">
	                        <section class="topping2"><img src="${v.top2.image}" data-type="${v.top2.id}"></section>
	                        </c:if>
	                        <c:if test="${v.patty2 != null}">
	                        <section class="patty2"><img src="${v.patty2.image}" data-type="${v.patty2.id}"></section>
							</c:if>
	                        
	                        <c:if test="${v.vege1 != null}">
	                        <section class="vegetable1"><img src="${v.vege1.image}" data-type="${v.vege1.id}"></section>
	                        </c:if>
	                        <c:if test="${v.top1 != null}">
	                        <section class="topping1"><img src="${v.top1.image}" data-type="${v.top1.id}"></section>
	                        </c:if>
	                        <c:if test="${v.patty1 != null}">
	                        <section class="patty1"><img src="${v.patty1.image}" data-type="${v.patty1.id}"></section>
	                        </c:if>
	                </div>
	                <img src="/b1/images/hamburger/buns_bottom.png" class="buns_bottom">
	            </div>
	
			    <div class="menu-right">
			        <input id="user_id" type="hidden" name="Mymenu" value="サンプルバーガー1" readonly="readonly">	
				    <div class="menu-info">
				        <span class="name">サンプルバーガー１</span><br>
				        <span class="price">¥1,590</span>
				    </div>
			        <div class="btn-group">
			            <input class="btn-submit" type="submit" name="submit" value="編集">
			            <input class="btn-delete" type="submit" name="delete" value="削除">
			        </div>
			    </div>
			</form>
		</c:forEach>
		</div>
		
		
		
		<div class="ViewMymenu">
		    <form action="edit.html">
		           <div class="burger">
	                <img src="/b1/images/hamburger/buns_top.png" class="buns_top">
	
	                <div class="stack-area">
	                        <section class="vegetable3"><img src="/b1/images/hamburger/onion.png" data-type="onion"></section>
	                        <section class="topping3"><img src="/b1/images/hamburger/egg.png" data-type="egg"></section>
	                        <section class="patty3"><img src="/b1/images/hamburger/chicken.png" data-type="chicken"></section>
	
	                        <section class="vegetable2"><img src="/b1/images/hamburger/tomato.png" data-type="tomato"></section>
	                        <section class="topping2"><img src="/b1/images/hamburger/bacon.png" data-type="bacon"></section>
	                        <section class="patty2"><img src="/b1/images/hamburger/beef.png" data-type="beef"></section>
	                </div>
	                <img src="/b1/images/hamburger/buns_bottom.png" class="buns_bottom">
	            </div>
	
			    <div class="menu-right">
			        <input id="user_id" type="hidden" name="Mymenu" value="サンプルバーガー1" readonly="readonly">	
				    <div class="menu-info">
				        <span class="name">サンプルバーガー2</span><br>
				        <span class="price">¥980</span>
				    </div>
			        <div class="btn-group">
			            <input class="btn-submit" type="submit" name="submit" value="編集">
			            <input class="btn-delete" type="submit" name="delete" value="削除">
			        </div>
			    </div>
			</form>
		</div>
		
		
				<div class="ViewMymenu">
		    <form action="edit.html">
		           <div class="burger">
	                <img src="/b1/images/hamburger/buns_top.png" class="buns_top">
	
	                <div class="stack-area">
	                        <section class="vegetable1"><img src="/b1/images/hamburger/lettuce.png" data-type="lettuce"></section>
	                        <section class="topping1"><img src="/b1/images/hamburger/cheese.png" data-type="cheese"></section>
	                        <section class="patty1"><img src="/b1/images/hamburger/chicken.png" data-type="chicken"></section>
	                </div>
	                <img src="/b1/images/hamburger/buns_bottom.png" class="buns_bottom">
	            </div>
	
			    <div class="menu-right">
			        <input id="user_id" type="hidden" name="Mymenu" value="サンプルバーガー1" readonly="readonly">	
				    <div class="menu-info">
				        <span class="name">サンプルバーガー3</span><br>
				        <span class="price">¥590</span>
				    </div>
			        <div class="btn-group">
			            <input class="btn-submit" type="submit" name="submit" value="編集">
			            <input class="btn-delete" type="submit" name="delete" value="削除">
			        </div>
			    </div>
			</form>
		</div>
		
		
		
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

    <script>
    "use strict";
        const thickness = {
            3: 14,
            4: 18,
            5: -2,
            6: -6,
            7: 10,
            8: 9,
            9: 14,
            10: 13
        };

        window.addEventListener("load", () => {

            // すべての stack-area をループ
            document.querySelectorAll(".stack-area").forEach(stack => {

                const ingredients = stack.querySelectorAll("img");

                let currentTop = 27;

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

                // バーガー全体の高さ調整
                const burger = stack.closest(".burger");
                burger.style.height = currentTop + "px";
            });

        });

    </script>
    
</body>
</html>