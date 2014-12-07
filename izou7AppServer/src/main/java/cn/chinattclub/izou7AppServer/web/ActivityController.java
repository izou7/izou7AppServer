package cn.chinattclub.izou7AppServer.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7AppServer.dto.AcitivityCooperationDto;
import cn.chinattclub.izou7AppServer.dto.AcitivityCrowdfundingDto;
import cn.chinattclub.izou7AppServer.dto.ActivityDetailInfoDto;
import cn.chinattclub.izou7AppServer.dto.ActivityInfoInListDto;
import cn.chinattclub.izou7AppServer.dto.ActivityMessageInfoDto;
import cn.chinattclub.izou7AppServer.dto.ActivityMessagePostDto;
import cn.chinattclub.izou7AppServer.dto.ActivityRegistrationDto;
import cn.chinattclub.izou7AppServer.dto.ActivityScheduleInfoDto;
import cn.chinattclub.izou7AppServer.dto.UserInfoInListDto;
import cn.chinattclub.izou7AppServer.dto.UserLoginDto;
import cn.chinattclub.izou7AppServer.entity.Activity;
import cn.chinattclub.izou7AppServer.entity.User;
import cn.chinattclub.izou7AppServer.realm.StatelessRealm;
import cn.chinattclub.izou7AppServer.service.ActivityService;
import cn.chinattclub.izou7AppServer.service.AuthenticateService;
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
	
	@Resource
	private AuthenticateService authenticateServiceImpl;

	@Autowired  
    private HttpServletRequest request;
	
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
			logger.error(e.getMessage());
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("data", activityInfoInListDtos);
		return response;
		  
	  }
	
	@RequestMapping(value="/myComingActivities",method = RequestMethod.GET)
	@ResponseBody
	public RestResponse myComingActivities(Integer page){
		page = page==null?0:page;
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "查询成功";
		List<ActivityInfoInListDto> activityInfoInListDtos = new ArrayList<ActivityInfoInListDto>();
		
		try{
			String token = request.getHeader("token");
			User user = authenticateServiceImpl.getUserName(token);
			if (user==null){	
				logger.error("用户不存在");
				msg = "用户不存在";
				statusCode = ResponseStatusCode.FORBIDDEN;
			}
			List<Activity> activities = activityServiceImpl.getComingActivityList(page,user);
			ActivityInfoInListDto activityInfoInListDto = new ActivityInfoInListDto();
			activityInfoInListDtos = activityInfoInListDto.ConvertToDto(activities);
		}catch(Exception e){
			msg = "内部错误";
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			logger.error(e.getMessage());
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("data", activityInfoInListDtos);
		return response;
	}
	
	@RequestMapping(value="/myInterestActivities",method = RequestMethod.GET)
	@ResponseBody
	public RestResponse myInterestActivities(Integer page){
		page = page==null?0:page;
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "查询成功";
		List<ActivityInfoInListDto> activityInfoInListDtos = new ArrayList<ActivityInfoInListDto>();
		
		try{
			String token = request.getHeader("token");
			User user = authenticateServiceImpl.getUserName(token);
			if (user==null){	
				logger.error("用户不存在");
				msg = "用户不存在";
				statusCode = ResponseStatusCode.FORBIDDEN;
			}
			List<Activity> activities = activityServiceImpl.getInterestActivityList(page,user);
			ActivityInfoInListDto activityInfoInListDto = new ActivityInfoInListDto();
			activityInfoInListDtos = activityInfoInListDto.ConvertToDto(activities);
		}catch(Exception e){
			msg = "内部错误";
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			logger.error(e.getMessage());
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("data", activityInfoInListDtos);
		return response;
	}
	
	@RequestMapping(value="/nearbyActivities",method = RequestMethod.GET)
	@ResponseBody
	public RestResponse nearbyActivities(Integer page, @RequestParam Float x, @RequestParam Float y){
		page = page==null?0:page;
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "查询成功";

		List<ActivityInfoInListDto> activityInfoInListDtos = new ArrayList<ActivityInfoInListDto>();
		
		try{
			List<Activity> activities = activityServiceImpl.getNearbyActivityList(page,x,y);
			ActivityInfoInListDto activityInfoInListDto = new ActivityInfoInListDto();
			activityInfoInListDtos = activityInfoInListDto.ConvertToDto(activities);
		}catch(Exception e){
			msg = "内部错误";
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			logger.error(e.getMessage());
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("data", activityInfoInListDtos);
		return response;
	}
	
	@RequestMapping(value="/concernActivities",method = RequestMethod.GET)
	@ResponseBody
	public RestResponse concernActivities(Integer page){
		page = page==null?0:page;
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "查询成功";

		List<ActivityInfoInListDto> activityInfoInListDtos = new ArrayList<ActivityInfoInListDto>();
		
		try{
			String token = request.getHeader("token");
			User user = authenticateServiceImpl.getUserName(token);
			if (user==null){	
				logger.error("用户不存在");
				msg = "用户不存在";
				statusCode = ResponseStatusCode.FORBIDDEN;
			}
			List<Object[]> activities = activityServiceImpl.getConcernActivityList(page,user);
			ActivityInfoInListDto activityInfoInListDto = new ActivityInfoInListDto();
			activityInfoInListDtos = activityInfoInListDto.ConvertObjToDto(activities);
		}catch(Exception e){
			msg = "内部错误";
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			logger.error(e.getMessage());
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("data", activityInfoInListDtos);
		return response;
	}
	
	@RequestMapping(value="/weMediaActivities",method = RequestMethod.GET)
	@ResponseBody
	public RestResponse weMediaActivities(Integer page){
		page = page==null?0:page;
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "查询成功";

		List<ActivityInfoInListDto> activityInfoInListDtos = new ArrayList<ActivityInfoInListDto>();
		
		try{
			String token = request.getHeader("token");
			User user = authenticateServiceImpl.getUserName(token);
			if (user==null){	
				logger.error("用户不存在");
				msg = "用户不存在";
				statusCode = ResponseStatusCode.FORBIDDEN;
			}
			List<Activity> activities = activityServiceImpl.getWeMediaActivityList(page,user);
			if(activities==null){
				response.setMessage(msg);
				response.setStatusCode(statusCode);
				response.getBody().put("data",activityInfoInListDtos);
			}else{
				ActivityInfoInListDto activityInfoInListDto = new ActivityInfoInListDto();
				activityInfoInListDtos = activityInfoInListDto.ConvertToDto(activities);
			}
		}catch(Exception e){
			msg = "内部错误";
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			logger.error(e.getMessage());
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("data", activityInfoInListDtos);
		return response;
	}
	
	@RequestMapping(value="/homePage/{id}",method = RequestMethod.GET)
	@ResponseBody
	public RestResponse homePage(@PathVariable Integer id){
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "查询成功";
		
		ActivityDetailInfoDto activityDetailInfoDto = new ActivityDetailInfoDto();
		try{
			Activity activity = activityServiceImpl.getActivityHomePage(id);
			if(activity==null){
				response.setMessage(msg);
				response.setStatusCode(statusCode);
				response.getBody().put("data",activityDetailInfoDto);
			}else{
				activityDetailInfoDto.ConvertToDto(activity);
			}
		}catch(Exception e){
			msg = "内部错误";
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			logger.error(e.getMessage());
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("data", activityDetailInfoDto);
		return response;
	}
	
	@RequestMapping(value="/joiner",method = RequestMethod.POST)
	@ResponseBody
	public RestResponse joiner(@RequestParam Integer id){
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "加入成功";
		
		try{
			String token = request.getHeader("token");
			User user = authenticateServiceImpl.getUserName(token);
			if (user==null){	
				logger.error("用户不存在");
				msg = "用户不存在";
				statusCode = ResponseStatusCode.FORBIDDEN;
			}else{
				if(!activityServiceImpl.hasJoined(id,user)){
					activityServiceImpl.addJoinActivity(id,user);
				}else{
					logger.error("该用户已经加入该活动了");
					msg = "重复加入";
					statusCode = ResponseStatusCode.FORBIDDEN;
				}
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
	
	@RequestMapping(value="/registration",method = RequestMethod.POST)
	@ResponseBody
	public RestResponse registration(@RequestBody ActivityRegistrationDto activityRegistrationDto){
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "报名成功";
		
		try{
			activityServiceImpl.addRegistrationActivity(activityRegistrationDto);
		}catch(Exception e){
			msg = "内部错误";
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			logger.error(e.getMessage());
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		return response;
	}
	
	@RequestMapping(value="/guest",method = RequestMethod.POST)
	@ResponseBody
	public RestResponse guest(@RequestParam Integer id){
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "申请成功";
		
		try{
			String token = request.getHeader("token");
			User user = authenticateServiceImpl.getUserName(token);
			if (user==null){	
				logger.error("用户不存在");
				msg = "用户不存在";
				statusCode = ResponseStatusCode.FORBIDDEN;
			}else{
				if(!activityServiceImpl.hasGuest(id,user)){
					activityServiceImpl.addGuestsActivity(id,user);
				}else{
					logger.error("该用户已经申请过");
					msg = "重复申请";
					statusCode = ResponseStatusCode.FORBIDDEN;
				}
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
	
	@RequestMapping(value="/public",method = RequestMethod.POST)
	@ResponseBody
	public RestResponse publicApply(@RequestBody AcitivityCooperationDto acitivityCooperationDto){
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "申请成功";
		
		try{
			String token = request.getHeader("token");
			User user = authenticateServiceImpl.getUserName(token);
			if (user==null){	
				logger.error("用户不存在");
				msg = "用户不存在";
				statusCode = ResponseStatusCode.FORBIDDEN;
			}else{
				if(!activityServiceImpl.hasPublicApplied(acitivityCooperationDto)){
					activityServiceImpl.addApplyActivity(acitivityCooperationDto);
				}else{
					logger.error("该用户已经申请过");
					msg = "重复申请过";
					statusCode = ResponseStatusCode.FORBIDDEN;
				}
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
	
	@RequestMapping(value="/crowdfunding",method = RequestMethod.POST)
	@ResponseBody
	public RestResponse crowdfunding(@RequestBody AcitivityCrowdfundingDto acitivityCrowdfundingDto){
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "选择成功";
		
		try{
			String token = request.getHeader("token");
			User user = authenticateServiceImpl.getUserName(token);
			if (user==null){	
				logger.error("用户不存在");
				msg = "用户不存在";
				statusCode = ResponseStatusCode.FORBIDDEN;
			}else{
				activityServiceImpl.addCrowdfunding(acitivityCrowdfundingDto,user);
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
	
	@RequestMapping(value="/joiners",method = RequestMethod.GET)
	@ResponseBody
	public RestResponse joiners(@RequestParam Integer id){
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "获取成功";
		
		List<UserInfoInListDto> userInfoInListDtoList = new ArrayList<UserInfoInListDto>(); 
		
		try{
			String token = request.getHeader("token");
			User user = authenticateServiceImpl.getUserName(token);
			if (user==null){	
				logger.error("用户不存在");
				msg = "用户不存在";
				statusCode = ResponseStatusCode.FORBIDDEN;
			}else{
				userInfoInListDtoList = activityServiceImpl.getUserInfoInListDtoList(user,id);
			}
		}catch(Exception e){
			msg = "内部错误";
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			logger.error(e.getMessage());
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("data", userInfoInListDtoList);
		return response;
	}
	
	@RequestMapping(value="/schedules",method = RequestMethod.GET)
	@ResponseBody
	public RestResponse schedules(@RequestParam Integer id){
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "获取成功";
		
		List<ActivityScheduleInfoDto> activityScheduleInfoDtoList = new ArrayList<ActivityScheduleInfoDto>(); 
		
		try{
			activityScheduleInfoDtoList = activityServiceImpl.getActivityScheduleInfoDtoList(id);
		}catch(Exception e){
			msg = "内部错误";
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			logger.error(e.getMessage());
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("data", activityScheduleInfoDtoList);
		return response;
	}
	
	@RequestMapping(value="/messages",method = RequestMethod.GET)
	@ResponseBody
	public RestResponse messages(@RequestParam Integer id, Integer page){
		page = page==null?0:page;
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "获取成功";
		
		List<ActivityMessageInfoDto> activityMessageInfoDtoList = new ArrayList<ActivityMessageInfoDto>(); 
		
		try{
			activityMessageInfoDtoList = activityServiceImpl.getActivityMessageInfoDtoList(id,page);
		}catch(Exception e){
			msg = "内部错误";
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			logger.error(e.getMessage());
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("data", activityMessageInfoDtoList);
		return response;
	}
	
	@RequestMapping(value="/message",method = RequestMethod.POST)
	@ResponseBody
	public RestResponse message(@RequestBody ActivityMessagePostDto activityMessagePostDto){
		
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "提交成功";
		
		try{
			String token = request.getHeader("token");
			User user = authenticateServiceImpl.getUserName(token);
			if (user==null){	
				logger.error("用户不存在");
				msg = "用户不存在";
				statusCode = ResponseStatusCode.FORBIDDEN;
			}else{
				activityServiceImpl.addMessage(user,activityMessagePostDto);
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
}
