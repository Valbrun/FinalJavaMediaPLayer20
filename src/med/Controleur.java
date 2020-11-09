package med;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

class  Controleur implements ActionListener{ 
	private static String VIDEO_PATH;
	Modele modele;
    Vue vue;
	private static JFileChooser filechooser = new JFileChooser(); 
    String fullPath;
    String ZS;
    Controleur(Modele modele, Vue vue) {
	this.modele = modele;
	this.vue = vue;
    }
    
    @SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {
    	
    	if (e.getSource() == vue.MonPlayBtn)  {
    	System.out.print("play"); 
        modele.mediaPlayerComponent.mediaPlayer().media().play(VIDEO_PATH);
    	}
    	
    	if (e.getSource() == vue.MonPauseBtn)  
    	{
    	System.out.print("pause");
        modele.mediaPlayerComponent.mediaPlayer().controls().pause(); 
    	}
    	
    	if (e.getSource() == vue.CHOOSER)  
    	{
    			  System.out.print("chooser ");  
	        	  System.out.print("CHOOSER CLICKED");	
	        	  File ourfile;
	              filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	              filechooser.showSaveDialog(null);
	              ourfile = filechooser.getSelectedFile();
	              VIDEO_PATH  = ourfile.getAbsolutePath(); 
	              System.out.print(VIDEO_PATH);	
	          }
    	
    	if(e.getSource() == vue.MonNextBtn) {
    		System.out.print("next");
    		modele.mediaPlayerComponent.mediaPlayer().controls().skipTime(9000);
    	}
    	
    	if(e.getSource() == vue.MonPreviousBtn) {
    		System.out.print("previous ");
    		 modele.mediaPlayerComponent.mediaPlayer().controls().skipTime(-6000);	
    	}
    	
    	if(e.getSource() == vue.MonScreenshotBtn) {
 
			try {
	            filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	            filechooser.showSaveDialog(null);
	           
				File file = filechooser.getCurrentDirectory();
				fullPath = file.getPath();
//				System.out.print(fullPath );
				  ZS ="b";
				  
				if ( ZS != null ) {
				Robot robot = new Robot();
				Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				BufferedImage screenshot = robot.createScreenCapture(rec);
				
			 
			
				
				String Pics =  ("\\screenshot" + Math.random()+".jpg");        
				ImageIO.write(screenshot,"JPG",
						new File(fullPath + Pics));
				 System.out.print(fullPath + Pics);
				}
				
			} catch (IOException | AWTException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
  			
    	}
    	
	}

	}; 
    	