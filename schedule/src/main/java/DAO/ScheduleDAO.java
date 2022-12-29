package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Events;

public class ScheduleDAO {
	 Connection conn = null;
	   PreparedStatement ps = null;
	   ResultSet rs = null;
	   
	   //데이터 베이스 연결 메소드
	   public static Connection getConnection () throws Exception {
	      Class.forName("oracle.jdbc.OracleDriver");
	      Connection con = DriverManager
	            .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "test1234");
	      return con;
}
	   
	   public String selectAll(HttpServletRequest request,HttpServletResponse response) {
		      ArrayList<Events> list = new ArrayList<Events>();
		      try {
		         conn = getConnection();//db연결
		         String sql = "select m.m_no, m.m_name, count(*) as Total ";
		         sql+= "from tbl_member_202005 m, tbl_vote_202005 v ";
		         sql+= "where m.m_no = v.m_no and v.v_confirm = 'Y' ";
		         sql+= "group by m.m_no, m.m_name ";
		         sql+= "order by total desc";
		      
		         ps = conn.prepareStatement(sql); //쿼리문 실행 준비
		         rs = ps.executeQuery(); //쿼리문 실행
		         System.out.println("0");
		         
		         while (rs.next()) {
		        	 Events events = new Events();
		        	 events.setEvent_name(rs.getString(1));
		        	 events.setStrat_date(rs.getString(2));
		        	 events.setEnd_date(rs.getString(3));
		            
		            list.add(events);
		         }
		         
		         request.setAttribute("list", list);
		         
		         conn.close();
		         ps.close();
		         rs.close();
		         
		      } catch (Exception e) {
		         e.printStackTrace();
		      } 
		      
		      return "insert.jsp";
	   }
	   
	   public int add(HttpServletRequest request, HttpServletResponse response) {
		   	int Event_id =Integer.parseInt(request.getParameter("Event_id"));
			String Event_name = request.getParameter("Event_name").trim();
			String Strat_date = request.getParameter("Strat_date").trim();
			String End_date = request.getParameter("End_date").trim();
			String Story = request.getParameter("Story").trim();
			int result = 0;
			
			try {
				conn = getConnection();
				
				String sql = "INSERT INTO events";
				sql += " values(?,?,TO_DATE(?, 'YY/MM/DD'),TO_DATE(?, 'YY/MM/DD'),?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, Event_id);
				ps.setString(2, Event_name);
				ps.setString(3, Strat_date);
				ps.setString(4, End_date);
				ps.setString(5, Story);
				
	
				result = ps.executeUpdate();
				System.out.println(result);
				
				conn.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return result;
		}
}