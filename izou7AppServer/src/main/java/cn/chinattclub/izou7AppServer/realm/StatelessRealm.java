package cn.chinattclub.izou7AppServer.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.chinattclub.izou7AppServer.dto.StatelessTokenDto;
import cn.chinattclub.izou7AppServer.service.UserService;
import cn.chinattclub.izou7AppServer.util.HmacSHA256Utils;

/**
 * 无状态域
 * @author ZY
 *
 */
public class StatelessRealm extends AuthorizingRealm {
	
	private static final Logger logger = LoggerFactory
			.getLogger(StatelessRealm.class);
	
	@Resource
	private UserService userServiceImpl;
	
    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持StatelessToken类型的Token
        return token instanceof StatelessTokenDto;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //根据用户名查找角色，请根据需求实现
    	 SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        StatelessTokenDto statelessToken = (StatelessTokenDto) token;
        String username = statelessToken.getUsername();
        try{
         	 //根据用户名获取密钥（和客户端的一样）
        	 String key = userServiceImpl.getKey(username);
             //在服务器端生成客户端参数消息摘要
             String serverDigest = HmacSHA256Utils.digest(key, statelessToken.getParams());
             //然后进行客户端消息摘要和服务器端消息摘要的匹配
             return new SimpleAuthenticationInfo(
                     username,
                     serverDigest,
                     getName());
        }catch(Exception e){
        	logger.error("获取用户信息失败！",e);
        	throw new AuthenticationException();
        }
    }
}
