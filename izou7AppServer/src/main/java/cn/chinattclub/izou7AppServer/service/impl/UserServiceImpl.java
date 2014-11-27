package cn.chinattclub.izou7AppServer.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7AppServer.dao.TokenDao;
import cn.chinattclub.izou7AppServer.dao.UserDao;
import cn.chinattclub.izou7AppServer.dto.UserLoginDto;
import cn.chinattclub.izou7AppServer.entity.Token;
import cn.chinattclub.izou7AppServer.entity.User;
import cn.chinattclub.izou7AppServer.service.UserService;
import cn.chinattclub.izou7AppServer.util.HmacSHA256Utils;
import cn.chinattclub.izou7AppServer.util.PasswordHelper;
/*
 * 用户业务逻辑类
 * @author ZY
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
    private UserDao userDao;
	
	@Resource
    private PasswordHelper passwordHelper;
	
	@Resource
	private TokenDao tokenDao;

    /**
     * 创建用户
     * @param user
     */
    public User createUser(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        userDao.save(user);
        return user;
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword) {
        User user =userDao.get(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.update(user);
    }


    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

	@Override
	public void createKey(User user) {
		// TODO Auto-generated method stub.
		user = findByUsername(user.getUsername());
		passwordHelper.createKey(user);
		userDao.update(user);
	}

	@Override
	public String getKey(String username) {
		User user = findByUsername(username);
		return user.getKey();
	}
	
	@Override
	public boolean isUserExists(String username) {
		User user = userDao.findByUsername(username);
		return user==null?false:true;
	}

	@Override
	public boolean isPass(UserLoginDto userLoginDto) {
		User user = userDao.findByUsername(userLoginDto.getUsername());
		PasswordHelper passwordHelper = new PasswordHelper();
		String newPassword = passwordHelper.password(userLoginDto.getPassword(), user.getSalt(),userLoginDto.getUsername());
		return newPassword.equals(user.getPassword())?true:false;
	}

	@Override
	public String saveToken(UserLoginDto userLoginDto) {
		User user = userDao.findByUsername(userLoginDto.getUsername());
		String tokenString = HmacSHA256Utils.digest(new Date().toString(),userLoginDto.getUsername());
		Token token = new Token();
		token.setToken(tokenString);
		token.setUser(user);
		token.setCreateTime(new Date());
		token.setExceedTime(new Date(new Date().getTime() + 24*3600*1000));
		tokenDao.save(token);
		return tokenString;
	}
}
