package com.janicaleksa.realestatereservationapp.constants;

public interface ControllerLayerConstants {
	
	interface API {
		
		static final String API_URL = "/api";

		interface User {
			
			static final String USER_URL = "/users";
			
			static final String REGISTRATION_URL = API_URL + USER_URL + "/registration";
			static final String AUTHENTICATE_URL = API_URL + USER_URL + "/authenticate/{username}&{password}";
			static final String LOGIN_URL = API_URL + USER_URL + "/login/{username}&{password}";
			static final String UPDATE_URL = API_URL + USER_URL + "/{username}";
			static final String DELETE_URL = API_URL + USER_URL + "/{username}";
		}
		
		interface Advertisement {
			
			static final String ADVERTISEMENT_URL = "/advertisement";
			
			static final String GET_SINGLE = API_URL + ADVERTISEMENT_URL + "/{code}";
			static final String GET_ALL = API_URL + ADVERTISEMENT_URL;
			static final String CREATE_URL = API_URL + ADVERTISEMENT_URL;
			static final String UPDATE_URL = API_URL + ADVERTISEMENT_URL + "/{code}";
			static final String DELETE_URL = API_URL + ADVERTISEMENT_URL + "/{code}";
		}
		
		interface Reservation {
			
			static final String RESERVATION_URL = "/reservation";
			
			static final String GET_SINGLE = API_URL + RESERVATION_URL + "/{id}";
			static final String GET_ALL = API_URL + RESERVATION_URL;
			static final String CREATE_URL = API_URL + RESERVATION_URL;
			static final String UPDATE_URL = API_URL + RESERVATION_URL + "/{id}";
			static final String DELETE_URL = API_URL + RESERVATION_URL + "/{id}";
		}
		
		interface Role {
			
			static final String ROLE_URL = "/role";
			
			static final String GET_ALL = API_URL + ROLE_URL;
		}
	}
	
	interface JWTToken {
		
		static final String AuthorizationHeader = "Authorization";
	}
	
	
}
