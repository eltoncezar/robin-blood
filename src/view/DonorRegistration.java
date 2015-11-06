package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DonorRegistration extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private DonorList donorlist;

	public DonorRegistration() {
		setTitle("CADASTRO DOADOR");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setSize(500, 560);
		
		JLabel lblNome = new JLabel("Nome");
		
		JLabel lblEmail = new JLabel("E-mail");
		
		JLabel lblCpf = new JLabel("CPF:");
		
		JLabel lblGenero = new JLabel("Genero:");
		
		JLabel lblTipoSanguineo = new JLabel("Tipo Sanguineo:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnSalvar = new JButton("Salvar");
		
		JButton btnCancelar = new JButton("Cancelar");
		
		
		
		JSeparator separator = new JSeparator();
		
		JComboBox comboBox_1 = new JComboBox();
		
		JComboBox comboBox_2 = new JComboBox();
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setToolTipText("Endere\u00E7o");
		
		JLabel lblInformaoesPessoais = new JLabel("Informa\u00E7oes Pessoais");
		lblInformaoesPessoais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInformaoesPessoais.setForeground(Color.BLUE);
		
		JLabel lblNewLabel = new JLabel("Endereço");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.BLUE);
		
		JSeparator separator_2 = new JSeparator();
		
		JLabel lblRua = new JLabel("Rua");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		
		JComboBox comboBox_3 = new JComboBox();
		
		JLabel lblCep = new JLabel("CEP");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContato.setForeground(Color.BLUE);
		
		JSeparator separator_3 = new JSeparator();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				if(donorlist == null){
                	donorlist = new DonorList();
                	donorlist.setVisible(true);
                	MainWindow.getDesktopPanel().add(donorlist);
                }
                else if(!donorlist.isVisible()){
                	donorlist.setVisible(true);
                	MainWindow.getDesktopPanel().add(donorlist);
                }
           		//Inicializa Frame Centralizado
           		donorlist.setBounds(0, 0, donorlist.getWidth(), donorlist.getHeight());
           		int lDesk = MainWindow.getDesktopPanel().getWidth();
                int aDesk = MainWindow.getDesktopPanel().getHeight();
                int lIFrame = donorlist.getWidth();
                int aIFrame = donorlist.getHeight();
                donorlist.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
                donorlist.moveToFront();
				
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCpf))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblGenero)
											.addGap(75)
											.addComponent(lblTipoSanguineo, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(comboBox_1, 0, 143, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNome)
										.addComponent(lblEmail))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
										.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))))
							.addGap(32))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(99)
							.addComponent(btnCancelar)
							.addGap(18)
							.addComponent(btnBuscar)
							.addGap(18)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
					.addGap(24))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInformaoesPessoais)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblRua, Alignment.LEADING)
								.addComponent(textField_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNumero)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCidade)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEstado)
								.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
								.addComponent(lblCep))))
					.addContainerGap(55, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
					.addGap(20))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblContato)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblInformaoesPessoais)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(lblGenero)
						.addComponent(lblTipoSanguineo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRua)
						.addComponent(lblNumero))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCidade)
						.addComponent(lblEstado)
						.addComponent(lblCep))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblContato)
						.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnBuscar)
						.addComponent(btnCancelar))
					.addGap(18))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tipo", "N\u00FAmero"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
}
