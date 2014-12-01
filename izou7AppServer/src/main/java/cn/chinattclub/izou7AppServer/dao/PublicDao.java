package cn.chinattclub.izou7AppServer.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7AppServer.entity.Public;
import cn.chinattclub.izou7AppServer.entity.User;
import cn.chinattclub.izou7AppServer.entity.UserInfo;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
/**
 * 活动基本信息DAO
 * @author ZY
 *
 */
@Repository
public class PublicDao  extends AdvancedHibernateDao<Public>{

	public List<Public> getPublicList(User user) {
		Criteria criteria = this.getCurrentSession().createCriteria(
				Public.class);
    	criteria.add(Restrictions.eq("user", user));
		return criteria.list();
	}
	
}
