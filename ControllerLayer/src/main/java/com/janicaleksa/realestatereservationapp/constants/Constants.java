package com.janicaleksa.realestatereservationapp.constants;

public interface Constants {
	
	interface API {
		
		static final String API_URL = "/api";

		interface User {
			
			static final String USER_URL = "/user";
			
			static final String REGISTRATION_URL = API_URL + USER_URL;
		}
	}
	
	
}
