<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 24.11.2017
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="msu" uri="custom.tag.lib.tdl" %>
<html>
  <head>
    <title>Tag Lib</title>
  </head>

  <body>
    <msu:dossier>
      <msu:name id="name-tag" value="sergei" />
      <msu:surname id="surname-tag" value="murkou" />
      <msu:sex id="sex-tag" />
      <msu:submit/>
    </msu:dossier>
  </body>

</html>
