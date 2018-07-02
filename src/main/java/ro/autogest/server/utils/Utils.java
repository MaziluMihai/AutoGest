package ro.autogest.server.utils;

import java.util.Random;

import org.springframework.util.DigestUtils;

public class Utils {

	public static String hashPassword(String password) {
		return DigestUtils.md5DigestAsHex(password.getBytes());
	}

	public static Integer generateToken() {
		Random rnd = new Random();
		return 100000 + rnd.nextInt(900000);
	}

}
