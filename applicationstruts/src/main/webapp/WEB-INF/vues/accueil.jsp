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

<div style="alignment: right;margin: 0 auto;width: 600px;">
    <s:url var="langueEN" action="locale">
        <s:param name="request_locale">
            en
        </s:param>
    </s:url>
    <s:url var="langueFR" action="locale">
        <s:param name="request_locale">
        fr
        </s:param>
    </s:url>
    <s:a href="%{#langueEN}">english</s:a> / <s:a href="%{#langueFR}">français</s:a>
</div>

<h1 align="center"><s:text name="accueil.titre"/></h1>
<div class="center-div">

<div style="text-align: center;">
    <img src="images/AlexKidd.jpg">
</div>
</div>
<div class="border-div">
<s:form method="POST" action="enregistrerpseudo">
    <s:textfield name="pseudo"  key="accueil.pseudo"/>
    <br>
    <s:radio name="choix" list="menu" listKey="choix" listValue="libelle" key="accueil.choix"/>
    <s:submit key="submit.label"/>
</s:form>
</div>
</body>
</html>
