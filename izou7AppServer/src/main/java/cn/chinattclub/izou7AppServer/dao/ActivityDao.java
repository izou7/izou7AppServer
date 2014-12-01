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
		criteria.createAlias("activityJoinList", "ajl").add(Restrictions.eq("ajl.user", user));
		//criteria.add(Restrictions.eq("user", user));

		criteria.add(Restrictions.between("startTime", new Date(), new Date(new Date().getTime()+24*3600*1000)));
		
		criteria.setFirstResult(pageNumber*page);
		criteria.setMaxResults(pageNumber);
		
		return criteria.list();
	}

	public List<Activity> getInterestActivityList(Integer page, User user) {
		int pageNumber = StringUtils.isNotBlank(getProperty("page.default_size")) ? 
				Integer.parseInt(getProperty("page.default_size")) : 10;
		Criteria criteria = this.getCurrentSession().createCriteria(Activity.class);
		
		String [] keywordList = user.getUserInfo().getInterestField().split(",");
		
		Disjunction dis=Restrictions.disjunction(); 
		for (int i=0;i<keywordList.length;i++){
			dis.add(Restrictions.like("tags", "%"+keywordList[i]+"%"));
		}
		criteria.add(dis);
		
		criteria.setFirstResult(pageNumber*page);
		criteria.setMaxResults(pageNumber);
		
		return criteria.list();
	}

	public List<Activity> getNearbyActivityList(Integer page, Float x, Float y) {
		int pageNumber = StringUtils.isNotBlank(getProperty("page.default_size")) ? 
				Integer.parseInt(getProperty("page.default_size")) : 10;
		
		Session session = this.getCurrentSession();
		String hql = "from Activity where (coordinate_x-?)*(coordinate_x-?)+(coordinate_y-?)*(coordinate_y-?)<10000";
		Query q = session.createQuery(hql);
		q.setFloat(0, x);
		q.setFloat(1, x);
		q.setFloat(2, y);
		q.setFloat(3, y);
		q.setFirstResult(pageNumber*page);
		q.setMaxResults(pageNumber);
		return q.list();
	}

	public List<Object[]> getConcernActivityList(Integer page, User user) {
		int pageNumber = StringUtils.isNotBlank(getProperty("page.default_size")) ? 
				Integer.parseInt(getProperty("page.default_size")) : 10;
		Session session = this.getCurrentSession();
		String hql = "from Activity a, ActivityJoin aj, User u, BrowsedUser bu where " +
				"a.id=aj.activity and aj.user=u.id and u.id=bu.browsedUser and bu.user=?";
		Query q = session.createQuery(hql);
		q.setInteger(0, user.getId());
		q.setFirstResult(pageNumber*page);
		q.setMaxResults(pageNumber);
		return q.list();
	}

	public List<Activity> getWeMediaActivityList(Integer page, List<String> wechatIdList) {
		int pageNumber = StringUtils.isNotBlank(getProperty("page.default_size")) ? 
				Integer.parseInt(getProperty("page.default_size")) : 10;
		Criteria criteria = this.getCurrentSession().createCriteria(Activity.class);
		criteria.createAlias("activityCooperationList", "acl").add(Restrictions.in("acl.wechatId", wechatIdList));
		criteria.add(Restrictions.eq("acl.status", InvitedStatus.AGREED));
		criteria.setFirstResult(pageNumber*page);
		criteria.setMaxResults(pageNumber);
		return criteria.list();
	}
	
}
