package com.sample.api.payload;

import java.util.List;

import com.sample.api.model.YelpReviews;

public class YelpReviewsResponse {

	private List<YelpReviews> reviews;
	private int total;
	private List<String> possible_languages;

	public List<YelpReviews> getReviews() {
		return reviews;
	}

	public int getTotal() {
		return total;
	}

	public List<String> getPossible_languages() {
		return possible_languages;
	}

}
