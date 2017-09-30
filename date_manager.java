import java.util.Calendar;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class date_manager extends mail_manager{
	
	 static Date date = new Date(); 
	
	public static void birth_check(String name , String surname , String father , String birth , String visit, String mail) {
		
		if ((day(birth) == current_day()) && (month(birth) == current_month())) {
			name = name + " " + father;
			mail_birthday(mail ,name);
		}
	}
	
	public static void visit_check(String name , String surname , String father , String birth , String visit, String mail) {
		
		if ((month(visit)+6)%12 == current_month() && day(visit)==current_day()) {
			name = name + " " + father;
			mail_remind(mail ,name);
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
