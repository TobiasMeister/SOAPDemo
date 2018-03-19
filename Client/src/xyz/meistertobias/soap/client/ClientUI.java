package xyz.meistertobias.soap.client;

import xyz.meistertobias.soap.client.gen.calc.CalcServiceService;
import xyz.meistertobias.soap.client.gen.user.User;
import xyz.meistertobias.soap.client.gen.user.UserServiceService;

public class ClientUI {
	
	public static void main(String[] args) {
		
		// SOAP: calc
		{
			var calcService = new CalcServiceService();
			var calc = calcService.getCalcServicePort();
			
			// add
			System.out.println(calc.add(5, 9));
			
			// subtract
			System.out.println(calc.subtract(5, 9));
			
			// multiply
			System.out.println(calc.multiply(5, 9));
			
			// divide
			System.out.println(calc.divide(5, 9));
		}

		System.out.println();

		// SOAP: user
		{
			var userServiceService = new UserServiceService();
			var userServicePort = userServiceService.getUserServicePort();
			
			// addUser
			var user = new User();
			user.setFirstName("Marcel");
			user.setLastName("Davis");
			user.setNickname("Leiter für Kundenzufriedenheit");
			userServicePort.addUser(user);
			
			// getUsers
			userServicePort.getUsers().forEach(u -> System.out.println(userToString(u)));
			
			// getUser
			System.out.println(userToString(userServicePort.getUser("Leiter für Kundenzufriedenheit")));
			
			// deleteUser
			userServicePort.deleteUser("Leiter für Kundenzufriedenheit");
		}
	}
	
	private static String userToString(User user) {
		return "User{" + "firstName='" + user.getFirstName() + '\'' + ", lastName='" + user.getLastName() + '\'' + ", nickname='" + user
				.getNickname() + '\'' + '}';
	}
}
