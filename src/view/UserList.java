package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import data.ConnectException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserList extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private UserRegistration userResFrame;
	private JDesktopPane desktopPane;
	private static MainWindow mainwindow;
	

	public UserList() {
		setClosable(true);
		setTitle("Listar Usu\u00E1rios");
		setSize(450, 350);
		
		JLabel lblNome = new JLabel("Nome");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		
		JButton btnEditar = new JButton("Editar");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(userResFrame == null){
                	try {
						userResFrame = new UserRegistration();
					} catch (ConnectException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
                	userResFrame.setVisible(true);
                	MainWindow.getDesktopPanel().add(userResFrame);
                }
                else if(!userResFrame.isVisible()){
                	userResFrame.setVisible(true);
                    desktopPane.add(userResFrame);
                }
           		//Inicializa Frame Centralizado
           		userResFrame.setBounds(0, 0, userResFrame.getWidth(), userResFrame.getHeight());
                int lDesk = MainWindow.getDesktopPanel().getWidth();
                int aDesk = MainWindow.getDesktopPanel().getHeight();
                int lIFrame = userResFrame.getWidth();
                int aIFrame = userResFrame.getHeight();
                userResFrame.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
                userResFrame.moveToFront();
                
                
            }
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnBuscar))
						.addComponent(lblNome))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(234, Short.MAX_VALUE)
					.addComponent(btnNovo)
					.addGap(18)
					.addComponent(btnEditar)
					.addGap(32))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnNovo))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "E-mail"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
}
