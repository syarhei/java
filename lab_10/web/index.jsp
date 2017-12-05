<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 05.12.2017
  Time: 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>lab_10</title>
    <script src="scripts/jquery-3.2.1.js"></script>
  </head>
  <body>
    <div>
      <input type="text" id="id" title="" />
      <input type="text" id="name" title="" />
      <input type="button" onclick="selectFromT1()" title="" value="get" />
      <input type="button" onclick="insertToT1()" title="" value="post" />
    </div>

    <div id="result">

    </div>

    <script>
        function selectFromT1() {
            $.ajax({
                url: "/database",
                type: "GET",
                success: result => {
                    $("#result").html(result);
                },
                error: error => {
                    console.log(error);
                }
            })
        }

        function insertToT1() {
            $.ajax({
                url: "/database",
                type: "POST",
                data: {
                    id: $("#id").val(),
                    name: $("#name").val()
                },
                success: result => {
                    alert(result);
                },
                error: error => {
                    console.log(error);
                }
            })
        }
    </script>
  </body>
</html>
