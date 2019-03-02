<%@ page import="model.User.User" %>
<%@ page import="model.Repo.GetRepo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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
    </style>
</head>
<body>
<%
    GetRepo.print("homePage.jsp");
    User user = (User) request.getAttribute("user");
%>
<form action="showAllUsersCtrl" method="GET">
    <button>مشاهده تمام کاربران</button>
</form>
<form action="showAllProjects" method="GET">
    <button>مشاهده تمام پروژه ها</button>
</form>
<form action="userOwnPage.jsp" method="GET">
    <button>پروفایل</button>
</form>
<h2 style="color: blue;"><%=user.getFirstName() + " " + user.getLastName()%> خوش آمدی </h2>
</body>
</html>