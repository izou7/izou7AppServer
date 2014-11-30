package cn.chinattclub.izou7AppServer.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7AppServer.entity.Token;
import cn.chinattclub.izou7AppServer.entity.User;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
/**
 * 
 * @author ZY
 *
 */
@Repository
public class TokenDao  extends AdvancedHibernateDao<Token>{

	public void deleteByToken(String token) {
		Session session = this.getCurrentSession();
		String hql = "delete from Token where token=?";
		Query q = session.createQuery(hql);
		q.setString(0, token);
		q.executeUpdate();
	}

}
