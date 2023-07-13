package com.mahindrafinance.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.UUID;

public class Util {
	    public static String generateRandomId() {
	        UUID uuid = UUID.randomUUID();
	        return uuid.toString();
	    }
	    
	    public static boolean isValidDateTime(String dateTimeString, String formatPattern) {
	        try {
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
	            LocalDateTime.parse(dateTimeString, formatter);
	            return true; // The string represents a valid date and time
	        } catch (DateTimeParseException e) {
	            return false; // The string does not represent a valid date and time
	        }
	    }
}
