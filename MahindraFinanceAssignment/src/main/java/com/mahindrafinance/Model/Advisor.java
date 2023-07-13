package com.mahindrafinance.Model;

public class Advisor extends BookingRequest {

	private String advisorId;
	private String advisorName;
	private String photoUrl;

	public Advisor(String advisorId, String advisorName, String photoUrl, BookingRequest bookingRequest) {
		super();
		this.advisorId = advisorId;
		this.advisorName = advisorName;
		this.photoUrl = photoUrl;
	}
	
	public Advisor(String advisorId, String advisorName, String photoUrl) {
		super();
		this.advisorId = advisorId;
		this.advisorName = advisorName;
		this.photoUrl = photoUrl;
	}

	public Advisor() {
		// TODO Auto-generated constructor stub
	}	

	public String getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(String advisorId) {
		this.advisorId = advisorId;
	}

	public String getAdvisorName() {
		return advisorName;
	}

	public void setAdvisorName(String advisorName) {
		this.advisorName = advisorName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		Advisor advisor;

		private Builder() {
			this.advisor = new Advisor();
		}

		public Builder with_advisorId(String advisorId) {
			advisor.advisorId = advisorId;
			return this;
		}

		public Builder with_advisorName(String advisorName) {
			advisor.advisorName = advisorName;
			return this;
		}

		public Builder with_photoUrl(String photoUrl) {
			advisor.photoUrl = photoUrl;
			return this;
		}

		public Advisor build() {
			return advisor;
		}
	}

}
