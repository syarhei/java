<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Timer" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 13.10.2017
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
    <script src="scripts/jquery-3.2.1.js"></script>
    <link href="css/default.css   " rel="stylesheet" >
  </head>
  <body>

    <%
      Calendar calendar = Calendar.getInstance();
      int hour = calendar.get(Calendar.HOUR_OF_DAY);
      int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    %>

    <div id="info">
      <%= hour < 6 ? "Good night" : hour < 12 ? "Good morning" : hour < 18 ? "Good afternoon" : "Good evening" %>
    </div>

    <div id="tbl" class="table"></div>

    <div>
      <div>
        <input type="button" onclick="runJjj()" value="JJJ">
      </div>
      <div>
        <% if (hour < 6) { %>
        <%@include file="pages/night.jsp" %>
        <% } else if (hour < 12) { %>
        <jsp:include page="pages/morning.jsp" />
        <% } else if (hour < 18) { %>
        <%@include file="pages/afternoon.jsp"%>
        <% } else { %>
        <jsp:forward page="pages/evening.jsp" />
        <% } %>
      </div>
      <div id="jjj-result"></div>
    </div>

    <script>

      function runJjj() {
          $.ajax({
              type: 'GET',
              url: '/jjj',
              success: result => {
                  $("#jjj-result").html(result);
              },
              error: err => {
                  console.log(err);
              }
          })
      }

      function createTable() {
          <%
            StringBuilder htmlValue = new StringBuilder();
            String wDay = "";
            htmlValue
                .append("<div class='table-head' >")
                .append("<div class='table-cell' >").append("DAY OF WEEK").append("</div>")
                .append("<div class='table-cell' >").append("DATE").append("</div>")
                .append("</div>");

            for (int i = 0; i < 7; i++) {
              int day = 24*60*60*1000*i;

              switch (weekDay) {
                  case 1: wDay = "sunday"; break;
                  case 2: wDay = "monday"; break;
                  case 3: wDay = "tuesday"; break;
                  case 4: wDay = "wednesday"; break;
                  case 5: wDay = "thursday"; break;
                  case 6: wDay = "friday"; break;
                  case 7: wDay = "saturday"; break;
              }

              htmlValue
                .append("<div class='table-row' >")
                .append("<div class='table-cell' >").append(wDay).append("</div>")
                .append("<div class='table-cell' >").append(dateFormat.format(new Date(calendar.getTimeInMillis() + day))).append("</div>")
                .append("</div>");

              weekDay = (weekDay % 7) + 1;
            }
          %>
          $("#tbl").html("<%= htmlValue %>");
      }

      createTable();
    </script>

  </body>
</html>
