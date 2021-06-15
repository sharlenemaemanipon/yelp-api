package com.sample.api.payload;

import java.util.List;

public class GoogleVisionApiRequest {

	private List<AnnotateImageRequest> requests;

	public GoogleVisionApiRequest(List<AnnotateImageRequest> requests) {
		super();
		this.requests = requests;
	}

	public List<AnnotateImageRequest> getRequests() {
		return requests;
	}

	public void setRequests(List<AnnotateImageRequest> requests) {
		this.requests = requests;
	}

}
