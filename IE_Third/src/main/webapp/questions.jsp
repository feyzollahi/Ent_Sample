<%@ page import="model.EntUtil" %><%--
  Created by IntelliJ IDEA.
  User: mahdi
  Date: 6/14/19
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        .mySlides {display:none;}
        body{
            text-align: right;
            direction: rtl;
        }
    </style>
</head>
<body>
<h2>کدام یک از موارد پایین برای شما زیاد اهمیت دارد؟</h2>
<form action="makeYourPhone.jsp">
    <%  int i = 0;
        String name = "";
        for(String question: EntUtil.getInstatnce().getIfYesQuests()){
            if(i == 0)
                name = "weight";
            else if(i == 1)
                name = "waterProof";
            else if(i == 2)
                name = "garanti";
            else if(i == 3)
                name = "goodCamera";
            else if(i == 4)
                name = "shortEdge";
            else if(i == 5)
                name = "smallSizeToCanBeInPacket";
    %>
            <h3 style="display: inline"> <%=question%></h3>
            <input style="width: 25px;height: 25px; cursor: pointer" type="checkbox" name=<%=name%>/>
            <br>
        <%  i++;%>
        <%}%>
       <button style="color: azure; background-color: brown; width: 120px; height: 60px; cursor: pointer; font-size: 19px">گوشی خود را بساز</button>
</form>
<div class="w3-container">

</div>

<div class="w3-content w3-display-container">

    <div class="w3-display-container mySlides">
        <img src="https://www.techadvisor.co.uk/cmsdata/features/3473395/best-budget-phones-2018.jpg" style="width:100%">
        <div class="w3-display-bottomleft w3-large w3-container w3-padding-16 w3-black">
            French Alps
        </div>
    </div>

    <div class="w3-display-container mySlides">
        <img src="https://www.techadvisor.co.uk/cmsdata/features/3473395/honor_10_lite_review_3.jpg" style="width:100%">
        <div class="w3-display-bottomright w3-large w3-container w3-padding-16 w3-black">
            Northern Lights
        </div>
    </div>

    <div class="w3-display-container mySlides">
        <img src="img_mountains.jpg" style="width:100%">
        <div class="w3-display-topleft w3-large w3-container w3-padding-16 w3-black">
            Beautiful Mountains
        </div>
    </div>

    <div class="w3-display-container mySlides">
        <img src="img_forest.jpg" style="width:100%">
        <div class="w3-display-topright w3-large w3-container w3-padding-16 w3-black">
            The Rain Forest
        </div>
    </div>

    <div class="w3-display-container mySlides">
        <img src="img_mountains.jpg" style="width:100%">
        <div class="w3-display-middle w3-large w3-container w3-padding-16 w3-black">
            Mountains!
        </div>
    </div>

    <button class="w3-button w3-display-left w3-black" onclick="plusDivs(-1)">&#10094;</button>
    <button class="w3-button w3-display-right w3-black" onclick="plusDivs(1)">&#10095;</button>

</div>

<script>
    var slideIndex = 1;
    showDivs(slideIndex);

    function plusDivs(n) {
        showDivs(slideIndex += n);
    }

    function showDivs(n) {
        var i;
        var x = document.getElementsByClassName("mySlides");
        if (n > x.length) {slideIndex = 1}
        if (n < 1) {slideIndex = x.length}
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        x[slideIndex-1].style.display = "block";
    }
</script>


</body>
</html>
