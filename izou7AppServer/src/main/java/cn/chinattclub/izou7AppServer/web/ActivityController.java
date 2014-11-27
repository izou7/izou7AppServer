package cn.chinattclub.izou7AppServer.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

import cn.chinattclub.izou7AppServer.dto.UserLoginDto;
import cn.chinattclub.izou7AppServer.entity.User;
import cn.chinattclub.izou7AppServer.realm.StatelessRealm;
import cn.chinattclub.izou7AppServer.service.ActivityService;
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
@RequestMapping("activity")
public class ActivityController {
	

	private static final Logger logger = LoggerFactory
			.getLogger(ActivityController.class);

	private ActivityService activityServiceImpl;
	
	@RequestMapping(value="/activities",method = RequestMethod.GET)
	@ResponseBody
	public RestResponse activities(String text, Integer city, Date startTime, Date endTime, Integer page) {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "查询成功";
		activityServiceImpl.getActivityList(text, city, startTime,endTime, page);
		
		
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		//response.getBody().put("data", dataMap);
		return response;
		  
	  }
}
