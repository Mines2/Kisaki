package util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
    private static String algorithmName = "md5";
    private static int hashIterations = 2;

    public static String getNewPassword(String password , String username){
        return new SimpleHash(algorithmName, password, ByteSource.Util.bytes(username), hashIterations).toHex();
    }
}
