package edu.utdallas.arch.index;

import edu.utdallas.arch.model.ResultBean;

public class Characters {

	
private char[][][] characters = null;


public char gchar(int l,int w,int c){
	System.out.println("character " + (c) + " of word " + (w) + " of line " + (l) + " is " + characters[l][w][c]);
	return characters[l][w][c]; 
	
}

public int rword(String a){
	
	return (a.split(" ")).length;
}
    
public ResultBean setChar(String[] lines,int mainEntryRef)
{
	char[][][] characters = new char[lines.length][][];
	String [] word;
	
	try
	{
	for (int k = 0; k < lines.length; k++){
		System.out.println(lines[k]);
		word = lines[k].split(" ");
		System.out.println(word.length);

			for(int j=0; j < word.length;j++ ){
			System.out.println("No of characters in " + (j+1) + " = " + word[j].length());
	
	
				for(int i=0; i < word[j].length(); i++ ){
				System.out.println("Character no " + (i+1) + " " + word[j].charAt(i));
		
				characters[k+1][j+1][i+1] = word[j].charAt(i);
		
				}   
			  
			}

		}
	}catch(Exception e){}
	return new CircularShift().setChar(lines,mainEntryRef);
	
}
 
}
