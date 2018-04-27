package com.uri870.elcmonitor.client;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class run {
	public static void main(String[] args) {
		
		FileInputStream in = null;
		try {
			in = new FileInputStream("em.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String facilityName = prop.getProperty("facilityName");
		try {
			in.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		int i = 1;
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		gui.setT2Text("\n"+sdf.format(date)+": "+facilityName+"- Monitor Starting...");
	while(true) {
		gui.setT2Text("\n"+"Loop Number: "+i);
		
	try {
		monitor.main(args);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	i++;
	}
}
}
