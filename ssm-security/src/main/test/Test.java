import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author zpm
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
//        BCrypt.gensalt("$2aee",8,new SecureRandom());
//        System.out.println(b.encode("123"));

        System.out.println(b.matches("123", "$2a$10$DxIY3IppQvbGQVI3V9ptKeTtqF9HU9d3JuCGVHUTpgDwwLfl58qSm"));
    }
}
