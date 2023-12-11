<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="localizations.localization" var="loc"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  >

<head>
    <meta charset="UTF-8">
    <title>Customer Cart</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: block;
            height: 100vh;
            background-color: #f5f5f5;
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

    </style>
</head>

<body>

<h1><fmt:message key="shoppingcart.header" bundle="${loc}"/></h1>

<c:if test="${empty sessionScope.cart}">
    <p><fmt:message key="shoppingcart.empty" bundle="${loc}"/>.</p>
</c:if>

<div class="container">
    <c:forEach var="CartItem" items="${sessionScope.cart}">
        <div class="product-box">
            <h2>${CartItem.product.getProName()}</h2>
            <img src="data:image/jpg;base64,${CartItem.product.getProImage()}" alt="" width="240" height="300"/>
            <c:choose>
                <c:when test="${CartItem.product.getProDiscount() == 0 or empty CartItem.product.getProDiscount()}">
                    <p><fmt:message key="shoppingcart.product.price" bundle="${loc}"/>: ${CartItem.product.getProPrice()}</p>
                </c:when>
                <c:otherwise>
                    <fmt:formatNumber var="roundedValue" value="${CartItem.product.getProPrice()*(100-CartItem.product.getProDiscount())/100}" pattern="#,##0.00" />

                    <p><fmt:message key="shoppingcart.product.price" bundle="${loc}"/>e: <del>${CartItem.product.getProPrice()}</del> <span style="color: red;">${roundedValue}</span></p>
                </c:otherwise>
            </c:choose>

            <p><fmt:message key="shoppingcart.label.category" bundle="${loc}"/>: ${CartItem.product.getProCat()}</p>
            <p><fmt:message key="shoppingcart.label.amount" bundle="${loc}" />: ${CartItem.amount}</p>


<%--            <form action="TechStore" method="post">--%>
<%--                <input type="hidden" name="command" value="UPDATE_CART">--%>
<%--                <input type="hidden" name="productId" value="${CartItem.product.id}">--%>

<%--                <label for="quantity"><fmt:message key="shoppingcart.label.amount" />:</label>--%>
<%--                <input type="number" id="quantity" name="quantity" value="${CartItem.amount}" min="1" required>--%>

<%--                <button type="submit">Update Quantity</button>--%>
<%--            </form>--%>

<%--            <form action="TechStore" method="post">--%>
<%--                <input type="hidden" name="command" value="REMOVE_FROM_CART">--%>
<%--                <input type="hidden" name="productId" value="${CartItem.product.id}">--%>
<%--                <button type="submit"><fmt:message key="shoppingcart.button.remove" /></button>--%>
<%--            </form>--%>
        </div>
    </c:forEach>
</div>
<c:if test="${not empty sessionScope.cart}">
    <form action="Checkout" method="post">
        <input type="hidden" name="command" value="CHECKOUT">
        <button type="submit"><fmt:message key="shoppingcart.button.order" bundle="${loc}"/></button>
    </form>
</c:if>
</body>

</html>