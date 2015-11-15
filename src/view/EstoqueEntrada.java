package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import models.ComboBoxItem;

public class EstoqueEntrada extends JInternalFrame {
	private JTextField textField;
	public EstoqueEntrada() {
		setClosable(true);
		setTitle("Estoque - Entrada de Sangue");
		//setBounds(100, 100, 450, 300);
		setSize(430,163);
		
		JLabel lblNewLabel = new JLabel("Quantidade");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblProduto = new JLabel("Produto");
		
		
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
		
		JLabel lblTipo = new JLabel("Tipo");
		
		JLabel lblRh = new JLabel("Rh");
		
		
		JComboBox<ComboBoxItem> comboBloodTypeFactor = new JComboBox<ComboBoxItem>();
		comboBloodTypeFactor.addItem(new ComboBoxItem("", ""));
		comboBloodTypeFactor.addItem(new ComboBoxItem("+", "+"));
		comboBloodTypeFactor.addItem(new ComboBoxItem("-", "-"));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		
		JSeparator separator = new JSeparator();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField, 0, 0, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProduto)
						.addComponent(comboProduct, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBloodType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipo))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRh)
						.addComponent(comboBloodTypeFactor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17))
				.addComponent(separator, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 282, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(115)
					.addComponent(btnSalvar)
					.addGap(18)
					.addComponent(btnCancelar)
					.addGap(143))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblRh)
						.addComponent(lblProduto)
						.addComponent(lblTipo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboProduct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBloodType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBloodTypeFactor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
}
