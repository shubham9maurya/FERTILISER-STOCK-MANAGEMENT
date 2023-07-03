package org.miniprojract.domain;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TodayDate {
		   private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	       private static Date date = new Date();
	        
	       public static String getDate()
	       {
	    	   return dateFormat.format(date);
	       }
}
