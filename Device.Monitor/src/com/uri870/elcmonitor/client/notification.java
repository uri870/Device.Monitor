package com.uri870.elcmonitor.client;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class notification {
	

	public static void main(String id) throws IOException {
		FileInputStream ini = new FileInputStream("em.properties");
		Properties propi = new Properties();
		propi.load(ini);
		String numberOfPings = propi.getProperty("numberOfPings");
		int numberOfPingsInt = Integer.parseInt(numberOfPings);
		ini.close();
		
		
		FileInputStream in = new FileInputStream("errorCounter.properties");
		Properties props = new Properties();
		props.load(in);
		String countString = props.getProperty(id);
		int countInt = Integer.parseInt(countString);
		in.close();
		
		if(countInt==numberOfPingsInt) {
			
			gui.setT2Text("\n Count reached, checking if notifications are enabled.. ");
			notificationsToggle.main1(id);
			sendToServer.main(id);
		}
		
		
	}

}
