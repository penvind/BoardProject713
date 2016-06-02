<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1 style="color: red">에러!!!!!!!에러!!!!!!!!!!!!!!!ERRORROORRORRRORRRRR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!</h1>
	<h3>에러 원인 : <%
	RuntimeException r = (RuntimeException)request.getAttribute("error"); 
	out.print(r.getMessage());
%></h3>
	
</body>
</html>