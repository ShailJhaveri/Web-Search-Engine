package edu.utdallas.arch.controller;

import java.io.IOException;
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

import edu.utdallas.arch.database.IndexEntryDAO;
import edu.utdallas.arch.database.IndexEntryDAOImpl;
import edu.utdallas.arch.database.MainEntryDAO;
import edu.utdallas.arch.database.MainEntryDAOImpl;
import edu.utdallas.arch.index.Characters;
import edu.utdallas.arch.model.IndexEntry;
import edu.utdallas.arch.model.MainEntry;
import edu.utdallas.arch.model.ResultBean;


/**
 * Servlet implementation class IndexController
 */
@WebServlet("/Index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doService(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(request, response);
	}
	
	
	//Service Method for Both king of Requests 
		protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String actionParameter = request.getParameter("actionParameter");

			if(actionParameter!=null)
			{
				//Going from Search Page to Circular Shift Page 
				if(actionParameter.equals("searchForString"))
				{
					searchForString(request, response);
				}
				
				//Going from Circular Shift page to FInal Page of Sorted List
				if(actionParameter.equals("showFinalResult"))
				{
					showFinalResult(request, response);
				}
				
				if(actionParameter.equals("searchMultiLines")){
					searchFromDatabase(request, response);
				}
				else
				{
					//redirecting to JSp Page 
					/*RequestDispatcher requestDispatcher; 
					requestDispatcher = request.getRequestDispatcher("/index.jsp");
					requestDispatcher.forward(request, response);*/
				}
			}
}
		
		
		
		private void searchFromDatabase(HttpServletRequest request,HttpServletResponse response) {
			//String searchWord = request.getParameter("combobox");
			String keyword = request.getParameter("radios");
			String textSearch =  request.getParameter("textSearch");
			
			//System.out.println("New Val : "+ textSearch);
			
			//System.out.println(searchWord + keyword);
			ArrayList<Integer> refKeys = new ArrayList<Integer>();
			ArrayList<MainEntry> finalEntries = new ArrayList<MainEntry>();
			IndexEntryDAO indexDAO = null;
			MainEntryDAO mainDAO = null;
			indexDAO = new IndexEntryDAOImpl();
			
			refKeys = indexDAO.getRefrencekeys(textSearch,keyword);
			mainDAO = new MainEntryDAOImpl();
			finalEntries = mainDAO.finalSearchResult(refKeys);
			
			request.setAttribute("finalEntries", finalEntries);
			
			try
			{
				 Connection con=null;
					Class.forName("com.mysql.jdbc.Driver");
					con= DriverManager.getConnection("jdbc:mysql://localhost:3306/swarch","root","root");
					Statement st1 = con.createStatement();
					List<String> list = new ArrayList<String>();
					ResultBean tempResultBean; 
					 			String query = "";
					 				query="Select data_lines from index_engine";
					 				ResultSet rs= st1.executeQuery(query) ;
					 				
					 				while(rs.next())
									{
										
										tempResultBean = new ResultBean();
										String[] splited = rs.getString(1).split(" ");
										list.add(splited[0]);
									}
							
							
							con.close();
							
							request.setAttribute("res",list);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			 
					
					
					
					
			
		/*	for(MainEntry fe : finalEntries ) {
				System.out.println(fe.toString());
			}
			*/
			try {
				RequestDispatcher requestDispatcher; 
				requestDispatcher = request.getRequestDispatcher("/af.jsp");
				requestDispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		private void searchForString(HttpServletRequest request, HttpServletResponse response)
		{
			int j=0;
			int i=0;
			int k=0;
			MainEntryDAO mainDao = null;
			MainEntry mainEntry = null;
			IndexEntryDAO indexDAO = null;
			
			try
			{
				String inputLine= request.getParameter("URL")!=null 
						&& !"".equals(request.getParameter("URL")) 
						? request.getParameter("URL") : "";
				
				String inputDescriptor= request.getParameter("Discription")!=null 
						&& !"".equals(request.getParameter("Discription")) 
					    ? request.getParameter("Discription") : "";
					    
					    String Removal= request.getParameter("Noise");
					    String[] nlines=Removal.split(",");
					    
								
					String[] lines=inputDescriptor.split("\\.");
			
					if(!inputLine.equals(""))
					{
						//Save Details in Database
						mainEntry = new MainEntry();
						mainEntry.setUrl(inputLine);
						mainEntry.setData(inputDescriptor);
						mainDao = new MainEntryDAOImpl();
						mainDao.insertEntryDetail(mainEntry);
					}
					
					//Calling Character Class method char 
					Characters charObj = new Characters();
					ResultBean result = charObj.setChar(lines,mainEntry.getId());
					
					//Get List From DB to JSp 
					indexDAO = new IndexEntryDAOImpl();
					ArrayList<IndexEntry> indexEntries = indexDAO.getDataLinesFromRef(mainEntry.getId());
					
					
					
					
					//Setting Parameter in jsp 
					request.setAttribute("finalLists", indexEntries);
					request.setAttribute("circulatList", result.getCircularShiftList());
					request.setAttribute("PageParameter", "circularShiftPage");
					
					
					
					
					//redirecting to JSp Page 
					RequestDispatcher requestDispatcher; 
					requestDispatcher = request.getRequestDispatcher("/index.jsp");
					requestDispatcher.forward(request, response);
			}
			catch(Exception e)
			{
				System.out.println("Problem in searchForString for searching String ");
				e.printStackTrace();
			}
		}
		
		
		private void showFinalResult(HttpServletRequest request, HttpServletResponse response)
		{
			
		}
		
		

}
