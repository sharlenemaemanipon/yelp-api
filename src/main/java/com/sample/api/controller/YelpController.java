package com.sample.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.api.model.YelpReviews;
import com.sample.api.payload.ApiResponse;
import com.sample.api.service.YelpService;

/**
 * Controller class for Yelp
 * 
 * @author SharleneMae.Manipon
 *
 */
@RestController
@RequestMapping("/yelp")
public class YelpController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private YelpService yelpService;

	@Autowired
	public YelpController(YelpService yelpService) {
		super();
		this.yelpService = yelpService;
	}

	/**
	 * Endpoint for retrieving the list of reviews of the given business id
	 * 
	 * @param businessId
	 * @returns a JSON string format response
	 */
	@GetMapping("/businesses/{businessId}/reviews")
	public ResponseEntity<ApiResponse> getYelpReviewsByBusinessId(@PathVariable String businessId) {
		long startTime = System.nanoTime();
		logger.info("Rx: GET /yelp/businesses/{}/reviews", businessId);

		try {
			List<YelpReviews> data = yelpService.getYelpReviewsByBusinessId(businessId);
			logger.info("Tx: GET /yelp/businesses/{}/reviews, Elapsed={}ms, 200", businessId,
					(System.nanoTime() - startTime) / 1000000.0);
			return new ResponseEntity<>(new ApiResponse(data), HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Tx: GET /yelp/businesses/{}/reviews, Elapsed={}ms, 400, {}", businessId,
					(System.nanoTime() - startTime) / 1000000.0, e.getMessage());
			return new ResponseEntity<>(new ApiResponse(null, e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

}
