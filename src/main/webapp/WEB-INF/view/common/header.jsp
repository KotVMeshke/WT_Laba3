<%--
  Created by IntelliJ IDEA.
  User: nstah
  Date: 04.11.23
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="localizations.localization" var="loc"/>
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

  div.align-right a {
    color: white;
    text-decoration: none;
  }


</style>
<header>
  <div class="containerMain">
    <div class="header">
      <div class="logo">TechShop</div>

          <div class="buttons">
                <a href="${pageContext.request.contextPath}/"><fmt:message key="bar.home" bundle="${loc}"/></a>
            <security:authorize access="!isAuthenticated()">
              <a href="${pageContext.request.contextPath}/reg/signInPage"><fmt:message key="bar.sign_in" bundle="${loc}"/></a>
              <a href="${pageContext.request.contextPath}/reg/signUpPage"><fmt:message key="bar.sign_up" bundle="${loc}"/></a>
            </security:authorize>
          </div>
          <div class="buttons">
            <security:authorize access="isAuthenticated()">
              <a href="${pageContext.request.contextPath}/reg/signOut"><fmt:message key="bar.log_out" bundle="${loc}"/></a>
              <security:authorize access="hasAuthority('ADMINISTRATOR')">
                <a href="${pageContext.request.contextPath}/admin"><fmt:message key="bar.admin" bundle="${loc}"/></a>
              </security:authorize>
            </security:authorize>
            <a class="language-btn" href="${pageContext.request.contextPath}/lang">${lang}</a>
          </div>

    </div>
  </div>

</header>


<%--  <nav>--%>
<%--    <a href="${pageContext.request.contextPath}/"><fmt:message key="bar.home" bundle="${loc}"/></a>--%>
<%--    <security:authorize access="!isAuthenticated()">--%>
<%--      <a href="${pageContext.request.contextPath}/reg/signInPage"><fmt:message key="bar.sign_in" bundle="${loc}"/></a>--%>
<%--      <a href="${pageContext.request.contextPath}/reg/signUpPage"><fmt:message key="bar.sign_up" bundle="${loc}"/></a>--%>
<%--    </security:authorize>--%>
<%--    <security:authorize access="isAuthenticated()">--%>
<%--      <a href="${pageContext.request.contextPath}/reg/signOut"><fmt:message key="bar.log_out" bundle="${loc}"/></a>--%>
<%--      <security:authorize access="hasAuthority('ADMINISTRATOR')">--%>
<%--        <a href="${pageContext.request.contextPath}/admin"><fmt:message key="bar.admin" bundle="${loc}"/></a>--%>
<%--      </security:authorize>--%>
<%--    </security:authorize>--%>
<%--    <a class="language-btn" href="${pageContext.request.contextPath}/lang">${lang}</a>--%>
<%--  </nav>--%>

