package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import business.DonationController;
import business.Utils;
import models.Donor;

public class DonationRegistration extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JTable tableDonations;
	private JTable tableStatuses;
	private Utils utils;
	private Donor donor = null;
	
	public DonationRegistration() {
		DonationController controller = new DonationController();
		utils = new Utils();
		
		setTitle("Cadastro Doa\u00E7\u00E3o");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setSize(600, 400);
		
		JLabel lblDoador = new JLabel("Doador");
		lblDoador.setForeground(Color.BLUE);
		lblDoador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNome = new JLabel("Nome");
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblCpf = new JLabel("CPF");
		
		txtCpf = new JFormattedTextField(utils.Mascara("###.###.###-##"));
		
		txtCpf.setColumns(10);
		
		JButton btnNovaDoacao = new JButton("Nova Doa\u00E7\u00E3o");
		btnNovaDoacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (donor != null) {
					controller.createNew(donor.getId());					
				}
				
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			private String param;

			public void actionPerformed(ActionEvent e) {
				param = txtCpf.getText();
				
				param = param.replace("-", " ");
				param = param.replace(".", " ");
				param = param.replace(" ", "");
				
				if(param == null && param.isEmpty()){
					JOptionPane.showMessageDialog(getContentPane(), "Campo CPF n�o preenchido", "Robin Blood", JOptionPane.WARNING_MESSAGE);
				}else{
					donor = controller.getDonorByCpf(param);
					if(donor.getCpf() == null){
						JOptionPane.showMessageDialog(getContentPane(), "CPF invalido!", "Robin Blood", JOptionPane.WARNING_MESSAGE);
					}else{
						txtNome.setText(donor.getName());
						txtCpf.setText(donor.getCpf());
						
						tableDonations.setModel(controller.getDonationsTableModel(controller.getLastDonations(donor.getId())));
						tableStatuses.setModel(controller.getStatusesTableModel(controller.getStatuses(donor.getId())));	
						
					}
				}
				
				
				
				if(param != null && !param.isEmpty())
				{
					donor = controller.getDonorByCpf(param);
					if(donor.getCpf() == null){
						JOptionPane.showMessageDialog(getContentPane(), "CPF invalido!", "Robin Blood", JOptionPane.WARNING_MESSAGE);
											
					}else{
						txtNome.setText(donor.getName());
						txtCpf.setText(donor.getCpf());
						
						tableDonations.setModel(controller.getDonationsTableModel(controller.getLastDonations(donor.getId())));
						tableStatuses.setModel(controller.getStatusesTableModel(controller.getStatuses(donor.getId())));	
					}
					
					
				}else{
					JOptionPane.showMessageDialog(getContentPane(), "Campo CPF n�o preenchido", "Robin Blood", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		JLabel lblUltimasDoaes = new JLabel("Ultimas Doa\u00E7\u00F5es");
		lblUltimasDoaes.setForeground(Color.BLUE);
		lblUltimasDoaes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JSeparator separator_2 = new JSeparator();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblStatusDoao = new JLabel("Hist\u00F3rico Doa\u00E7\u00E3o");
		lblStatusDoao.setForeground(Color.BLUE);
		lblStatusDoao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JSeparator separator_3 = new JSeparator();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDoador)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblStatusDoao)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblNome)
									.addComponent(lblCpf)
									.addComponent(txtCpf)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(25)
									.addComponent(btnNovaDoacao)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnBuscar))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblUltimasDoaes)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStatusDoao)
						.addComponent(lblDoador)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCpf)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNovaDoacao)
								.addComponent(btnBuscar))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblUltimasDoaes)
								.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, 0, 0, Short.MAX_VALUE))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		tableDonations = new JTable();
		tableDonations.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Data", "Status"
			}
		));
		tableDonations.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	int id = Integer.parseInt(tableDonations.getValueAt(tableDonations.getSelectedRow(), 0).toString());
	        	tableStatuses.setModel(controller.getStatusesTableModel(controller.getStatuses(id)));
	        }
	    });
		scrollPane.setViewportView(tableDonations);
		

		tableStatuses = new JTable();
		tableStatuses.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data/Hora", "Status"
			}
		));
		
		scrollPane_1.setViewportView(tableStatuses);
		
		
		getContentPane().setLayout(groupLayout);

	}
}
