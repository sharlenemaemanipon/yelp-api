package com.sample.api.service;

import java.util.Arrays;
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
import com.sample.api.payload.AnnotateImageRequest;
import com.sample.api.payload.FaceAnnotation;
import com.sample.api.payload.Feature;
import com.sample.api.payload.GoogleVisionApiRequest;
import com.sample.api.payload.GoogleVisionApiResponse;
import com.sample.api.payload.Image;
import com.sample.api.payload.ImageSource;
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

	@Value("${google-vision-api-key}")
	private String googleVisionApiKey;

	@Value("${google-vision-image-annotate-url}")
	private String googleVisionImageAnnotateUrl;

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

		// get request to yelp api
		ResponseEntity<YelpReviewsResponse> result = restTemplate.exchange(
				String.format(yelpBusinessReviewsUrl, businessId), HttpMethod.GET, new HttpEntity(headers),
				YelpReviewsResponse.class);
		if (!result.getStatusCode().equals(HttpStatus.OK)) {
			return null;
		}

		List<YelpReviews> reviews = result.getBody().getReviews();
		for (YelpReviews review : reviews) {
			GoogleVisionApiRequest googleVisionApiRequest = new GoogleVisionApiRequest(
					Arrays.asList(new AnnotateImageRequest(new Image(new ImageSource(review.getUser().getImage_url())),
							Arrays.asList(new Feature("FACE_DETECTION", 50)))));
			// post request to google vision api
			ResponseEntity<GoogleVisionApiResponse> googleResult = restTemplate.exchange(String.format(googleVisionImageAnnotateUrl, googleVisionApiKey), HttpMethod.POST,
					new HttpEntity<>(googleVisionApiRequest), GoogleVisionApiResponse.class);
			FaceAnnotation image_emotion = null;
			if (googleResult.getStatusCode().equals(HttpStatus.OK)) {
				int index = 0;
				try {
					image_emotion = googleResult.getBody().getResponses().get(index).getFaceAnnotations().get(index);
				} catch (Exception e) {
					image_emotion = null;
				}
			}
			review.getUser().setImage_emotion(image_emotion);
		}
		return reviews;
	}

}
