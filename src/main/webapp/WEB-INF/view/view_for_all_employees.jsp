<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<body>
<h3>All employees</h3>
<br><br>

<form action="search">
    <input type="text" name="keyword"/>
    <input type="submit" value="Search"/>
</form>

<br><br>

<table border="1">
    <tr>
        <th>Surname</th>
        <th>Name</th>
        <th>Middle Name</th>
        <th>Position</th>
        <th>Birthday</th>
        <th>Mobile Phone</th>
        <th>Email</th>
        <th>Department</th>
        <security:authorize access="hasRole('ADMIN')">
            <th>Options</th>
        </security:authorize>

    </tr>

    <c:forEach var="employee" items="${allEmployees}">

        <c:url var="editButton" value="/editEmployee">
            <c:param name="emp_id" value="${employee.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="emp_id" value="${employee.id}"/>
        </c:url>

        <tr>
            <td>${employee.surname}</td>
            <td>${employee.name}</td>
            <td>${employee.middleName}</td>
            <td>${employee.position}</td>
            <td>${employee.birthday}</td>
            <td>${employee.mobilePhone}</td>
            <td>${employee.email}</td>
            <td>${employee.department.name}</td>
            <security:authorize access="hasRole('ADMIN')">
                <td>
                    <input type="button" value="edit" onclick="window.location.href = '${editButton}'"/>
                    <input type="button" value="delete" onclick="window.location.href = '${deleteButton}'"/>
                </td>
            </security:authorize>

        </tr>
    </c:forEach>
</table>
<br><br>
<security:authorize access="hasRole('ADMIN')">
    <input type="button" value="add" onclick="window.location.href = 'addEmployee'"/>
</security:authorize>
<br><br>
<input type="button" value="excel" onclick="window.location.href = 'download'"/>

</body>
</html>
