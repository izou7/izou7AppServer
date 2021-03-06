package cn.chinattclub.izou7AppServer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7AppServer.dao.ActivityCooperationDao;
import cn.chinattclub.izou7AppServer.dao.ActivityCrowdfundingResultDao;
import cn.chinattclub.izou7AppServer.dao.ActivityCrowdfundingRewardSettingDao;
import cn.chinattclub.izou7AppServer.dao.ActivityCrowdfundingSettingDao;
import cn.chinattclub.izou7AppServer.dao.ActivityDao;
import cn.chinattclub.izou7AppServer.dao.ActivityGuestsDao;
import cn.chinattclub.izou7AppServer.dao.ActivityJoinDao;
import cn.chinattclub.izou7AppServer.dao.ActivityMessageDao;
import cn.chinattclub.izou7AppServer.dao.ActivityRegistrationDao;
import cn.chinattclub.izou7AppServer.dao.ActivityScheduleDao;
import cn.chinattclub.izou7AppServer.dao.PublicDao;
import cn.chinattclub.izou7AppServer.dao.TokenDao;
import cn.chinattclub.izou7AppServer.dao.UserDao;
import cn.chinattclub.izou7AppServer.dto.AcitivityCooperationDto;
import cn.chinattclub.izou7AppServer.dto.AcitivityCrowdfundingDto;
import cn.chinattclub.izou7AppServer.dto.ActivityMessageInfoDto;
import cn.chinattclub.izou7AppServer.dto.ActivityMessagePostDto;
import cn.chinattclub.izou7AppServer.dto.ActivityRegistrationDto;
import cn.chinattclub.izou7AppServer.dto.ActivityScheduleInfoDto;
import cn.chinattclub.izou7AppServer.dto.UserInfoInListDto;
import cn.chinattclub.izou7AppServer.dto.UserLoginDto;
import cn.chinattclub.izou7AppServer.entity.Activity;
import cn.chinattclub.izou7AppServer.entity.ActivityCooperation;
import cn.chinattclub.izou7AppServer.entity.ActivityCrowdfundingResult;
import cn.chinattclub.izou7AppServer.entity.ActivityCrowdfundingRewardSetting;
import cn.chinattclub.izou7AppServer.entity.ActivityCrowdfundingSetting;
import cn.chinattclub.izou7AppServer.entity.ActivityGuests;
import cn.chinattclub.izou7AppServer.entity.ActivityJoin;
import cn.chinattclub.izou7AppServer.entity.ActivityMessage;
import cn.chinattclub.izou7AppServer.entity.ActivityRegistration;
import cn.chinattclub.izou7AppServer.entity.ActivitySchedule;
import cn.chinattclub.izou7AppServer.entity.Public;
import cn.chinattclub.izou7AppServer.entity.Token;
import cn.chinattclub.izou7AppServer.entity.User;
import cn.chinattclub.izou7AppServer.entity.UserInfo;
import cn.chinattclub.izou7AppServer.enumeration.GuestRegistrationStatus;
import cn.chinattclub.izou7AppServer.enumeration.InvitedStatus;
import cn.chinattclub.izou7AppServer.service.ActivityService;
import cn.chinattclub.izou7AppServer.service.UserService;
import cn.chinattclub.izou7AppServer.util.HmacSHA256Utils;
import cn.chinattclub.izou7AppServer.util.PasswordHelper;
import cn.zy.commons.util.json.JsonConverter;
/*
 * 用户业务逻辑类
 * @author ZY
 *
 */
@Service
public class ActivityServiceImpl implements ActivityService {

	@Resource
	private ActivityDao activityDao;
	
	@Resource
	private PublicDao publicDao;
	
	@Resource
	private ActivityJoinDao activityJoinDao;
	
	@Resource
	private ActivityRegistrationDao activityRegistrationDao;
	
	@Resource
	private ActivityGuestsDao activityGuestsDao;
	
	@Resource
	private ActivityCooperationDao activityCooperationDao;
	
	@Resource
	private ActivityCrowdfundingResultDao activityCrowdfundingResultDao;
	
	@Resource
	private ActivityCrowdfundingRewardSettingDao activityCrowdfundingRewardSettingDao;
	
	@Resource
	private ActivityScheduleDao activityScheduleDao;
	
	@Resource
	private ActivityMessageDao activityMessageDao;
	
	@Override
	public List<Activity> getActivityList(String text, Integer city, Date startTime,
			Date endTime, Integer page) {
		return activityDao.getActivities(text, city, startTime, endTime, page);
	}

	@Override
	public List<Activity> getComingActivityList(Integer page, User user) {
		// TODO Auto-generated method stub
		return activityDao.getComingActivityList(page, user);
	}

	@Override
	public List<Activity> getInterestActivityList(Integer page, User user) {
		return activityDao.getInterestActivityList(page,user);
	}

	@Override
	public List<Activity> getNearbyActivityList(Integer page, Float x, Float y) {
		return activityDao.getNearbyActivityList(page,x,y);
	}

	@Override
	public List<Object[]> getConcernActivityList(Integer page, User user) {
		return activityDao.getConcernActivityList(page,user);
	}

	@Override
	public List<Activity> getWeMediaActivityList(Integer page, User user) {
		List<Public> publicList = publicDao.getPublicList(user);
		if(publicList.size()==0){
			return null;
		}
		List<String> wechatIdList = new ArrayList<String>();
		for(Public pub:publicList){
			String wechatId = pub.getWechatId();
			wechatIdList.add(wechatId);
		}
		return activityDao.getWeMediaActivityList(page,wechatIdList);
	}

	@Override
	public Activity getActivityHomePage(Integer id) {
		return activityDao.get(id);
	}

	@Override
	public void addJoinActivity(Integer id, User user) {
		Activity activity = activityDao.get(id);
		ActivityJoin activityJoin = new ActivityJoin();
		activityJoin.setActivity(activity);
		activityJoin.setUser(user);
		activityJoin.setCreateTime(new Date());
		activityJoin.setUpdateTime(new Date());
		activityJoinDao.save(activityJoin);
	}

	@Override
	public boolean hasJoined(Integer id, User user) {
		Activity activity = activityDao.get(id);
		return activityJoinDao.exists(activity,user);
	}

	@Override
	public void addRegistrationActivity(
			ActivityRegistrationDto activityRegistrationDto) {
		Activity activity = activityDao.get(activityRegistrationDto.getId());
		ActivityRegistration activityRegistration = new ActivityRegistration();
		activityRegistration.setActivity(activity);
		activityRegistration.setRegistration(activityRegistrationDto.getRegistration());
		activityRegistration.setCreateTime(new Date());
		activityRegistration.setUpdateTime(new Date());
		activityRegistrationDao.save(activityRegistration);
	}

	@Override
	public void addGuestsActivity(Integer id, User user) {
		ActivityGuests activityGuests = new ActivityGuests();
		Activity activity = activityDao.get(id);
		activityGuests.setActivity(activity);
		activityGuests.setCreateTime(new Date());
		activityGuests.setName(user.getUsername());
		activityGuests.setUpdateTime(new Date());
		activityGuests.setType(0);
		activityGuests.setSource(false);
		activityGuests.setRank(0);
		activityGuests.setStatus(GuestRegistrationStatus.UNSEND);
		activityGuests.setUser(user.getId());
		
		UserInfo userInfo = user.getUserInfo();
		if (userInfo!=null){
			if(userInfo.getCareerInfo()!=null && userInfo.getCareerInfo()!=""){
				Map<String,Object> careerInfo = new HashMap<String,Object>();
				careerInfo = JsonConverter.parse(userInfo.getCareerInfo(), Map.class);
				activityGuests.setCompany(careerInfo.get("company").toString());
				activityGuests.setPosition(careerInfo.get("position").toString());
				activityGuests.setResearchArea(careerInfo.get("researchArea").toString());
			}
			activityGuests.setBirthday(userInfo.getBirthday());
			activityGuests.setEmail(userInfo.getEmail());
			activityGuests.setIntroduction(userInfo.getIntroduction());
			activityGuests.setName(userInfo.getRealName());
			activityGuests.setPhone(userInfo.getPhone());
			activityGuests.setSex(userInfo.isSex());
			
		}
		activityGuestsDao.save(activityGuests);
		
	}

	@Override
	public boolean hasGuest(Integer id, User user) {
		Activity activity = activityDao.get(id);
		return activityGuestsDao.hasGuest(activity, user);
	}

	@Override
	public boolean hasPublicApplied(
			AcitivityCooperationDto acitivityCooperationDto) {
		Activity activity = activityDao.get(acitivityCooperationDto.getId());
		return activityCooperationDao.hasCooprated(activity,acitivityCooperationDto.getPublicId());
	}

	@Override
	public void addApplyActivity(AcitivityCooperationDto acitivityCooperationDto) throws Exception {
		ActivityCooperation activityCooperation = new ActivityCooperation();
		Activity activity = activityDao.get(acitivityCooperationDto.getId());
		Public pub = publicDao.getByWechatId(acitivityCooperationDto.getPublicId());
		
		if (pub!=null){
			activityCooperation.setActivity(activity);
			activityCooperation.setCreateTime(new Date());
			activityCooperation.setDescription(pub.getDescription());
			activityCooperation.setPublicName(pub.getPublicName());
			activityCooperation.setStatus(InvitedStatus.UNSEND);
			activityCooperation.setTags(pub.getTags());
			activityCooperation.setType(0);
			activityCooperation.setUpdateTime(new Date());
			activityCooperation.setWechatId(acitivityCooperationDto.getPublicId());
			activityCooperationDao.save(activityCooperation);
		}else{
			throw new Exception("公众号不存在");
		}
		
		
		
	}

	@Override
	public void addCrowdfunding(
			AcitivityCrowdfundingDto acitivityCrowdfundingDto, User user) throws Exception {
		ActivityCrowdfundingRewardSetting activityCrowdfundingRewardSetting = activityCrowdfundingRewardSettingDao.get(acitivityCrowdfundingDto.getId());
		if (activityCrowdfundingRewardSetting.getRewardStartTime().after(new Date()) || activityCrowdfundingRewardSetting.getRewardEndTime().before(new Date())){
			throw new Exception ("当前日期无法众筹");
		}
		
		
		ActivityCrowdfundingResult activityCrowdfundingResult = new ActivityCrowdfundingResult();
		
		activityCrowdfundingResult.setUser(user);
		activityCrowdfundingResult.setCrowdfunding(activityCrowdfundingRewardSetting);
		activityCrowdfundingResult.setAccountInfo(acitivityCrowdfundingDto.getAccountInfo());
		activityCrowdfundingResultDao.save(activityCrowdfundingResult);
	}

	@Override
	public List<UserInfoInListDto> getUserInfoInListDtoList(User user, Integer id) {
		Activity activity = activityDao.get(id);
		List<ActivityJoin> activityJoinList = activityJoinDao.getJoiners(activity,user);
		List<UserInfoInListDto> userInfoInListDtoList = new ArrayList<UserInfoInListDto>();
		for (ActivityJoin activityJoin:activityJoinList){
			UserInfoInListDto userInfoInListDto = new UserInfoInListDto();
			userInfoInListDto.setUserId(activityJoin.getUser().getId());
			userInfoInListDto.setUserName(activityJoin.getUser().getUsername());
			userInfoInListDto.setIntroduction(activityJoin.getUser().getUserInfo().getIntroduction());
			userInfoInListDto.setHeadPicture(activityJoin.getUser().getUserInfo().getHeadPicture());
			userInfoInListDto.setHeadPictureUrl(activityJoin.getUser().getUserInfo().getHeadPictureUrl());
			userInfoInListDto.setConcerned(false);
			userInfoInListDto.setSuggest(false);
			userInfoInListDtoList.add(userInfoInListDto);
		}
		return userInfoInListDtoList;
	}

	@Override
	public List<ActivityScheduleInfoDto> getActivityScheduleInfoDtoList(
			Integer id) {
		Activity activity = activityDao.get(id);
		List<ActivitySchedule> activityScheduleList= activityScheduleDao.getByActivity(activity);
		
		List<ActivityScheduleInfoDto> activityScheduleInfoDtoList = new ArrayList<ActivityScheduleInfoDto>();
		for (ActivitySchedule activitySchedule:activityScheduleList){
			ActivityScheduleInfoDto activityScheduleInfoDto = new ActivityScheduleInfoDto();
			activityScheduleInfoDto.setContent(activitySchedule.getContent());
			activityScheduleInfoDto.setStartTime(activitySchedule.getStartTime());
			activityScheduleInfoDto.setEndTime(activitySchedule.getEndTime());
			activityScheduleInfoDtoList.add(activityScheduleInfoDto);
		}
		return activityScheduleInfoDtoList;
	}

	@Override
	public List<ActivityMessageInfoDto> getActivityMessageInfoDtoList(
			Integer id, Integer page) {
		List<ActivityMessage> activityMessageList = activityMessageDao.getByActivity(id, page);
		
		List<ActivityMessageInfoDto> activityMessageInfoDtoList = new ArrayList<ActivityMessageInfoDto>();
		
		for(ActivityMessage activityMessage:activityMessageList){
			ActivityMessageInfoDto activityMessageInfoDto = new ActivityMessageInfoDto();
			activityMessageInfoDto.setUserId(activityMessage.getUser().getId());
			activityMessageInfoDto.setMessage(activityMessage.getMessage());
			activityMessageInfoDto.setMessageTime(activityMessage.getCreateTime());
			activityMessageInfoDto.setHeadPicture(activityMessage.getUser().getUserInfo().getHeadPicture());
			activityMessageInfoDto.setHeadPictureUrl(activityMessage.getUser().getUserInfo().getHeadPictureUrl());
			activityMessageInfoDtoList.add(activityMessageInfoDto);
		}
		return activityMessageInfoDtoList;
	}

	@Override
	public void addMessage(User user,
			ActivityMessagePostDto activityMessagePostDto) {
		ActivityMessage activityMessage = new ActivityMessage();
		activityMessage.setActivity(activityMessagePostDto.getId());
		activityMessage.setMessage(activityMessagePostDto.getMessage());
		activityMessage.setUser(user);
		activityMessage.setCreateTime(new Date());
		activityMessageDao.save(activityMessage);
	}

	
}
