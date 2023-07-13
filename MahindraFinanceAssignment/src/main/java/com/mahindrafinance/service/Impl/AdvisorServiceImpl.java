package com.mahindrafinance.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindrafinance.Dao.AdvisorDao;
import com.mahindrafinance.Dao.UserDao;
import com.mahindrafinance.Model.Advisor;
import com.mahindrafinance.Model.BookingRequest;
import com.mahindrafinance.Model.User;
import com.mahindrafinance.service.AdvisorService;
import com.mahindrafinance.util.Util;

@Service
public class AdvisorServiceImpl implements AdvisorService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AdvisorDao advisorDao;
	

	private static final Logger log = LoggerFactory.getLogger(AdvisorServiceImpl.class);

	public void saveDatabaseObject(Advisor advisor) {
		System.out.println(" advisor :" + advisor);
		Advisor dataToBeStored = new Advisor();
		dataToBeStored.setAdvisorName(advisor.getAdvisorName());
		dataToBeStored.setPhotoUrl(advisor.getPhotoUrl());

		System.out.println("name " + dataToBeStored.getAdvisorName());
		System.out.println("url " + dataToBeStored.getPhotoUrl());

		// advisorDao.saveDatabaseObject(dataToBeStored);

	}

	@Override
	public List<Advisor> fetchAdvisorsByUserId(String userId) {
		User userRecord = getUserByUserId(userId);
		List<Advisor> advisorList = userRecord.getAdvisorsAssignedToUser();
		return advisorList;
	}

	public User getUserByUserId(String userId) {

		List<User> listUsers = userDao.getAllDataBaseObjects();
		System.out.println("Size of Users : " + listUsers.size());

		User user = new User();

		if (userId != null && !userId.isEmpty()) {
			user = listUsers.stream().filter(u -> u.getUserId().equals(userId)).findFirst().orElse(null);
		}
		return user;
	}

	@Override
	public void bookCallWithAdvisor(String userId, String advisorId, BookingRequest request) {

		String bookingTime = request.getBookingDateTime();
		System.out.println("bookingTime 1:" + bookingTime);
//		BookingRequest bookingRequestObject = createBookingRequestObject(bookingTime);

		User userRecord = getUserByUserId(userId);

		Advisor advisorRecord = userRecord.getAdvisorsAssignedToUser().stream()
					.filter(u -> u.getAdvisorId().equals(advisorId)).findFirst().orElse(null);

			advisorRecord.setBookingId(Util.generateRandomId());
			advisorRecord.setBookingDateTime(bookingTime);
			System.out.println("advisor record : " + advisorRecord.toString());
			
			advisorDao.saveDatabaseObject(advisorRecord);
	}

	public BookingRequest createBookingRequestObject(String bookingTime) {

		BookingRequest bookingRequestObject = new BookingRequest();
		String formatPattern = "yyyy-MM-dd'T'HH:mm:ss";

		System.out.println("bookingTime :" + bookingTime);
		bookingRequestObject.setBookingId(Util.generateRandomId());

		if (bookingTime != null && !bookingTime.isEmpty()) {
			boolean isValid = Util.isValidDateTime(bookingTime, formatPattern);

			if (isValid) {
				bookingRequestObject.setBookingDateTime(bookingTime);
				System.out.println("Booking request object : " + bookingRequestObject.toString());
			} else {
				log.error("Invalid formate of  date and time");
			}

			return bookingRequestObject;
		} else {
			log.error("Provided booking date and time is invalid.");
			return bookingRequestObject;
		}
	}

	@Override
	public List<Advisor> fetchBookedCalls(String userId) {
		User userRecord = getUserByUserId(userId);

		List<Advisor> advisorList = userRecord.getAdvisorsAssignedToUser();
		System.out.println("advisorList size : " + advisorList.size());

		return advisorList.stream()
				.filter(advisor -> advisor.getBookingDateTime() != null && !advisor.getBookingDateTime().isEmpty())
				.collect(Collectors.toList());
	}

}
