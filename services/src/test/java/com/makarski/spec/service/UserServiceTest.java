package com.makarski.spec.service;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.makarski.spec.dataaccess.UserProfileDao;
import com.makarski.spec.dataaccess.filters.UserFilter;
import com.makarski.spec.dataaccess.impl.AbstractDaoImpl;
import com.makarski.spec.datamodel.Department;
import com.makarski.spec.datamodel.UserProfile;
import com.makarski.spec.datamodel.UserProfile_;
import com.makarski.spec.datamodel.UserRole;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context-test.xml" })
public class UserServiceTest {

	@Inject
	private UserService userService;

	@Inject
	private UserProfileDao userProfileDao;

	@Test
	public void test() {
		Assert.assertNotNull(userService);
	}

	@Test
	public void testEntityManagerInitialization()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field f = AbstractDaoImpl.class.getDeclaredField("entityManager");
		f.setAccessible(true);
		EntityManager em = (EntityManager) f.get(userProfileDao);

		Assert.assertNotNull(em);
	}

	@Test
	public void testRegistration() throws ParseException {
		UserProfile profile = new UserProfile();

		profile.setFirstName("testFName");
		profile.setLastName("testLName");
		profile.setEmail(System.currentTimeMillis() + "mail@test.by");
		profile.setPassword("pswd");
		profile.setRole(UserRole.admin);
		Department dep;
		long l=1;
		profile.setDepartmentFk(dep);

		//задаём дату
		String str_date = "11-June-07";
		DateFormat formatter;
		Date date;
		formatter = new SimpleDateFormat("dd-MMM-yy");
		date = formatter.parse(str_date);
		profile.setLogIn(date);

		userService.register(profile);

		UserProfile registredProfile = userService.getProfile(profile.getId());

		Assert.assertNotNull(registredProfile);

		String updatedFName = "updatedName";
		profile.setFirstName(updatedFName);
		userService.update(profile);

		Assert.assertEquals(updatedFName, userService.getProfile(profile.getId()).getFirstName());

		userService.delete(profile.getId());

		Assert.assertNull(userService.getProfile(profile.getId()));
	}

	@Test
	public void testSearch() {
		// clean all data from users
		List<UserProfile> all = userService.getAll();
		for (UserProfile userProfile : all) {
			userService.delete(userProfile.getId());
		}

		// start create new data
		int testObjectsCount = 5;
		for (int i = 0; i < testObjectsCount; i++) {
			UserProfile profile = new UserProfile();

			profile.setFirstName("testFName" + i);
			profile.setLastName("testLName" + i);

			profile.setEmail(i + "mail@test.by");
			profile.setPassword(i + "pswd");
			profile.setRole(UserRole.admin);
			userService.register(profile);
		}

		UserFilter filter = new UserFilter();
		List<UserProfile> result = userService.find(filter);
		Assert.assertEquals(testObjectsCount, result.size());
		// test paging
		filter.setFetchCredentials(true);
		int limit = 3;
		filter.setLimit(limit);
		filter.setOffset(0);
		result = userService.find(filter);
		Assert.assertEquals(limit, result.size());

		// test sort

		filter.setLimit(null);
		filter.setOffset(null);
		filter.setSortOrder(true);
		filter.setSortProperty(UserProfile_.firstName);
		result = userService.find(filter);
		Assert.assertEquals(testObjectsCount, result.size());

	}
}
