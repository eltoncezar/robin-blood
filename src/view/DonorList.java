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

import business.DonorController;
import data.ConnectException;
import models.Donor;

public class DonorList extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private DonorRegistration donorResFrame;
	private DonorController controller;
	private List<Donor> donors;
	

	
	public DonorList() {
		controller = new DonorController();
		
		setClosable(true);
		setTitle("Listar Doadores");
		//setBounds(100, 100, 450, 300);
		setSize(450, 350);
		
		donors = controller.getAll();
		
		table = new JTable();
		table.setModel(controller.getTableModel(donors));
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		
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
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowIndex = table.getSelectedRow();
				if (rowIndex > -1) {
					Donor selectedItem = donors.get(rowIndex);
					
					try {
						controller.delete(selectedItem);
						donors = controller.getAll();
						table.setModel(controller.getTableModel(donors));
						JOptionPane.showMessageDialog(getContentPane(), "Deletado com Sucesso!", "Robin Blood", JOptionPane.INFORMATION_MESSAGE);
					} catch (ConnectException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(getContentPane(), "Selecione um item!", "Robin Blood", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(190, Short.MAX_VALUE)
					.addComponent(btnExcluir)
					.addGap(18)
					.addComponent(btnNovo)
					.addGap(18)
					.addComponent(btnEditar)
					.addGap(27))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNome)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
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
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnNovo)
						.addComponent(btnExcluir))
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
