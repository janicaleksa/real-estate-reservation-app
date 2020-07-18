package com.janicaleksa.realestatereservationapp.constants;

import java.time.LocalDateTime;
import java.util.Date;

public interface ServiceLayerConstants {

	interface JWTToken {
		
		static final String SECRET_KEY = "aleksajanic";
		static final long EXPIRING_HOURS = 1;
		static final LocalDateTime CURRENT_DATE_TIME = LocalDateTime.now();
		static final Date CURRENT_DATE = new Date();
	}
	
}
