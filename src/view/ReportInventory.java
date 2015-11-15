package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class ReportInventory extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	

	public ReportInventory() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setSize(900,585);
		
		JLabel lblPanoramaGeral = new JLabel("Panorama Geral");
		lblPanoramaGeral.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPanoramaGeral.setForeground(Color.BLUE);
		
		JSeparator separator = new JSeparator();
		
		JPanel panel = new JPanel();
		criaGrafico(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Dados"));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPanoramaGeral)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPanoramaGeral)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblProduto = new JLabel("Produto");
		
		JLabel lblFatorRh = new JLabel("Fator Rh");
		
		JLabel lblTipo = new JLabel("Tipo");
		
		JComboBox comboBox_1 = new JComboBox();
		
		JComboBox comboBox_2 = new JComboBox();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblDataInicial = new JLabel("Data Inicial");
		
		JLabel lblDataFinal = new JLabel("Data Final");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JCheckBox chckbxEntradas = new JCheckBox("Entradas");
		
		JCheckBox chckbxSaida = new JCheckBox("Saida");
		
		JButton btnConsultar = new JButton("Consultar");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, 0, 140, Short.MAX_VALUE)
								.addComponent(lblProduto)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTipo)
										.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDataInicial)
										.addComponent(chckbxEntradas))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFatorRh)
										.addComponent(chckbxSaida)
										.addComponent(lblDataFinal)
										.addComponent(textField_1, 0, 0, Short.MAX_VALUE)
										.addComponent(comboBox_2, Alignment.TRAILING, 0, 61, Short.MAX_VALUE))))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(btnConsultar)
							.addGap(33))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblProduto)
					.addGap(4)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipo)
						.addComponent(lblFatorRh))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataInicial)
						.addComponent(lblDataFinal))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxEntradas)
						.addComponent(chckbxSaida))
					.addPreferredGap(ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
					.addComponent(btnConsultar)
					.addGap(22))
		);
		panel_1.setLayout(gl_panel_1);
		getContentPane().setLayout(groupLayout);

	}
	
	private CategoryDataset createDataset() {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();	
		dataset.addValue(1000.0,"01/2015","Mês/Ano");
		dataset.addValue(1750.0,"02/2015","Mês/Ano");		
		dataset.addValue(1500.0,"03/2015","Mês/Ano");	
		dataset.addValue(700.0,"04/2015","Mês/Ano");
		return dataset;
		
		}
	
	public void criaGrafico(JPanel panel) {
		
		CategoryDataset cds = createDataset();	
		String titulo = "Relatório de produtos";		
		String eixoy = "Valores";		
		String txt_legenda = "Ledenda:";
		boolean legenda = true;		
		boolean tooltips = true;		
		boolean urls = true;		
		JFreeChart graf = ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
		ChartPanel myChartPanel = new ChartPanel(graf, true);		
		
		myChartPanel.setSize(panel.getWidth(),panel.getHeight());	
		myChartPanel.setVisible(true);
		
		panel.removeAll();		
		panel.add(myChartPanel);		
		panel.revalidate();		
		panel.repaint();
		
		}
}
