package cn.chinattclub.izou7AppServer.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.chinattclub.izou7AppServer.entity.Token;
import cn.chinattclub.izou7AppServer.interceptor.AuthenticateInterceptor;
import cn.chinattclub.izou7AppServer.service.AuthenticateService;
import cn.chinattclub.izou7AppServer.service.TokenService;

/**
 * 用户验证业务逻辑类
 *
 * @author zhangying.
 *         Created 2014-11-27.
 */
public class AuthenticateServiceImpl implements AuthenticateService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticateServiceImpl.class);
	@Resource
	private TokenService tokenServiceImpl;
	@Override
	public boolean authenticate(String tokenStr) {
		// TODO Auto-generated method stub.
		Token token = tokenServiceImpl.findByToken(tokenStr);
		Date now = new Date();
		if(StringUtils.isBlank(tokenStr)&&token!=null){
			logger.warn("token不存在");
		}else{
			if(token.getUser()!=null){
				Date date = token.getExceedTime();
				if(now.getTime()<date.getTime()){
					return true;
				}else{
					logger.warn("token已过期");
				}
			}
		}
		return false;
	}
	
}
