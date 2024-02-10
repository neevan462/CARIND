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
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void processRequest(HttpServletRequest request, HttpServletResponse response)throws SQLException , ServletException, IOException, ClassNotFoundException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("username");
		String password=request.getParameter("password");
		try {
			
			boolean flag=false;
			if(email.equals("shiva@gmail.com") && password.equals("shiva143"))
			{
				flag=true;
			}			
			if(flag){
			
				 response.sendRedirect("Admin.html");
				}
				else
				{
					out.println("<!DOCTYPE html>\r\n"
							+ "<html lang=\"en\">\r\n"
							+ "<head>\r\n"
							+ "    <meta charset=\"UTF-8\">\r\n"
							+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
							+ "    <title>Login Page</title>\r\n"
							+ "    <style>\r\n"
							+ "        body {\r\n"
							+ "            font-family: Arial, sans-serif;\r\n"
							+ "            background-color: #f0f0f0;\r\n"
							+ "            margin: 0;\r\n"
							+ "            padding: 0;\r\n"
							+ "            display: flex;\r\n"
							+ "            justify-content: center;\r\n"
							+ "            align-items: center;\r\n"
							+ "            height: 100vh;\r\n"
							+ "        }\r\n"
							+ "        .login-container {\r\n"
							+ "            background-color: #ffffff;\r\n"
							+ "            padding: 40px;\r\n"
							+ "            border-radius: 10px;\r\n"
							+ "            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);\r\n"
							+ "            width: 400px;\r\n"
							+ "            text-align: center;\r\n"
							+ "        }\r\n"
							+ "        .login-container h2 {\r\n"
							+ "            margin-bottom: 20px;\r\n"
							+ "            color: #333333;\r\n"
							+ "        }\r\n"
							+ "        .login-container input[type=\"text\"],\r\n"
							+ "        .login-container input[type=\"password\"] {\r\n"
							+ "            width: 100%;\r\n"
							+ "            padding: 10px;\r\n"
							+ "            margin-bottom: 20px;\r\n"
							+ "            border-radius: 5px;\r\n"
							+ "            border: 1px solid #cccccc;\r\n"
							+ "        }\r\n"
							+ "        .login-container input[type=\"submit\"] {\r\n"
							+ "            width: 100%;\r\n"
							+ "            padding: 10px;\r\n"
							+ "            border: none;\r\n"
							+ "            border-radius: 5px;\r\n"
							+ "            background-color: #4caf50;\r\n"
							+ "            color: #ffffff;\r\n"
							+ "            cursor: pointer;\r\n"
							+ "        }\r\n"
							+ "        .login-container input[type=\"submit\"]:hover {\r\n"
							+ "            background-color: #45a049;\r\n"
							+ "        }\r\n"
							+ "        .login-container p {\r\n"
							+ "            margin-top: 15px;\r\n"
							+ "            font-size: 14px;\r\n"
							+ "        }\r\n"
							+ "        .login-container a {\r\n"
							+ "            color: #4caf50;\r\n"
							+ "            text-decoration: none;\r\n"
							+ "        }\r\n"
							+ "    </style>\r\n"
							+ "</head>\r\n"
							+ "<body>\r\n"
							+ "<pr>Username or Password wrong<pr>"
							+ "    <div class=\"login-container\">\r\n"
							+ "        <h2>Login</h2>\r\n"
							+ "        <form action=\"AdminLoginServlet\" method=\"post\">\r\n"
							+ "            <input type=\"text\" name=\"username\" placeholder=\"username\" required>\r\n"
							+ "            <input type=\"password\" name=\"password\" placeholder=\"password\" required>\r\n"
							+ "            <input type=\"submit\" value=\"Login\">\r\n"
							+ "        </form>\r\n"
							+ "        <p>Don't have an account? <a href=\"#\">Sign up</a></p>\r\n"
							+ "    </div>\r\n"
							+ "</body>\r\n"
							+ "</html>\r\n"
							+ "");
				}
		}
		catch(Exception e)
		{ out.println("error:"+e.getMessage());
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			processRequest(request,response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
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
