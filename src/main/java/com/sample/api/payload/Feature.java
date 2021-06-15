package com.sample.api.payload;

public class Feature {

	private String type;
	private int maxResults;

	public Feature(String type, int maxResults) {
		super();
		this.type = type;
		this.maxResults = maxResults;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

}
