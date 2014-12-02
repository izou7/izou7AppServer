package cn.chinattclub.izou7AppServer.dao;

import java.util.Date;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7AppServer.entity.Activity;
import cn.chinattclub.izou7AppServer.entity.ActivityJoin;
import cn.chinattclub.izou7AppServer.entity.Public;
import cn.chinattclub.izou7AppServer.entity.User;
import cn.chinattclub.izou7AppServer.enumeration.InvitedStatus;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
import static cn.zy.commons.webdev.props.ApplicationConfiguration.getProperty;
/**
 * 
 * @author ZY
 *
 */
@Repository
public class ActivityJoinDao extends AdvancedHibernateDao<ActivityJoin>{

	public boolean exists(Activity activity, User user) {
		Criteria criteria = this.getCurrentSession().createCriteria(ActivityJoin.class);
		criteria.add(Restrictions.eq("activity", activity));
		criteria.add(Restrictions.eq("user", user));
		return criteria.list().size()==0?false:true;
	}

	
}
