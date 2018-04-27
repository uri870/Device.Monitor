package com.uri870.elcmonitor.client;
import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

// An AWT program inherits from the top-level container java.awt.Frame
public class guiStatus extends Frame implements ActionListener {
   public static TextArea tfCount; // Declare a TextField component 
   public static JTextPane statusView;

   
   // Constructor to setup GUI components and event handlers
   public guiStatus () {
	   
	  setLayout(new FlowLayout());
         // "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
         // the components from left-to-right, and flow to next row from top-to-bottom.
 
      //lblCount = new Label("Counter");  // construct the Label component
      //add(lblCount);                    // "super" Frame container adds Label component
      
	  statusView = new JTextPane(); // construct the TextField component
	  statusView.setEditable(false);       // set to read-only
      add(statusView);                     // "super" Frame container adds TextField component

      guiStatus.setT1Text2("Devices with Errors: \n");
      Properties prop = new Properties();
  	InputStream input = null;

  	try {

  		InputStream input1 = new FileInputStream("errorCounter.properties");
  		prop.load(input1);

  		Enumeration<?> e = prop.propertyNames();
  		while (e.hasMoreElements()) {
  			String key = (String) e.nextElement();
  			String value = prop.getProperty(key);
  			int countValue = Integer.parseInt(value);
  			if(countValue>0) {
  			guiStatus.setT2Text2("Device : " + key + ", Error Count : " + value+"\n");
  			}
  		}

  	} catch (IOException ex) {
  		ex.printStackTrace();
  	} finally {
  		if (input != null) {
  			try {
  				input.close();
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
  		}
  	}
 
      setTitle("ELC Monitor V1.0 - Status View");  // "super" Frame sets its title
      setSize(450, 200);        // "super" Frame sets its initial window size
      addWindowListener( new WindowAdapter() {
    	  @Override
          public void windowClosing(WindowEvent we) {
    		  dispose();
              
    	  }
      });

      // For inspecting the Container/Components objects
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
      setLocationRelativeTo(null);
      setVisible(true);         // "super" Frame shows
 
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
      
      
      
   }
 

// The entry main() method
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an instance
      guiStatus app = new guiStatus();
         // or simply "new AWTCounter();" for an anonymous instance

   }


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
public static void setT1Text2(String text){
	try {
		StyledDocument doc = statusView.getStyledDocument();
		SimpleAttributeSet keyWord = new SimpleAttributeSet();
		StyleConstants.setBold(keyWord, true);
	      doc.insertString(doc.getLength(), text, keyWord);
	   } catch(BadLocationException exc) {
	      exc.printStackTrace();
	   }
	}

public static void setT2Text2(String text){
	try {
		StyledDocument doc = statusView.getStyledDocument();
		SimpleAttributeSet keyWord = new SimpleAttributeSet();
		StyleConstants.setForeground(keyWord, Color.RED);
		StyleConstants.setBackground(keyWord, Color.YELLOW);
		StyleConstants.setBold(keyWord, true);
	      doc.insertString(doc.getLength(), "-> "+text, keyWord);
	   } catch(BadLocationException exc) {
	      exc.printStackTrace();
	   }
	}

  

}