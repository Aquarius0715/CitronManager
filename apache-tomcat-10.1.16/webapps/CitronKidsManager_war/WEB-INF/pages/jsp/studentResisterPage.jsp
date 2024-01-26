<%@ page import="java.util.ArrayList" %>
<%@ page import="com.citronkids.citronkidsmanager.model.StudentResisterPageMdl" %><%--
  Created by IntelliJ IDEA.
  User: ji1wxs
  Date: 2023/12/08
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=Shift_JIS" language="java" %>
<%
    StudentResisterPageMdl mdl = new StudentResisterPageMdl();
    if (request.getSession().getAttribute("model") != null) {
        mdl = (StudentResisterPageMdl) request.getSession().getAttribute("model");
    }
    ArrayList<String> errorMessages = new ArrayList<>();
    if (request.getAttribute("errorMessages") != null) {
        errorMessages = (ArrayList<String>) request.getAttribute("errorMessages");
    }
%>

<%
    StringBuilder sb = new StringBuilder();
    for (String message : errorMessages) {
        sb.append("<font color=\"red\">");
        sb.append(message);
        sb.append("</font>");
        sb.append("</br>");
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
    <title>���k�o�^</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
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
<article>
    <div class="content">
        <br><br>
        <h1>���k�f�[�^�o�^</h1>
        <%= sb.toString() %>
        <br>
        <form action="StudentResister" method="post">
            ���k�̏��<br>
            ���k�c�����@�@�@:<input type="text" name="studentLastName" value="<%= mdl.getStudentLastName() %>">&#009;
            ���k���O���@�@�@:<input type="text" name="studentFirstName" value="<%= mdl.getStudentLastName() %>" ><br>
            ���k�c���J�i���@:<input type="text" name="studentLastNameKana" value="<%= mdl.getStudentLastNameKana() %>">&#009;
            ���k���O�J�i���@:<input type="text" name="studentFirstNameKana" value="<%= mdl.getStudentFirstNameKana() %>"><br><br>
            ���[���A�h���X�@:<input type="email" name="emailAddress" value="<%= mdl.getMailAddress() %>"><br>
            �Œ�d�b�ԍ��@�@:<input type="tel" name="telNumber" value="<%= mdl.getTelNumber() %>">&#009;
            �g�ѓd�b�ԍ��@�@:<input type="tel" name="phoneNumber" value="<%= mdl.getPhoneNumber() %>"><br>
            �ً}�A���恖�@�@:<input type="tel" name="emergencyNumber" value="<%= mdl.getEmergencyCallNumber() %>">&#009;
            �ً}�A���摱����:<input type="text" name="emergencyRelationship" value="<%= mdl.getEmergencyRelationship() %>"><br>
            ���k���N�������@:<input type="date" name="birthday" value="<%= mdl.getBirthday() %>"><br><br>
            �ی�҂̏��<br>
            �ی�ҕc�����@�@:<input type="text" name="parentLastName" value="<%= mdl.getParentLastName() %>">&#009;
            �ی�Җ��O���@�@:<input type="text" name="parentFirstName" value="<%= mdl.getParentFirstName() %>"><br>
            �ی�ҕc���J�i��:<input type="text" name="parentLastNameKana" value="<%= mdl.getParentLastNameKana() %>">&#009;
            �ی�Җ��O�J�i��:<input type="text" name="parentFirstNameKana" value="<%= mdl.getParentFirstNameKana() %>"><br>
            �ی�ґ������@�@:<input type="text" name="familyRelationship" value="<%= mdl.getFamilyRelationship() %>"><br><br>
            �Z�����<br>
            �X�֔ԍ����@�@�@:<input type="text" name="zipCode" value="<%= mdl.getZipCode() %>"><br>
            �s���{�����@�@�@:<input type="text" name="prefecture" value="<%= mdl.getPrefecture() %>"><br>
            �s�撬�����@�@�@:<input type="text" name="cityAndDistrict" value="<%= mdl.getCityAndDistrict() %>"><br>
            �Ԓn���@�@�@�@�@:<input type="text" name="street" value="<%= mdl.getStreet() %>"><br>
            �����ԍ��@�@�@�@:<input type="text" name="apartmentNumber" value="<%= mdl.getApartmentNumber() %>"><br>
            ���̑��ڍׁ@�@�@:<input type="text" name="detail" value="<%= mdl.getDetail() %>"><br>
            <input type="submit" value="�m�F">
        </form>
    </div>
</article>
</body>
</html>