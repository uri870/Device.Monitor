package com.uri870.elcmonitor.client;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class errorResetter {

	public static void main(String id) throws IOException {
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		FileInputStream ini = new FileInputStream("em.properties");
		Properties propi = new Properties();
		propi.load(ini);
		String numberOfPings = propi.getProperty("numberOfPings");
		int numberOfPingsInt = Integer.parseInt(numberOfPings);
		ini.close();
		
		FileInputStream inin = new FileInputStream("errorCounter.properties");
		Properties propsi = new Properties();
		propsi.load(inin);
		String countString = propsi.getProperty(id);
		int countInt = Integer.parseInt(countString);
		inin.close();
		
		if(countInt>numberOfPingsInt) {
			FileInputStream in = new FileInputStream("errorCounter.properties");
			Properties props = new Properties();
			props.load(in);
			in.close();

			FileOutputStream out = new FileOutputStream("errorCounter.properties");
			props.setProperty(id, "0");
			props.store(out, null);
			out.close();
			Date date = new Date();
			gui.setT2Text("\n"+sdf.format(date)+": id: " +id+" Success - counter reset.. ");
			gui.setT2Text("\n Connection restored for device: "+id);
			sendResetMail.main(id);
		}

		FileInputStream in = new FileInputStream("errorCounter.properties");
		Properties props = new Properties();
		props.load(in);
		in.close();

		FileOutputStream out = new FileOutputStream("errorCounter.properties");
		props.setProperty(id, "0");
		props.store(out, null);
		out.close();
		Date date = new Date();
		gui.setT2Text("\n"+sdf.format(date)+": id: " +id+" Success - counter reset.. ");
		notification.main(id);
		
	}
	
}
