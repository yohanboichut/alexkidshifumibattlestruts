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
        Fin de la partie. Le vainqueur est <s:property value="vainqueur"/> par le score de <s:property value="scoreJoueur1"/> - <s:property value="scoreJoueur2"/>.
        <br>
        Pour refaire une partie, veuillez cliquer <s:a action="deconnexion">ici</s:a>.

    </span>
</div>

</body>
</html>
