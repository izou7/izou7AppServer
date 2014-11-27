package cn.chinattclub.izou7AppServer.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7AppServer.dao.ActivityDao;
import cn.chinattclub.izou7AppServer.dao.TokenDao;
import cn.chinattclub.izou7AppServer.dao.UserDao;
import cn.chinattclub.izou7AppServer.dto.UserLoginDto;
import cn.chinattclub.izou7AppServer.entity.Activity;
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
	
	@Override
	public List<Activity> getActivityList(String text, int city, Date startTime,
			Date endTime, int page) {
		return activityDao.getActivities();
	}
	
}
