package com.mahindrafinance.service;

import java.util.List;

import com.mahindrafinance.Model.Advisor;
import com.mahindrafinance.Model.BookingRequest;

public interface AdvisorService {

	void saveDatabaseObject(Advisor advisor);

	public List<Advisor> fetchAdvisorsByUserId(String userId);

	void bookCallWithAdvisor(String userId, String advisorId, BookingRequest request);

	List<Advisor> fetchBookedCalls(String userId);
}
