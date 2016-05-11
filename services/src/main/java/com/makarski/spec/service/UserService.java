package com.makarski.spec.service;

import java.util.List;

import javax.transaction.Transactional;

import com.makarski.spec.dataaccess.filters.UserFilter;
import com.makarski.spec.datamodel.UserProfile;

public interface UserService {

	@Transactional
	void register(UserProfile profile);

	UserProfile getProfile(Long id);

	@Transactional
	void update(UserProfile profile);

	@Transactional
	void delete(Long id);

	List<UserProfile> find(UserFilter filter);

	List<UserProfile> getAll();

}
