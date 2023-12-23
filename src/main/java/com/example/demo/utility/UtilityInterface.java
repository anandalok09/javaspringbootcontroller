package com.example.demo.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public interface UtilityInterface {
	static String getCurrentDate() {
		String date=new SimpleDateFormat("dd-mm-yyyy").format(Calendar.getInstance().getTime());
		return date;
	}

}
