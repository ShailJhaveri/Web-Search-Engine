package edu.utdallas.arch.index;

import java.util.ArrayList;

public class NoiseEliminator {
	public static boolean noiseremove(String s){
		if(!s.matches("^(OF|THE|AND|OR|A|AN|AS|IS|ARE|of|the|and|or|a|an|as|is|are|Of|The|And|Or|a|An|As|Is|Are)")){
			return true;
		}
			return false;
	}
	
	public static boolean noiseremove(String s,ArrayList<String> inputWords){
		if(inputWords.contains(s)){
			return false;//If Current String is starting with one of the given Words
		}
			return true;
	}
	

}
