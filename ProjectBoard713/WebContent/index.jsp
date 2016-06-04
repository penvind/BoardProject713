<%@page import="java.util.List"%>
<%@page import="board.common.PageUtil"%>
<%@page import="board.model.BoardDTO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%! PageUtil pg = new PageUtil();%>
<%
   List<BoardDTO> list = (List<BoardDTO>)request.getAttribute("index");
if(list != null){
   pg.init(list.size(), request);
}

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
</style>

</head>
<body>
<table id="box" align="center" width="603" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="5"><img src="images/ceil.gif" width="603" height="25"></td>
  </tr>
  <tr>
    <td height="2" colspan="5" bgcolor="#6395FA"><img src="images/line_01.gif"></td>
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
      <%
         int num = pg.getNum();
         int curPos = pg.getCurPos(); 
      %>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" >
        <% for(int i=1; i<=pg.getPageSize(); i++){ %>
        <%if(num<1) break; %>
        <%BoardDTO dto = list.get(curPos++); %>
          <tr align="center" height="20px" onMouseOver="this.style.background='#FFFF99'" onMouseOut="this.style.background=''">
           <td width="50"><%=num--%></td>
           <td width="303"><a href="detail.do?idx=<%=dto.getIdx() %>"><%=dto.getTitle() %></a></td>
           <td width="100"><%=dto.getWriter() %></td>
           <td width="100"><%=dto.getRegdate() %></td>
           <td width="50"><%=dto.getHit() %></td>
          </tr>
         <% } %>
         <tr>
            <td height="1" colspan="5" background="images/line_dot.gif"></td>
         </tr>
        </table>      
        </td>
   </tr>
  <tr>
   
    <td id="paging" height="20" colspan="5" align="center">  
       <a href="index.jsp?CurrentPage=<%=pg.getFirstBlock()-1%>"> ◀ </a>
       <% for(int i=pg.getFirstBlock(); i<=pg.getLastBlock(); i++){ %>
          <%if(i>pg.getTotalPage()) break; %>
          <a href="index.jsp?CurrentPage=<%=i%>">[<%=i%>]</a> 
         <% } %>
         <a href="index.jsp?CurrentPage=<%=pg.getLastBlock()+1%>"> ▶ </a> 
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
        <td><img src="images/search_btn.gif" width="32" height="17"></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="30" colspan="5" align="right" style="padding-right:2px;"><a href="write.jsp"><img src="images/write_btin.gif" width="61" height="20" border="0"></a></td>
  </tr>
  <tr>
    <td height="1" colspan="5" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="20" colspan="5" align="center" id="copyright">Copyright  All Rights Reserved </td>
  </tr>
</table>
</body>
</html>