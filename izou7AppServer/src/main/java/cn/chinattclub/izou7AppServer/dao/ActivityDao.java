package cn.chinattclub.izou7AppServer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7AppServer.entity.Activity;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
/**
 * 
 * @author ZY
 *
 */
@Repository
public class ActivityDao  extends AdvancedHibernateDao<Activity>{

	public List<Activity> getActivities() {
		return null;
		// TODO Auto-generated method stub
		
	}
	
}
