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
import cn.chinattclub.izou7AppServer.entity.ActivityMessage;
import cn.chinattclub.izou7AppServer.entity.ActivitySchedule;
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
public class ActivityMessageDao extends AdvancedHibernateDao<ActivityMessage>{

	public List<ActivityMessage> getByActivity(Integer id, Integer page) {
		int pageNumber = StringUtils.isNotBlank(getProperty("page.default_size")) ? 
				Integer.parseInt(getProperty("page.default_size")) : 10;
		
		Criteria criteria = this.getCurrentSession().createCriteria(ActivityMessage.class);
		criteria.add(Restrictions.eq("activity", id));
		
		criteria.setFirstResult(pageNumber*page);
		criteria.setMaxResults(pageNumber);
		
		return criteria.list();
	}
	
}
