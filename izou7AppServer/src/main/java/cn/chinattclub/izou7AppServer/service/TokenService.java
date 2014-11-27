package cn.chinattclub.izou7AppServer.service;

import cn.chinattclub.izou7AppServer.entity.Token;
import cn.chinattclub.izou7AppServer.entity.User;



/**
 * 
 * token业务逻辑接口
 *
 * @author zhangying.
 *         Created 2014-11-27.
 */
public interface TokenService {

  public Token findByToken(String token);
}
