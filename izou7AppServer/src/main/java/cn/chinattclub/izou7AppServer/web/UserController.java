package cn.chinattclub.izou7AppServer.web;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7AppServer.entity.User;
import cn.chinattclub.izou7AppServer.realm.StatelessRealm;
import cn.chinattclub.izou7AppServer.service.UserService;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;


/**
 * 
 * 用户控制器
 *
 * @author zhangying.
 *         Created 2014-11-12.
 */
@Controller
@RequestMapping("user")
public class UserController {
	

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
	
	
	@Resource
	private UserService userServiceImpl;

    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public RestResponse login(@RequestBody User user) {
    	RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "登录成功！";
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(
				user.getUsername(), user.getPassword());
		try {
			currentUser.login(token);
			//生成密钥
			userServiceImpl.createKey(user);
			user = userServiceImpl.findByUsername(user.getUsername());
			response.getBody().put("key",user.getKey());
		} catch (UnknownAccountException uae) {
			msg = "用户名不存在！";
			logger.error("用户名【"+user.getUsername()+"】不存在！",uae);
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		} catch (IncorrectCredentialsException ice) {
			msg = "密码错误！";
			logger.error("用户【"+user.getUsername()+"】密码错误！",ice);
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		} catch (LockedAccountException lae) {
			msg = "用户已经被锁定不能登录，请与管理员联系！";
			logger.error("用户【"+user.getUsername()+"】被锁定！",lae);
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		} catch (ExcessiveAttemptsException eae) {
			msg = "错误次数过多！";
			logger.error("用户【"+user.getUsername()+"】错误次数过多！",eae);
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		} catch (AuthenticationException ae) {
			logger.error("用户【"+user.getUsername()+"】其他登陆错误！",ae);
			msg = "其他的登录错误！";
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		return response;
    }
}
