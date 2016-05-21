<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insert_action.jsp" method="post">
<table>
	<caption>글 쓰기</caption>
<tr>
	<th>제목</th>
	<td><input type="text" name="title" 
	autofocus="autofocus" required="required"/></td>
</tr>
<tr>
	<th>작성자</th>
	<td><input type="text" name="name" required="required"/></td>
</tr>
<tr>
	<th>비밀번호</th>
	<td><input type="password" name="pwd" required="required"/></td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea rows="5" cols="40" name="content"  required="required"/></textarea></td>
</tr>
<tr>
	<td colspan="2" class="center">
		<input type="submit" value="확인" />
		<input type="reset" value="초기화" />
	</td>
</tr>
</table>
</form>
</body>
</html>