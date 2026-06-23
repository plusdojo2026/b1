<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FanTable | おすすめメニュー診断</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/question_akinator.css">
</head>
<body>

<main>
    <div class="page-title">おすすめメニュー診断</div>

    <!-- 質問メインコンテンツエリア -->
    <form action="/b1/AkinatorQuestionResultServlet" method="POST"  class="question-container">
        <h2 class="question-title">Q.今日の気分は？</h2>
        <div class="question">
	        <div class="options-text">
	            <p>A.${category1}は${material11}</p>
	            <p>B.${category1}は${material12}</p>
	        </div>
	
	        <!-- 【仕様共通化】安全なコンテキストパス付きのサーブレットURLへPOST送信 -->
	        <div class="btn-row">
	        	<input type="hidden" name="category1" value="${category1}">
	            <input type="radio" name="material1" value="${material11}" id="q1_A" required>
	            	<label for="q1_A" class="btn-opt">A.${material11}</label>
	            <input id="q1_B" type="radio" name="material1" value="${material12}">
	            <label for="q1_B" class="btn-opt">B.${material12}</label>
	        </div>
        </div>
        
        <div class="question">
	        <div class="options-text">
	            <p>A.${category2}は${material21}</p>
	            <p>B.${category2}は${material22}</p>
	        </div>
	
	        <!-- 【仕様共通化】安全なコンテキストパス付きのサーブレットURLへPOST送信 -->
	        <div class="btn-row">
	        	<input type="hidden" name="category2" value="${category2}">
	            <input type="radio" name="material2" value="${material21}" id="q2_A" required>
	            	<label for="q2_A" class="btn-opt">A.${material21}</label>
	            <input id="q2_B" type="radio" name="material2" value="${material22}">
	            <label for="q2_B" class="btn-opt">B.${material22}</label>
	        </div>
        </div>
        
        <div class="question">
	        <div class="options-text">
	            <p>A.${category3}は${material31}</p>
	            <p>B.${category3}は${material32}</p>
	        </div>
	
	        <!-- 【仕様共通化】安全なコンテキストパス付きのサーブレットURLへPOST送信 -->
	        <div class="btn-row">
	        	<input type="hidden" name="category3" value="${category3}">
	            <input type="radio" name="material3" value="${material31}" id="q3_A" required>
	            	<label for="q3_A" class="btn-opt">A.${material31}</label>
	            <input id="q3_B" type="radio" name="material3" value="${material32}">
	            <label for="q3_B" class="btn-opt">B.${material32}</label>
	        </div>
        </div>
    <input type="submit" class="button" value="一致するメニューを診断する">
        
    </form>
    </main>

    <!-- 指定された固定形式の共通フッターナビゲーション -->
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
                <li class="nowpage"><a href="/b1/akinator">
                		<img src="/b1/images/akinator_red.png" class="footer_icon"><br>診断
                	</a></li>
                <li><a href="/b1/mydata">
                	<img src="/b1/images/mydata.png" class="footer_icon"><br>マイデータ
                	</a></li>
            </ul>
        </nav>
    </footer>

</body>
</html>
