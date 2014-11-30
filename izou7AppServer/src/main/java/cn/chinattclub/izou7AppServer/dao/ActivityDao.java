package cn.chinattclub.izou7AppServer.dao;

import java.util.Date;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7AppServer.entity.Activity;
import cn.chinattclub.izou7AppServer.entity.User;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
import static cn.zy.commons.webdev.props.ApplicationConfiguration.getProperty;
/**
 * 
 * @author ZY
 *
 */
@Repository
public class ActivityDao  extends AdvancedHibernateDao<Activity>{

	public List<Activity> getActivities(String text, Integer city, Date startTime, Date endTime, Integer page) {
		int pageNumber = StringUtils.isNotBlank(getProperty("page.default_size")) ? 
							Integer.parseInt(getProperty("page.default_size")) : 10;
		Criteria criteria = this.getCurrentSession().createCriteria(Activity.class);
		if (text!=null){
			criteria.add(Restrictions.like("name", "%"+text+"%"));
		}
		if (city!=null){
			criteria.createAlias("city", "c").add(Restrictions.eq("c.id", city));
		}
		if (startTime!=null && endTime!=null){
			criteria.add(Restrictions.between("startTime", startTime, endTime));
		}
		criteria.setFirstResult(pageNumber*page);
		criteria.setMaxResults(pageNumber);
		
    	return criteria.list();
		
	}

	public List<Activity> getComingActivityList(Integer page, User user) {
		int pageNumber = StringUtils.isNotBlank(getProperty("page.default_size")) ? 
				Integer.parseInt(getProperty("page.default_size")) : 10;
		Criteria criteria = this.getCurrentSession().createCriteria(Activity.class);
		criteria.add(Restrictions.eq("user", user));

		criteria.add(Restrictions.between("startTime", new Date(), new Date(new Date().getTime()+24*3600*1000)));
		
		criteria.setFirstResult(pageNumber*page);
		criteria.setMaxResults(pageNumber);
		
		return criteria.list();
	}
	
}
