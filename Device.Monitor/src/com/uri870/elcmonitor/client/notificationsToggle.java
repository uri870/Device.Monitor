package com.uri870.elcmonitor.client;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class notificationsToggle {
static int notificationToggle;
final static DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public static void main(int i) {
		// TODO Auto-generated method stub
		if (i==1) {
			notificationToggle=1;
			Date date = new Date();
			gui.setT2Text("\n"+sdf.format(date)+": notifications enabled ");
		}else {
			notificationToggle=0;
			Date date = new Date();
			gui.setT2Text("\n"+sdf.format(date)+": notifications disabled ");
			
		}
		
	}
	public static void main1(String id) {
		// TODO Auto-generated method stub
		if (notificationToggle==1) {
			try {
				gui.setT2Text("\n Sending notifications for devices: "+id);
				sendMail.main(id);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {gui.setT2Text("\n Notifications are disabled.");}
		
	}

}
