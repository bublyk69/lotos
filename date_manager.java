import java.util.Calendar;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class date_manager extends mail_manager{
	
	 static Date date = new Date();
	 
	public static void checker(String name , String father , String birth , String mail) {
		
		if (birth_check(birth)) {
			
			name = name + " " + father;
			mail_birthday(mail ,name);
			
		}
		
		if (birth_check(birth)) {
			
			name = name + " " + father;
			mail_remind(mail ,name);
			
		}
		
	} 
	
	public static boolean birth_check(String s) {
		
		if ((day(s) == current_day()) && (month(s) == current_month())) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static boolean visit_check(String s) {
		
		if ((day(s) == current_day()) && ((month(s)+6)%12 == current_month())) {
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
