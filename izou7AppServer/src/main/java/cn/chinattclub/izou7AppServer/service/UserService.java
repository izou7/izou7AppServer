package cn.chinattclub.izou7AppServer.service;

import cn.chinattclub.izou7AppServer.entity.User;



/*
 * 
 *@Title:
 *@Description:
 *@Author:ZY
 *@Since:2014-11-9
 *@Version:1.1.0
 */
public interface UserService {

    /**
     * 创建用户
     * @param user
     */
    public User createUser(User user);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword);

    
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);

	/**
	 * 根据用户名生成密钥
	 *
	 * @param username
	 * @return
	 */
	public void createKey(User user);

	/**
	 * 获取用户的密钥
	 *
	 * @param username
	 * @return
	 */
	public String getKey(String username);
}
