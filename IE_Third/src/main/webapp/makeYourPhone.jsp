<%@ page import="model.EntUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="model.Order" %><%--
  Created by IntelliJ IDEA.
  User: mahdi
  Date: 6/14/19
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h2, h3, h4{
            display: inline;
        }
        body{
            text-align: center;
        }
        input[type="radio"]{
            width: 20px;
            height: 20px;
        }
    </style>
    
</head>
<body>
<% EntUtil.MakeYourPhone makeYourPhone = EntUtil.getInstatnce().getMakeYourPhone();
Enumeration<String> enumeration = request.getParameterNames();
while(enumeration.hasMoreElements()){
//    System.out.println(request.getParameter(enumeration.nextElement()));
    String element = enumeration.nextElement();
    request.setAttribute(element, request.getParameter(element));
}
    Enumeration<String> enumeration2 = request.getAttributeNames();
    Order order = Order.getInstance();
    while(enumeration2.hasMoreElements()) {
        String element = enumeration2.nextElement();
        System.out.println(element + " " + request.getParameter(element));
        if(element.equals("weight"))
            order.setWeight(true);
        if(element.equals("waterProof"))
            order.setWaterProof(true);
        if(element.equals("garanti"))
            order.setGaranti(true);
        if(element.equals("goodCamera"))
            order.setGoodCamera(true);
        if(element.equals("shortEdge"))
            order.setShortEdgge(true);
        if(element.equals("smallSizeToCanBeInPacket"))
            order.setSmallSizeToCanBeInPacket(true);

    }
    %>
<form action="selphoneGoods.jsp">
    <h1><%=makeYourPhone.getHeader()%></h1>
    <br>
    <h3>رنگ گوشی</h3>
    <br>
    <h4> <%=makeYourPhone.getColor().get(0)%></h4>
    <input type="radio" name="color" value="black"/>
    <br>
    <h4> <%=makeYourPhone.getColor().get(1)%></h4>
    <input type="radio" name="color" value="white"/>
    <br>
    <h4> <%=makeYourPhone.getColor().get(2)%></h4>
    <input type="radio" name="color" value="gray"/>
    <br>
    <br>
    <h3> سایز صفحه گوشی</h3>
    <br>
    <h4><%=makeYourPhone.getScreenSize().get(0)%></h4>
    <input type="radio" name="screen" value="5.0"/>
    <br>
    <h4><%=makeYourPhone.getScreenSize().get(1)%></h4>
    <input type="radio" name="screen" value="5.5"/>
    <br>
    <h4><%=makeYourPhone.getScreenSize().get(2)%></h4>
    <input type="radio" name="screen" value="5.7"/>
    <br>
    <br>
    <h3>سایز حافظه رم</h3>
    <br>
    <h4><%=makeYourPhone.getRamSize().get(0)%></h4>
    <input type="radio" name="ram" value="4"/>
    <br>
    <h4><%=makeYourPhone.getRamSize().get(1)%></h4>
    <input type="radio" name="ram" value="6"/>
    <br>
    <h4><%=makeYourPhone.getRamSize().get(2)%></h4>
    <input type="radio" name="ram" value="8"/>
    <br>
    <br>
    <h3>رزولوشن دوربین پشت</h3>
    <br>
    <h4>  تعداد دوربین:<%=makeYourPhone.getBackCameras().get(0).getCameraNum()%> </h4>
    <h4>  رزولوشن: <%=makeYourPhone.getBackCameras().get(0).getRes()%></h4>
    <input type="radio" name="back" value="1_8"/>
    <br>
    <h4>  تعداد دوربین:<%=makeYourPhone.getBackCameras().get(1).getCameraNum()%> </h4>
    <h4>  رزولوشن: <%=makeYourPhone.getBackCameras().get(1).getRes()%></h4>
    <input type="radio" name="back" value="2_8"/>
    <br>
    <h4>  تعداد دوربین:<%=makeYourPhone.getBackCameras().get(2).getCameraNum()%> </h4>
    <h4>  رزولوشن: <%=makeYourPhone.getBackCameras().get(2).getRes()%></h4>
    <input type="radio" name="back" value="1_12"/>
    <br>
    <h4><%=makeYourPhone.getBackCameras().get(3).getCameraNum()%> تعداد دوربین: </h4>
    <h4><%=makeYourPhone.getBackCameras().get(3).getRes()%> رزولوشن: </h4>
    <input type="radio" name="back" value="2_12"/>
    <br>
    <br>
    <button type="submit" style="height: 70px; width: 150px; color: azure; background-color: brown; font-size: 21px; cursor: pointer">انتخاب لوازم همراه گوشی</button>
</form>
</body>
</html>
