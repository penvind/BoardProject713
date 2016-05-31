<%@page import="model.BoardDAO"%>
<%@page import="model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
	request.setCharacterEncoding("UTF-8");
	
	int idx = Integer.parseInt(request.getParameter("idx"));
	
	BoardDTO dto = new BoardDTO();
	dto.setIdx(idx);

	BoardDAO dao = new BoardDAO();
	int result = dao.delete(idx);

    
    
    %>
<!DOCTYPE html>
<script type="text/javascript">
<%
	if(result == 0) { %>
		alert("삭제 실패");
		history.back();
	<%} else { %>
		alert("삭제 성공");
		location.href="index.jsp";
	<%}

%>
</script>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>