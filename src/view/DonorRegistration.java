package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import business.DonorController;
import business.DonorPhoneController;
import business.PhoneController;
import business.Utils;
import data.ConnectException;
import models.Address;
import models.ComboBoxItem;
import models.Donor;
import models.DonorPhone;
import models.Phone;

public class DonorRegistration extends JInternalFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtEmail;
	private JFormattedTextField txtCPF;
	private JTextField txtrua;
	private JTextField txtnumero;
	private JTextField txtcidade;
	private JFormattedTextField txtcep;
	private JTable table;
	
	private DonorController donorcontroller;
	private PhoneController phonecontroller;
	private DonorPhoneController donorphonecontroller;
	private Utils utils;

	

	public DonorRegistration(Donor paramDonor) {
		donorcontroller = new DonorController();
		phonecontroller = new PhoneController();
		donorphonecontroller = new DonorPhoneController();
		DefaultTableModel modelo = new DefaultTableModel();
		utils = new Utils();
		Address paramAddress = null;
		
		setTitle("CADASTRO DOADOR");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setSize(500, 630);

		JLabel lblNome = new JLabel("Nome");

		JLabel lblEmail = new JLabel("E-mail");

		JLabel lblCpf = new JLabel("CPF:");

		JLabel lblGenero = new JLabel("Genero:");

		JLabel lblTipoSanguineo = new JLabel("Tipo Sanguineo:");

		txtName = new JTextField();
		txtName.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		txtCPF = new JFormattedTextField(utils.Mascara("###.###.###-##"));
		//txtCPF = new JFormattedTextField();
		txtCPF.setColumns(10);
		
		JComboBox<ComboBoxItem> comboBloodType = new JComboBox<ComboBoxItem>();
		comboBloodType.addItem(new ComboBoxItem("", ""));
		comboBloodType.addItem(new ComboBoxItem("A", "A"));
		comboBloodType.addItem(new ComboBoxItem("B", "B"));
		comboBloodType.addItem(new ComboBoxItem("AB", "AB"));
		comboBloodType.addItem(new ComboBoxItem("O", "O"));

		JComboBox<ComboBoxItem> comboGender = new JComboBox<ComboBoxItem>();
		comboGender.addItem(new ComboBoxItem("", ""));
		comboGender.addItem(new ComboBoxItem("M", "M"));
		comboGender.addItem(new ComboBoxItem("F", "F"));
		
		JComboBox<ComboBoxItem> comboBoxEstado = new JComboBox<ComboBoxItem>();
		comboBoxEstado.addItem(new ComboBoxItem("", ""));
		comboBoxEstado.addItem(new ComboBoxItem("AC", "AC"));
		comboBoxEstado.addItem(new ComboBoxItem("AL", "AC"));
		comboBoxEstado.addItem(new ComboBoxItem("AM", "AM"));
		comboBoxEstado.addItem(new ComboBoxItem("AP", "AP"));
		comboBoxEstado.addItem(new ComboBoxItem("BA", "BA"));
		comboBoxEstado.addItem(new ComboBoxItem("CE", "CE"));
		comboBoxEstado.addItem(new ComboBoxItem("DF", "DF"));
		comboBoxEstado.addItem(new ComboBoxItem("ES", "ES"));
		comboBoxEstado.addItem(new ComboBoxItem("GO", "GO"));
		comboBoxEstado.addItem(new ComboBoxItem("MA", "MA"));
		comboBoxEstado.addItem(new ComboBoxItem("MG", "MG"));
		comboBoxEstado.addItem(new ComboBoxItem("MS", "MS"));
		comboBoxEstado.addItem(new ComboBoxItem("MT", "MT"));
		comboBoxEstado.addItem(new ComboBoxItem("PA", "PA"));
		comboBoxEstado.addItem(new ComboBoxItem("PB", "PB"));
		comboBoxEstado.addItem(new ComboBoxItem("PE", "PE"));
		comboBoxEstado.addItem(new ComboBoxItem("PI", "PI"));
		comboBoxEstado.addItem(new ComboBoxItem("PR", "PR"));
		comboBoxEstado.addItem(new ComboBoxItem("RJ", "RJ"));
		comboBoxEstado.addItem(new ComboBoxItem("RN", "RN"));
		comboBoxEstado.addItem(new ComboBoxItem("RO", "RO"));
		comboBoxEstado.addItem(new ComboBoxItem("RS", "RS"));
		comboBoxEstado.addItem(new ComboBoxItem("SC", "SC"));
		comboBoxEstado.addItem(new ComboBoxItem("SE", "SE"));
		comboBoxEstado.addItem(new ComboBoxItem("SP", "SP"));
		comboBoxEstado.addItem(new ComboBoxItem("TO", "TO"));
		
		

		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idaddres = 0;
				if(paramDonor.getId() != 0){
					idaddres = 1;
				}
				
				
				try {
					Address add = new Address(idaddres,
							txtrua.getText(),
							Integer.valueOf(txtnumero.getText()),
							"Brasil",
							txtcep.getText(),
							comboBoxEstado.getSelectedItem().toString(),
							txtcidade.getText());
					
					String CPF = txtCPF.getText();
					CPF = CPF.replace("-", " ");
					CPF = CPF.replace(".", " ");
					CPF = CPF.replace(" ", "");
					
					
					Donor don = new Donor(paramDonor.getId(),
							txtName.getText(),
							CPF,
							comboGender.getSelectedItem().toString(),
							txtEmail.getText(),
							comboBloodType.getSelectedItem().toString(),
							add);
					
					donorcontroller.save(don);
					
					List<Phone> phon = new ArrayList<>();
					
					for (int count = 0; count < modelo.getRowCount(); count++){
						phon.add(new Phone(0, modelo.getValueAt(count, 0).toString()));
			        }
					List<Phone> phons = phonecontroller.save(phon);
					
					for (Phone phone : phons) {
						donorphonecontroller.save(new DonorPhone(phone, don));
					}
					
					
					
					JOptionPane.showMessageDialog(getContentPane(), "Salvo com Sucesso!", "Robin Blood", JOptionPane.INFORMATION_MESSAGE);
				} catch (ConnectException e) {
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
		comboBloodTypeFactor.addItem(new ComboBoxItem("", ""));
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

		txtcep = new JFormattedTextField(utils.Mascara("#####-###"));
		txtcep.setColumns(10);

		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContato.setForeground(Color.BLUE);

		JSeparator separator_3 = new JSeparator();

		JScrollPane scrollPane = new JScrollPane();
		
		
		
		List<Phone> phones = phonecontroller.getByFilter(paramDonor.getId());		
		
		
		
		modelo.addColumn("Numero");

		table = new JTable(modelo);
		

		if(paramDonor.getId() != 0){
			table.setModel(phonecontroller.getTableModel(phones));
			txtName.setText(paramDonor.getName());
			txtEmail.setText(paramDonor.getEmail());
			txtCPF.setText(paramDonor.getCpf());
			
			int idadd = paramDonor.getAddresses().getId();
			paramAddress = donorcontroller.getById(idadd);
			
			
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
				if(code.equals(paramDonor.getBloodType())){
						comboBloodType.setSelectedItem(comboBloodType.getItemAt(i));
					
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
			
		}
		
		JButton btnAdicionarTelefone = new JButton("Adicionar");
		btnAdicionarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFormattedTextField txtphone = new JFormattedTextField(utils.Mascara("(##) ####-####"));
		       
		        
				int result = JOptionPane.showConfirmDialog(getContentPane(), txtphone, "Robin Blood", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
		            String tel = txtphone.getText();
		            modelo.addRow(new Object[]{tel});	
		            
		        }
				
				
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				
				int rowIndex = table.getSelectedRow();
				if (rowIndex > -1) {
						modelo.removeRow(rowIndex);  
				}
				else {
					JOptionPane.showMessageDialog(getContentPane(), "Selecione um item!", "Robin Blood", JOptionPane.WARNING_MESSAGE);
				}
				
			
				
				
				
				
				
				
			}
		});
		
		
		
		

		

		// string.substring(string.length() - 1))

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInformaoesPessoais)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addContainerGap(447, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEmail)
					.addContainerGap(446, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCpf))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboGender, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGenero))
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(comboBloodType, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBloodTypeFactor, 0, 49, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTipoSanguineo, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
									.addGap(30))))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(txtName)
							.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)))
					.addGap(39))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblRua, Alignment.LEADING)
								.addComponent(txtrua, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNumero)
								.addComponent(txtnumero, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCidade)
								.addComponent(txtcidade, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEstado)
								.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtcep, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
								.addComponent(lblCep))))
					.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(293, Short.MAX_VALUE)
					.addComponent(btnRemover)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAdicionarTelefone)
					.addGap(45))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(183, Short.MAX_VALUE)
					.addComponent(btnCancelar)
					.addGap(18)
					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(140))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblContato)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblInformaoesPessoais)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addComponent(lblNome)
					.addGap(5)
					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEmail)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTipoSanguineo)
							.addComponent(lblGenero))
						.addComponent(lblCpf))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBloodType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBloodTypeFactor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRua)
						.addComponent(lblNumero))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtnumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCidade)
						.addComponent(lblEstado)
						.addComponent(lblCep))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtcidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtcep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblContato)
						.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRemover)
						.addComponent(btnAdicionarTelefone))
					.addGap(12)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnCancelar))
					.addGap(32))
		);

		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
}
