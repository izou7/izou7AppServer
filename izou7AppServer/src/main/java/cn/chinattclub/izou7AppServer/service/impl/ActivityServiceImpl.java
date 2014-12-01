package cn.chinattclub.izou7AppServer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7AppServer.dao.ActivityDao;
import cn.chinattclub.izou7AppServer.dao.PublicDao;
import cn.chinattclub.izou7AppServer.dao.TokenDao;
import cn.chinattclub.izou7AppServer.dao.UserDao;
import cn.chinattclub.izou7AppServer.dto.UserLoginDto;
import cn.chinattclub.izou7AppServer.entity.Activity;
import cn.chinattclub.izou7AppServer.entity.Public;
import cn.chinattclub.izou7AppServer.entity.Token;
import cn.chinattclub.izou7AppServer.entity.User;
import cn.chinattclub.izou7AppServer.service.ActivityService;
import cn.chinattclub.izou7AppServer.service.UserService;
import cn.chinattclub.izou7AppServer.util.HmacSHA256Utils;
import cn.chinattclub.izou7AppServer.util.PasswordHelper;
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
	
}
