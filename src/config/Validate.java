package config;

public class Validate {
	public static boolean username(String username) {
		String[] arr = username.split("");
		for (String str : arr) {
			if (str.equals(" ")) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean password(String password) {
		String[] arr = password.split("");
		for (String str : arr) {
			if (str.equals(" ")) {
				return false;
			}
		}
		return true;
	}
}
