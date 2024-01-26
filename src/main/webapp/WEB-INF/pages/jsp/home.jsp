<%@ page pageEncoding="Shift_JIS" %>
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
    <title>���k�o�^</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
    <header>
        <h1>&nbsp;CitronKidsManager</h1>
        <text>&emsp;ver 1.0.0-SNAPSHOT</text>
    </header>
</head>
<body>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sidePanel.css">
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

        <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sidePanel.css">--%>
        <ul>
            <li><a href="#">�z�[��</a></li>
            <li><a href="#">���Ɩ���Ǘ�</a></li>
            <li><a href="#">���k�f�[�^�Ǘ�</a></li>
            <li><a href="${pageContext.request.contextPath}/StudentResister">���k�f�[�^�o�^</a></li>
            <li><a href="#">��邱�ƃ��X�g</a></li>
            <li><a href="#">���ӊǗ�</a></li>
            <li><a href="#">�z�M�ݒ�</a></li>
            <li><a href="#">���[�U�[�ݒ�</a></li>
        </ul>
    </div>
</div>
</body>
</html>