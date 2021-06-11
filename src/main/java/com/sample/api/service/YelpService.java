package com.sample.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sample.api.model.YelpReviews;
import com.sample.api.payload.YelpReviewsResponse;

/**
 * Service class for Yelp
 * 
 * @author SharleneMae.Manipon
 *
 */
@Service
@PropertySource(value = "classpath:application.properties")
public class YelpService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${yelp-api-key}")
	private String yelpApiKey;

	@Value("${yelp-business-reviews-url}")
	private String yelpBusinessReviewsUrl;

	public YelpService() {
		super();
	}

	/**
	 * Retrieves the list of Yelp reviews of the given business id parameter
	 * 
	 * @param businessId
	 * @returns the list of Yelp reviews of the given business id parameter
	 */
	public List<YelpReviews> getYelpReviewsByBusinessId(String businessId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + yelpApiKey);

		ResponseEntity<YelpReviewsResponse> result = restTemplate.exchange(
				String.format(yelpBusinessReviewsUrl, businessId), HttpMethod.GET, new HttpEntity(headers),
				YelpReviewsResponse.class);

		if (!result.getStatusCode().equals(HttpStatus.OK)) {
			return null;
		}
		return result.getBody().getReviews();
	}

}
