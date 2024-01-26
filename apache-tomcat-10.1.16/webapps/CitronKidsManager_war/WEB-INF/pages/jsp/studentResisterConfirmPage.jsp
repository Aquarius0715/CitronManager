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
  <title>���k�o�^�m�F</title>
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
<article>
  <div class="content">
    <br><br>
    <h1>���k�f�[�^�o�^�m�F</h1>
    <form action="StudentResisterConfirm" method="post">
      ���k�̏��<br>
      ���k�c�����@�@�@:<input type="text" name="studentLastName" value="<%= mdl.getStudentLastName() %>" readonly>&#009;
      ���k���O���@�@�@:<input type="text" name="studentFirstName" value="<%= mdl.getStudentLastName() %>" readonly><br>
      ���k�c���J�i���@:<input type="text" name="studentLastNameKana" value="<%= mdl.getStudentLastNameKana() %>" readonly>&#009;
      ���k���O�J�i���@:<input type="text" name="studentFirstNameKana" value="<%= mdl.getStudentFirstNameKana() %>" readonly><br><br>
      ���[���A�h���X�@:<input type="email" name="emailAddress" value="<%= mdl.getMailAddress() %>" readonly><br>
      �Œ�d�b�ԍ��@�@:<input type="tel" name="telNumber" value="<%= mdl.getTelNumber() %>" readonly>&#009;
      �g�ѓd�b�ԍ��@�@:<input type="tel" name="phoneNumber" value="<%= mdl.getPhoneNumber() %>" readonly><br>
      �ً}�A���恖�@�@:<input type="tel" name="emergencyNumber" value="<%= mdl.getEmergencyCallNumber() %>" readonly>&#009;
      �ً}�A���摱����:<input type="text" name="emergencyRelationship" value="<%= mdl.getEmergencyRelationship() %>" readonly><br>
      ���k���N�������@:<input type="date" name="birthday" value="<%= mdl.getBirthday() %>" readonly><br><br>
      �ی�҂̏��<br>
      �ی�ҕc�����@�@:<input type="text" name="parentLastName" value="<%= mdl.getParentLastName() %>" readonly>&#009;
      �ی�Җ��O���@�@:<input type="text" name="parentFirstName" value="<%= mdl.getParentFirstName() %>" readonly><br>
      �ی�ҕc���J�i��:<input type="text" name="parentLastNameKana" value="<%= mdl.getParentLastNameKana() %>" readonly>&#009;
      �ی�Җ��O�J�i��:<input type="text" name="parentFirstNameKana" value="<%= mdl.getParentFirstNameKana() %>" readonly><br>
      �ی�ґ������@�@:<input type="text" name="familyRelationship" value="<%= mdl.getFamilyRelationship() %>" readonly><br><br>
      �Z�����<br>
      �X�֔ԍ����@�@�@:<input type="text" name="zipCode" value="<%= mdl.getZipCode() %>" readonly><br>
      �s���{�����@�@�@:<input type="text" name="prefecture" value="<%= mdl.getPrefecture() %>" readonly><br>
      �s�撬�����@�@�@:<input type="text" name="cityAndDistrict" value="<%= mdl.getCityAndDistrict() %>" readonly><br>
      �Ԓn���@�@�@�@�@:<input type="text" name="street" value="<%= mdl.getStreet() %>" readonly><br>
      �����ԍ��@�@�@�@:<input type="text" name="apartmentNumber" value="<%= mdl.getApartmentNumber() %>" readonly><br>
      ���̑��ڍׁ@�@�@:<input type="text" name="detail" value="<%= mdl.getDetail() %>" readonly><br>
      <input type="submit" name="resister" value="�o�^">
      <input type="submit" name="fix" value="�C��">
    </form>
  </div>
</article>
</body>
</html>
