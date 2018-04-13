package kisaki.web.entiy.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.stereotype.Component;

@Component
public class MemberAccountRealm extends AuthorizingRealm {
    private String algorithmName = "md5";
    private int hashIterations = 2;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String user = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();


        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String) authenticationToken.getPrincipal();
        String newPassword = new SimpleHash(algorithmName, "123456", ByteSource.Util.bytes(username), hashIterations).toHex();

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username, new SimpleHash(algorithmName, "123456", username, hashIterations).toHex(),
                new SimpleByteSource(username), getName());


        return authenticationInfo;
    }


}
