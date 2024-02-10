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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class BuyServlet
 */
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		String prdname=request.getParameter("carname");
		String cost=request.getParameter("cost");
		String color=request.getParameter("color");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","carInd","root123");
			PreparedStatement pstmt=conn.prepareStatement("Insert into Orders values(?,?,?)");
			pstmt.setString(1, prdname);
			pstmt.setString(2, cost);
			pstmt.setString(3, color);
			
			int res=pstmt.executeUpdate();
			if(res>0)
			{
				out.println("<h1>Order Placed..<a href='Home.html'>Homepage</a><h1>");
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
