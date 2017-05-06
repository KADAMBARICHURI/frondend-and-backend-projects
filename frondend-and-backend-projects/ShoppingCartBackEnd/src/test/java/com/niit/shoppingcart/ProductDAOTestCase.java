package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;


public class ProductDAOTestCase {

@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static ProductDAO  productDAO;
	
	@Autowired  static Product product;
	
	
	//The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case
	 * and will execute only once
	 */
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
		productDAO =  (ProductDAO) context.getBean("productDAO");
		
		//get the user from context
		
		product = (Product)context.getBean("product");
		
	}
	
	@Test
	public void createUserTestCase()
	{
		product.setId("203");
		product.setName("saree");
		product.setDescription("its a synthetic");
		product.setPrice("5000");
		product.setCategoryID("100200");
		product.setSupplierID("505");
		
		boolean flag =  productDAO.save(product);
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createUser TestCase  abcd",false,flag);
		
	}
	
	
	//@Test
	public void updateUserTestCase()
	{
		product.setId("kadambari");
		product.setName("Kadambari churi");
		product.setDescription("kadambari");
		product.setPrice("ROLE_USER");
		product.setCategoryID("8778787979");
		product.setSupplierID("555");
		
		boolean flag =  productDAO.update(product);
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals(" update user test case",false,flag);
		
	}
	
	//@Test
	public void validateUSerTestCase()
	{
		
		boolean flag =  productDAO.validate("suresh", "sureshhh", null, null, null, null);
		
		
		assertEquals(false, flag);
		
	}
	
	//@Test
	public void getAllUserTestCase()
	{
		int actualSize=   productDAO.list().size();
		
		//will compare actual and expected
		//if actual and expected is same - TC will pass
		//if it is different - TC fail
		assertEquals(12, actualSize);
	}
	
	
	
	
	
	
	
	

}
