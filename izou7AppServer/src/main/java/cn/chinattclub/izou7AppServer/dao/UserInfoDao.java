package cn.chinattclub.izou7AppServer.dao;

import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7AppServer.entity.UserInfo;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
/**
 * 活动基本信息DAO
 * @author ZY
 *
 */
@Repository
public class UserInfoDao  extends AdvancedHibernateDao<UserInfo>{
}
