package com.html;

import jakarta.servlet.ServletException;
import java.io.*;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryServlet
 */
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
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
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException{
        response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String query=request.getParameter("query");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=null;
		try{
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","carInd","root123");
			PreparedStatement pstm=conn.prepareStatement("Insert into Query values(?,?,?)");
			
			pstm.setString(1, name);
			
			pstm.setString(2, email);
			
			pstm.setString(3, query);
			
			int r=pstm.executeUpdate();
			
			if(r>0)
			{
				out.println("<h1>Query submitted succesfully....<h1>");
				out.println("<h3><a href='Contact.html'>click</a></h3>");
			}
			else
			{
				out.println("Your query failed to submit...");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			response.getWriter().println("welcome to ;;query");
			processRequest(request, response);
		} catch (ClassNotFoundException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
