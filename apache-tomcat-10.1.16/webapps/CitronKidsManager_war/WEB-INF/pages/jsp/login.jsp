<%@ page pageEncoding="Shift_JIS" %>
<%
    String message = "";
    if (session.getAttribute("message") != null) {
        message = (String) session.getAttribute("message");
        session.removeAttribute("message");
    }
%>
<!DOCTYPE html>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <header>
        <h1>&nbsp;CitronKidsManager</h1>
        <text>&emsp;ver 1.0.0-SNAPSHOT</text>
    </header>
    <br><br><br>
</head>
<body>
<center>
    <div class="text-align: center">
        <br>
        <form action="Login" method="post">
            ユーザー名:<input type="text" name="user"><br>
            パスワード:<input type="password" name="pass"><br>
            <input type="submit" value="ログイン">
        </form>
        <%= message %>
    </div>
</center>
</body>
</html>