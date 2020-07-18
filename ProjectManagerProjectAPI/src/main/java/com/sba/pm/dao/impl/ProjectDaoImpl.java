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

import com.sba.pm.dao.intf.IProjectDao;
import com.sba.pm.entity.ProjectEntity;

@Repository("projectDao")
public class ProjectDaoImpl implements IProjectDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public Integer saveOrUpdateProject(ProjectEntity projectEntity) {
		Integer result = 0;
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			session.saveOrUpdate(projectEntity);
			session.flush();
			result = projectEntity.getId();
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
	public List<ProjectEntity> getAllProjects() {
		List<ProjectEntity> results = new ArrayList<>();
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<ProjectEntity> createQuery = cb.createQuery(ProjectEntity.class);
			Root<ProjectEntity> root = createQuery.from(ProjectEntity.class);
			createQuery.select(root);

			Query<ProjectEntity> query = session.createQuery(createQuery);
			results = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}

	@Override
	public Integer delete(Integer id) {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			ProjectEntity project = (ProjectEntity)session.get(ProjectEntity.class, id);
			session.delete(project);
			beginTransaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}
