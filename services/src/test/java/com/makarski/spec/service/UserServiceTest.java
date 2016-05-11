package com.makarski.spec.service;

import java.lang.reflect.Field;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.makarski.spec.dataaccess.UserProfileDao;
import com.makarski.spec.dataaccess.impl.AbstractDaoImpl;
import com.makarski.spec.datamodel.UserProfile;
import com.makarski.spec.datamodel.UserRole;
import com.makarski.spec.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context-test.xml" })
public class UserServiceTest {

    @Inject
    private UserService userService;

    @Inject
    private UserProfileDao userProfileDao;
    
    @Inject
	private UserProfile userProfile;

    @Test
    public void test() {
        Assert.assertNotNull(userService);
    }

    @Test
    public void testEntityManagerInitialization() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field f = AbstractDaoImpl.class.getDeclaredField("entityManager");
        f.setAccessible(true);
        EntityManager em = (EntityManager) f.get(userProfileDao);

        Assert.assertNotNull(em);
    }

    @Test
    public void testRegistration() {
        UserProfile profile = new UserProfile();

        profile.setFirstName("testFName");
        profile.setLastName("testLName");

        userProfile.setEmail(System.currentTimeMillis() + "mail@test.by");
        userProfile.setPassword("pswd");
        userProfile.setRole(UserRole.admin);
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

}
