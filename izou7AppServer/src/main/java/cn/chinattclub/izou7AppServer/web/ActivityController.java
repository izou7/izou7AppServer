package cn.chinattclub.izou7AppServer.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import cn.chinattclub.izou7AppServer.dto.ActivityInfoInListDto;
import cn.chinattclub.izou7AppServer.dto.UserLoginDto;
import cn.chinattclub.izou7AppServer.entity.Activity;
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

	@Resource
	private ActivityService activityServiceImpl;
	
	@RequestMapping(value="/activities",method = RequestMethod.GET)
	@ResponseBody
	public RestResponse activities(String text, Integer city, Date startTime, Date endTime, Integer page) {
		page = page==null?0:page;
		//startTime = startTime==null?new Date(0):startTime;
		//endTime = endTime==null?new Date():endTime;
		//city = city==null?0:city;
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "查询成功";
		List<ActivityInfoInListDto> activityInfoInListDtos = new ArrayList<ActivityInfoInListDto>();
		try{
			List<Activity> activities = activityServiceImpl.getActivityList(text, city, startTime,endTime, page);
			ActivityInfoInListDto activityInfoInListDto = new ActivityInfoInListDto();
			activityInfoInListDtos = activityInfoInListDto.ConvertToDto(activities);
		}catch(Exception e){
			msg = "内部错误";
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("data", JsonConverter.format(activityInfoInListDtos));
		return response;
		  
	  }
}