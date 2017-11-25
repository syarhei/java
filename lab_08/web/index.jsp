<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 25.11.2017
  Time: 4:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="./scripts/jquery-3.2.1.js"></script>
    <style>
      .title-name {
        color: red;
        font-weight: bold;
      }
    </style>
  </head>
  <body>
    <div>
      <input type="text" title="" id="param1">
      <input type="text" title="" id="param2">
      <input type="text" title="" id="param3">

      <input type="button" onclick="requestToAaa()" value="post">
    </div>

    <div id="result-field"></div>

    <script>
      function requestToAaa() {
          $.ajax({
              url: "aaa",
              method: "post",
              data: {
                  "param1": $("#param1").val(),
                  "param2": $("#param2").val(),
                  "param3": $("#param3").val()
              },
              success: result => {
                  $("#result-field").html(result);
              },
              error: error => {
                  console.log(error);
              }
          })
      }
    </script>
  </body>
</html>
