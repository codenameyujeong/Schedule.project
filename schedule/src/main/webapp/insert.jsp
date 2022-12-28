<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="script.js"></script>
</head>
<body>
   
   <section>
   <%@ include file="top.jsp" %>
      <div class="title">스케줄 등록하기</div>
      <form name="frm" action="insert">
         <input type="hidden" id="GUBUN" value="insert">
         <div class="wrapper">

         <table>
            <tr>
            <th>내용</th>
            <td><input type="text" name="Event_name" ></td>
            </tr>
            <tr>
            <th>일정시작 날짜</th>
            <td><input type="text" name="Strat_date"></td>
            </tr>
            <tr>
            <th>일정마무리 날짜</th>
            <td><input type="text" name="End_date"></td>
            </tr>
            <tr>
            <td colspan="2">
            <button class="btn" type="submit" onclick="fn_submit(); return false;">등록하기</button>
            <button class="btn" type="reset">다시하기</button>
            </td>
            </tr>
         </table>
         </div>
      </form>
   </section>
</body>
</html>