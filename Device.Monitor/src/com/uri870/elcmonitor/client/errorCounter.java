package com.uri870.elcmonitor.client;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class errorCounter {

	public static void main(String id) throws IOException {
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		FileInputStream in = new FileInputStream("errorCounter.properties");
		Properties props = new Properties();
		props.load(in);
		String countString = props.getProperty(id);
		int countInt = Integer.parseInt(countString);
		countInt++;
		String count = Integer.toString(countInt);
		in.close();

		FileOutputStream out = new FileOutputStream("errorCounter.properties");
		props.setProperty(id, count);
		props.store(out, null);
		out.close();
		Date date = new Date();
		gui.setT2Text("\n"+sdf.format(date)+": id: " +id+" failed "+countInt+" times");
		notification.main(id);
		
	}
	
}
