package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import models.User;

public class UserList extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtParBusca;
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
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);


		JLabel lblNome = new JLabel("Nome");

		txtParBusca = new JTextField();
		
		txtParBusca.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) {  
					btnBuscar.doClick();  
		          }  
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtParBusca.getText().equals("")){
					JOptionPane.showMessageDialog(getParent(), "Nome Invalido!","Robin Blood",JOptionPane.ERROR_MESSAGE);
				}else{
					if(controller.getByFilter(txtParBusca.getText()).isEmpty()){
						JOptionPane.showMessageDialog(getParent(), "Usuário não registrado!","Robin Blood",JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						table.setModel(controller.getTableModel(controller.getByFilter(txtParBusca.getText())));
					}			
				}
				
			}
		});
		txtParBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) {  
					btnBuscar.doClick();  
		          } 
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
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowIndex = table.getSelectedRow();
				if (rowIndex > -1) {
					User selectedItem = users.get(rowIndex);
					try {
						controller.delete(selectedItem);
					} catch (ConnectException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(getContentPane(), "Selecione um item!", "Robin Blood", JOptionPane.WARNING_MESSAGE);
				}
				
			}
				
			
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(185, Short.MAX_VALUE)
					.addComponent(btnExcluir)
					.addGap(18)
					.addComponent(btnNovo)
					.addGap(18)
					.addComponent(btnEditar)
					.addGap(32))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(txtParBusca, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnBuscar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtParBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnNovo)
						.addComponent(btnExcluir))
					.addContainerGap(26, Short.MAX_VALUE))
		);

		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
	
	private void createUserRegistration(User user) {
		// Verifica inicialização do Frame
		if (userResFrame == null) {
			try {
				userResFrame = new UserRegistration(user);
			} catch (ConnectException e1) {
				e1.printStackTrace();
			}
			userResFrame.setVisible(true);
			MainWindow.getDesktopPanel().add(userResFrame);
		} else if (!userResFrame.isVisible()) {
			try {
				userResFrame = new UserRegistration(user);
			} catch (ConnectException e) {
				e.printStackTrace();
			}
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
