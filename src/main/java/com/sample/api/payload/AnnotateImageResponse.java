package com.sample.api.payload;

import java.util.List;

public class AnnotateImageResponse {

	List<FaceAnnotation> faceAnnotations;

	public List<FaceAnnotation> getFaceAnnotations() {
		return faceAnnotations;
	}

}
