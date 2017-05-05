package com.niit.shoppingcart.daoimpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;



@Repository("categoryDAO")
@Transactional

public class CategoryDAOImpl implements CategoryDAO {
	
	
	@Autowired 
	private SessionFactory sessionFactory;
	private Session s;
	
	
	//write user defined constructor with one parameter i.e., sessionFactory
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * This save method create record in the User table.
	 * If the record is created successfully, it will return true
	 * else will return false
	 */

	public boolean save(Category category) {
		/*try
		{
		sessionFactory.getCurrentSession().save(category);
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will execute
			e.printStackTrace();
			return false;
		}
		return true;*/
		Transaction tx=null;
		Session s;
		try
		{
			s = sessionFactory.openSession();
			tx =  s.beginTransaction();
			s.save(category);
			tx.commit();
			
			
			
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will execute
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		s.close();
		return true;
		
	}
	/**
	 * This update method update record in the User table.
	 * If the record is updated successfully, it will return true
	 * else will return false
	 */
	public boolean update(Category category) {
		/*try
		{
		sessionFactory.getCurrentSession().update(category);
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will execute
			e.printStackTrace();
			return false;
		}
		return true;
	*/
		Transaction tx=null;
		Session s;
	
		try
		{
			s = sessionFactory.openSession();
			tx =  s.beginTransaction();
			s.update(category);
			tx.commit();
			
			
			
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will execute
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		s.close();
		return true;
	
	
	}

	public List<Category> list() {
		
		
		return  sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public Category getCategoryByID(String id) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
		return 	(Category)  sessionFactory.getCurrentSession().get(Category.class, id);
		
	}



public Category getCategoryByName(String name) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	 (Category)  sessionFactory.getCurrentSession().get(Category.class,name);
	  
	  
		
	}

	public boolean validate(String id, String name, String description) {
		// TODO Auto-generated method stub
		return false;
	}

	public com.niit.shoppingcart.domain.Category get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
















