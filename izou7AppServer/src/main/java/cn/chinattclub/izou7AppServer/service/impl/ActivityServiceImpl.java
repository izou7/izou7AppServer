package cn.chinattclub.izou7AppServer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7AppServer.dao.ActivityDao;
import cn.chinattclub.izou7AppServer.dao.ActivityGuestsDao;
import cn.chinattclub.izou7AppServer.dao.ActivityJoinDao;
import cn.chinattclub.izou7AppServer.dao.ActivityRegistrationDao;
import cn.chinattclub.izou7AppServer.dao.PublicDao;
import cn.chinattclub.izou7AppServer.dao.TokenDao;
import cn.chinattclub.izou7AppServer.dao.UserDao;
import cn.chinattclub.izou7AppServer.dto.ActivityRegistrationDto;
import cn.chinattclub.izou7AppServer.dto.UserLoginDto;
import cn.chinattclub.izou7AppServer.entity.Activity;
import cn.chinattclub.izou7AppServer.entity.ActivityGuests;
import cn.chinattclub.izou7AppServer.entity.ActivityJoin;
import cn.chinattclub.izou7AppServer.entity.ActivityRegistration;
import cn.chinattclub.izou7AppServer.entity.Public;
import cn.chinattclub.izou7AppServer.entity.Token;
import cn.chinattclub.izou7AppServer.entity.User;
import cn.chinattclub.izou7AppServer.entity.UserInfo;
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
	
}
