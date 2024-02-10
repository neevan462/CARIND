package com.html;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
/**
 * Servlet implementation class DisplayQueriesServlet
 */
public class DisplayQueriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayQueriesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
        PrintWriter out = response.getWriter();
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "carInd";
        String password = "root123";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
           
            Connection conn = DriverManager.getConnection(url, user, password);
            
            String sql = "SELECT *FROM Query";
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute the SQL query
            
            ResultSet resultSet = statement.executeQuery();
            // Display queries
            
            out.println("<html><head><title>Query List</title></head><body>");
            out.println("<h1 text-align:centre'>Queries</h1>");
            
            out.println("<table>");
            out.println("<tr><th>Name</th><th>gmail</th><th> Query</th></tr>");
            while (resultSet.next()) {
            	
                out.println("<tr><td>"+resultSet.getString(1)+"</td><td>"+ resultSet.getString(2) +"</td><td>"+resultSet.getString(3)+ "</td></tr>");
            }
            out.println("</tbody></table>");
            out.println("</body></html>");
            
            resultSet.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("An error occurred while retrieving queries.");
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
