package med;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

class  Controleur implements ActionListener{ 
	private static String VIDEO_PATH;
	Modele modele;
    Vue vue;
	private static JFileChooser filechooser = new JFileChooser(); 
    
    Controleur(Modele modele, Vue vue) {
	this.modele = modele;
	this.vue = vue;
//    modele.mediaPlayerComponent.mediaPlayer().media().play("lib\\dd.mp4");
    }
    
    @SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {
    	
    	if (e.getSource() == vue.MonPlayBtn)  {
    	System.out.print("play");
//    	modele.mediaPlayerComponent.mediaPlayer().controls().play(); 
        modele.mediaPlayerComponent.mediaPlayer().media().play(VIDEO_PATH);
    	}
    	
    	if (e.getSource() == vue.MonPauseBtn)  
    	{
    	System.out.print("pause");
        modele.mediaPlayerComponent.mediaPlayer().controls().pause(); 
    	}
    	
    	if (e.getSource() == vue.CHOOSER)  
    	{
    			  System.out.print("pause");
 
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
    		modele.mediaPlayerComponent.mediaPlayer().controls().skipTime(5000);
    	}
    	
    	if(e.getSource() == vue.MonPreviousBtn) {
    		System.out.print("previous");
    		 modele.mediaPlayerComponent.mediaPlayer().controls().skipTime(-6000);	
    	}
    	
    	if(e.getSource() == vue.MonScreenshotBtn) {
    		System.out.print("Screenshot");
    		 try {
				Robot robot = new Robot();
				Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				
				BufferedImage screenshot = robot.createScreenCapture(rec);
				ImageIO.write(screenshot,"JPG",
						new File("D:\\screenshot.jpg"));
				
			} catch ( Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    			
    	}
    	
	}

	}; 
    	