package edu.utdallas.arch.model;

public class IndexEntry {

	
	private int id;
	private String dataLines;
	private int refMainEntry;
	
	
	public IndexEntry(){}
	
	public IndexEntry(int id, String dataLines, int refMainEntry) {
		super();
		this.id = id;
		this.dataLines = dataLines;
		this.refMainEntry = refMainEntry;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDataLines() {
		return dataLines;
	}


	public void setDataLines(String dataLines) {
		this.dataLines = dataLines;
	}


	public int getRefMainEntry() {
		return refMainEntry;
	}


	public void setRefMainEntry(int refMainEntry) {
		this.refMainEntry = refMainEntry;
	}


	@Override
	public String toString() {
		return "IndexEntry [id=" + id + ", dataLines=" + dataLines + ", refMainEntry=" + refMainEntry + "]";
	}
	
	
}
