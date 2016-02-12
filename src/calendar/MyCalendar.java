package calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyCalendar {

	public static void main(String[] args) {

        String recent = "20";
        Integer daysBack = Integer.valueOf(recent);
        
        if (daysBack>0) { 
        	
        	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	Calendar cal = Calendar.getInstance();
        	String now = dateFormat.format(cal.getTime());
        	
        	cal.add(Calendar.DATE, -daysBack);
        	String dateDaysBack = dateFormat.format(cal.getTime());
        	
     	    System.out.println(now + " - " + dateDaysBack);
        	
        }
	
	}

}
