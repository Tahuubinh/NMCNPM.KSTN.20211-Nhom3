package services;

import java.awt.Font;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import com.toedter.calendar.JDateChooser;


public class TimeStampService {

	final static String NEW_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	
	public Timestamp convertTimeStamp(Date date, String hour, String mitue) {
		Timestamp timestamp = null;		
		return timestamp;
	}
	
	public Timestamp convertFromString(String timestamp) {
		Timestamp t = null;		
		return t;
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
		JDateChooser date = new JDateChooser();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = date.getDate();
		Calendar cal = Calendar.getInstance();
		date.setDate(sdf.parse("2022-1-15"));
		String str = sdf.format(d).toString();
		Timestamp timestamp = Timestamp.valueOf(str + " 00:00:00");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH'h':mm'm,' dd 'tháng' MM', năm' yyyy");
		String str2 = sdf2.format(d);
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String yy = str2.substring(str2.length() - 4, str2.length());
		String mm = str2.substring(str2.length() - 12, str2.length()-10);
		String dd = str2.substring(9, 11);
		String hh = str2.substring(0, 2);
		String mn = str2.substring(4, 6);
		String str3 = yy + "-" + mm + "-" + dd + " " + hh + ":" + mn + ":00";
		Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(c.YEAR, 2);
        d = c.getTime();
        date.setDate(d);
		System.out.println(date.getDate());
		System.exit(0);
	}
}
