<%--
  Created by IntelliJ IDEA.
  User: ji1wxs
  Date: 2024/02/18
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }
        header {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: left;
            position: fixed;
            width: 100%;
            top: 0;
            z-index: 1000;
        }
        header h1 {
            margin: 0;
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: left;
            position: fixed;
            width: 100%;
            top: 0;
            z-index: 1000;
        }
        nav ul {
            list-style: none;
            padding: 0;
        }
        nav li {
            display: inline;
            margin-right: 20px;
        }
        nav a {
            text-decoration: none;
            color: #fff;
        }
    </style>
    <title>生徒登録</title>
    <header>
        <h1>&nbsp;CitronKidsManager</h1>
        <text>&emsp;ver 1.0.0-SNAPSHOT</text>
    </header>
</head>
<body>
<div>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }
        .sidebar {
            width: 150px;
            background-color: #333;
            color: #fff;
            position: fixed;
            height: 100%;
        }
        .sidebar ul {
            list-style: none;
            padding: 0;
        }
        .sidebar ul li {
            padding: 10px;
            text-align: center;
        }
        .sidebar ul li a {
            text-decoration: none;
            color: #fff;
            display: block;
        }
        .sidebar ul li a:hover {
            background-color: #555;
        }
        .content {
            margin-left: 250px;
            padding: 20px;
        }

        article {
            display: flex;
        }
    </style>
    <div class="sidebar">
        <ul>
            <li><a href="#">ホーム</a></li>
            <li><a href="#">授業名簿管理</a></li>
            <li><a href="#">生徒データ管理</a></li>
            <li><a href="${pageContext.request.contextPath}/StudentResister">生徒データ登録</a></li>
            <li><a href="#">やることリスト</a></li>
            <li><a href="#">月謝管理</a></li>
            <li><a href="#">配信設定</a></li>
            <li><a href="#">ユーザー設定</a></li>
        </ul>
    </div>
</div>
<article>
    <div class="content">
        <br><br>
        <h1>登録に成功しました。</h1>
        <form action="StudentResisterComplete" method="post">
            <input type="submit" name="return" value="メインメニュに戻る">
            <input type="submit" name="next" value="新規登録">
        </form>
    </div>
</article>
</body>
</html>

