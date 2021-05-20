<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>Employee info</h2>
<br>

<form:form action="saveEmployee" modelAttribute="employee">

    <form:hidden path="id"/>

    Surname <form:input path="surname"/> <form:errors path="surname"/>
    <br><br>
    Name <form:input path="name"/> <form:errors path="name"/>
    <br><br>
    Middle name <form:input path="middleName"/>
    <br><br>
    Position <form:input path="position"/>
    <br><br>
    Birthday <form:input path="birthday"/> <form:errors path="birthday"/>
    <br><br>
    Mobile Phone <form:input path="mobilePhone"/> <form:errors path="mobilePhone"/>
    <br><br>
    Email <form:input path="email"/> <form:errors path="email"/>
    <br><br>
    Department
    <form:select path="department.id">
        <c:forEach var="department" items="${departments}">
            <form:option value="${department.id}" label="${department.name}">
            </form:option>
        </c:forEach>
    </form:select>
    <br><br>
    <input type="submit" value="OK">

</form:form>

</body>
</html>