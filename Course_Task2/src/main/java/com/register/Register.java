package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));

		boolean isInserted = saveToDb(name, email, age);
		if (isInserted) {
			request.setAttribute("name", name) ;
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		} else {
			out.println("<h1>Failed Please Try Again</h1>");
		}
	}

	private boolean saveToDb(String name, String email, int age) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/register_db";
		String username = "root";
		String password = "123456";
		String sqlCommand = "INSERT INTO register (name , age , email) VALUES (? , ? ,?)";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);

			PreparedStatement statement = con.prepareStatement(sqlCommand);
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.setString(3, email);

			int rowsAffected = statement.executeUpdate();

			if (rowsAffected > 0) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
