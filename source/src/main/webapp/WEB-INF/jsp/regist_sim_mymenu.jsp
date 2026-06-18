<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

        <h2>¥5,000</h2>
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

        <div class="choice_material">

            <div class="item_material">
                <h3>パティ1</h3>
                <input type="radio" name="patty1" value="0" id="patty1_null">
                    <label for="patty1_null">なし</label>

                <input type="radio" name="patty1" value="1" id="patty1_beef">
                    <label for="patty1_beef">ビーフ</label>

                <input type="radio" name="patty1" value="2" id="patty1_chicken">
                    <label for="patty1_chicken">チキン</label>
            </div>
            <br>

            <div class="item_material">
                <h3>トッピング1</h3>
                <input type="radio" name="topping1" value="0" id="topping1_null">
                    <label for="topping1_null">なし</label>

                <input type="radio" name="topping1" value="1" id="topping1_cheese">
                    <label for="topping1_cheese">チーズ</label>

                <input type="radio" name="topping1" value="2" id="topping1_bacon">
                    <label for="topping1_bacon">ベーコン</label>

                <input type="radio" name="topping1" value="3" id="topping1_egg">
                    <label for="topping1_egg">エッグ</label>
            </div> 
            <br>
        
            <div class="item_material">
            <h3>野菜1</h3>
                <input type="radio" name="vegetable1" value="0" id="vegetable1_null">
                    <label for="vegetable1_null">なし</label>

                <input type="radio" name="vegetable1" value="1" id="vegetable1_lettuce">
                    <label for="vegetable1_lettuce">レタス</label>

                <input type="radio" name="vegetable1" value="2" id="vegetable1_tomato">
                    <label for="vegetable1_tomato">トマト</label>

                <input type="radio" name="vegetable1" value="3" id="vegetable1_onion">
                    <label for="vegetable1_onion">タマネギ</label>
            </div>
            <br>


            <div class="item_material">
                <h3>パティ2</h3>
                <input type="radio" name="patty2" value="0" id="patty2_null">
                    <label for="patty2_null">なし</label>

                <input type="radio" name="patty2" value="1" id="patty2_beef">
                    <label for="patty2_beef">ビーフ</label>

                <input type="radio" name="patty2" value="2" id="patty2_chicken">
                    <label for="patty2_chicken">チキン</label>
            </div>
            <br>

            <div class="item_material">
                <h3>トッピング2</h3>
                <input type="radio" name="topping2" value="0" id="topping2_null">
                    <label for="topping2_null">なし</label>

                <input type="radio" name="topping2" value="1" id="topping2_cheese">
                    <label for="topping2_cheese">チーズ</label>

                <input type="radio" name="topping2" value="2" id="topping2_bacon">
                    <label for="topping2_bacon">ベーコン</label>

                <input type="radio" name="topping2" value="3" id="topping2_egg">
                    <label for="topping2_egg">エッグ</label>
            </div>
            <br>

            <div class="item_material">
                <h3>野菜2</h3>
                <input type="radio" name="vegetable2" value="0" id="vegetable2_null">
                    <label for="vegetable2_null">なし</label>

                <input type="radio" name="vegetable2" value="1" id="vegetable2_lettuce">
                    <label for="vegetable2_lettuce">レタス</label>

                <input type="radio" name="vegetable2" value="2" id="vegetable2_tomato">
                    <label for="vegetable2_tomato">トマト</label>

                <input type="radio" name="vegetable2" value="3" id="vegetable2_onion">
                    <label for="vegetable2_onion">タマネギ</label>
            </div>
            <br>


            <div class="item_material">
                <h3>パティ3</h3>
                <input type="radio" name="patty3" value="0" id="patty3_null">
                    <label for="patty3_null">なし</label>

                <input type="radio" name="patty3" value="1" id="patty3_beef">
                    <label for="patty3_beef">ビーフ</label>

                <input type="radio" name="patty3" value="2" id="patty3_chicken">
                    <label for="patty3_chicken">チキン</label>
            </div>
            <br>

            <div class="item_material">
                <h3>トッピング3</h3>
                <input type="radio" name="topping3" value="0" id="topping3_null">
                    <label for="topping3_null">なし</label>

                <input type="radio" name="topping3" value="1" id="topping3_cheese">
                    <label for="topping3_cheese">チーズ</label>

                <input type="radio" name="topping3" value="2" id="topping3_bacon">
                    <label for="topping3_bacon">ベーコン</label>

                <input type="radio" name="topping3" value="3" id="topping3_egg">
                    <label for="topping3_egg">エッグ</label>
            </div>
            <br>

            <div class="item_material">
                <h3>野菜3</h3>
                <input type="radio" name="vegetable3" value="0" id="vegetable3_null">
                    <label for="vegetable3_null">なし</label>

                <input type="radio" name="vegetable3" value="1" id="vegetable3_lettuce">
                    <label for="vegetable3_lettuce">レタス</label>

                <input type="radio" name="vegetable3" value="2" id="vegetable3_tomato">
                    <label for="vegetable3_tomato">トマト</label>

                <input type="radio" name="vegetable3" value="3" id="vegetable3_onion">
                    <label for="vegetable3_onion">タマネギ</label>
            </div>
            <br>

            <br>
            <input type="submit" value="このメニューをマイメニューに追加する">
            <p></p>

            <span class="space">　</span>
        </div>

    </main>

    <footer>
        <nav>
            <ul>
                <li class="nowpage"><a href="/b1/home">
                		<img src="/b1/images/home_red.png" class="footer_icon"><br>ホーム
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

	window.addEventListener("load", stackIngredients);

	document.querySelectorAll("input[type=radio]").forEach(radio => {
	    radio.addEventListener("change", e => {

	        const id = e.target.id;  //
	        const [sectionName, ingredient] = id.split("_");

	        const section = document.querySelector(`.${sectionName}`);

	        if (ingredient === "null") {
	            // なし → セクションを空にする
	            section.innerHTML = "";
	        } else {
	            // 具材画像を挿入
	            section.innerHTML = `
	                <img src="/b1/images/hamburger/${ingredient}.png" data-type="${ingredient}">
	            `;
	        }

	        // 具材を積み直す
	        stackIngredients();
	    });
	});
		</script>

</body>
</html>
