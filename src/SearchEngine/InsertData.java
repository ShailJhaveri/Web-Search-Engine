package SearchEngine;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertData() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request , response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = null;
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Varun@36");
	        Statement st = con.createStatement();
	        System.out.println("Connection Established" + con);
	        ResultSet rs = st.executeQuery("select * from sengine");
	       
	        while(rs.next()){
	        	System.out.println(rs.getInt(1));
	        	System.out.println(rs.getString(2));
	        	System.out.println(rs.getString(3));
	        }
	        
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
