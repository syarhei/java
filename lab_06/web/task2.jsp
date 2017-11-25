<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 25.11.2017
  Time: 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="./scripts/jquery-3.2.1.js"></script>
</head>
<body>
    <div>
        <select title="cbean" id="cbean">
            <option value="new">new</option>
            <option value="old">old</option>
        </select>
        <input type="text" title="" id="value-1">
        <input type="text" title="" id="value-2">
        <input type="text" title="" id="value-3">
        <input type="button" onclick="postCBean()" value="post">
        <input type="button" onclick="getCBean()" value="get">
    </div>

    <div id="result-field">

    </div>

    <script>
        function postCBean() {
            $.ajax({
                url: "ccc",
                method: "post",
                data: {
                    "cbean": $("#cbean").val(),
                    ["value-1"]: $("#value-1").val(),
                    ["value-2"]: $("#value-2").val(),
                    ["value-3"]: $("#value-3").val()
                },
                success: result => {
                    alert(result);
                },
                error: error => {
                    console.log(error);
                }
            })
        }

        function getCBean() {
            $.ajax({
                url: "ccc",
                method: "get",
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
