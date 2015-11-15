package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HospitalList extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private HospitalRegistration hospitalresgistrationframe;

	
	public HospitalList() {
		setClosable(true);
		setTitle("Listar Hospitais");
		setSize(450, 350);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		
		JButton btnBuscar = new JButton("Buscar");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JSeparator separator = new JSeparator();
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hospitalresgistrationframe = new HospitalRegistration();
				hospitalresgistrationframe.setVisible(true);
	   			MainWindow.getDesktopPanel().add(hospitalresgistrationframe);
	   			
	   			hospitalresgistrationframe.setBounds(0, 0, hospitalresgistrationframe.getWidth(), hospitalresgistrationframe.getHeight());
	   	        int lDesk = MainWindow.getDesktopPanel().getWidth();
	   	        int aDesk = MainWindow.getDesktopPanel().getHeight();
	   	        int lIFrame = hospitalresgistrationframe.getWidth();
	   	        int aIFrame = hospitalresgistrationframe.getHeight();
	   	     hospitalresgistrationframe.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
	   	  hospitalresgistrationframe.moveToFront();
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnBuscar))
								.addComponent(lblNome))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNovo)
							.addGap(18)
							.addComponent(btnEditar)
							.addGap(25))))
				.addComponent(separator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnNovo))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}

}
