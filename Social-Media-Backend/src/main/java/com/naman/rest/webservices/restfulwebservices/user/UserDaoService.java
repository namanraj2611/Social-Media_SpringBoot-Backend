package com.naman.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int userCount=0;

	static {
		users.add(new User(++userCount, "Naman", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "Raj", LocalDate.now().minusYears(25)));
		users.add(new User(++userCount, "Sharma", LocalDate.now().minusYears(20)));
	}
	
	
	public List<User> findAll(){
		return users;
	}

	public User findOne(int id) {
		
		Predicate<? super User> predicate= user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User saveUser(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
		
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate=user -> user.getId().equals(id) ;
		users.removeIf(predicate);
	}
}
