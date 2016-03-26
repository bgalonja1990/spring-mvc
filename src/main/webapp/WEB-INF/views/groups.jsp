<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>
    Add a Group
</h1>
 
<c:url var="addAction" value="/groups/add" ></c:url>
 
<form:form method="POST" action="${addAction}" modelAttribute="group">
<table>
    <c:if test="${!empty user.firstName}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="name">
                <spring:message text="Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="name" />
        </td> 
    </tr>
  
    <tr>
        <td colspan="2">
           
            <c:if test="${empty user.name}">
                <input type="submit"
                    value="<spring:message text="Add Group"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>

	<h3>Group List</h3>
<c:if test="${!empty groups}">
    <table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.id}</td>
            <td>${group.name}</td>
            <td><a href="<c:url value='/groups/remove/${group.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>