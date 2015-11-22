package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import business.LoginController;
import java.awt.Toolkit;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;


	public Login() throws IOException {
		LoginController controller = new LoginController();

		setSize(350, 250);
		setVisible(true);
				

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		JButton btnEntrar = new JButton("Entrar");
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) {  
					btnEntrar.doClick();  
		          } 
			}
		});


		JLabel picLabel = new JLabel();
		picLabel.setIcon(new ImageIcon(Login.class.getResource("/Imagens/logo_small.png")));

		
		btnEntrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) {  
					btnEntrar.doClick();  
		          } 
			}
		});
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (controller.validateUser(txtUsuario.getText(), new String(txtPassword.getPassword()))) {
					MainWindow.getInstancia();
					dispose();
				}
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(picLabel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUsurio, Alignment.LEADING)
						.addComponent(txtUsuario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
						.addComponent(btnEntrar, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
						.addComponent(lblSenha, Alignment.LEADING)
						.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUsurio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSenha)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(12))
						.addComponent(picLabel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagens/IconLogo.png")));
	}
}
