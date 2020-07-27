package com.janicaleksa.realestatereservationapp.service.impl;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.janicaleksa.realestatereservationapp.entities.Role;
import com.janicaleksa.realestatereservationapp.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Override
	public Collection<Role> findAllRoles() {
		return Arrays.asList(Role.values());
	}

}
