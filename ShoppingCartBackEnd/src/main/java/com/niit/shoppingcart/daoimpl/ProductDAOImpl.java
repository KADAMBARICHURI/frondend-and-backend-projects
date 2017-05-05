package com.niit.shoppingcart.daoimpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//write user defined constructor with one parameter i.e., sessionFactory
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * This save method create record in the User table.
	 * If the record is created successfully, it will return true
	 * else will return false
	 */

	public boolean save(Product product) {
/*		try
		{
		sessionFactory.getCurrentSession().save(product);
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
			s.save(product);
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
	public boolean update(Product product) {
		try
		{
		sessionFactory.getCurrentSession().update(product);
		}catch (Exception e) {
			//if any exception comes during execute of try block, catch will execute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	
	

	public List<Product> list() {
		
		
		return  sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	public Product get(String id) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	(Product)  sessionFactory.getCurrentSession().get(Product.class, id);
		
	}

	public boolean validate(String id, String password, String description, String price, String categoryID,
			String supplierID) {
		// TODO Auto-generated method stub
		return false;
	}

}
















