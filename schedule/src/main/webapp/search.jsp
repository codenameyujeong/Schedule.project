<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.util.*"%>
<%@ page import="DTO.Events"%>
 <%
request.setCharacterEncoding("UTF-8");
ArrayList<Events> list = new ArrayList<Events>();
list = (ArrayList<Events>) request.getAttribute("list");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<title>Insert title here</title>
</head>
<body>

<%@ include file="top.jsp"%>
	<section>
		<div class="title">후보조회</div>
		<div class="wrapper">
			<table style="width: 900px">
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>소속정당</th>
					<th>학력</th>
					<th>주민번호</th>
					<th>지역구</th>
					<th>대표번호</th>
		</tr>
		 		<%
				for (Events m : list) {
				%> 
				<tr>
					<td><%=m.getEvent_name()%></td>
					<td><%=m.getStrat_date()%></td>
					<td><%=m.getEnd_date()%></td>
					<td><%=m.getStory()%></td>

				</tr>
			 	<%
				}
				%> 
			</table>
		</div>
	</section>
	
</body>
</html>