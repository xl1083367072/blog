package com.xl.realm;

import com.xl.pojo.Blogger;
import com.xl.service.BloggerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseRealm extends AuthorizingRealm {

    @Autowired
    private BloggerService bloggerService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        获得令牌对象
        UsernamePasswordToken t = (UsernamePasswordToken) token;
//        获得登录的用户名
        String username = t.getPrincipal().toString();
//        去数据库中查询此用户的密码和盐
        Blogger blogger = bloggerService.findByUserName(username);
        String password = blogger.getPassword();
        String salt = blogger.getSalt();
//        将用户名密码和盐让shiro自己去验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes(salt), getName());
        return authenticationInfo;
    }
}
