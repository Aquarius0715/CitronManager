<%@ page import="com.citronkids.citronkidsmanager.model.StudentResisterPageMdl" %>
<%@ page import="com.citronkids.citronkidsmanager.model.StudentResisterConfirmPageMdl" %><%--
  Created by IntelliJ IDEA.
  User: ji1wxs
  Date: 2024/01/22
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=Shift_JIS" language="java" %>
<%
  StudentResisterPageMdl mdl = new StudentResisterPageMdl();
  if (request.getSession().getAttribute("model") != null) {
    mdl = (StudentResisterPageMdl) request.getSession().getAttribute("model");
  }
%>
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
  <title>生徒登録確認</title>
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
    <h1>生徒データ登録確認</h1>
    <form action="StudentResisterConfirm" method="post">
      生徒の情報<br>
      生徒苗字＊　　　:<input type="text" name="studentLastName" value="<%= mdl.getStudentLastName() %>" readonly>&#009;
      生徒名前＊　　　:<input type="text" name="studentFirstName" value="<%= mdl.getStudentLastName() %>" readonly><br>
      生徒苗字カナ＊　:<input type="text" name="studentLastNameKana" value="<%= mdl.getStudentLastNameKana() %>" readonly>&#009;
      生徒名前カナ＊　:<input type="text" name="studentFirstNameKana" value="<%= mdl.getStudentFirstNameKana() %>" readonly><br><br>
      メールアドレス　:<input type="email" name="emailAddress" value="<%= mdl.getMailAddress() %>" readonly><br>
      固定電話番号　　:<input type="tel" name="telNumber" value="<%= mdl.getTelNumber() %>" readonly>&#009;
      携帯電話番号　　:<input type="tel" name="phoneNumber" value="<%= mdl.getPhoneNumber() %>" readonly><br>
      緊急連絡先＊　　:<input type="tel" name="emergencyNumber" value="<%= mdl.getEmergencyCallNumber() %>" readonly>&#009;
      緊急連絡先続柄＊:<input type="text" name="emergencyRelationship" value="<%= mdl.getEmergencyRelationship() %>" readonly><br>
      生徒生年月日＊　:<input type="date" name="birthday" value="<%= mdl.getBirthday() %>" readonly><br><br>
      保護者の情報<br>
      保護者苗字＊　　:<input type="text" name="parentLastName" value="<%= mdl.getParentLastName() %>" readonly>&#009;
      保護者名前＊　　:<input type="text" name="parentFirstName" value="<%= mdl.getParentFirstName() %>" readonly><br>
      保護者苗字カナ＊:<input type="text" name="parentLastNameKana" value="<%= mdl.getParentLastNameKana() %>" readonly>&#009;
      保護者名前カナ＊:<input type="text" name="parentFirstNameKana" value="<%= mdl.getParentFirstNameKana() %>" readonly><br>
      保護者続柄＊　　:<input type="text" name="familyRelationship" value="<%= mdl.getFamilyRelationship() %>" readonly><br><br>
      住所情報<br>
      郵便番号＊　　　:<input type="text" name="zipCode" value="<%= mdl.getZipCode() %>" readonly><br>
      都道府県＊　　　:<input type="text" name="prefecture" value="<%= mdl.getPrefecture() %>" readonly><br>
      市区町村＊　　　:<input type="text" name="cityAndDistrict" value="<%= mdl.getCityAndDistrict() %>" readonly><br>
      番地＊　　　　　:<input type="text" name="street" value="<%= mdl.getStreet() %>" readonly><br>
      部屋番号　　　　:<input type="text" name="apartmentNumber" value="<%= mdl.getApartmentNumber() %>" readonly><br>
      その他詳細　　　:<input type="text" name="detail" value="<%= mdl.getDetail() %>" readonly><br>
      <input type="submit" name="resister" value="登録">
      <input type="submit" name="fix" value="修正">
    </form>
  </div>
</article>
</body>
</html>
