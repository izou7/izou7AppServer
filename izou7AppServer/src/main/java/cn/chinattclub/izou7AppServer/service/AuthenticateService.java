package cn.chinattclub.izou7AppServer.service;

import cn.chinattclub.izou7AppServer.entity.User;



/**
 * 
 * 授权验证
 *
 * @author zhangying.
 *         Created 2014-11-27.
 */
public interface AuthenticateService {
	/**
	 * 
	 * 授权验证
	 *
	 * @param token
	 * @return
	 */
	public boolean authenticate(String token);

	public User getUserName(String token);
}
