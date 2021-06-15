package com.sample.api.payload;

public class Image {
	private ImageSource source;

	public Image(ImageSource source) {
		super();
		this.source = source;
	}

	public ImageSource getSource() {
		return source;
	}

	public void setSource(ImageSource source) {
		this.source = source;
	}

}
