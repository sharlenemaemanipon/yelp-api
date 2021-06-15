package com.sample.api.payload;

public class FaceAnnotation {

	private String joyLikelihood;
	private String sorrowLikelihood;
	private String angerLikelihood;
	private String surpriseLikelihood;
	private String underExposedLikelihood;
	private String blurredLikelihood;
	private String headwearLikelihood;

	public String getJoyLikelihood() {
		return joyLikelihood;
	}

	public String getSorrowLikelihood() {
		return sorrowLikelihood;
	}

	public String getAngerLikelihood() {
		return angerLikelihood;
	}

	public String getSurpriseLikelihood() {
		return surpriseLikelihood;
	}

	public String getUnderExposedLikelihood() {
		return underExposedLikelihood;
	}

	public String getBlurredLikelihood() {
		return blurredLikelihood;
	}

	public String getHeadwearLikelihood() {
		return headwearLikelihood;
	}

}
