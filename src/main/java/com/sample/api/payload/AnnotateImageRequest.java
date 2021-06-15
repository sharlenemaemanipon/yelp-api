package com.sample.api.payload;

import java.util.List;

public class AnnotateImageRequest {

	private Image image;
	private List<Feature> features;

	public AnnotateImageRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnnotateImageRequest(Image image, List<Feature> features) {
		super();
		this.image = image;
		this.features = features;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

}
