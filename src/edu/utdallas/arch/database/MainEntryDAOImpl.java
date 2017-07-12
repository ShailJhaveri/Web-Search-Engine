package edu.utdallas.arch.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.utdallas.arch.model.MainEntry;
import edu.utdallas.arch.util.ConnectionObj;

public class MainEntryDAOImpl implements MainEntryDAO{

	
	@Override
	public int insertEntryDetail(MainEntry mainEntry) {
		
		//Implement this method for inserting new row for Main Entry 
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;
		try
		{
			 conn = ConnectionObj.getConnection();
		      stmt = conn.prepareStatement("INSERT INTO `swarch`.`sengine`(`url`,`data`)VALUES(?, ?)");
		      
		      //stmt.setInt(1,Integer.parseInt(address.getPersonId()));
		      stmt.setString(1,mainEntry.getUrl());
		      stmt.setString(2,mainEntry.getData());
		      
		      result = stmt.executeUpdate();
		      
		      
		      ResultSet rs = stmt.getGeneratedKeys();
		      if (rs.next()) {
		        int newId = rs.getInt(1);
		        mainEntry.setId(newId);
		      }
		      
		}
		catch(Exception e )
		{
			System.out.println("Problem in Inserting into Main Entry Object ");
			e.printStackTrace();
		}
		finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	
		return result;
	}

	
	public ArrayList<MainEntry> finalSearchResult(ArrayList<Integer> refKeys) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ArrayList<MainEntry> finalEntries = new ArrayList<MainEntry>();
		try
		{
			 conn = ConnectionObj.getConnection();
			 String query = "SELECT * FROM swarch.sengine WHERE ID IN ("+getSearchQuery(refKeys)+") AND dateFeild >=curdate();";
				
			stmt = conn.prepareStatement(query); 
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				MainEntry mainEntry = new MainEntry(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				finalEntries.add(mainEntry);
			}
		}
		catch(Exception e )
		{
				System.out.println("Problem in Searching Index Entry Data ");
				e.printStackTrace();
		}
		return finalEntries;
		
	}
	
	
	private String getSearchQuery(ArrayList<Integer> refKeys)
	{
		String resultQuery = "";
			for(int i=0;i<refKeys.size();i++)
			{
				if(i==0)
				{
					resultQuery+=refKeys.get(i);
				}
				else
				{
					resultQuery+=","+refKeys.get(i);
				}
			}
		
		
		return resultQuery;
	}

}
