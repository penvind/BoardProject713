<%@page import="model.BoardDAO"%>
<%@page import="model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% %>
<%
	request.setCharacterEncoding("UTF-8");
	
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BoardDTO dto = new BoardDTO();
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);

	BoardDAO dao = new BoardDAO();
	int result = dao.insert(dto);

	


%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script type="text/javascript">
<%
	if(result ==1) { %>
		alert("정상등록");
		location.href="index.jsp";
	<%} else { %>
		alert("등록실패");
		history.back();
	<%}

%>
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>