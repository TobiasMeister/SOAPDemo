package xyz.meistertobias.soap.server;

import xyz.meistertobias.soap.Config;

import javax.xml.ws.Endpoint;

public class ServerUI {
	
	public static void main(String[] args) {
		var calcService = new CalcService();
		var userService = new UserService();
		Endpoint.publish("http://127.0.0.1:" + Config.DEFAULT_PORT + "/calc", calcService);
		Endpoint.publish("http://127.0.0.1:" + Config.DEFAULT_PORT + "/user", userService);
	}
}
