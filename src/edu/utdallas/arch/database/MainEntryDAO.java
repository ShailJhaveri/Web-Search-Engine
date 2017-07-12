package edu.utdallas.arch.database;

import java.util.ArrayList;

import edu.utdallas.arch.model.MainEntry;

public interface MainEntryDAO {

	
	public int insertEntryDetail(MainEntry mainEntry);
	
	public ArrayList<MainEntry> finalSearchResult(ArrayList<Integer> refKeys);   
		
}
