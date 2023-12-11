<%--
  Created by IntelliJ IDEA.
  User: nstah
  Date: 20.09.23
  Time: 01:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="localizations.localization" var="loc"/>
<html>
<head>
    <title>Admin page</title>
</head>
<jsp:include page="common/header.jsp"/>
<body>
<h1><fmt:message key="admin.prodadd.header" bundle="${loc}"/></h1>
<form action="TechStore" method="post" enctype="multipart/form-data">
    <label for="productName"><fmt:message key="admin.prodadd.label.name" bundle="${loc}"/>:</label>
    <input type="text" name="productName" id="productName" required><br>

    <label for="productPrice"><fmt:message key="admin.prodadd.label.price" bundle="${loc}"/>:</label>
    <input type="number" name="productPrice" id="productPrice" required><br>
    <input type="hidden" name="command" value="ADD_PRODUCT" />

    <label for="productCategory"><fmt:message key="admin.prodadd.label.category" bundle="${loc}" />:</label>
    <input type="text" name="productCategory" id="productCategory" required><br>

    <label for="productImage"><fmt:message key="admin.prodadd.label.image" bundle="${loc}"/>:</label>
    <input type="file" name="productImage" id ="productImage" accept="image/*" required>

    <input type="submit" value="<fmt:message key="admin.prodadd.button" bundle="${loc}"/>">
</form>

<%--<form:form action="${pageContext.request.contextPath}/reg/signIn" method="post" modelAttribute="userEnt">--%>
<h1><fmt:message key="admin.ban.header" bundle="${loc}"/></h1>
<form:form action="${pageContext.request.contextPath}/admin/ban" method="post" modelAttribute="ban">
    <form:label path="name" for="name"><fmt:message key="admin.ban.label.user" bundle="${loc}"/>:</form:label>
    <form:input path="name" type="text" id="name" name="name" required="true"/>
    <form:button type="submit"><fmt:message key="admin.ban.button" bundle="${loc}"/></form:button>
</form:form>

<h1><fmt:message key="admin.discount.header" bundle="${loc}"/></h1>
<form:form action="${pageContext.request.contextPath}/admin/discount" method="post" modelAttribute="discountItem">
    <form:label path="id" for="id"><fmt:message key="admin.discount.label.Id" bundle="${loc}"/>:</form:label>
    <form:input path="id" type="text" name="id" id="id" required="true"/><br>

    <form:label path="discount" for="discount"><fmt:message key="admin.discount.label.discount" bundle="${loc}" />:</form:label>
    <form:input path="discount" type="number" name="discount" id="discount" required="true"/><br>
    <form:button type="submit"><fmt:message key="admin.discount.button" bundle="${loc}"/></form:button>
</form:form>

<%--</form:form>--%>
<%--    <c:forEach var="user" items="${users}">--%>
<%--        <div>--%>
<%--            <p>${user.getUserLogin()}(<fmt:message key="user.role" bundle="${loc}"/>: ${user.getRole().toString()}</p>)--%>
<%--            <a href="${pageContext.request.contextPath}/admin/ban/${user.getIdUser()}"><fmt:message key="user.ban" bundle="${loc}"/></a>--%>
<%--            <a href="${pageContext.request.contextPath}/delete/${user.getIdUser()}"><fmt:message key="user.delete" bundle="${loc}"/></a>--%>
<%--            <br>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>


</body>
</html>
