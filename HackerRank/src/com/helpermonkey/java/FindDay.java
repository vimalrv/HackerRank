package com.helpermonkey.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class FindDay {
	public static void main(String[] args) throws ParseException{
		Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        
        Date dt = sdf.parse(year+month+day);
        
        sdf = new SimpleDateFormat("EEEEEEE");
        System.out.println(sdf.format(dt).toUpperCase());
        
	}
}
