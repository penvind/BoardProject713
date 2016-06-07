<%@page import="board.model.BoardDTO"%>
<%@page import="board.model.BoardDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<% 
	BoardDTO dto = (BoardDTO)request.getAttribute("dto");
%>
<html>

<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
#box{border:1px solid #CCCCCC}
#writer,#title,#content{font-size:9pt;font-weight:bold;color:#7F7F7F;돋움}
input{
	font-size:9pt;
	border-left:1px solid #C3C3C3;
	border-top:1px solid #C3C3C3;
	border-right:1px solid #C3C3C3;
	border-bottom:1px solid #C3C3C3;
	color:#7F7F7F;돋움
}
#title input{width:250px;}
#content textarea{
width:503px;
border:0;
height:153;
background:url("images/write_bg.gif");
border:#C3C3C3 1px solid 
}
#copyright{font-size:9pt;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>

$(document).ready(function(){
	$("#button").click(function(){
		callAjax();
	});
});


function callAjax(){
	// var boardData = $("form1").serialize();
	$.ajax({
			type : "post",
			url 	: "update.do",
			data : {
					idx : $('#idx').val(),
					title : $('#title').val(),
					writer : $('#writer').val(),
					content : $('#content').val()
			},
/* 			
 */
			success : whenSuccess,
			error : whenError
	});
}

function whenSuccess(resdata){
	return false;
	$("#ajaxReturn").html(resdata);
	console.log();
}

function whenError(){
	alert("Error");	
}






var flag = false;

function confirmCheck(){
	if(confirm("수정하시겠습니까?")){
		flag = !flag;
		log.d("confirm chek");
	}
	return flag;
}
/* 

function commit(){
	if(confirmCheck()){
	 	if(form1.writer.value==""){
			alert("writer 비어있음!");
			form1.writer.focus();
			return;
		}else if(form1.title.value==""){
			alert("title 비어있음!");
			form1.title.focus();
			return;
		}else if(form1.content.value==""){
			alert("content 비어있음!");
			form1.content.focus();
			return;
		}
	 	log.d(confirmCheck());
		form1.action="update.do"; 
		form1.submit();
	}else{
		alert("수정이 취소되었습니다.");
		history.back();
	}
}
 */
</script>
</head>
<body>
<form id="form1" method="post">
<input type="hidden" name="idx" id="idx" value="<%=dto.getIdx()%>">
<input type="hidden" name="check" value="true">
<table id="box" align="center" width="603" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="images/ceil.gif" width="603" height="25"></td>
  </tr>
  <tr>
    <td height="2" bgcolor="#6395FA"><img src="images/line_01.gif"></td>
  </tr>
  <tr>
    <td height="1" bgcolor="#CCCCCC"></td>
  </tr>
	<tr>	
		<td id="list"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="100">&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr id="writer">
            <td height="25" align="center">작성자</td>
            <td><input type="text" name="writer" id="writer" value="<%=dto.getWriter()%>" ></td>
          </tr>
          <tr id="title">
            <td height="25" align="center">제목</td>
            <td><input type="text" name="title" id="title" value="<%=dto.getTitle()%> " ></td>
          </tr>
          <tr id="content">
            <td align="center">내용</td>
            <td><textarea name="content" style="" ><%=dto.getContent() %></textarea></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
	</tr>
  <tr>
    <td height="30" align="right" style="padding-right:2px;">
	<button onclick="callAjax()"> 수정 </button>
	<a href="index.do"><img src="images/list_btn.gif" width="61" height="20"></a>	</td>
  </tr>
  <tr>
    <td height="1" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="20" align="center" id="copyright">Copyright All Rights Reserved </td>
  </tr>
</table>
</form>
</body>
</html>
