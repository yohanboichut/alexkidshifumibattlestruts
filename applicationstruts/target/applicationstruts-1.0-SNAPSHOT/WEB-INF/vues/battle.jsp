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

<div class="border-div">
<div style="text-align: center;">
<table class="plateau">
    <tr>
        <td align="left"><span class="scoreboard"> <s:property value="pseudoJoueur1"/></span> </td>
        <td align="center"><span class="scoreboard"><s:property value="scoreJoueur1"/></span></td>
        <td align="center"><span class="scoreboard">-</span></td>
        <td align="center"><span class="scoreboard"><s:property value="scoreJoueur2"/></span></td>
        <td align="right"><span class="scoreboard"><s:property value="pseudoJoueur2"/></span>s</td>
    </tr>
    <tr>
        <td>
            <s:if test="%{choixJoueur1 == 'Pierre'}">
                <img src="images/akspierre.png">
            </s:if>
            <s:if test="%{choixJoueur1 == 'Ciseaux'}">
                <img src="images/aksciseaux.png">
            </s:if>
            <s:if test="%{choixJoueur1 == 'Feuille'}">
                <img src="images/aksfeuille.png">
            </s:if>
            <s:if test="%{choixJoueur1 == ''}">
                <img src="images/aksrien.png">
            </s:if>

        </td>
        <td   colspan="3">&nbsp;</td>
        <td align="right">
            <s:if test="%{choixJoueur2 == 'Pierre'}">
                <img src="images/jankenpierre.png">
            </s:if>
            <s:if test="%{choixJoueur2 == 'Ciseaux'}">
                <img src="images/jankenciseaux.png">
            </s:if>
            <s:if test="%{choixJoueur2 == 'Feuille'}">
                <img src="images/jankenfeuille.png">
            </s:if>
            <s:if test="%{choixJoueur2 == ''}">
                <img src="images/jankenrien.png">
            </s:if>
        </td>

    </tr>
</table>
</div>
    <div class="border-div">
        <div style="text-align: center;">
            <s:form method="POST" action="jouer">
                <s:select name="choix" list="%{choixJoueurs}" label="Faites votre choix"/>
                <br>
                <s:submit key="submit.label"/>
            </s:form>
        </div>
    </div>





</div>
</body>
</html>
