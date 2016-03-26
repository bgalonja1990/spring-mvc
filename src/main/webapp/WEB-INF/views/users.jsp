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
    Add a User
</h1>
 
<c:url var="addAction" value="/users/add" ></c:url>
 
<form:form method="POST" action="${addAction}" modelAttribute="user">
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
            <form:label path="firstName">
                <spring:message text="Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="firstName" />
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="lastName">
                <spring:message text="Last Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="lastName" />
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="groups">
                <spring:message text="Groups"/>
            </form:label>
        </td>
        <td>
            
            <form:select path="groups" multiple="true"  >
            	<form:options items="${allGroups}" itemLabel="name" itemValue="id"/>
            </form:select>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty user.lastName}">
                <input type="submit"
                    value="<spring:message text="Edit Person"/>" />
            </c:if>
            <c:if test="${empty user.lastName}">
                <input type="submit"
                    value="<spring:message text="Add Person"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>

	<h3>Persons List</h3>
<c:if test="${!empty users}">
    <table class="tg">
    <tr>
        <th width="80">User ID</th>
        <th width="120">First Name</th>
        <th width="120">Last Name</th>
        <th width="120">Groups</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>
            	<c:forEach items="${user.groups}" var="group">${group.name}&nbsp;</c:forEach>
            </td>
            <td><a href="<c:url value='/users/edit/${user.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/users/remove/${user.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if> 
</body>
</html>
