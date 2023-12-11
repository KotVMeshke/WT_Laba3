<%--
  Created by IntelliJ IDEA.
  User: nstah
  Date: 20.09.23
  Time: 00:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="localizations.localization" var="loc"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp</title>
    <style>
        body {

            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            display: flex;
            flex-direction: column;
        }

        .registration-form, .login-form {
            margin-bottom: 20px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        label {
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="password"] {
            width: 94%;
            padding: 8px;
            margin-bottom: 10px;

            padding-right: -20px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>

<body>

<%--<jsp:include page="common/header.jsp"/>--%>
<div class="form-container">
    <div class="registration-form">
<form:form action="${pageContext.request.contextPath}/reg/signUp" method="post" modelAttribute="userEnt">

    <form:label path="username" for="username"><fmt:message key="form.username" bundle="${loc}"/>:</form:label>
    <form:input path="username" type="text" id="username" name="username" required="true"/>
    <form:errors path="username"/>

    <form:label path="password" for="password"><fmt:message key="form.password" bundle="${loc}"/>:</form:label>
    <form:input path="password" type="password" id="password" name="password" required="true"/>
    <form:errors path="password"/>

    <form:button type="submit"><fmt:message key="form.submitBtn" bundle="${loc}"/></form:button>
</form:form>
        </div>
</div>

</body>

</html>

