<%@ page import="model.EntUtil" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="model.Order" %>
<%@ page import="com.sun.org.apache.xpath.internal.operations.Or" %>
<%@ page import="dataLayer.dataMapper.OrderMapper" %><%--
  Created by IntelliJ IDEA.
  User: mahdi
  Date: 6/15/19
  Time: 12:16 PM
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
<%
    Enumeration<String> enumeration = request.getParameterNames();
    while(enumeration.hasMoreElements()) {
        String element = enumeration.nextElement();
        request.setAttribute(element, request.getParameter(element));
    }
    Enumeration<String> enumeration2 = request.getAttributeNames();
    Order order = Order.getInstance();
    while(enumeration2.hasMoreElements()) {
        String element = enumeration2.nextElement();
        if(element.equals("charger"))
            order.setCharger(true);
        if(element.equals("cover"))
            order.setCover(true);
        if(element.equals("antiscratch"))
            order.setAntiScratch(true);
        if(element.equals("headphone"))
            order.setHeadphone(true);
        if(element.equals("wirelessCharger"))
            order.setWirelessCharger(true);
        System.out.println(element + " " + request.getParameter(element));
    }
    OrderMapper orderMapper = new OrderMapper();

%>
<body>
<h1 style="background-color: brown; color: azure"><%=EntUtil.getInstatnce().getMakeYourPhone().getPriceDescription()%></h1>
</body>
</html>
