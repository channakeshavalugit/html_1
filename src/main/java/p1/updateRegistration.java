package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class updateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updateRegistration() {
        super();
    }
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Get");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("emailId");
		String mobile = request.getParameter("mobile");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test_1","root","channa12345sql");
		Statement stmnt = con.createStatement();
		stmnt.executeUpdate("update registration set mobile='"+mobile+"' where email='"+email+"'");
		
		con.close();
	} catch (Exception e) {
		
	}
			
	}
}
	
