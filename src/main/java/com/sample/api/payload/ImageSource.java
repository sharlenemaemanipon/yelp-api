package com.sample.api.payload;

public class ImageSource {

	private String imageUri;

	public ImageSource(String imageUri) {
		super();
		this.imageUri = imageUri;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

}
