package edu.utdallas.arch.model;

public class MainEntry {

	
	private int id;
	private String url;
	private String data;
	private int frequency;
	private int priority;
	
	public MainEntry()
	{
		
	}
	
	public MainEntry(int id, String url, String data, int frequency, int priority) {
		super();
		this.id = id;
		this.url = url;
		this.data = data;
		this.frequency = frequency;
		this.priority = priority;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "MainEntry [id=" + id + ", url=" + url + ", data=" + data + ", frequency=" + frequency + ", priority="
				+ priority + "]";
	}
	
	
}
