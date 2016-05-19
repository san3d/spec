package com.makarski.spec.dataaccess;

import java.util.List;

import com.makarski.spec.dataaccess.filters.UserFilter;
import com.makarski.spec.datamodel.UserProfile;

public interface UserProfileDao extends AbstractDao<UserProfile, Long> {
	
//	public UserProfile getProfileByEmail(String email); //доработать
	
	List<UserProfile> find(UserFilter filter); // как у Димы
	
}
