package cn.chinattclub.izou7AppServer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7AppServer.dao.TokenDao;
import cn.chinattclub.izou7AppServer.entity.Token;
import cn.chinattclub.izou7AppServer.service.TokenService;
/**
 * token业务逻辑类
 *
 * @author zhangying.
 *         Created 2014-11-27.
 */
@Service
public class TokenServiceImpl implements TokenService {

	@Resource
	private TokenDao dao;
	
	@Override
	public Token findByToken(String token) {
		// TODO Auto-generated method stub.
		List<Token> tokens = dao.findByHQL("from Token as token where token.token=?",0,1000,token);
		if(tokens!=null&&tokens.size()>0){
			return tokens.get(0);
		}
		return null;
	}

	@Override
	public void deleteToken(String token) {

		dao.deleteByToken(token);
		
	}
	
}
