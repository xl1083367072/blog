import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class TestTrim {

    @Test
    public void run(){
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String password = new SimpleHash("md5", "root", "salt",2).toString();
        System.out.println(password);
    }

}
