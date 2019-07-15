<%@ page import="model.EntUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <style>
        table {
            text-align: center;
            margin: 0 auto;
        }

        td {
            min-width: 300px;
            margin: 5px 5px 5px 5px;
            text-align: center;
        }
        body{
            text-align: center;
        }
    </style>
</head>
<body>
<%--<%--%>
    <%--GetRepo.print("homePage.jsp");--%>
    <%--User user = (User) request.getAttribute("user");--%>
<%--%>--%>
<% EntUtil entUtil = EntUtil.getInstatnce();%>
<h1 style="color: brown"><%= entUtil.getFirstDescription()%></h1>
<%--<h2 style="color: blue;"><%=user.getFirstName() + " " + user.getLastName()%> خوش آمدی </h2>--%>
<br>
<h2><%= entUtil.getFirstQuest()%></h2>
<form action="questions.jsp" method="GET">
    <button style="width: 100px; height: 50px; background-color: brown; color: azure; font-size: 20px; display: inline; cursor: pointer;" type="submit">بله</button>
</form>
<form action="yourPhone.jsp" method="GET">
    <button style="width: 100px; height: 50px; background-color: brown; color: azure; font-size: 20px; display: inline; cursor: pointer" type="submit">خیر</button>
</form>
</body>
</html>