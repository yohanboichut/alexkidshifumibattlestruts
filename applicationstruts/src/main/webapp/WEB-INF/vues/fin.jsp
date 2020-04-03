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

    <span class="fontcostumisee">
        <s:text name="fin.message1"/><s:property value="vainqueur"/><s:text name="fin.message2"/><s:property value="scoreJoueur1"/> - <s:property value="scoreJoueur2"/>.
        <br>
        <s:text name="fin.message3"/><s:a action="deconnexion"><s:text name="fin.message4"/></s:a>.

    </span>
</div>

</body>
</html>
