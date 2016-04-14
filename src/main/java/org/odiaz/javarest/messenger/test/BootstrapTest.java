package org.odiaz.javarest.messenger.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.odiaz.javarest.messenger.dto.UserDto;

public class BootstrapTest {

	public static void main(String[] args) throws Exception {
		
		List<UserDto> users = new ArrayList<UserDto>();
		
		for(int i=1; i < 500; i++){
			UserDto userDetails = new UserDto();
			userDetails.setUserName("User" + i);
			userDetails.setRegisteredOn(new Date());
			users.add(userDetails);
		}
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {			
			
			session.beginTransaction();			
			users.forEach((user) -> session.save(user) );
			session.getTransaction().commit();	
			
		} catch (Exception e) {			
			session.getTransaction().rollback();
			throw new Exception("Error saving the user" + e.getStackTrace());
		}finally{
			session.close();
		}

	}

}
