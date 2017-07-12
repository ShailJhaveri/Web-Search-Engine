package edu.utdallas.arch.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.utdallas.arch.model.IndexEntry;
import edu.utdallas.arch.util.ConnectionObj;

public class IndexEntryDAOImpl implements IndexEntryDAO {

	@Override
	public int insertIntoIndexEntry(IndexEntry indexEntry) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int result = 0;
		try
		{
			 conn = ConnectionObj.getConnection();
		      stmt = conn.prepareStatement("INSERT INTO `swarch`.`index_engine`(`data_lines`,`main_id`)VALUES( ?, ?);");
		      
		      //stmt.setInt(1,Integer.parseInt(address.getPersonId()));
		      stmt.setString(1,indexEntry.getDataLines());
		      stmt.setInt(2,indexEntry.getRefMainEntry());
		      
		      result = stmt.executeUpdate();
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

	@Override
	public ArrayList<IndexEntry> getDataLinesFromRef(int refNum) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlQuery="";
		ArrayList<IndexEntry> entryList = new ArrayList<IndexEntry>();
		IndexEntry indexEntry;
		try
		{
			 conn = ConnectionObj.getConnection();
			 sqlQuery = "select * from `swarch`.`index_engine` where main_id=? order by data_lines";
			 
		      stmt = conn.prepareStatement(sqlQuery);
		      stmt.setInt(1, refNum);

		      rs = stmt.executeQuery();
		      
		      while (rs.next()) {
		    	  indexEntry = new IndexEntry( rs.getInt(1), rs.getString(2), rs.getInt(3));
		    	  entryList.add(indexEntry);
		      }
		}
		catch(Exception e )
		{
			System.out.println("Problem in Searching Index Entry Data ");
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
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return entryList;
	}

	@Override
	public ArrayList<Integer> getRefrencekeys(String searchWords, String keyword){
		Connection conn = null;
		PreparedStatement stmt = null;
		ArrayList<Integer> refKeys = new ArrayList<Integer>();
		int result = 0;
		try{
			
		conn = ConnectionObj.getConnection();
		String query = "SELECT distinct (main_id) FROM swarch.index_engine WHERE "+getSearchQuery(searchWords,keyword);;
		 stmt = conn.prepareStatement(query); 
		 ResultSet rs = stmt.executeQuery();
		 while(rs.next()){
			 refKeys.add(rs.getInt(1));
		 }
		 
		}
	catch(Exception e )
	{
		System.out.println("Problem in Searching Index Entry Data ");
		e.printStackTrace();
	}
		return refKeys;
	}
	
	
	
	private String getSearchQuery(String searchWords, String keyword)
	{
		String resultQuery = "";
		String[] allWords = searchWords.split(" ");
		if(keyword.equalsIgnoreCase("OR")) 
		{
			for(int i=0;i<allWords.length;i++)
			{
				if(i==0)
				{
					resultQuery+=" data_lines LIKE '%"+allWords[i]+"%'";
				}
				else
				{
					resultQuery+=" OR data_lines LIKE '%"+allWords[i]+"%'";
				}
			}
		}
		else if(keyword.equalsIgnoreCase("AND"))
		{
			for(int i=0;i<allWords.length;i++)
			{
				if(i==0)
				{
					resultQuery+=" data_lines LIKE '%"+allWords[i]+"%'";
				}
				else
				{
					resultQuery+=" AND data_lines LIKE '%"+allWords[i]+"%'";
				}
			}
		}
		else if(keyword.equalsIgnoreCase("NOT"))
		{
			for(int i=0;i<allWords.length;i++)
			{
				if(i==0)
				{
					resultQuery+=" data_lines NOT LIKE '%"+allWords[i]+"%'";
				}
				else
				{
					resultQuery+=" AND data_lines NOT LIKE '%"+allWords[i]+"%'";
				}
			}
		}
		
		
		return resultQuery;
	}

}
