package com.helpermonkey.algoeasy.strings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeConvertor {

	public static String convertTime(String timeInAMPM) throws ParseException {
		
		
		 SimpleDateFormat inFormat = new SimpleDateFormat("hh:mm:ssa");
         //inFormat.setLenient(false);
         Date dt = inFormat.parse(timeInAMPM);
         SimpleDateFormat outFormat = new SimpleDateFormat("HH:mm:ss");
         //outFormat.setTimeZone(timeZone);
         return outFormat.format(dt);
		
	}

	public static void main(String[] args) throws ParseException {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = convertTime(s);
		System.out.println(result);
	}
	
	
//	public static String convertTime(String timeInAMPM) {
//		char[] timeArr = timeInAMPM.toCharArray();
//		// 0, 1, 8, 9
//		char[] newTimeArr = new char[8];
//
//		int hour = new Integer(("" + timeArr[0] + timeArr[1])).intValue();
//		if (('A' == timeArr[8]) && ('M' == timeArr[9])) {
//			if (hour == 12) {
//				hour = 0;
//			}
//		} else if (('P' == timeArr[8]) && ('M' == timeArr[9])) {
//			if (hour == 12) {
//				hour = 12;
//			} else {
//				hour = hour + 12;
//			}
//		}
//		char[] hourArr = (new String("" + hour)).toCharArray();
//		newTimeArr[0] = hourArr[0];
//		newTimeArr[1] = hourArr[1];
//		newTimeArr[2] = timeArr[2];
//		newTimeArr[3] = timeArr[3];
//		newTimeArr[4] = timeArr[4];
//		newTimeArr[5] = timeArr[5];
//		newTimeArr[6] = timeArr[6];
//		newTimeArr[7] = timeArr[7];
//
//		return new String(newTimeArr);
//	}
}