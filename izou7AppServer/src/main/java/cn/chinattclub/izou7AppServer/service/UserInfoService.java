package cn.chinattclub.izou7AppServer.service;

import cn.chinattclub.izou7AppServer.dto.UserInfoUpdateDto;
import cn.chinattclub.izou7AppServer.dto.UserLoginDto;
import cn.chinattclub.izou7AppServer.dto.UserRegistInfoDto;
import cn.chinattclub.izou7AppServer.entity.User;
import cn.chinattclub.izou7AppServer.entity.UserInfo;



/*
 * 
 *@Title:
 *@Description:
 *@Author:ZY
 *@Since:2014-11-9
 *@Version:1.1.0
 */
public interface UserInfoService {

	void updateUserInfo(UserInfo userInfo, UserInfoUpdateDto userInfoUpdateDto);

	UserInfoUpdateDto getUserInfo(UserInfo userInfo);

   
}
