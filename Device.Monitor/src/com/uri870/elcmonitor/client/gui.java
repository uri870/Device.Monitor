package com.uri870.elcmonitor.client;
import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces

import javax.swing.AbstractButton;
import javax.swing.JToggleButton;

// An AWT program inherits from the top-level container java.awt.Frame
public class gui extends Frame implements ActionListener {
   public static TextArea tfCount; // Declare a TextField component 
   private Button btnCount;   // Declare a Button component
   private Button btnStart;   // Declare a Button component
   private Button btnStatus;   // Declare a Button component
   private JToggleButton toggleButton;
   public static TextArea statusView;

   
   // Constructor to setup GUI components and event handlers
   public gui () {
	   
	  setLayout(new FlowLayout());
         // "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
         // the components from left-to-right, and flow to next row from top-to-bottom.
 
      //lblCount = new Label("Counter");  // construct the Label component
      //add(lblCount);                    // "super" Frame container adds Label component
      
      
      tfCount = new TextArea(13, 75); // construct the TextField component
      tfCount.setEditable(false);       // set to read-only
      add(tfCount);                     // "super" Frame container adds TextField component


      
      btnStart = new Button("Start");   // construct the Button component
      add(btnStart);                    // "super" Frame container adds Button component
      
      
      btnStart.addActionListener(this);
         // "btnCount" is the source object that fires an ActionEvent when clicked.
         // The source add "this" instance as an ActionEvent listener, which provides
         //   an ActionEvent handler called actionPerformed().
         // Clicking "btnCount" invokes actionPerformed().

      btnCount = new Button("Reset Notifications");   // construct the Button component
      add(btnCount);                    // "super" Frame container adds Button component
      

 
      btnCount.addActionListener(this);
         // "btnCount" is the source object that fires an ActionEvent when clicked.
         // The source add "this" instance as an ActionEvent listener, which provides
         //   an ActionEvent handler called actionPerformed().
         // Clicking "btnCount" invokes actionPerformed().
      
      btnStatus = new Button("Status");   // construct the Button component
      add(btnStatus);                    // "super" Frame container adds Button component
      btnStatus.addActionListener(this);
      
      
      toggleButton = new JToggleButton("Notifications OFF");
      add(toggleButton);
      toggleButton.addActionListener(this);

 
      
         // "btnCount" is the source object that fires an ActionEvent when clicked.
         // The source add "this" instance as an ActionEvent listener, which provides
         //   an ActionEvent handler called actionPerformed().
         // Clicking "btnCount" invokes actionPerformed().
     
      //statusView = new TextArea(13, 45); // construct the TextField component
      //statusView.setEditable(false);       // set to read-only
      //add(statusView);                     // "super" Frame container adds TextField component

 
      setTitle("ELC Monitor V1.0");  // "super" Frame sets its title
      setSize(650, 300);        // "super" Frame sets its initial window size
      addWindowListener( new WindowAdapter() {
    	  @Override
          public void windowClosing(WindowEvent we) {

              System.exit(0);
    	  }
      });
      // For inspecting the Container/Components objects
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
 
      setVisible(true);         // "super" Frame shows
 
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
      
      
      
   }
 

// The entry main() method
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an instance
      gui app = new gui();
         // or simply "new AWTCounter();" for an anonymous instance

   }
 
 
   Thread t = new Thread(new Runnable() {
       @Override
       public void run() {
            run.main(null);
       }
});
  
   
   
   // ActionEvent handler - Called back upon button-click.
   @Override
   public void actionPerformed(ActionEvent evt) {
	   if(evt.getSource() == btnCount) {
	   resetErrorCounter.main();
	   }
	   if(evt.getSource() == btnStart) {
		   btnStart.setEnabled(false);
		   
		   t.start();
		  
	
		}
	   if(evt.getSource() == btnStatus) {
		   
		   guiStatus.main(null);
		  
	
		}

	   if(evt.getSource() == toggleButton) {
		   AbstractButton abstractButton = (AbstractButton) evt.getSource();
		   boolean selected = abstractButton.getModel().isSelected();
		   int value;
		   if(selected==true) {
		   toggleButton.setText("Notifications ON");
		   
		   notificationsToggle.main(value=1);
		   }
		   if(selected==false) {
			   toggleButton.setText("Notifications OFF");
			   notificationsToggle.main(value=0);
			   }
	
	   }

		   
   }
   public static void setT2Text(String text){
	   tfCount.append(text);
	}
   

}