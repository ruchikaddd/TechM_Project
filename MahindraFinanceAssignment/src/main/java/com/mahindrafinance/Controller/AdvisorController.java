package com.mahindrafinance.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mahindrafinance.Model.Advisor;
import com.mahindrafinance.Model.BookingRequest;
import com.mahindrafinance.service.AdvisorService;

@RestController
public class AdvisorController {

	private static final Logger log = LoggerFactory.getLogger(AdvisorController.class);

	@Autowired
	private AdvisorService advisorService;

	@PostMapping("/admin/advisor")
	public ResponseEntity saveAdvisor(@RequestBody Advisor advisor) {

		System.out.println("im here" + advisor);
		try {

			if (advisor.getAdvisorName() == null || advisor.getPhotoUrl() == null) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			} else {
				advisorService.saveDatabaseObject(advisor);
				return new ResponseEntity(HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error occured while saving data");
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/user/{userId}/advisor")
	public ResponseEntity<?> getAdvisors(@PathVariable String userId) {
		// Fetch the list of advisors
		List<Advisor> advisors = advisorService.fetchAdvisorsByUserId(userId);
		return ResponseEntity.ok(advisors);
	}
	
	@PostMapping("/user/{userId}/advisor/{advisorId}")
    public ResponseEntity<?> bookCall(@PathVariable String userId, @PathVariable String advisorId,@RequestBody BookingRequest bookingRequest) {
    
		advisorService.bookCallWithAdvisor(userId,advisorId,bookingRequest);
        return ResponseEntity.ok().build();
    }
	
	@GetMapping("/user/{userId}/advisor/booking")
    public ResponseEntity<List<Advisor>> getBookedCalls(@PathVariable String userId) {
       
        List<Advisor> bookedCalls = advisorService.fetchBookedCalls(userId);
        return ResponseEntity.ok(bookedCalls);
    }
	 
}
