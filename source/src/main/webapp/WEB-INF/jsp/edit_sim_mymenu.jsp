<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dto.Mymenu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FanTable │ マイメニュー追加</title>
    <link rel="stylesheet" href="/b1/css/common.css">
    <link rel="stylesheet" href="/b1/css/sim.css">
</head>
<body>

    <header>
    </header>

<main class="mymenuregist">

        
		<div class="illustration-stage">

            <div class="burger">
                <img src="/b1/images/hamburger/buns_bottom.png" class="buns_bottom">

                <div id="stack-area">
                    <section class="patty1"></section>
                    <section class="topping1"></section>
                    <section class="vegetable1"></section>

                    <section class="patty2"></section>
                    <section class="topping2"></section>
                    <section class="vegetable2"></section>

                    <section class="patty3"></section>
                    <section class="topping3"></section>
                    <section class="vegetable3"></section>
                </div>

                <img src="/b1/images/hamburger/buns_top.png" class="buns_top">
            </div>

		</div>

        <form class="choice_material" method="post" action="/b1/mymenuedit">  
        	  
            <input type="hidden" name="bunstop" value="1">
            <input type="hidden" name="bunsbottom" value="2">

            <div class="item_material">
                <h3>パティ1</h3>
                <input type="radio" name="patty1" value="0" id="patty1_null" ${mymenu.patty1 != null && mymenu.patty1 == 0 ? 'checked' : ''}>
                    <label for="patty1_null">なし</label>

                <input type="radio" name="patty1" value="3" id="patty1_beef" ${mymenu.patty1 == 3 ? 'checked' : ''}>
                    <label for="patty1_beef">ビーフ</label>

                <input type="radio" name="patty1" value="4" id="patty1_chicken" ${mymenu.patty1 == 4 ? 'checked' : ''}>
                    <label for="patty1_chicken">チキン</label>
            </div>
            <br>

            <div class="item_material">
                <h3>トッピング1</h3>
                <input type="radio" name="topping1" value="0" id="topping1_null" ${mymenu.topping1 != null && mymenu.topping1 == 0 ? 'checked' : ''}>
                    <label for="topping1_null">なし</label>

                <input type="radio" name="topping1" value="5" id="topping1_cheese" ${mymenu.topping1 == 5 ? 'checked' : ''}>
                    <label for="topping1_cheese">チーズ</label>

                <input type="radio" name="topping1" value="6" id="topping1_bacon" ${mymenu.topping1 == 6 ? 'checked' : ''}>
                    <label for="topping1_bacon">ベーコン</label>

                <input type="radio" name="topping1" value="7" id="topping1_egg" ${mymenu.topping1 == 7 ? 'checked' : ''}>
                    <label for="topping1_egg">エッグ</label>
            </div> 
            <br>
        
            <div class="item_material">
            <h3>野菜1</h3>
                <input type="radio" name="vegetable1" value="0" id="vegetable1_null" ${mymenu.vege1 != null && mymenu.vege1 == 0 ? 'checked' : ''}>
                    <label for="vegetable1_null">なし</label>

                <input type="radio" name="vegetable1" value="8" id="vegetable1_lettuce" ${mymenu.vege1 == 8 ? 'checked' : ''}>
                    <label for="vegetable1_lettuce">レタス</label>

                <input type="radio" name="vegetable1" value="9" id="vegetable1_tomato" ${mymenu.vege1 == 9 ? 'checked' : ''}>
                    <label for="vegetable1_tomato">トマト</label>

                <input type="radio" name="vegetable1" value="10" id="vegetable1_onion" ${mymenu.vege1 == 10 ? 'checked' : ''}>
                    <label for="vegetable1_onion">タマネギ</label>
            </div>
            <br>


            <div class="item_material">
                <h3>パティ2</h3>
                <input type="radio" name="patty2" value="0" id="patty2_null" ${mymenu.patty2 != null && mymenu.patty2 == 0 ? 'checked' : ''}>
                    <label for="patty2_null">なし</label>

                <input type="radio" name="patty2" value="3" id="patty2_beef" ${mymenu.patty2 == 3 ? 'checked' : ''}>
                    <label for="patty2_beef">ビーフ</label>

                <input type="radio" name="patty2" value="4" id="patty2_chicken" ${mymenu.patty2 == 4 ? 'checked' : ''}>
                    <label for="patty2_chicken">チキン</label>
            </div>
            <br>

            <div class="item_material">
                <h3>トッピング2</h3>
                <input type="radio" name="topping2" value="0" id="topping2_null"  ${mymenu.topping2 != null && mymenu.topping2 == 0 ? 'checked' : ''}>
                    <label for="topping2_null">なし</label>

                <input type="radio" name="topping2" value="5" id="topping2_cheese" ${mymenu.topping2 == 5 ? 'checked' : ''}>
                    <label for="topping2_cheese">チーズ</label>

                <input type="radio" name="topping2" value="6" id="topping2_bacon"  ${mymenu.topping2 == 6 ? 'checked' : ''}>
                    <label for="topping2_bacon">ベーコン</label>

                <input type="radio" name="topping2" value="7" id="topping2_egg" ${mymenu.topping2 == 7 ? 'checked' : ''}>
                    <label for="topping2_egg">エッグ</label>
            </div>
            <br>

            <div class="item_material">
                <h3>野菜2</h3>
                <input type="radio" name="vegetable2" value="0" id="vegetable2_null" ${mymenu.vege2 != null && mymenu.vege2 == 0 ? 'checked' : ''}>
                    <label for="vegetable2_null">なし</label>

                <input type="radio" name="vegetable2" value="8" id="vegetable2_lettuce" ${mymenu.vege2 == 8 ? 'checked' : ''}>
                    <label for="vegetable2_lettuce">レタス</label>

                <input type="radio" name="vegetable2" value="9" id="vegetable2_tomato" ${mymenu.vege2 == 9 ? 'checked' : ''}>
                    <label for="vegetable2_tomato">トマト</label>

                <input type="radio" name="vegetable2" value="10" id="vegetable2_onion" ${mymenu.vege2 == 10 ? 'checked' : ''}>
                    <label for="vegetable2_onion">タマネギ</label>
            </div>
            <br>


            <div class="item_material">
                <h3>パティ3</h3>
                <input type="radio" name="patty3" value="0" id="patty3_null" ${mymenu.patty3 != null && mymenu.patty3 == 0 ? 'checked' : ''}>
                    <label for="patty3_null">なし</label>

                <input type="radio" name="patty3" value="3" id="patty3_beef" ${mymenu.patty3 == 3 ? 'checked' : ''}>
                    <label for="patty3_beef">ビーフ</label>

                <input type="radio" name="patty3" value="4" id="patty3_chicken" ${mymenu.patty3 == 4 ? 'checked' : ''}>
                    <label for="patty3_chicken">チキン</label>
            </div>
            <br>

            <div class="item_material">
                <h3>トッピング3</h3>
                <input type="radio" name="topping3" value="0" id="topping3_null" ${mymenu.topping3 != null && mymenu.topping3 == 0 ? 'checked' : ''}>
                    <label for="topping3_null">なし</label>

                <input type="radio" name="topping3" value="5" id="topping3_cheese" ${mymenu.topping3 == 5 ? 'checked' : ''}>
                    <label for="topping3_cheese">チーズ</label>

                <input type="radio" name="topping3" value="6" id="topping3_bacon" ${mymenu.topping3 == 6 ? 'checked' : ''}>
                    <label for="topping3_bacon">ベーコン</label>

                <input type="radio" name="topping3" value="7" id="topping3_egg" ${mymenu.topping3 == 7 ? 'checked' : ''}>
                    <label for="topping3_egg">エッグ</label>
            </div>
            <br>

            <div class="item_material">
                <h3>野菜3</h3>
                <input type="radio" name="vegetable3" value="0" id="vegetable3_null" ${mymenu.vege3 != null && mymenu.vege3 == 0 ? 'checked' : ''}>
                    <label for="vegetable3_null">なし</label>

                <input type="radio" name="vegetable3" value="8" id="vegetable3_lettuce" ${mymenu.vege3 == 8 ? 'checked' : ''}>
                    <label for="vegetable3_lettuce">レタス</label>

                <input type="radio" name="vegetable3" value="9" id="vegetable3_tomato" ${mymenu.vege3 == 9 ? 'checked' : ''}>
                    <label for="vegetable3_tomato">トマト</label>

                <input type="radio" name="vegetable3" value="10" id="vegetable3_onion" ${mymenu.vege3 == 10 ? 'checked' : ''}>
                    <label for="vegetable3_onion">タマネギ</label>
            </div>
            <br>
            
			<div class="item_material">
                <h3>ソース</h3>
                <input type="radio" name="sauce" value="11" id="sauce_BBQ"  ${mymenu.sauce == 11 ? 'checked' : ''}>
                    <label for="sauce_BBQ">BBQ</label>

                <input type="radio" name="sauce" value="12" id="sauce_salsa"  ${mymenu.sauce == 12 ? 'checked' : ''}>
                    <label for="sauce_salsa">サルサ</label>

                <input type="radio" name="sauce" value="13" id="sauce_mustard"  ${mymenu.sauce == 13 ? 'checked' : ''}>
                    <label for="sauce_mustard">マスタード</label>
            </div>
            <br>
            <div>
            	<input type="hidden" name="price" value="${mymenu.price}">
            </div>

            <h3>メニュー名</h3>
            <input type="hidden" name="id" value="${mymenu.id}">
            <input type="text" name="name" value="${mymenu.name}">

            <input type="submit" value="マイメニューを更新する">
            <p></p>
            <span class="space">　</span>
        </form>

    </main>

    <footer>
        <nav>
            <ul>
                <li><a href="/b1/home">
                		<img src="/b1/images/home.png" class="footer_icon"><br>ホーム
                	</a></li>
                <li  class="nowpage"><a href="/b1/custom">
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
	function stackIngredients() {
	    const thickness = {
	        chicken: 24,
	        beef: 18,
	        cheese: 2,
	        lettuce: 17,
	        egg: 14,
	        onion: 17,
	        bacon: 1,
	        tomato: 18
	    };

	    const offset = {
	        lettuce: 15,
	        cheese: -8,
	        bacon: -13
	    };

	    const bottom = document.querySelector(".buns_bottom");
	    const ingredients = Array.from(document.querySelectorAll("#stack-area img"));
	    const top = document.querySelector(".buns_top");

	    let currentBottom = bottom.offsetHeight - 20;

	    ingredients.forEach((img, index) => {
	        const type = img.dataset.type;
	        const thick = thickness[type] || 15;
	        const visualOffset = offset[type] || 20;

	        img.style.position = "absolute";
	        img.style.bottom = (currentBottom + visualOffset) + "px";
	        img.style.left = "0";
	        img.style.zIndex = 50 + index;

	        currentBottom += Math.max(thick, 1);
	    });

	    top.style.position = "absolute";
	    top.style.bottom = (currentBottom + 20) + "px";
	    top.style.left = "0";
	}

	
	
	window.addEventListener("load", () => {
	    document.querySelectorAll("input[type=radio]:checked").forEach(radio => {
	        const id = radio.id;
	        const [sectionName, ingredient] = id.split("_");

	        const section = document.querySelector("." + sectionName);

	        if (!section) return;

	        if (ingredient === "null") {
	            section.innerHTML = "";
	        } else {
	            section.innerHTML =
	                '<img src="/b1/images/hamburger/' + ingredient + '.png" data-type="' + ingredient + '">';
	        }
	    });

	    // ★ここが重要：2回待つ
	    requestAnimationFrame(() => {
	        requestAnimationFrame(() => {
	            stackIngredients();
	        });
	    });
	});


	document.querySelectorAll("input[type=radio]").forEach(radio => {
	    radio.addEventListener("change", e => {

	        const id = e.target.id;  //
	        const [sectionName, ingredient] = id.split("_");
	        
	        console.log("id:", id);
	        console.log("sectionName:", sectionName);
	        console.log("ingredient:", ingredient);

	        const section = document.querySelector(`.\${sectionName}`);

	        if (ingredient === "null") {
	            section.innerHTML = "";
	        } else {
	            section.innerHTML = `
	                <img src="/b1/images/hamburger/\${ingredient}.png" data-type="\${ingredient}">
	            `;
	        }


	        // 具材を積み直す
	        stackIngredients();
	    });
	});
	
		</script>

</body>
</html>