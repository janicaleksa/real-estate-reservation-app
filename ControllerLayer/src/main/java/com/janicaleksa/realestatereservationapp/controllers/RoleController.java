package com.janicaleksa.realestatereservationapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janicaleksa.realestatereservationapp.constants.ControllerLayerConstants;
import com.janicaleksa.realestatereservationapp.service.RoleService;

@RestController
public class RoleController {
	
	private final RoleService roleService;
	
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@GetMapping(value = ControllerLayerConstants.API.Role.GET_ALL)
	public ResponseEntity<?> getAllRoles() {
		return ResponseEntity.ok(getRoleService().findAllRoles());
	}

	private RoleService getRoleService() {
		return roleService;
	}
}
