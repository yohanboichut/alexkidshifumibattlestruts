<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: yoh
  Date: 02/04/2020
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="alexstyle.css"/>

</head>
<body>

<h1 align="center"><s:text name="accueil.titre"/></h1>
<div class="center-div">

<div style="text-align: center;">
    <img src="images/AlexKidd.jpg">
</div>
</div>
<div class="border-div">
<s:form method="POST" action="enregistrerpseudo">
    <s:textfield name="pseudo"  label="Nom"/>
    <br>
    <s:radio name="choix" list="menu" listKey="choix" listValue="libelle"/>
    <s:submit key="submit.label"/>
</s:form>
</div>
</body>
</html>
