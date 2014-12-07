package cn.chinattclub.izou7AppServer.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7AppServer.dto.UserInfoUpdateDto;
import cn.chinattclub.izou7AppServer.dto.UserLoginDto;
import cn.chinattclub.izou7AppServer.dto.UserModifyPasswordDto;
import cn.chinattclub.izou7AppServer.dto.UserRegistInfoDto;
import cn.chinattclub.izou7AppServer.entity.User;
import cn.chinattclub.izou7AppServer.realm.StatelessRealm;
import cn.chinattclub.izou7AppServer.service.AuthenticateService;
import cn.chinattclub.izou7AppServer.service.TokenService;
import cn.chinattclub.izou7AppServer.service.UserInfoService;
import cn.chinattclub.izou7AppServer.service.UserService;
import cn.zy.commons.util.json.JsonConverter;
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
	
	@Resource
	private AuthenticateService authenticateServiceImpl;

	@Autowired  
    private HttpServletRequest request;
	
	@Resource
	private TokenService tokenServiceImpl;
	
	@Resource
	private UserInfoService userInfoServiceImpl;
	
//    @RequestMapping(value="/login",method = RequestMethod.POST)
//    @ResponseBody
//    public RestResponse login(@RequestBody User user) {
//    	RestResponse response = new RestResponse();
//		int statusCode = ResponseStatusCode.OK;
//		String msg = "登录成功！";
//		Subject currentUser = SecurityUtils.getSubject();
//		UsernamePasswordToken token = new UsernamePasswordToken(
//				user.getUsername(), user.getPassword());
//		try {
//			currentUser.login(token);
//			//生成密钥
//			userServiceImpl.createKey(user);
//			user = userServiceImpl.findByUsername(user.getUsername());
//			response.getBody().put("key",user.getKey());
//		} catch (UnknownAccountException uae) {
//			msg = "用户名不存在！";
//			logger.error("用户名【"+user.getUsername()+"】不存在！",uae);
//			statusCode = ResponseStatusCode.UNAUTHORIZED;
//		} catch (IncorrectCredentialsException ice) {
//			msg = "密码错误！";
//			logger.error("用户【"+user.getUsername()+"】密码错误！",ice);
//			statusCode = ResponseStatusCode.UNAUTHORIZED;
//		} catch (LockedAccountException lae) {
//			msg = "用户已经被锁定不能登录，请与管理员联系！";
//			logger.error("用户【"+user.getUsername()+"】被锁定！",lae);
//			statusCode = ResponseStatusCode.UNAUTHORIZED;
//		} catch (ExcessiveAttemptsException eae) {
//			msg = "错误次数过多！";
//			logger.error("用户【"+user.getUsername()+"】错误次数过多！",eae);
//			statusCode = ResponseStatusCode.UNAUTHORIZED;
//		} catch (AuthenticationException ae) {
//			logger.error("用户【"+user.getUsername()+"】其他登陆错误！",ae);
//			msg = "其他的登录错误！";
//			statusCode = ResponseStatusCode.UNAUTHORIZED;
//		}
//		response.setMessage(msg);
//		response.setStatusCode(statusCode);
//		return response;
//    }
	
	
	  @RequestMapping(value="/login",method = RequestMethod.POST)
	  @ResponseBody
	  public RestResponse login(@RequestBody UserLoginDto userLoginDto) {
		  RestResponse response = new RestResponse();
		  int statusCode = ResponseStatusCode.OK;
		  String msg = "登录成功！";
		  Map<String,String> dataMap = new HashMap<String,String>();
		  if (userLoginDto.getSource()!=0){
				logger.debug("其他系统用户登陆:"+userLoginDto.getSource());
				response.setMessage(msg);
				response.setStatusCode(statusCode);
				response.getBody().put("data", dataMap);
				return response;
		  }
		  
		  try{
			  if (!userServiceImpl.isUserExists(userLoginDto.getUsername())){
				  	logger.error("用户【"+userLoginDto.getUsername()+"】不存在");
				  	msg = "用户不存在";
					statusCode = ResponseStatusCode.UNAUTHORIZED;
			  }else if(!userServiceImpl.isPass(userLoginDto)){
				  	logger.error("用户【"+userLoginDto.getUsername()+"】登陆失败");
				  	msg = "登陆失败";
					statusCode = ResponseStatusCode.UNAUTHORIZED;
			  }else {
				  	logger.debug("用户【"+userLoginDto.getUsername()+"】登陆成功");
					String token = userServiceImpl.saveToken(userLoginDto);
					dataMap.put("token", token);
					//data = JsonConverter.format(dataMap);
			  }
		  }catch(Exception e){
			  msg = "内部错误";
			  statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			  logger.error(e.getMessage());
		  }
		  response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("data", dataMap);
		return response;
		  
	  }
	  
	  
	  @RequestMapping(value="/user",method = RequestMethod.POST)
	  @ResponseBody
	  public RestResponse regist(@RequestBody UserRegistInfoDto userRegistInfoDto) {
		  RestResponse response = new RestResponse();
		  int statusCode = ResponseStatusCode.OK;
		  String msg = "注册成功！";
		  try{
			  if (userServiceImpl.isUserExists(userRegistInfoDto.getUsername())){	
				  	logger.error("用户【"+userRegistInfoDto.getUsername()+"】已存在");
				  	msg = "用户已存在";
					statusCode = ResponseStatusCode.FORBIDDEN;
			  }else {
				  userServiceImpl.addUser(userRegistInfoDto);
			  }
		  }catch(Exception e){
			  msg = "内部错误";
			  statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			  logger.error(e.getMessage());
		  }
		  response.setMessage(msg);
		response.setStatusCode(statusCode);
		return response;
		  
	  }
	  
	  @RequestMapping(value="/user",method = RequestMethod.PUT)
	  @ResponseBody
	  public RestResponse modify(@RequestBody UserModifyPasswordDto userModifyPasswordDto) {
		  
		  String token = request.getHeader("token");
		  User user = authenticateServiceImpl.getUserName(token);
		  
		  RestResponse response = new RestResponse();
		  int statusCode = ResponseStatusCode.OK;
		  String msg = "修改成功！";
		  
		  try{
			  String oldEncryptPassword = userServiceImpl.getEncryptPassword(userModifyPasswordDto.getOldPassword(),user);
			  String newEncryptPassword = userServiceImpl.getEncryptPassword(userModifyPasswordDto.getNewPassword(),user);
			  if (user==null){	
				  logger.error("用户不存在");
				  msg = "用户不存在";
				  statusCode = ResponseStatusCode.FORBIDDEN;
			  }else if(!user.getPassword().equals(oldEncryptPassword)){
				  logger.error("旧密码不正确");
				  msg = "旧密码不正确";
				  statusCode = ResponseStatusCode.FORBIDDEN;
			  }else{
				  userServiceImpl.updatePasswordNew(user, newEncryptPassword);
			  }
		  }catch(Exception e){
			  msg = "内部错误";
			  statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			  logger.error(e.getMessage());
		  }
		  response.setMessage(msg);
		  response.setStatusCode(statusCode);
		  return response;
		  
	  }
	  
	  
	  @RequestMapping(value="/logout",method = RequestMethod.PUT)
	  @ResponseBody
	  public RestResponse logout() {
		  
		  String token = request.getHeader("token");
		  User user = authenticateServiceImpl.getUserName(token);
		  
		  RestResponse response = new RestResponse();
		  int statusCode = ResponseStatusCode.OK;
		  String msg = "登出成功！";

		  try{
			  if (user==null){	
				  logger.error("用户不存在");
				  msg = "用户不存在";
				  statusCode = ResponseStatusCode.FORBIDDEN;
			  }else{
				  tokenServiceImpl.deleteToken(token);
			  }
		  }catch(Exception e){
			  msg = "内部错误";
			  statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			  logger.error(e.getMessage());
		  }
		  response.setMessage(msg);
		  response.setStatusCode(statusCode);
		  return response;
	  }
	  
	  
	  @RequestMapping(value="/currentUser",method = RequestMethod.GET)
	  @ResponseBody
	  public RestResponse currentUser() {

		  RestResponse response = new RestResponse();
		  int statusCode = ResponseStatusCode.OK;
		  String msg = "获取成功！";
		  User user = null;
		  Map<String,Object> retMap = new HashMap<String,Object>();
		  try{
			  String token = request.getHeader("token");
			  user = authenticateServiceImpl.getUserName(token);
			  retMap.put("id", user.getId());
			  retMap.put("username", user.getUsername());
			  retMap.put("source", user.getSource());
		  }catch(Exception e){
			  msg = "内部错误";
			  statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			  logger.error(e.getMessage());
		  }
		  response.setMessage(msg);
		  response.setStatusCode(statusCode);
		  response.getBody().put("data",retMap);
		  return response;
	  }
	  
	  @RequestMapping(value="/userInfo",method = RequestMethod.PUT)
	  @ResponseBody
	  public RestResponse modifyUserInfo(@RequestBody UserInfoUpdateDto userInfoUpdateDto) {

		  RestResponse response = new RestResponse();
		  int statusCode = ResponseStatusCode.OK;
		  String msg = "修改成功！";
		  try{
			  String token = request.getHeader("token");
			  User user = authenticateServiceImpl.getUserName(token);
			  if (user==null){	
				  logger.error("用户不存在");
				  msg = "用户不存在";
				  statusCode = ResponseStatusCode.FORBIDDEN;
			  }else{
				  userInfoServiceImpl.updateUserInfo(user.getUserInfo(),userInfoUpdateDto);
			  }
			  
		  }catch(Exception e){
			  msg = "内部错误";
			  statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			  logger.error(e.getMessage());
		  }
		  response.setMessage(msg);
		  response.setStatusCode(statusCode);
		  return response;
	  }
	  
	  @RequestMapping(value="/userInfo",method = RequestMethod.GET)
	  @ResponseBody
	  public RestResponse getUserInfo() {
		  UserInfoUpdateDto userInfoUpdateDto = null;
		  RestResponse response = new RestResponse();
		  int statusCode = ResponseStatusCode.OK;
		  String msg = "获取成功！";
		  try{
			  String token = request.getHeader("token");
			  User user = authenticateServiceImpl.getUserName(token);
			  if (user==null){	
				  logger.error("用户不存在");
				  msg = "用户不存在";
				  statusCode = ResponseStatusCode.FORBIDDEN;
			  }else{
				  userInfoUpdateDto=userInfoServiceImpl.getUserInfo(user.getUserInfo());
			  }
			  
		  }catch(Exception e){
			  msg = e.getLocalizedMessage();
			  statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			  logger.error(e.getMessage());
		  }
		  response.setMessage(msg);
		  response.setStatusCode(statusCode);
		  response.getBody().put("data",userInfoUpdateDto);
		  return response;
	  }
	  
}
