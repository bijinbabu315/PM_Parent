package com.sba.pm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sba.pm.dao.intf.IUserDao;
import com.sba.pm.entity.ProjectEntity;
import com.sba.pm.entity.UserEntity;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public Integer saveOrUpdateUser(UserEntity userEntity) {
		Integer result = 0;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			session.saveOrUpdate(userEntity);
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
	public Integer updateProjectInUser(ProjectEntity projectEntity) {
		Integer result = 0;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		String newValue = null;
		try {
			session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaUpdate<UserEntity> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(UserEntity.class);
			Root<UserEntity> root = criteriaUpdate.from(UserEntity.class);
			criteriaUpdate.set(root.get("taskData"), newValue);
			criteriaUpdate.set(root.get("isManager"), newValue);
			criteriaUpdate.set(root.get("projectData"), newValue);
			criteriaUpdate.where(root.get("projectData").in(projectEntity));
			session.createQuery(criteriaUpdate).executeUpdate();
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
	public List<UserEntity> getAllUsers() {
		List<UserEntity> results = new ArrayList<>();
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<UserEntity> createQuery = cb.createQuery(UserEntity.class);
			Root<UserEntity> root = createQuery.from(UserEntity.class);
			createQuery.orderBy(cb.desc(root.get("id")));
			createQuery.select(root);

			Query<UserEntity> query = session.createQuery(createQuery);
			results = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}

	@Override
	public Integer deleteUser(Integer id) {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			UserEntity user = (UserEntity) session.get(UserEntity.class, id);
			session.delete(user);
			beginTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
