package com.janicaleksa.realestatereservationapp.constants;

public interface Constants {
	
	interface API {
		
		static final String API_URL = "/api";

		interface User {
			
			static final String USER_URL = "/users";
			
			static final String REGISTRATION_URL = API_URL + USER_URL + "/registration";
			static final String AUTHENTICATE_URL = API_URL + USER_URL + "/authenticate";
			static final String LOGIN_URL = API_URL + USER_URL + "/login";
			static final String UPDATE_URL = API_URL + USER_URL + "/{username}";
			static final String DELETE_URL = API_URL + USER_URL + "/{username}";
		}
	}
	
	
}
