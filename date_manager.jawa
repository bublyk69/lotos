import java.util.Calendar;
import java.util.Date;

public class date_manager {
	
	 static Date date = new Date();
	
	public static boolean birth_check(String s) {
		
		if ((day(s) == current_day()) && (month(s) == current_month())) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static int current_day() {
		
	      Calendar cal = Calendar.getInstance();
	      return cal.get(Calendar.DAY_OF_MONTH);
		
	}
	
	public static int current_month() {
		
	      Calendar cal = Calendar.getInstance();
	      return cal.get(Calendar.MONTH)+1;
		
	}
	
	public static int day(String s) {
		
		s = s.substring(0,2);
		return Integer.parseInt(s);
		
	}
	
	public static int month(String s) {
		
		s = s.substring(3,5);
		return Integer.parseInt(s);
		
	}
	
}
