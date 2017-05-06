package com.niit.shoppingcart.daoimpl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;


@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//write user defined constructor with one parameter i.e., sessionFactory
	
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * This save method create record in the User table.
	 * If the record is created successfully, it will return true
	 * else will return false
	 */

	public boolean save(Supplier supplier) {
		/*try
		{
		sessionFactory.getCurrentSession().save(supplier);
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
			s.save(supplier);
			tx.commit();
			
			sessionFactory.getCurrentSession().save(supplier);
			
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
	public boolean update(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().update(supplier);
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will execute
			e.printStackTrace();
			return false;
		}
		return true;
	}



	
	

	public List<Supplier> list() {
		
		
		return  sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	public Supplier get(String id) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	(Supplier)  sessionFactory.getCurrentSession().get(Supplier.class, id);
		
	}

	public boolean validate(String id, String name, String address) {
		// TODO Auto-generated method stub
		return false;
	}

	
}

