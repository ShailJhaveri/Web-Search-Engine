package edu.utdallas.arch.database;

import java.util.ArrayList;

import edu.utdallas.arch.model.IndexEntry;

public interface IndexEntryDAO {

	
	public int insertIntoIndexEntry(IndexEntry indexEntry);
	
	public ArrayList<IndexEntry> getDataLinesFromRef(int refNum);
	
	public ArrayList<Integer> getRefrencekeys(String searchWords, String keyword);
	
	//TODO - Get main_Ref from 
}
