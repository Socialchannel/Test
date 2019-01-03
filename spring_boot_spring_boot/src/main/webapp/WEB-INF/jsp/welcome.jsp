<%@page session="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:csrfInput /> 
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	Â  Â Â Â Â 	
	<h3 style="color: red;">Hello Admin</h3>
</body>
</html>