package view;

import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class Main {

		
	public static void main(String[] args) throws IOException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
		Login telaLogin = new Login();
		telaLogin.setLocationRelativeTo(null);
		
		

	}

}
