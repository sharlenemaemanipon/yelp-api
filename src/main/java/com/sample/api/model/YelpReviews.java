package com.sample.api.model;

public class YelpReviews {

	private String id;
	private String url;
	private String text;
	private int rating;
	private String time_created;
	private YelpUser user;

	public String getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public String getText() {
		return text;
	}

	public int getRating() {
		return rating;
	}

	public String getTime_created() {
		return time_created;
	}

	public YelpUser getUser() {
		return user;
	}

}
