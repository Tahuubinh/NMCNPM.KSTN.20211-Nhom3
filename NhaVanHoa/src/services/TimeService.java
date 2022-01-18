package services;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeService {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("HH'h':mm'm,' dd-MM-yyyy");
	private SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public String convertToDate(Timestamp timestamp) {
		return sdf.format(timestamp);
	}
	public String convertToDateShowInTable(Timestamp timestamp) {
		return sdf2.format(timestamp).toString();
	}
	
	public Timestamp convertDateToTimestamp(Date date, String hour, String minute) {
		String str = sdf.format(date).toString();
		str = str + " " + hour + ":" + minute + ":00";
		Timestamp timestamp = Timestamp.valueOf(str);
		return timestamp;
	}
	
	public Timestamp convertDatesqlToTimestamp(java.sql.Date date) {
		String str = sdf3.format(date);
		return Timestamp.valueOf(str);
	}
	
	public Timestamp convertDateToTimestamp(Date date) {
		String str = sdf3.format(date);
		return Timestamp.valueOf(str);
	}
	
	public String convertTimestampPostgresql(Timestamp timestamp) {
		return sdf3.format(timestamp);
	}
	public Timestamp convertDatetableToTimestamp(String str2) {
		String yy = str2.substring(str2.length() - 4, str2.length());
		String mm = str2.substring(str2.length() - 7, str2.length()-5);
		String dd = str2.substring(str2.length() - 10, str2.length()-8);
		String hh = str2.substring(0, 2);
		String mn = str2.substring(4, 6);
		String str3 = yy + "-" + mm + "-" + dd + " " + hh + ":" + mn + ":00";
		return Timestamp.valueOf(str3);
	}
}
