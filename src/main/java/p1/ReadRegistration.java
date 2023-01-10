package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ReadRegistration")
public class ReadRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ReadRegistration() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test_1","root","channa12345sql");
			Statement stmnt = con.createStatement();
			ResultSet result = stmnt.executeQuery("select * from registration");
			PrintWriter out=response.getWriter();
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<th>");
			out.println("Name");
			out.println("</th>");
			out.println("<th>");
			out.println("City");
			out.println("</th>");
			out.println("<th>");
			out.println("email");
			out.println("</th>");
			out.println("<th>");
			out.println("mobile");
			out.println("</th>");
			out.println("</tr>");

			while(result.next()) {
				out.println("<tr>");
				out.println("<th>");
				out.println(result.getString(1));
				out.println("</th>");
				out.println("<th>");
				out.println(result.getString(2));
				out.println("</th>");

				out.println("<th>");
				out.println(result.getString(3));
				out.println("</th>");

				out.println("<th>");
				out.println(result.getString(4));
				out.println("</th>");

				out.println("</tr>");
			}

			out.println("</table>");

			
			
			con.close();
		} catch (Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("post");
	}

}
