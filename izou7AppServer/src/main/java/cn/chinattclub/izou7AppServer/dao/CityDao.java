package cn.chinattclub.izou7AppServer.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7AppServer.entity.City;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
/**
 * 
 * @author ZY
 *
 */
@Repository
public class CityDao  extends AdvancedHibernateDao<City>{
	/**
	 * 
	 * 通过省ID获取城市
	 *
	 * @param id
	 * @return
	 */
	public List<City> findCityByProvince(int id){
		Criteria criteria = this.getCurrentSession().createCriteria(
				City.class);
		criteria.add(Restrictions.eq("province.id", id));
		return criteria.list();
	}
}
