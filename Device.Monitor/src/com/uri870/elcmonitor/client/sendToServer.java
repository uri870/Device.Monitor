package com.uri870.elcmonitor.client;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.OutputStream;

import java.io.OutputStreamWriter;

import java.net.InetAddress;

import java.net.Socket;
import java.util.Properties;

public class sendToServer

{

 private static Socket socket;

 public static void main(String id) throws IOException

 {
	 
		FileInputStream in = new FileInputStream("em.properties");
		Properties prop = new Properties();
		prop.load(in);
		String facilityName = prop.getProperty("facilityName");
		in.close();

 try

 {
 String idAndValue = id+","+facilityName;
 String host = "localhost";

 int port = 25000;

 InetAddress address = InetAddress.getByName(host);

 socket = new Socket(address, port);

 //Send the message to the server

 OutputStream os = socket.getOutputStream();

 OutputStreamWriter osw = new OutputStreamWriter(os);

 BufferedWriter bw = new BufferedWriter(osw);

 String number = idAndValue;

 String sendMessage = number;

 bw.write(sendMessage);

 bw.flush();

 System.out.println("Message sent to the server : "+sendMessage);

 //Get the return message from the server



 }

 catch (Exception exception)

 {

 exception.printStackTrace();

 }

 finally

 {

 //Closing the socket

 try

 {

 socket.close();

 }

 catch(Exception e)

 {

 e.printStackTrace();

 }

 }

 }

}
