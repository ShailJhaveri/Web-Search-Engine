package edu.utdallas.arch.model;

import java.util.ArrayList;

public class ResultBean {

	private ArrayList<String> finalLists = new ArrayList<String>();
	
	private ArrayList<ArrayList<String>> circularShiftList = new ArrayList<ArrayList<String>>();

	
	public ArrayList<String> getFinalLists() {
		return finalLists;
	}
	public void setFinalLists(ArrayList<String> finalLists) {
		this.finalLists = finalLists;
	}
	public ArrayList<ArrayList<String>> getCircularShiftList() {
		return circularShiftList;
	}
	public void setCircularShiftList(ArrayList<ArrayList<String>> circularShiftList) {
		this.circularShiftList = circularShiftList;
	}
	
}
