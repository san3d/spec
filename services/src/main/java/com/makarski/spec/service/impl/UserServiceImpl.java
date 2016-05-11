package com.makarski.spec.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.makarski.spec.dataaccess.UserProfileDao;
import com.makarski.spec.dataaccess.filters.UserFilter;
import com.makarski.spec.datamodel.UserProfile;
import com.makarski.spec.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Inject
	private UserProfileDao userProfileDao;

	@Override
	public void register(UserProfile profile) {

		profile.setLogIn(new Date());
		userProfileDao.insert(profile);

		LOGGER.info("User regirstred: {}"/*, userProfile*/);
	}

	@Override
	public UserProfile getProfile(Long id) {
		return userProfileDao.get(id);
	}

	@Override
	public void update(UserProfile profile) {
		userProfileDao.update(profile);
	}

	@Override
	public void delete(Long id) {
		userProfileDao.delete(id);
	}

	@Override
	public List<UserProfile> find(UserFilter filter) {
		return userProfileDao.find(filter);
	}

	@Override
	public List<UserProfile> getAll() {
		return userProfileDao.getAll();
	}
}
