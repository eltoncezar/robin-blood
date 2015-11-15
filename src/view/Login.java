package view;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class Login extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	public Login() throws IOException {
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		
		passwordField = new JPasswordField();
		
		BufferedImage myPicture = ImageIO.read(new File("..\\Imagens\\IconBlood1.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(162)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsurio)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
								.addComponent(lblSenha)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(picLabel)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(lblUsurio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSenha)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(picLabel)
					.addContainerGap(81, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
