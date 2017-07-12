package edu.utdallas.arch.index;

import java.util.ArrayList;

import edu.utdallas.arch.database.IndexEntryDAO;
import edu.utdallas.arch.database.IndexEntryDAOImpl;
import edu.utdallas.arch.model.IndexEntry;
import edu.utdallas.arch.model.ResultBean;

public class CircularShift {
	
	public char gchar(int l,int w,int c){
		System.out.println("character " + (c) + " of word " + (w) + " of line " + (l) + " is " + csget[l][w][c]);
		return csget[l][w][c]; 
		
	}
	
	public ResultBean cshift(){
		return null;
		
	}
	

	char[][][] csget = null;
	public ResultBean setChar(String[] lines,int mainEntryRef) {
		
		StringBuffer sb = new StringBuffer("");
		//StringBuffer sb2 = new StringBuffer("");
		ArrayList<String> finalLists = new ArrayList<String>();
		ArrayList<ArrayList<String>> circularShiftList = new ArrayList<ArrayList<String>>();
		ArrayList<String> innerList = null;
		
		ResultBean results = new ResultBean();
		
		IndexEntryDAO indexEntryDao = new IndexEntryDAOImpl();
		IndexEntry indexEntry = null;
		
		
		
		for(int i1=0;i1<lines.length;i1++){
			
			System.out.println();
			//out.println("Line : " + (i1+1));
			String[] temp = lines[i1].split(" ");
			//String[] fieldsToInclude = {"OF","THE","AND","OR"};
			innerList = new ArrayList<String>();
			//String[] VALUES = new String[] {};
	    	for(int i=0;i<temp.length;i++){
	    		sb = new StringBuffer("");
	    		int m=i;
	    		//sb2.append("Shift " + (i+1) + " : " );
	    			
	    		for(int j=i;j<temp.length;j++){
	    			//sb2.append(temp[j] + " ");
	    			sb.append(temp[j] + " ");
	    		}
	    		for(int j=0;j<i;j++){
	    			sb.append(temp[j]+" ");
	    			//sb2.append(" " + temp[j]);
	    		}
	    		//out.println();
	    		
	    		
	    		innerList.add(sb.toString());
	    		
	    		if(NoiseEliminator.noiseremove(temp[m])){
	    		finalLists.add(sb.toString());
	    		
	    		indexEntry = new IndexEntry();
	    		indexEntry.setRefMainEntry(mainEntryRef);
	    		indexEntry.setDataLines(sb.toString());
	    		
	    		indexEntryDao.insertIntoIndexEntry(indexEntry);
	    		}
	    		
	    		
	    	}
	    	circularShiftList.add(innerList);
		}
		
		
		results.setFinalLists(new AlphabeticShift().alphaShift(finalLists));
		results.setCircularShiftList(circularShiftList);
		return results;
		
	}
	
	
}

