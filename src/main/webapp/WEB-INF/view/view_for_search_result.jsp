<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<body>

<table border="1">
    <tr>
        <th>Surname</th>
        <th>Name</th>
        <th>Middle name</th>
        <th>Position</th>
        <th>Birthday</th>
        <th>Mobile Phone</th>
        <th>Email</th>
        <th>Department</th>
    </tr>

    <c:forEach var="employee" items="${searchResult}">

        <tr>
            <td>${employee.surname}</td>
            <td>${employee.name}</td>
            <td>${employee.middleName}</td>
            <td>${employee.position}</td>
            <td>${employee.birthday}</td>
            <td>${employee.mobilePhone}</td>
            <td>${employee.email}</td>
            <td>${employee.department.name}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
