<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        nav {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        nav a {
            color: #fff;
            text-decoration: none;
            margin: 0 15px;
        }

        .movies-container {
            margin: 20px;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .movie-card {
            width: 250px;
            margin: 15px;
            padding: 10px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .pagination {
            text-align: center;
            margin-top: 20px;
        }


        .pagination button {
            padding: 8px 16px;
            margin: 0 5px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .pagination button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<jsp:include page="common/header.jsp"/>
<body>

<div class="movies-container">

    <!-- Movie Cards will be dynamically generated here -->


<%--    <c:forEach var="product" items="${products}">--%>
<%--        <div class="movie-card">--%>
<%--                <img src="${pageContext.request.contextPath}/images/image.jpg" alt="image"/>--%>
<%--            <a href="/movie/${Pr.getId()}">${movie.getName()}</a>--%>
<%--            <p>${movie.getShortDescription()}</p>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
    <!-- Repeat the movie card structure for other movies -->

</div>

<div class="container">
    <h1><fmt:message key="main.product.header" bundle="${loc}"/></h1>
    <c:forEach var="product" items="${products}">
        <div class="product-box">
            <h2>${product.getProName()}</h2>
            <img src="data:image/jpg;base64,${product.getProImage()}" alt="" width="240" height="300"/>
            <c:choose>
                <c:when test="${product.getProDiscount() == 0 or empty product.getProDiscount()}">
                    <p><fmt:message key="main.product.price" bundle="${loc}"/>: ${product.getProPrice()}</p>
                </c:when>
                <c:otherwise>
                    <fmt:formatNumber var="roundedValue" value="${product.getProPrice()*(100-product.getProDiscount())/100}"
                                      pattern="#,##0.00"/>
                    <p><fmt:message key="main.product.price" bundle="${loc}"/>:
                        <del>${product.getProPrice()}</del>
                        <span style="color: red;">${roundedValue}</span></p>
                </c:otherwise>
            </c:choose>


            <p><fmt:message key="main.product.category" bundle="${loc}"/>: ${product.getProCat()}</p>

<%--            <c:if test="${not empty sessionScope.UserId}">--%>
<%--                <form action="TechStore" method="post">--%>
<%--                    <input type="hidden" name="command" value="ADD_TO_CART">--%>
<%--                    <input type="hidden" name="productId" value="${product.id}">--%>
<%--                    <button type="submit"><fmt:message key="main.product.add.button"/></button>--%>
<%--                </form>--%>
<%--            </c:if>--%>
        </div>
    </c:forEach>
</div>

<div class="pagination">
    <c:if test="${page > 0}">
        <a href="${pageContext.request.contextPath}/main?page=${page-1}"><fmt:message key="main.prev" bundle="${loc}"/></a>
    </c:if>
    <c:if test="${page < maxPage}">
        <a href="${pageContext.request.contextPath}/main?page=${page+1}"><fmt:message key="main.next" bundle="${loc}"/></a>
    </c:if>
</div>

</body>

</html>

