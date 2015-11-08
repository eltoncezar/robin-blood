package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import data.ConnectException;
import models.User;
import business.UserRegistrationController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserList extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private UserRegistrationController controller;

	public UserList() {
		controller = new UserRegistrationController();

		setClosable(true);
		setTitle("Listar Usu\u00E1rios");
		// setBounds(100, 100, 450, 300);
		setSize(450, 350);
		
		table = new JTable();
		table.setModel(controller.getTableModel(controller.getAll()));

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

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																scrollPane,
																GroupLayout.DEFAULT_SIZE,
																406,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				textField,
																				GroupLayout.DEFAULT_SIZE,
																				323,
																				Short.MAX_VALUE)
																		.addGap(18)
																		.addComponent(
																				btnBuscar))
														.addComponent(lblNome))
										.addContainerGap())
						.addGroup(
								Alignment.TRAILING,
								groupLayout.createSequentialGroup()
										.addContainerGap(341, Short.MAX_VALUE)
										.addComponent(btnEditar).addGap(32)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblNome)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(btnBuscar))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE,
												201, GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(btnEditar)
										.addContainerGap(19, Short.MAX_VALUE)));

		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
}
