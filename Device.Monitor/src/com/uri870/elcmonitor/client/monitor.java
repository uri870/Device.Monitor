package com.uri870.elcmonitor.client;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class monitor {
	
  public static void main(String[] args) throws IOException {
	  
	Properties prop = new Properties();
	InputStream input = null;
	int i = 1;
	int count = 1;
	String addr = null;
	String id = null;
	final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	

	try (InputStream is = new FileInputStream("config.properties")) {
        
        for (int aChar = 0; aChar != -1;aChar = is.read())
            count += aChar == '\n' ? 1 : 0;
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
while(i <= count) {
	
	try {

		input = new FileInputStream("config.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
			String[] device = prop.getProperty("device"+i).split(",");
			
			String str = Arrays.toString(device);
			addr = str.substring( 1, str.indexOf(","));
			id = str.substring(str.indexOf(",")+3, str.length()-1);    
			//InetAddress.getByName(addr).isReachable(5000);
			InetAddress[] addresses = InetAddress.getAllByName(addr);
	      for (InetAddress address : addresses) {
	        if (address.isReachable(5000))
	        {   
	        	Date date = new Date();
	        	gui.setT2Text("\n"+sdf.format(date)+": Success! ip: " + addr + ", id: " +id);
	        	errorResetter.main(id);
	           
	        }
	        else
	        {
	        	Date date = new Date();
	           gui.setT2Text("\n"+sdf.format(date)+": Failed! ip: "+addr + " id: " + id);
	           errorCounter.main(id);
	           
	        }
	      }

	} catch (IOException ex) {
		ex.printStackTrace();
		try {
			Date date = new Date();
			gui.setT2Text("\n"+sdf.format(date)+": Failed! ip: "+addr + " id: " + id);
			errorCounter.main(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
i++;
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  }
}