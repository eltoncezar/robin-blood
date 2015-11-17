package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import models.ComboBoxItem;



public class Distribution extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	

	public Distribution() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setSize(500, 600);
		
		
		
		
		
		
		JPanel simpleBordersProduct = new JPanel();
		simpleBordersProduct.setBorder(BorderFactory.createTitledBorder("Produto"));
		
		JPanel simpleBordersHospital = new JPanel();
		simpleBordersHospital.setBorder(BorderFactory.createTitledBorder("Beneficiário"));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JSeparator separator = new JSeparator();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnAdicionar = new JButton("Adicionar");
		
		JButton btnRemover = new JButton("Remover");
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(300, Short.MAX_VALUE)
					.addComponent(btnSalvar)
					.addGap(18)
					.addComponent(btnCancelar)
					.addGap(28))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(simpleBordersProduct, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(283, Short.MAX_VALUE)
					.addComponent(btnAdicionar)
					.addGap(18)
					.addComponent(btnRemover)
					.addGap(31))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(simpleBordersHospital, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(2)
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(simpleBordersProduct, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(simpleBordersHospital, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAdicionar)
						.addComponent(btnRemover))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar)))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Quantidade", "Hospital", "Produto", "Tipo", "Rh"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		
		scrollPane.setViewportView(table);
		
		JLabel lblHospital = new JLabel("Hospital");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		JButton btnBuscarHospital = new JButton("Buscar Hospital");
		GroupLayout gl_simpleBordersHospital = new GroupLayout(simpleBordersHospital);
		gl_simpleBordersHospital.setHorizontalGroup(
			gl_simpleBordersHospital.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_simpleBordersHospital.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_simpleBordersHospital.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_simpleBordersHospital.createSequentialGroup()
							.addComponent(lblHospital)
							.addGap(162)
							.addComponent(lblEndereo))
						.addGroup(gl_simpleBordersHospital.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
						.addComponent(btnBuscarHospital, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_simpleBordersHospital.setVerticalGroup(
			gl_simpleBordersHospital.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_simpleBordersHospital.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_simpleBordersHospital.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHospital)
						.addComponent(lblEndereo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_simpleBordersHospital.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnBuscarHospital)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		simpleBordersHospital.setLayout(gl_simpleBordersHospital);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblProduto = new JLabel("Produto");
		
				
		JLabel lblTipo = new JLabel("Tipo");
	

		
		
		JComboBox<ComboBoxItem> comboProduct = new JComboBox<ComboBoxItem>();
		comboProduct.addItem(new ComboBoxItem("", ""));
		comboProduct.addItem(new ComboBoxItem("PRP", "Plasma Rico em Plaqueta"));
		comboProduct.addItem(new ComboBoxItem("CH", "Concentrado de Hemácias"));
		comboProduct.addItem(new ComboBoxItem("CP", "Concentrado de Plaquetas"));
		comboProduct.addItem(new ComboBoxItem("PFC", "Plasma Fresco Congelado"));
		comboProduct.addItem(new ComboBoxItem("P24", "Plasma de 24h"));
		comboProduct.addItem(new ComboBoxItem("CRIO", "Crioprecipitado"));
		comboProduct.addItem(new ComboBoxItem("Albumina", "Albumina"));
		comboProduct.addItem(new ComboBoxItem("Globulinas", "Globulinas"));
		comboProduct.addItem(new ComboBoxItem("CFC", "Concetrado Fatores de Coagulação"));
		
	
		
		
		
		
		
		JComboBox<ComboBoxItem> comboBloodType = new JComboBox<ComboBoxItem>();
		comboBloodType.addItem(new ComboBoxItem("", ""));
		comboBloodType.addItem(new ComboBoxItem("A", "A"));
		comboBloodType.addItem(new ComboBoxItem("B", "B"));
		comboBloodType.addItem(new ComboBoxItem("AB", "AB"));
		comboBloodType.addItem(new ComboBoxItem("O", "O"));
		

		
		JLabel lblRh = new JLabel("Rh");
		
		
		JComboBox<ComboBoxItem> comboBloodTypeFactor = new JComboBox<ComboBoxItem>();
		comboBloodTypeFactor.addItem(new ComboBoxItem("", ""));
		comboBloodTypeFactor.addItem(new ComboBoxItem("+", "+"));
		comboBloodTypeFactor.addItem(new ComboBoxItem("-", "-"));
		
		
		GroupLayout gl_simpleBordersProduct = new GroupLayout(simpleBordersProduct);
		gl_simpleBordersProduct.setHorizontalGroup(
			gl_simpleBordersProduct.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_simpleBordersProduct.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_simpleBordersProduct.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textField, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(lblQuantidade, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(28)
					.addGroup(gl_simpleBordersProduct.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProduto)
						.addComponent(comboProduct, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addGroup(gl_simpleBordersProduct.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBloodType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipo))
					.addGap(39)
					.addGroup(gl_simpleBordersProduct.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBloodTypeFactor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRh))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		gl_simpleBordersProduct.setVerticalGroup(
			gl_simpleBordersProduct.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_simpleBordersProduct.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_simpleBordersProduct.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantidade)
						.addComponent(lblProduto)
						.addComponent(lblTipo)
						.addComponent(lblRh))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_simpleBordersProduct.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboProduct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBloodType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBloodTypeFactor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		simpleBordersProduct.setLayout(gl_simpleBordersProduct);
		getContentPane().setLayout(groupLayout);

	}
}
