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
import javax.swing.JButton;

import business.DonationController;
import business.LoginController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	private static MainWindow windows;

	public Login() throws IOException {
		LoginController controller = new LoginController();

		setSize(300, 233);
		setVisible(true);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");

		txtPassword = new JPasswordField();

		BufferedImage myPicture = ImageIO.read(new File(
				"Imagens\\logo_small.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (controller.validateUser(txtUsuario.getText(), new String(txtPassword.getPassword()))) {
					windows.getInstancia();
					dispose();
				}
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(picLabel, GroupLayout.PREFERRED_SIZE,
								139, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(btnEntrar,
												Alignment.TRAILING,
												GroupLayout.DEFAULT_SIZE, 127,
												Short.MAX_VALUE)
										.addComponent(txtPassword,
												Alignment.TRAILING,
												GroupLayout.DEFAULT_SIZE, 127,
												Short.MAX_VALUE)
										.addComponent(lblSenha)
										.addComponent(txtUsuario,
												Alignment.TRAILING,
												GroupLayout.DEFAULT_SIZE, 127,
												Short.MAX_VALUE)
										.addComponent(lblUsurio))
						.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				picLabel,
																				GroupLayout.PREFERRED_SIZE,
																				181,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																Alignment.TRAILING,
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblUsurio)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				txtUsuario,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				lblSenha)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				txtPassword,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				btnEntrar)
																		.addGap(22)))));
		getContentPane().setLayout(groupLayout);
	}
}
