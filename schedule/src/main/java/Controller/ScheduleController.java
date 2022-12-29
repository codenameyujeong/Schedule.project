package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ScheduleDAO;


@WebServlet("/")
public class ScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ScheduleController() {
        super();
       
    }

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPro(request, response); //get으로 오든 post로 오든 처리를 하기 위해.
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPro(request, response);
	}

	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      //웹 프로젝트 하나당 생성됨 , 톰캣의 context path를 가져온다.
	      //Servers.xml에서 확인 할 수 있음.
	      String context = request.getContextPath();
	      //주소중에 맨 끝 파일명만 가져온다. (경로의 맨 끝 파일명을 가져온다.)
	      String command = request.getServletPath();
	      String site = "";
	      System.out.println(context + "," + command);
	      
	      ScheduleDAO events = new ScheduleDAO();
	      
	      switch (command) {
	      case "/home" :
	         site = "index.jsp";
	         break;
	      case "/search" :
	             site = events.selectAll(request, response);
		         break;
	      case "/insert" :
	             site = "insert.jsp";
		         break;
	      case "/add" :
	    	  int result = events.add(request, response); 
		         response.setContentType("text/html; charset=UTF-8");
		         PrintWriter out = response.getWriter();
		         
		         if(result == 1) {
		            out.println("<script>");
		            out.println(" alert('일정이 정상적으로 등록되었습니다!!'); location.href='" + context + "';");
		            out.println("</script>");
//		            out.flush();
		         } else {
		            out.println("<script>");
		            out.println(" alert('일정이 정상적으로 등록되지 않았습니다'); location.href='" + context + "';");
		            out.println("</script>");
//		            out.flush();
		         } 
		    	break;
//	      case "/insert":
//		    	int result = events.insert(request, response); 
//		         response.setContentType("text/html; charset=UTF-8");
//		         PrintWriter out = response.getWriter();
//		         
//		         if(result == 1) {
//		            out.println("<script>");
//		            out.println(" alert('일정이 정상적으로 등록되었습니다!!'); location.href='" + context + "';");
//		            out.println("</script>");
//		            out.flush();
//		         } else {
//		            out.println("<script>");
//		            out.println(" alert('일정이 정상적으로 등록되지 않았습니다'); location.href='" + context + "';");
//		            out.println("</script>");
//		            out.flush();
//		         } 
//		    	break;
//		         
//		         if(result == 1) {
//		            out.println("<script>");
//		            out.println(" alert('투표정보가 정상적으로 등록되었습니다!!'); location.href='" + context + "';");
//		            out.println("</script>");
//		            out.flush();
//		         } else {
//		            out.println("<script>");
//		            out.println(" alert('투표정보가 정상적으로 등록되지 않았습니다'); location.href='" + context + "';");
//		            out.println("</script>");
//		            out.flush();
//		         } 
//		    	break;
//		    case "/lookup" :
//		         site = member.lookup(request, response);
//		         break;
//		    case "/rank" :
//	             site = member.rank(request, response);
//		         break;
	      }	   
	      getServletContext().getRequestDispatcher("/" + site).forward(request, response);
	}
}
