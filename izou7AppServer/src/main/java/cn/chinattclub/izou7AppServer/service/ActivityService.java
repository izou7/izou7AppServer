package cn.chinattclub.izou7AppServer.service;

import java.util.Date;
import java.util.List;

import cn.chinattclub.izou7AppServer.dto.AcitivityCooperationDto;
import cn.chinattclub.izou7AppServer.dto.AcitivityCrowdfundingDto;
import cn.chinattclub.izou7AppServer.dto.ActivityMessageInfoDto;
import cn.chinattclub.izou7AppServer.dto.ActivityMessagePostDto;
import cn.chinattclub.izou7AppServer.dto.ActivityRegistrationDto;
import cn.chinattclub.izou7AppServer.dto.ActivityScheduleInfoDto;
import cn.chinattclub.izou7AppServer.dto.UserInfoInListDto;
import cn.chinattclub.izou7AppServer.dto.UserLoginDto;
import cn.chinattclub.izou7AppServer.entity.Activity;
import cn.chinattclub.izou7AppServer.entity.User;



/*
 * 
 *@Title:
 *@Description:
 *@Author:ZY
 *@Since:2014-11-9
 *@Version:1.1.0
 */
public interface ActivityService {

	List<Activity> getActivityList(String text, Integer city, Date startTime, Date endTime,
			Integer page);

	List<Activity> getComingActivityList(Integer page, User user);

	List<Activity> getInterestActivityList(Integer page, User user);

	List<Activity> getNearbyActivityList(Integer page, Float x, Float y);

	List<Object[]> getConcernActivityList(Integer page, User user);

	List<Activity> getWeMediaActivityList(Integer page, User user);

	Activity getActivityHomePage(Integer id);

	void addJoinActivity(Integer id, User user);

	boolean hasJoined(Integer id, User user);

	void addRegistrationActivity(
			ActivityRegistrationDto activityRegistrationDto);

	void addGuestsActivity(Integer id, User user);

	boolean hasGuest(Integer id, User user);

	boolean hasPublicApplied(AcitivityCooperationDto acitivityCooperationDto);

	void addApplyActivity(AcitivityCooperationDto acitivityCooperationDto) throws Exception;

	void addCrowdfunding(AcitivityCrowdfundingDto acitivityCrowdfundingDto, User user) throws Exception ;

	List<UserInfoInListDto> getUserInfoInListDtoList(User user, Integer id);

	List<ActivityScheduleInfoDto> getActivityScheduleInfoDtoList(Integer id);

	List<ActivityMessageInfoDto> getActivityMessageInfoDtoList(Integer id,
			Integer page);

	void addMessage(User user, ActivityMessagePostDto activityMessagePostDto);

    
}
