package med;

public class Main {

	 public static void main(String[] arg) {
			Modele modele = new Modele();
			Vue vue = new Vue(modele);
			Controleur controleur =  new Controleur(modele, vue);
			vue.MonPlayBtn.addActionListener(controleur);
			vue.MonPauseBtn.addActionListener(controleur);
			vue.MonNextBtn.addActionListener(controleur);
			vue.MonPreviousBtn.addActionListener(controleur);
			vue.CHOOSER.addActionListener(controleur);
			vue.MonScreenshotBtn.addActionListener(controleur);
			
			
		  }
}
