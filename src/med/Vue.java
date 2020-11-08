package med;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
@SuppressWarnings("unused")
class Vue extends JFrame {
    Modele modele;
    
    private static final long serialVersionUID = 1L;
    
    JButton MonPlayBtn;
    JButton MonPauseBtn;
    JButton MonPreviousBtn;
    JButton MonNextBtn;
    JButton MonScreenshotBtn;
	JButton CHOOSER;
    
    Vue(Modele modele) {
    	this.modele = modele;
    	modele.mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
    	
		 try {
	         UIManager.setLookAndFeel(
	         UIManager.getSystemLookAndFeelClassName());
	      } 
	      catch (Exception e) {
	         System.out.println(e);
	      }
    	this.setTitle("L2soirMediaPlayer");
		this.setBounds(100, 100, 600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());   	 
      

        JPanel controlsPane = new JPanel();
        controlsPane.setBackground(Color.BLACK);
        
		//Pour previous BTN///////////////////////////////////////////////////
        Icon MonScreenshotBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("screenshot.png"));
        MonScreenshotBtn = new JButton(MonScreenshotBtnIcon);
        MonScreenshotBtn.setContentAreaFilled(false);
        MonScreenshotBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        controlsPane.add(MonScreenshotBtn); 
        
        
		//Pour previous BTN///////////////////////////////////////////////////
        Icon MonPreviousBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("previous.png"));
        MonPreviousBtn = new JButton(MonPreviousBtnIcon);
        MonPreviousBtn.setContentAreaFilled(false);
        MonPreviousBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        controlsPane.add(MonPreviousBtn); 
        
		//Pour PLAY BTN///////////////////////////////////////////////////
 
        Icon MonPlayBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("play.png"));
        MonPlayBtn = new JButton(MonPlayBtnIcon); 
        MonPlayBtn.setContentAreaFilled(false);
        MonPlayBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        controlsPane.add(MonPlayBtn);
   

         
        
        
		//Pour Pause BTN///////////////////////////////////////////////////
        Icon MonPauseBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("pause.png"));
        MonPauseBtn = new JButton(MonPauseBtnIcon); 
        MonPauseBtn.setContentAreaFilled(false);
        MonPauseBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        controlsPane.add(MonPauseBtn);
        
      //Pour next BTN///////////////////////////////////////////////////
        Icon MonNextBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("next.png"));
        MonNextBtn = new JButton(MonNextBtnIcon); 
        MonNextBtn.setContentAreaFilled(false);
        MonNextBtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        controlsPane.add(MonNextBtn); 
        
        
		//CHOOSER///////////////////////////////////////////////////
        Icon CHOOSERBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("folder.png"));
		CHOOSER = new JButton(CHOOSERBtnIcon);
		CHOOSER.setContentAreaFilled(false);
		CHOOSER.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		controlsPane.add(CHOOSER);
		
        /////////////////////////////////////////////////////////
        contentPane.add(controlsPane, BorderLayout.SOUTH);
        contentPane.add(modele.mediaPlayerComponent, BorderLayout.CENTER);	 
        this.setContentPane(contentPane);
        this.setVisible(true);
  
    }
	

    
    
    
}