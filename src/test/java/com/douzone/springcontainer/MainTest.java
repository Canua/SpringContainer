package com.douzone.springcontainer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.springcontainer.user.User;

import config.user.AppConfig01;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig01.class)
public class MainTest {

	@Autowired
	private User user;

	@Test
	public void testUserNotNull() {
		assertNotNull(user);
	}
	
	@Test
	public void testMethod1() {
		assert(1==1);
	}
	
	@Test
	public void testMethod2() {
		fail();
	}
	@Test
	public void testMethod() {
		User user = null; // dao.getUser("kickscar@gmail.com")
		assert(user != null);
	}

}

