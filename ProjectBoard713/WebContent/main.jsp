<%@ page contentType="text/html;charset=utf-8"%>
<%
	int TotalRecord = 204;  //게시글의 총 개수
	
	int CurrentPage = 1;    //현재 페이지
	int PageSize = 10;      //한 페이지당 보여질 글의 개수
	int BlockSize = 10;     //한번에 보여질 블럭(페이지 분할) 개수

	if(request.getParameter("CurrentPage") != null){
		CurrentPage = Integer.parseInt(request.getParameter("CurrentPage"));
	}
	
	int TotalPage =  (int) Math.ceil((float)TotalRecord/PageSize);		   // 게시글 총 개수 % 한페이지에 보여질 블록 개수 
	int FirstBlock = CurrentPage - ((CurrentPage-1) % BlockSize);       
	int LastBlock  = FirstBlock + (BlockSize-1);                       
	
	
	out.print("CurrentPage = " + CurrentPage);
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
@IMPORT url("WebContent/site.css");
</style>
<script>
	function init(){
		list.action();
	}
</script>
</head>
<body onload="init()">
<form name="list" method="get" action="main.jsp">
<table id="box" align="center" width="603" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="5"><img src="WebContent/images/ceil.gif" width="603" height="25"></td>
  </tr>
  <tr>
    <td height="2" colspan="5" bgcolor="#6395FA"><img src="WebContent/images/line_01.gif"></td>
  </tr>
  <tr id="title" align="center">
    <td width="50" height="20">번호</td>
    <td width="303" height="20">제목</td>
    <td width="100" height="20">글쓴이</td>
    <td width="100" height="20">날짜</td>
    <td width="50" height="20">조회수</td>
  </tr>
  <tr>
    <td height="1" colspan="5" bgcolor="#CCCCCC"></td>
  </tr>
	<tr>	
		<td colspan="5" id="list">
		  <table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <% for(int i=1; i<=PageSize; i++){ %>
		    <tr align="center" height="20px" onMouseOver="this.style.background='#FFFF99'" onMouseOut="this.style.background=''">
			  <td width="50">1</td>
			  <td width="303"><a href="detail.jsp">제목입니다.</a></td>
			  <td width="100">관리자</td>
			  <td width="100">2016/05/18</td>
			  <td width="50">5</td>
		    </tr>
			<% } %>
			<tr>
				<td height="1" colspan="5" background="WebContent/images/line_dot.gif"></td>
			</tr>
		  </table>		
		  </td>
	</tr>
  <tr>
   
    <td id="paging" height="20" colspan="5" align="center">  
    	<a href="main.jsp?CurrentPage=<%=FirstBlock-1%>"> ◀ </a>
    	<% for(int i=FirstBlock; i<=LastBlock; i++){ %>
    		<%if(i>TotalPage) break; %>
    		<a href="main.jsp?CurrentPage=<%=i%>">[<%=i%>]</a> 
   		<% } %>
   		<a href="main.jsp?CurrentPage=<%=LastBlock+1%>"> ▶ </a> 
   	</td>
  
  </tr>
  <tr>
    <td height="20" colspan="5" align="right" style="padding-right:2px;">
	<table width="160" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="70">
          <select name="select" id="category">
            <option>제목</option>
            <option>내용</option>
            <option>글쓴이</option>
          </select>        </td>
        <td width="80">
          <input name="textfield" id="keyword" type="text" size="15">        </td>
        <td><img src="WebContent/images/search_btn.gif" width="32" height="17"></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="30" colspan="5" align="right" style="padding-right:2px;"><a href="write.jsp"><img src="WebContent/images/write_btin.gif" width="61" height="20" border="0"></a></td>
  </tr>
  <tr>
    <td height="1" colspan="5" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="20" colspan="5" align="center" id="copyright">Copyright  All Rights Reserved </td>
  </tr>
</table>
</form>
</body>
</html>
