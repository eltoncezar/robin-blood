package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
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
	private JTextField textField_nome;
	private JTextField textField_mail;
	private JPasswordField passwordField;
	private UserList userlist;
	private JDesktopPane desktopPane;
	
	private UserRegistrationController controller;
	

	public UserRegistration() throws ConnectException {
		
		controller = new UserRegistrationController();
		
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Cadastrar Usu\u00E1rio");
		//setBounds(100, 100, 600, 500);
		setSize(305,300);
		
		//Teste Segunda janela
		desktopPane = new JDesktopPane();
        setContentPane(desktopPane);
        
		
		JLabel lblNome = new JLabel("Nome");
		
		JLabel lblSenha = new JLabel("Senha");
		
		JLabel lblEmail = new JLabel("E-mail");
		
		textField_nome = new JTextField();
		textField_nome.setColumns(10);
		
		textField_mail = new JTextField();
		textField_mail.setColumns(10);
		
		JButton btnOk = new JButton("Salvar");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		passwordField = new JPasswordField();
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNewLabel_1 = new JLabel("Tipo Usuário");
		
		
		List<UserType> userTypes = controller.getUserTypes();
		JComboBox comboBox = new JComboBox(new DefaultComboBoxModel<>(userTypes.toArray()));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		
		JButton btnAlterar = new JButton("Buscar");
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(userlist == null){
                	userlist = new UserList();
                	userlist.setVisible(true);
                	MainWindow.getDesktopPanel().add(userlist);
                }
                else if(!userlist.isVisible()){
                	userlist.setVisible(true);
                	MainWindow.getDesktopPanel().add(userlist);
                }
           		//Inicializa Frame Centralizado
           		userlist.setBounds(0, 0, userlist.getWidth(), userlist.getHeight());
           		int lDesk = MainWindow.getDesktopPanel().getWidth();
                int aDesk = MainWindow.getDesktopPanel().getHeight();
                int lIFrame = userlist.getWidth();
                int aIFrame = userlist.getHeight();
                userlist.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
                userlist.moveToFront();
			
            }
			
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
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
						.addComponent(textField_nome)
						.addComponent(textField_mail)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSenha)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))))
					.addContainerGap(195, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(btnCancelar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAlterar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(224, Short.MAX_VALUE))
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
					.addComponent(textField_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblEmail)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_mail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnAlterar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
}
