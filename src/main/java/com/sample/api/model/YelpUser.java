package com.sample.api.model;

import com.sample.api.payload.FaceAnnotation;

public class YelpUser {

	private String id;
	private String profile_url;
	private String image_url;
	private String name;
	private FaceAnnotation image_emotion;

	public String getId() {
		return id;
	}

	public String getProfile_url() {
		return profile_url;
	}

	public String getImage_url() {
		return image_url;
	}

	public String getName() {
		return name;
	}

	public FaceAnnotation getImage_emotion() {
		return image_emotion;
	}

	public void setImage_emotion(FaceAnnotation image_emotion) {
		this.image_emotion = image_emotion;
	}

}
