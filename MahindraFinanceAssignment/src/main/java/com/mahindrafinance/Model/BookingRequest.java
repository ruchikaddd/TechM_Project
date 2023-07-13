package com.mahindrafinance.Model;

public class BookingRequest {
	
	private String bookingId;
	private String bookingDateTime;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(String bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	@Override
	public String toString() {
		return "BookingRequest [bookingId=" + bookingId + ", bookingDateTime=" + bookingDateTime + "]";
	}

}
