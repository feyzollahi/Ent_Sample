<%@ page import="java.util.Enumeration" %>
<%@ page import="model.Order" %><%--
  Created by IntelliJ IDEA.
  User: mahdi
  Date: 6/15/19
  Time: 12:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            text-align: center;
        }
    </style>

</head>
<body>
<%  System.out.println(request.getParameter("color"));
    Enumeration<String> enumeration = request.getParameterNames();
    while(enumeration.hasMoreElements()){
        String element = enumeration.nextElement();
        request.setAttribute(element, request.getParameter(element));
    }
    Enumeration<String> enumeration2 = request.getAttributeNames();
    Order order = Order.getInstance();

    while(enumeration2.hasMoreElements()) {
        String element = enumeration2.nextElement();
        if(element.equals("color"))
            order.setColor((String)request.getAttribute("color"));
        if(element.equals("screen"))
            order.setScreenSize(Double.parseDouble((String) request.getAttribute("screen")));
        if(element.equals("ram"))
            order.setRamSize(Integer.parseInt((String) request.getAttribute("ram")));
        if(element.equals("back")) {
            order.setBackCameraResolution(Integer.parseInt(((String) request.getAttribute("back")).split("_")[1]));
            order.setNumOfCamera(Integer.parseInt(((String) request.getAttribute("back")).split("_")[0]));
        }
        System.out.println(element + " " + request.getParameter(element));
    }

%>

<form action="price.jsp">
    <h3 style="display: inline"> شارژر</h3>
    <input style="width: 25px;height: 25px; cursor: pointer" type="checkbox" name="charger"/>
    <br>
    <h3 style="display: inline"> کاور</h3>
    <input style="width: 25px;height: 25px; cursor: pointer" type="checkbox" name="cover"/>
    <br>
    <h3 style="display: inline"> ضدخش</h3>
    <input style="width: 25px;height: 25px; cursor: pointer" type="checkbox" name="antiscratch"/>
    <br>
    <h3 style="display: inline"> هدفون</h3>
    <input style="width: 25px;height: 25px; cursor: pointer" type="checkbox" name="headphone"/>
    <br>
    <h3 style="display: inline"> شاژر بیسیم</h3>
    <input style="width: 25px;height: 25px; cursor: pointer" type="checkbox" name="wirelessCharger"/>
    <br>
    <br>
    <button style="color: azure; background-color: brown; width: 150px; height: 70px; cursor: pointer; font-size: 22px">هدایت به صفحه قیمت</button>
</form>
</body>
</html>
