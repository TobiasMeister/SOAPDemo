package xyz.meistertobias.soap.server;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebService
public class UserService {
	
	private List<User> users = new ArrayList<>();
	
	public List<User> getUsers() {
		return users;
	}
	
	public User getUser(String nickname) {
		return findUser(nickname).orElse(null);
	}
	
	public void addUser(User user) {
		if (!users.contains(user)) users.add(user);
	}
	
	public void deleteUser(String nickname) {
		findUser(nickname).ifPresent(users::remove);
	}
	
	private Optional<User> findUser(String nickname) {
		return users.stream().filter(user -> user.getNickname().equals(nickname)).findFirst();
	}
}
