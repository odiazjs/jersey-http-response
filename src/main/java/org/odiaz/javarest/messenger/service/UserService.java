package org.odiaz.javarest.messenger.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.odiaz.javarest.messenger.contracts.IUserContract;
import org.odiaz.javarest.messenger.dto.UserDto;

public class UserService implements IUserContract {

	@Override
	public List<UserDto> getAllUsers() throws Exception {

		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {			
			
			session.beginTransaction();
			List<UserDto> users = session.createCriteria(UserDto.class).list();
			return users;
			
		} catch (Exception e) {			
			
			session.getTransaction().rollback();
			throw new Exception("Error getting the users" + e.getStackTrace());
			
		}finally{
			
			session.close();
			
		}
		
	}

}
