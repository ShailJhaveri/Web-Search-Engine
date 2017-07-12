package SearchEngine;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Autofill
 */
@WebServlet("/AutoFill")
public class AutoFill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoFill() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Connection con=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter out = response.getWriter();
	        
				Class.forName("com.mysql.jdbc.Driver");
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/swarch","root","root");
				Statement st1 = con.createStatement();
				//String n= " Rajan " ;
				 				//String n =  request.getParameter("search_val");
				List<String> list = new ArrayList<String>();
				 			String query = "";
				 				query="Select data_lines from index_engine";
				 				ResultSet rs= st1.executeQuery(query) ;
				 				
				 				while(rs.next())
								{
									
									String[] splited = rs.getString(1).split(" ");
									list.add(splited[0]);
								}
						
						
						con.close();
						
						request.setAttribute("res",list);
						
						//session.setAttribute("ans", rs);
						//session.setAttribute("login_name", rs.getString(1));
						//request.setAttribute("res",list);
				 //}
				 
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/af.jsp");
				dispatcher.forward(request, response);
				
				
				
				//response.sendRedirect("Search_book.jsp");
				//response.sendRedirect("Search_book.jsp");
				
				//response.sendRedirect("congrats.jsp");
		 
				
		
		}
		 catch(Exception e){
			 System.out.println(e);
		 }
	}


}

