package com.example.demo.utility;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public interface UtilityInterface {
	public static String updateMessage="Update success fully";
	public static String insertFailedByIdMessage="Creation record failed";
	public static String notUpdatedByID="geating error during updating  Header where id=";
	static String getCurrentDate() {
		String date=new SimpleDateFormat("dd-mm-yyyy").format(Calendar.getInstance().getTime());
		return date;
	}

}
