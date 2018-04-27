package com.uri870.elcmonitor.client;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class resetErrorCounter {
	final static DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public static void main() {
		Properties prop = new Properties();
		InputStream input = null;
		int i = 1;
		int count = 1;
		String addr = null;
		String id = null;
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
					
					
				FileInputStream in = new FileInputStream("errorCounter.properties");
				Properties props = new Properties();
				props.load(in);
				in.close();
				
				
				FileOutputStream out = new FileOutputStream("errorCounter.properties");
				props.setProperty(id, "0");
				props.store(out, null);
				out.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			i++;
			}
		Date date = new Date();
		gui.setT2Text("\n"+sdf.format(date)+": Error count has been reset! ");
		
	}

}
