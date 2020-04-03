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

<script language="JavaScript">
    function stateChange() {
        setTimeout(function () {
            var pathArray = window.location.pathname.split( "/" );
            var pathnamerebuilt="";
            for (let i=0;i<pathArray.length-1;i++) {
                pathnamerebuilt+= pathArray[i]+"/";
            }
            var url = window.location.protocol + "//" + window.location.host + pathnamerebuilt + "attendreadversaire.action";
            window.location.replace(url);
        }, 4000);
    }

    stateChange()
</script>
<body>

<h1 align="center"><s:text name="accueil.titre"/></h1>
<div class="center-div">
    <div style="text-align: center;">
        <img src="images/AlexKidd.jpg">
    </div>

</div>
<div class="border-div">
    <span class="fontcostumisee">
    Bonjour, <s:property value="pseudo"/>, voici le token à transmettre à votre invité :
        <br>
        <br>
    <span style="font-size: 11pt">
    <s:property value="token"/>
    </span>
        <br>
    <br>
    Veuillez patienter en attendant son arrivée...
    </span>
</div>
</body>
</html>
