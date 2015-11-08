package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import business.UserRegistrationController;
import data.ConnectException;
import models.Donor;
import models.User;

import javax.swing.JFrame;

public class UserList extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private UserRegistrationController controller;
	private UserRegistration userResFrame;

	public UserList() {
		setClosable(true);
		controller = new UserRegistrationController();
		setTitle("Listar Usu\u00E1rios");
		// setBounds(100, 100, 450, 300);
		setSize(450, 350);
		
		List<User> users = controller.getAll();
		table = new JTable();
		table.setModel(controller.getTableModel(users));
		


		JLabel lblNome = new JLabel("Nome");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(controller.getTableModel(controller.getByFilter("el")));
			}
		});

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowIndex = table.getSelectedRow();
				if (rowIndex > -1) {
					User selectedItem = users.get(rowIndex);
					createUserRegistration(selectedItem);
				}
				else {
					JOptionPane.showMessageDialog(getContentPane(), "Selecione um item!", "Robin Blood", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				createUserRegistration(new User());
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(
										groupLayout.createSequentialGroup().addGap(18)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 406,
																Short.MAX_VALUE)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(textField, GroupLayout.DEFAULT_SIZE, 323,
																Short.MAX_VALUE)
														.addGap(18).addComponent(btnBuscar)).addComponent(lblNome))
				.addContainerGap()).addGroup(
						groupLayout.createSequentialGroup().addContainerGap(246, Short.MAX_VALUE).addComponent(btnNovo)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnEditar).addGap(32)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNome)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnEditar)
								.addComponent(btnNovo))
						.addContainerGap(19, Short.MAX_VALUE)));

		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
	
	private void createUserRegistration(User user) {
		// Verifica inicialização do Frame
		if (userResFrame == null) {
			try {
				userResFrame = new UserRegistration();
			} catch (ConnectException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			userResFrame.setVisible(true);
			MainWindow.getDesktopPanel().add(userResFrame);
		} else if (!userResFrame.isVisible()) {
			userResFrame.setVisible(true);
			MainWindow.getDesktopPanel().add(userResFrame);
		}
		// Inicializa Frame Centralizado
		userResFrame.setBounds(0, 0, userResFrame.getWidth(), userResFrame.getHeight());
		int lDesk = MainWindow.getDesktopPanel().getWidth();
		int aDesk = MainWindow.getDesktopPanel().getHeight();
		int lIFrame = userResFrame.getWidth();
		int aIFrame = userResFrame.getHeight();
		userResFrame.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
		userResFrame.moveToFront();
	}
	
}
