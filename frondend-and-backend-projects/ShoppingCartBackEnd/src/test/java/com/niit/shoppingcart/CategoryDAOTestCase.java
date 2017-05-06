package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;


public class CategoryDAOTestCase {

	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static CategoryDAO  categoryDAO;
	
	@Autowired  static Category category;
	
	
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
		categoryDAO =  (CategoryDAO) context.getBean("categoryDAO");
		
		//get the user from context
		
		category = (Category)context.getBean("category");
		
	}
	
	@Test
	public void createUserTestCase()
	{
		category.setId("100202");
		category.setName("Sandals");
		category.setDescription("All types of sandals are available");
		boolean flag =  categoryDAO.save(category);
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createUser TestCase  abcd",false,flag);
		
	}
	
	
	//@Test
	public void updateUserTestCase()
	{
		category.setId("100201");
		category.setName("Jewellery");
		category.setDescription("All types of Jewellery are available");
		
		boolean flag =  categoryDAO.update(category);
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals(" update user test case",false,flag);
		
	}
	
	
	
	
	//@Test
	public void getAllUserTestCase()
	{
		int actualSize=   categoryDAO.list().size();
		
		//will compare actual and expected
		//if actual and expected is same - TC will pass
		//if it is different - TC fail
		assertEquals(12, actualSize);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}













