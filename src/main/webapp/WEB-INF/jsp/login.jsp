<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>景区网站管理员登录</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/css/style.css" />" >
</head>
<body>
<%--防止直接通过URL访问--%>
<c:if test="${!empty error}">
    <font color="red"><c:out value="${error}"/></font>
</c:if>

<sf:form method="POST" commandName="loginInfo"
         action="${pageContext.request.contextPath}/admin/loginCheck">
    <sf:errors path="*" element="div" cssClass="errors"/>
    <sf:label path="userName"
              cssErrorClass="error">用户名：</sf:label>
    <sf:input path="userName" cssErrorClass="error"/>
    <br/>
    <sf:label path="password"
              cssErrorClass="error">密码：</sf:label>
    <sf:input type="password"
              path="password" cssErrorClass="error"/>
    <br/>

    <input type="submit" value="登录"/>
    <input type="reset" value="重置"/>
</sf:form>

</body>
</html>
