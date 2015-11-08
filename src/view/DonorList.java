package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import models.Donor;
import business.DonorController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class DonorList extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private DonorRegistration donorResFrame;
	private DonorController controller;

	public DonorList() {
		controller = new DonorController();
		
		setClosable(true);
		setTitle("Listar Doadores");
		//setBounds(100, 100, 450, 300);
		setSize(450, 350);
		
		List<Donor> donors = controller.getAll();
		table = new JTable();
		table.setModel(controller.getTableModel(donors));
		
		JLabel lblNome = new JLabel("Nome");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(controller.getTableModel(controller.getByFilter(textField.getText())));
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowIndex = table.getSelectedRow();
				if (rowIndex > -1) {
					Donor selectedItem = donors.get(rowIndex);
					createDonorRegistration(selectedItem);
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
				createDonorRegistration(new Donor());
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
					.addContainerGap(239, Short.MAX_VALUE)
					.addComponent(btnNovo)
					.addGap(18)
					.addComponent(btnEditar)
					.addGap(27))
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
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnNovo))
					.addContainerGap())
		);

		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
	}
	
	private void createDonorRegistration(Donor param) {
		//Verifica inicialização do Frame
   		if(donorResFrame == null){
   			donorResFrame = new DonorRegistration(param);
   			donorResFrame.setVisible(true);
   			MainWindow.getDesktopPanel().add(donorResFrame);
        }
        else if(!donorResFrame.isVisible()){
        	donorResFrame.dispose();
        	donorResFrame = new DonorRegistration(param);
        	donorResFrame.setVisible(true);
        	MainWindow.getDesktopPanel().add(donorResFrame);
        }
   		//Inicializa Frame Centralizado
   		donorResFrame.setBounds(0, 0, donorResFrame.getWidth(), donorResFrame.getHeight());
        int lDesk = MainWindow.getDesktopPanel().getWidth();
        int aDesk = MainWindow.getDesktopPanel().getHeight();
        int lIFrame = donorResFrame.getWidth();
        int aIFrame = donorResFrame.getHeight();
        donorResFrame.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
        donorResFrame.moveToFront();
	}
}
