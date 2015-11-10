package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import data.ConnectException;
import data.UserTypeData;
import javafx.print.PageRange;
import models.User;
import models.UserType;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;

import business.UserRegistrationController;

public class UserRegistration extends JInternalFrame {
	private JTextField txtnome;
	private JTextField txtmail;
	private JPasswordField txtpassword;
	private JDesktopPane desktopPane;
	
	private UserRegistrationController controller;
	

	public UserRegistration(User paran) throws ConnectException {
		
		controller = new UserRegistrationController();
		
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Cadastrar Usu\u00E1rio");
		//setBounds(100, 100, 600, 500);
		setSize(305,300);
		
		//Teste Segunda janela
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
        setContentPane(desktopPane);
        
		
		JLabel lblNome = new JLabel("Nome");
		
		JLabel lblSenha = new JLabel("Senha");
		
		JLabel lblEmail = new JLabel("E-mail");
		
		txtnome = new JTextField();
		txtnome.setColumns(10);
		
		txtmail = new JTextField();
		txtmail.setColumns(10);
		
		JButton btnOk = new JButton("Salvar");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controller.save(new User(
							txtnome.getText(),
							0,
							String.valueOf(txtpassword.getPassword()),
							txtmail.getText(),
							1,
							1
				));	
					JOptionPane.showMessageDialog(getContentPane(), "Salvo com Sucesso!", "Robin Blood", JOptionPane.INFORMATION_MESSAGE);
					txtnome.setText(null);
					txtpassword.setText(null);
					txtmail.setText(null);
				} catch (ConnectException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		txtpassword = new JPasswordField();
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNewLabel_1 = new JLabel("Tipo Usuário");
		
		
		List<UserType> userTypes = controller.getUserTypes();
		JComboBox comboType_User = new JComboBox(new DefaultComboBoxModel<>(userTypes.toArray()));
		comboType_User.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		//Recarregando User para editar
		txtnome.setText(paran.getName());
		txtmail.setText(paran.getEmail());
		txtpassword.setText(paran.getPassword());
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
					.addGap(440))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(440))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtnome)
						.addComponent(txtmail)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSenha)
								.addComponent(txtpassword, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboType_User, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))))
					.addContainerGap(195, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(btnCancelar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(248, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtnome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblEmail)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboType_User, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
}
