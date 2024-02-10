package com.html;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException, IOException {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	public void processRequest(HttpServletRequest request, HttpServletResponse response)throws SQLException , ServletException, IOException, ClassNotFoundException
	{
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","carInd","root123");
			PreparedStatement pstmt=conn.prepareStatement("Insert into Customer values(?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			int res=pstmt.executeUpdate();
			out.println("<h1>Registration is succesfull....<h1>");
			if(res>0)
			{
			    response.sendRedirect("./Signin.html");
			}
			else{
				out.println("Please Enter a valid details");
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.print(e.getMessage()+"g"+e.getCause());
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
