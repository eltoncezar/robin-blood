package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import business.AdressController;
import business.DonorController;
import business.UserRegistrationController;
import data.ConnectException;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionModel;
import models.Address;
import models.ComboBoxItem;
import models.Donor;
import models.Phone;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DonorRegistration extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtCPF;
	private JTextField txtrua;
	private JTextField txtnumero;
	private JTextField txtcidade;
	private JTextField txtcep;
	private JTable table;
	
	private DonorController donorcontroller;
	private AdressController addresscontroller;
	

	public DonorRegistration(Donor paramDonor) {
		addresscontroller = new AdressController();
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

		txtName = new JTextField();
		txtName.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		
		JComboBox<ComboBoxItem> comboBloodType = new JComboBox<ComboBoxItem>();
		comboBloodType.addItem(new ComboBoxItem("A", "A"));
		comboBloodType.addItem(new ComboBoxItem("B", "B"));
		comboBloodType.addItem(new ComboBoxItem("AB", "AB"));
		comboBloodType.addItem(new ComboBoxItem("O", "O"));

		JComboBox<ComboBoxItem> comboGender = new JComboBox<ComboBoxItem>();
		comboGender.addItem(new ComboBoxItem("M", "Masculino"));
		comboGender.addItem(new ComboBoxItem("F", "Feminino"));
		
		JComboBox<ComboBoxItem> comboBoxEstado = new JComboBox<ComboBoxItem>();
		comboBoxEstado.addItem(new ComboBoxItem("", ""));
		comboBoxEstado.addItem(new ComboBoxItem("AC", "Acre"));
		comboBoxEstado.addItem(new ComboBoxItem("AL", "Alagoas"));
		comboBoxEstado.addItem(new ComboBoxItem("AM", ""));
		comboBoxEstado.addItem(new ComboBoxItem("AP", ""));
		comboBoxEstado.addItem(new ComboBoxItem("BA", "Bahia"));
		comboBoxEstado.addItem(new ComboBoxItem("CE", "Ceara"));
		comboBoxEstado.addItem(new ComboBoxItem("DF", "Destrito Fedaral"));
		comboBoxEstado.addItem(new ComboBoxItem("ES", "Espirito Santo"));
		comboBoxEstado.addItem(new ComboBoxItem("GO", "Goias"));
		comboBoxEstado.addItem(new ComboBoxItem("MA", ""));
		comboBoxEstado.addItem(new ComboBoxItem("MG", "Minas Gerais"));
		comboBoxEstado.addItem(new ComboBoxItem("MS", "Mato Groso do Sul"));
		comboBoxEstado.addItem(new ComboBoxItem("MT", "Mato Groso"));
		comboBoxEstado.addItem(new ComboBoxItem("PA", ""));
		comboBoxEstado.addItem(new ComboBoxItem("PB", ""));
		comboBoxEstado.addItem(new ComboBoxItem("PE", "Pernanbuco"));
		comboBoxEstado.addItem(new ComboBoxItem("PI", "Piaui"));
		comboBoxEstado.addItem(new ComboBoxItem("PR", "Parana"));
		comboBoxEstado.addItem(new ComboBoxItem("RJ", "Rio de Janeiro"));
		comboBoxEstado.addItem(new ComboBoxItem("RN", ""));
		comboBoxEstado.addItem(new ComboBoxItem("RO", "Rondonia"));
		comboBoxEstado.addItem(new ComboBoxItem("RS", "Rio Grande do Sul"));
		comboBoxEstado.addItem(new ComboBoxItem("SC", "Santa Catarina"));
		comboBoxEstado.addItem(new ComboBoxItem("SE", ""));
		comboBoxEstado.addItem(new ComboBoxItem("SP", "São Paulo"));
		comboBoxEstado.addItem(new ComboBoxItem("TO", "Tocantis"));
		
		
		
		
//		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AM", "AP",
//				"BA", "CE", "DF", "ES", "GO",
//				"MA", "MG", "MS", "MT", "PA",
//				"PB", "PE", "PI", "PR", "RJ",
//				"RN", "RO", "RS", "SC", "SE",
//				"SP", "TO"}));
//		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					donorcontroller.save(new Donor(0,
							txtName.getText(),
							txtCPF.getText(),
							comboGender.getSelectedItem().toString(),
							txtEmail.getText(),
							"M",//comboBloodType.getSelectedItem().toString(),
							//Tem que retornar o ID do endereço cadastrado no banco
							1
//							int i = adressController.save(new Address(0,
//									txtrua.getText(),
//									Integer.parseInt(txtnumero.getText()),
//									"Brasil",
//									txtcep.getText(),
//									comboBoxEstado.getSelectedItem().toString(),
//									txtcep.getText()))
							
							
							));
				} catch (ConnectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JSeparator separator = new JSeparator();

		

		JComboBox<ComboBoxItem> comboBloodTypeFactor = new JComboBox<ComboBoxItem>();
		comboBloodTypeFactor.addItem(new ComboBoxItem("+", "+"));
		comboBloodTypeFactor.addItem(new ComboBoxItem("-", "-"));

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

		txtrua = new JTextField();
		txtrua.setColumns(10);

		JLabel lblNumero = new JLabel("Numero");

		txtnumero = new JTextField();
		txtnumero.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");

		txtcidade = new JTextField();
		txtcidade.setColumns(10);

		JLabel lblEstado = new JLabel("Estado");

		
		
		

		JLabel lblCep = new JLabel("CEP");

		txtcep = new JTextField();
		txtcep.setColumns(10);

		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContato.setForeground(Color.BLUE);

		JSeparator separator_3 = new JSeparator();

		JScrollPane scrollPane = new JScrollPane();

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Tipo", "N\u00FAmero" }));

		txtName.setText(paramDonor.getName());
		txtEmail.setText(paramDonor.getEmail());
		txtCPF.setText(paramDonor.getCpf());
		
		int tes = paramDonor.getAddresses();
		Address paramAddress = addresscontroller.getByFilter(paramDonor.getAddresses());
		
		txtrua.setText(paramAddress.getStreet());
		txtnumero.setText(String.valueOf(paramAddress.getNumber()));
		txtcidade.setText(paramAddress.getCity());
		txtcep.setText(paramAddress.getZipCode());
		
		

		DefaultComboBoxModel<ComboBoxItem> model;
		String code;
		
		model = (DefaultComboBoxModel<ComboBoxItem>) comboBoxEstado.getModel();
		for (int i = 0; i < model.getSize(); ++i) {
			ComboBoxItem item = (ComboBoxItem) model.getElementAt(i);
			code = item.getCode();

			if (code.equals(paramAddress.getState())) {
				comboBoxEstado.setSelectedItem(comboBoxEstado.getItemAt(i));
			}
		}
		
		//
		model = (DefaultComboBoxModel<ComboBoxItem>) comboGender.getModel();
		for (int i = 0; i < model.getSize(); ++i) {
			ComboBoxItem item = (ComboBoxItem) model.getElementAt(i);
			code = item.getCode();

			if (code.equals(paramDonor.getGender())) {
				comboGender.setSelectedItem(comboGender.getItemAt(i));
			}
		}

		model = (DefaultComboBoxModel<ComboBoxItem>) comboBloodType.getModel();
		for (int i = 0; i < model.getSize(); ++i) {
			ComboBoxItem item = (ComboBoxItem) model.getElementAt(i);
			code = item.getCode();
			if(paramDonor.getName() != null){
				if (code.equals(paramDonor.getBloodType().substring(0, paramDonor.getBloodType().length() - 1))) {
					comboBloodType.setSelectedItem(comboBloodType.getItemAt(i));
				}
			}

			
		}
		
		model = (DefaultComboBoxModel<ComboBoxItem>) comboBloodTypeFactor.getModel();
		for (int i = 0; i < model.getSize(); ++i) {
			ComboBoxItem item = (ComboBoxItem) model.getElementAt(i);
			code = item.getCode();
			if(paramDonor.getName() != null){
				if (code.equals(paramDonor.getBloodType().substring(paramDonor.getBloodType().length() - 1))) {
					comboBloodTypeFactor.setSelectedItem(comboBloodTypeFactor.getItemAt(i));
				}				
			}

			
		}

		// string.substring(string.length() - 1))

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																txtCPF,
																																GroupLayout.PREFERRED_SIZE,
																																126,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																lblCpf))
																										.addGap(18)
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																groupLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				lblGenero)
																																		.addGap(75)
																																		.addComponent(
																																				lblTipoSanguineo,
																																				GroupLayout.DEFAULT_SIZE,
																																				191,
																																				Short.MAX_VALUE))
																														.addGroup(
																																groupLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				comboGender,
																																				GroupLayout.PREFERRED_SIZE,
																																				98,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addGap(18)
																																		.addComponent(
																																				comboBloodType,
																																				0,
																																				143,
																																				Short.MAX_VALUE)
																																		.addGap(18)
																																		.addComponent(
																																				comboBloodTypeFactor,
																																				GroupLayout.PREFERRED_SIZE,
																																				GroupLayout.DEFAULT_SIZE,
																																				GroupLayout.PREFERRED_SIZE))))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblNome)
																														.addComponent(
																																lblEmail))
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																txtName,
																																GroupLayout.DEFAULT_SIZE,
																																417,
																																Short.MAX_VALUE)
																														.addComponent(
																																txtEmail,
																																GroupLayout.DEFAULT_SIZE,
																																417,
																																Short.MAX_VALUE))))
																		.addGap(32))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(99)
																		.addComponent(
																				btnCancelar)
																		.addGap(18)
																		.addComponent(
																				btnBuscar)
																		.addGap(18)
																		.addComponent(
																				btnSalvar,
																				GroupLayout.PREFERRED_SIZE,
																				84,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(24))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblInformaoesPessoais)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(separator_1,
												GroupLayout.PREFERRED_SIZE,
												361, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblNewLabel)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(separator_2,
												GroupLayout.DEFAULT_SIZE, 433,
												Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING,
																false)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								lblRua,
																								Alignment.LEADING)
																						.addComponent(
																								txtrua,
																								Alignment.LEADING,
																								GroupLayout.PREFERRED_SIZE,
																								322,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(33)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblNumero)
																						.addComponent(
																								txtnumero,
																								GroupLayout.PREFERRED_SIZE,
																								95,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblCidade)
																						.addComponent(
																								txtcidade,
																								GroupLayout.PREFERRED_SIZE,
																								135,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(18)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblEstado)
																						.addComponent(
																								comboBoxEstado,
																								GroupLayout.PREFERRED_SIZE,
																								134,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(34)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								txtcep,
																								GroupLayout.DEFAULT_SIZE,
																								120,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblCep))))
										.addContainerGap(55, Short.MAX_VALUE))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addComponent(separator,
												GroupLayout.DEFAULT_SIZE, 515,
												Short.MAX_VALUE).addGap(20))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblContato)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(separator_3,
												GroupLayout.PREFERRED_SIZE,
												420, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(31, Short.MAX_VALUE))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE,
												453, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(52, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lblInformaoesPessoais)
														.addComponent(
																separator_1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblNome)
														.addComponent(
																txtName,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblEmail)
														.addComponent(
																txtEmail,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblCpf)
														.addComponent(lblGenero)
														.addComponent(
																lblTipoSanguineo))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtCPF,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboGender,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBloodType,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBloodTypeFactor,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lblNewLabel)
														.addComponent(
																separator_2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblRua)
														.addComponent(lblNumero))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtrua,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtnumero,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblCidade)
														.addComponent(lblEstado)
														.addComponent(lblCep))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtcidade,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBoxEstado,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtcep,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lblContato)
														.addComponent(
																separator_3,
																GroupLayout.PREFERRED_SIZE,
																1,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE,
												102, GroupLayout.PREFERRED_SIZE)
										.addGap(28)
										.addComponent(separator,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(btnSalvar)
														.addComponent(btnBuscar)
														.addComponent(
																btnCancelar))
										.addGap(18)));

		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
}
