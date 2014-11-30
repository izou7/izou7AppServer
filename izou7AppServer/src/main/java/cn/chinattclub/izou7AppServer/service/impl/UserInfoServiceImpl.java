package cn.chinattclub.izou7AppServer.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.stereotype.Service;

import cn.chinattclub.izou7AppServer.dao.CityDao;
import cn.chinattclub.izou7AppServer.dao.TokenDao;
import cn.chinattclub.izou7AppServer.dao.UserDao;
import cn.chinattclub.izou7AppServer.dao.UserInfoDao;
import cn.chinattclub.izou7AppServer.dto.UserInfoUpdateDto;
import cn.chinattclub.izou7AppServer.dto.UserLoginDto;
import cn.chinattclub.izou7AppServer.dto.UserRegistInfoDto;
import cn.chinattclub.izou7AppServer.entity.Token;
import cn.chinattclub.izou7AppServer.entity.User;
import cn.chinattclub.izou7AppServer.entity.UserInfo;
import cn.chinattclub.izou7AppServer.service.UserInfoService;
import cn.chinattclub.izou7AppServer.service.UserService;
import cn.chinattclub.izou7AppServer.util.HmacSHA256Utils;
import cn.chinattclub.izou7AppServer.util.PasswordHelper;
/*
 * 用户业务逻辑类
 * @author ZY
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Resource
    private UserDao userDao;
	
	@Resource
    private PasswordHelper passwordHelper;
	
	@Resource
	private TokenDao tokenDao;
	
	@Resource
	private UserInfoDao userInfoDao;
	
	@Resource
	private CityDao cityDao;

	@Override
	public void updateUserInfo(UserInfo userInfo,
			UserInfoUpdateDto userInfoUpdateDto) {
		if (userInfoUpdateDto.getRealName()!=null){
			userInfo.setRealName(userInfoUpdateDto.getRealName());
		}
		if(userInfoUpdateDto.getPhone()!=null){
			userInfo.setPhone(userInfoUpdateDto.getPhone());
		}
		if(userInfoUpdateDto.getEmail()!=null){
			userInfo.setEmail(userInfoUpdateDto.getEmail());
		}
		if(userInfoUpdateDto.getQq()!=null){
			userInfo.setQq(userInfoUpdateDto.getQq());
		}
		if(userInfoUpdateDto.getHeadPicture()!=null){
			userInfo.setHeadPicture(userInfoUpdateDto.getHeadPicture());
		}
		if(userInfoUpdateDto.getBirthday()!=null){
			userInfo.setBirthday(userInfoUpdateDto.getBirthday());
		}
		if(userInfoUpdateDto.getCity()!=null){
			userInfo.setCity(cityDao.get(userInfoUpdateDto.getCity()));
		}
		if(userInfoUpdateDto.isSex()!=null){
			userInfo.setSex(userInfoUpdateDto.isSex());
		}
		if(userInfoUpdateDto.getIntroduction()!=null){
			userInfo.setIntroduction(userInfoUpdateDto.getIntroduction());
		}
		if(userInfoUpdateDto.getCareerInfo()!=null){
			userInfo.setCareerInfo(userInfoUpdateDto.getCareerInfo());
		}
		userInfoDao.update(userInfo);
	}

	@Override
	public UserInfoUpdateDto getUserInfo(UserInfo userInfo) {
		UserInfoUpdateDto userInfoUpdateDto = new UserInfoUpdateDto();
		userInfoUpdateDto.setId(userInfo.getId());
		userInfoUpdateDto.setRealName(userInfo.getRealName());
		userInfoUpdateDto.setEmail(userInfo.getEmail());
		userInfoUpdateDto.setPhone(userInfo.getPhone());
		userInfoUpdateDto.setQq(userInfo.getQq());
		userInfoUpdateDto.setHeadPicture(userInfo.getHeadPicture());
		userInfoUpdateDto.setBirthday(userInfo.getBirthday());
		userInfoUpdateDto.setCity(userInfo.getCity().getId());
		userInfoUpdateDto.setSex(userInfo.isSex());
		userInfoUpdateDto.setIntroduction(userInfo.getIntroduction());
		userInfoUpdateDto.setCareerInfo(userInfo.getCareerInfo());
		
		return userInfoUpdateDto;
	}

    
}
