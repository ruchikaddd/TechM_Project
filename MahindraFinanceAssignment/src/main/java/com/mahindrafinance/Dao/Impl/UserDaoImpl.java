package com.mahindrafinance.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mahindrafinance.Dao.UserDao;
import com.mahindrafinance.Model.Advisor;
import com.mahindrafinance.Model.User;
import com.mahindrafinance.util.Util;

@Repository
public class UserDaoImpl implements UserDao {	
	
	public void saveDatabaseObject(User user)
	{
//		save the data 		
	}

	@Override
	public List<User> getAllDataBaseObjects() {
		List<User> userList =new ArrayList<User>();		
		List<Advisor> advisorsList1 = new ArrayList<>();
		List<Advisor> advisorsList2 = new ArrayList<>();
		
		Advisor advisor1 = new Advisor();
		advisor1.setAdvisorId("advisorId_1");
		advisor1.setAdvisorName("Advisor 1");
		advisor1.setPhotoUrl("profile-pic-url-2");
		
		Advisor advisor2 = new Advisor();
		advisor2.setAdvisorId("advisorId_2");
		advisor2.setAdvisorName("Advisor 2");
		advisor2.setPhotoUrl("profile-pic-url-2");
		advisor2.setBookingId(Util.generateRandomId());
		advisor2.setBookingDateTime("2023-07-14T10:00:00");
		
		Advisor advisor3 = new Advisor();
		advisor3.setAdvisorId("advisorId_3");
		advisor3.setAdvisorName("Advisor 3");
		advisor3.setPhotoUrl("profile-pic-url-3");
		advisor3.setBookingId(Util.generateRandomId());
		advisor3.setBookingDateTime("2023-09-14T10:00:00");
		
		Advisor advisor4 = new Advisor();
		advisor4.setAdvisorId("advisorId_4");
		advisor4.setAdvisorName("Advisor 4");
		advisor4.setPhotoUrl("profile-pic-url-4");
		
		Advisor advisor5 = new Advisor();
		advisor5.setAdvisorId("advisorId_5");
		advisor5.setAdvisorName("Advisor 5");
		advisor5.setPhotoUrl("profile-pic-url-5");
		
		Advisor advisor6 = new Advisor();
		advisor6.setAdvisorId("advisorId_6");
		advisor6.setAdvisorName("Advisor 6");
		advisor6.setPhotoUrl("profile-pic-url-6");
		advisor6.setBookingId(Util.generateRandomId());
		advisor6.setBookingDateTime("2023-09-14T10:00:00");
		
		advisorsList1.add(advisor1);
		advisorsList1.add(advisor2);
		advisorsList1.add(advisor3);
		
		advisorsList2.add(advisor4);
		advisorsList2.add(advisor5);
		advisorsList2.add(advisor6);
		        
        userList.add(new User("1234","Ruchika1", "ruchika.dharmik27@gmail.com", "root" ,advisorsList1));
        userList.add(new User("123456","Ruchika2", "ruchika.dharmik27@gmail.com", "root" ,advisorsList2));
		
        return userList;
	}
}
