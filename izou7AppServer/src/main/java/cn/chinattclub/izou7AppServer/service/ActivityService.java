package cn.chinattclub.izou7AppServer.service;

import java.util.Date;
import java.util.List;

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


    
}
