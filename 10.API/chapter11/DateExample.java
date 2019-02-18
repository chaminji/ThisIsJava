package chapter11;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateExample {
	public static void main(String[] args) {
		Date now = new Date(0);
		String strNow1 = now.toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
	}
}
