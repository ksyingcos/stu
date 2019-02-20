package org.stu.spring.boot.shiro;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.stu.spring.boot.shiro.entity.SysPermission;
import org.stu.spring.boot.shiro.entity.SysRole;
import org.stu.spring.boot.shiro.entity.User;
import org.stu.spring.boot.shiro.service.UserService;

public class ShiroRealm extends AuthorizingRealm {

  @Autowired
  private UserService userService;

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(
      PrincipalCollection principals) {
    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    String username = (String) principals.getPrimaryPrincipal();

    User user = userService.findUserByName(username);

    if (CollectionUtils.isNotEmpty(user.getRoles())) {
      for (SysRole role : user.getRoles()) {
        authorizationInfo.addRole(role.getRole());
        if (CollectionUtils.isNotEmpty(role.getPermissions())) {
          for (SysPermission permission : role.getPermissions()) {
            authorizationInfo.addStringPermission(permission.getName());
          }
        }
      }
    }
    return authorizationInfo;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(
      AuthenticationToken token) throws AuthenticationException {
    String username = (String) token.getPrincipal();
    User user = userService.findUserByName(username);

    if (user == null) {
      return null;
    }
    SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
        user.getUsername(), user.getPassword(),
        ByteSource.Util.bytes(user.getCredentialsSalt()), getName());
    return authenticationInfo;
  }
}
