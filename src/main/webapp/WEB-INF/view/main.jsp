<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="localizations.localization" var="loc"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TechStore</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: block;
            height: 100vh;
            background-color: #f5f5f5;
        }

        .containerMain {
            text-align: center;
            width: 100%;
        }

        .view-cart-button, .add-to-cart-button {
            background-color: #4caf50;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 16px;
            margin-bottom: 10px;
        }

        .view-cart-button:hover, .add-to-cart-button:hover {
            background-color: #45a049;
        }

        .buttons {
            display: flex;
            justify-content: space-between;
            padding-right: 5%;
            width: 10%;
            /*border: red 2px solid;*/
            height: 100%;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            background-color: #333;
            color: white;
            width: 100%;
        }

        .logo {
            font-style: italic;
            font-size: 24px;
        }

        .signin, .signup {
            width: 90%;
            height: 90%;
            font-size: 18px; /* Set the font size according to your preference */
            margin: 10px; /* Set the margin according to your preference */
            background-color: #2f2e2e;
            color: white;
            border: none;
            border-radius: 25px; /* Add rounded corners */
            cursor: pointer;
            transition: background-color 0.3s ease; /* Add smooth transition for hover effect */
        }

        .signin:hover, .signup:hover {
            background-color: #555; /* Change background color on hover */
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: white;
            padding: 10px 0;
            text-align: center;
        }

        .container {
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 80%;
        }

        .product-box {
            border: 1px solid #ccc;
            padding: 20px;
            margin: 10px;
            width: 250px;
            text-align: center;
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .product-box h2 {
            font-size: 18px;
            margin-bottom: 10px;
        }

        .product-box img {
            margin-bottom: 10px;
            max-width: 100%;
            height: auto;
        }

        .product-box p {
            margin-bottom: 10px;
        }

        .product-box button {
            background-color: #4caf50;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 16px;
        }

        .product-box button:hover {
            background-color: #45a049;
        }

        form {
            margin-bottom: 20px;
        }

        form input[type="text"] {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-right: 10px;
        }

        form button {
            background-color: #333;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 16px;
        }

        form button:hover {
            background-color: #555;
        }

        div.align-right {
            text-align: right;
            padding: 10px;
            background-color: #333;
        }

        div.align-right a {
            color: white;
            text-decoration: none;
        }

        #language {
            margin-top: 10px;
            margin-right: 10px;
            padding: 5px;
            border-radius: 5px;
            background-color: #f2f2f2;
            border: 1px solid #ccc;
        }
        </style>
</head>
<jsp:include page="common/header.jsp"/>
<body>

<security:authorize access="isAuthenticated()">
    <a href="${pageContext.request.contextPath}/cart/cartPage"><fmt:message key="main.showcart.button" bundle="${loc}"/></a>
</security:authorize>
<div class="container">
    <h1><fmt:message key="main.product.header" bundle="${loc}"/></h1>
    <c:forEach var="product" items="${products}">
        <div class="product-box">
            <h2>${product.getProduct().getProName()}</h2>
            <img src="data:image/jpg;base64,${product.getProduct().getProImage()}" alt="" width="240" height="300"/>
            <c:choose>
                <c:when test="${product.getProduct().getProDiscount() == 0 or empty product.getProduct().getProDiscount()}">
                    <p><fmt:message key="main.product.price" bundle="${loc}"/>: ${product.getProduct().getProPrice()}</p>
                </c:when>
                <c:otherwise>
                    <fmt:formatNumber var="roundedValue" value="${product.getProduct().getProPrice()*(100-product.getProduct().getProDiscount())/100}"
                                      pattern="#,##0.00"/>
                    <p><fmt:message key="main.product.price" bundle="${loc}"/>:
                        <del>${product.getProduct().getProPrice()}</del>
                        <span style="color: red;">${roundedValue}</span></p>
                </c:otherwise>
            </c:choose>


            <p><fmt:message key="main.product.category" bundle="${loc}"/>: ${product.getCategory().getCatName()}</p>

            <security:authorize access="isAuthenticated()">
                <form:form action="${pageContext.request.contextPath}/addCart" method="post" modelAttribute="addCart">
                    <form:input path="prodId" value="${product.getProduct().getProId()}" type="hidden"/>
                    <form:button type="submit"><fmt:message key="main.product.add.button" bundle="${loc}"/></form:button>
                </form:form>
            </security:authorize>
        </div>
    </c:forEach>
</div>

</body>

</html>

