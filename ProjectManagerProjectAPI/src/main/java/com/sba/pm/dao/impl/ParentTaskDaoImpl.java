package com.sba.pm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sba.pm.dao.intf.IParentTaskDao;
import com.sba.pm.entity.ParentTaskEntity;

@Repository("parentTaskDao")
public class ParentTaskDaoImpl implements IParentTaskDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public Integer saveOrUpadte(ParentTaskEntity parentTaskEntity) {
		Integer result = 0;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			session.saveOrUpdate(parentTaskEntity);
			result = 1; 
			beginTransaction.commit();
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}


	@Override
	public List<ParentTaskEntity> getAllParentTask() {
		List<ParentTaskEntity> results = new ArrayList<>();
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<ParentTaskEntity> createQuery = cb.createQuery(ParentTaskEntity.class);
			Root<ParentTaskEntity> root = createQuery.from(ParentTaskEntity.class);
			createQuery.select(root);

			Query<ParentTaskEntity> query = session.createQuery(createQuery);
			results = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}

}
