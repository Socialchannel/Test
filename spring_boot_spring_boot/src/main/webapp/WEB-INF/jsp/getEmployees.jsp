<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:csrfInput />
<html>
<head>
<title>Show Employees</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h3 style="color: red;">Show All Employees</h3>
		<table>
		<c:forEach var="listValue" items="${employees}">
			<tr>
			<td>${listValue.empId}</td>
			<td>${listValue.empName}</td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>