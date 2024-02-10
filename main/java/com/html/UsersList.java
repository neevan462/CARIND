package com.html;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

/**
 * Servlet implementation class UsersList
 */
public class UsersList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request,response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request,response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,ClassNotFoundException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","carInd","root123");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select *from Customer");
			 out.println("<html><head><title>User List</title></head><body>");
	            out.println("<h2>User List</h2>");
	            out.println("<table>");
	            out.println("<tr><th>Name</th><th>gmail</th><th> Password</th></tr>");
	            while (rs.next()) {
	            	
	                out.println("<tr><td>"+rs.getString(1)+"</td><td>"+ rs.getString(2) +"</td><td>"+"*90sghfh2"+rs.getString(3)+"5623*hvk"+ "</td></tr>");
	            }
	            out.println("</tbody></table>");
	            out.println("</body></html>");
	            
	            rs.close();
	            stmt.close();
	            conn.close();
		}
		catch(Exception e)
		{ out.println("error:"+e.getMessage());
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request,response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			
	     }
	}

}
