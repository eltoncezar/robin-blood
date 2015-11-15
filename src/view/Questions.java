package view;




import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JButton;


public class Questions extends JInternalFrame {

	
	private static final long serialVersionUID = 1L;

	public Questions() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setSize(755, 700);
		
		JLabel lblCirurgiaNeurolgica = new JLabel("Cirurgia neurol\u00F3gica");
		
		JLabel lblExamesEndoscpios = new JLabel("Exames endosc\u00F3pios");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		
		JProgressBar progressBar = new JProgressBar();
		
		JLabel lblPerguntasRespondidas = new JLabel("Perguntas respondidas");
		
		JButton btnEncerrar = new JButton("Encerrar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblCirurgiaNeurolgica, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblExamesEndoscpios, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(128)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPerguntasRespondidas)
								.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 496, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 718, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(540, Short.MAX_VALUE)
					.addComponent(btnEncerrar)
					.addGap(126))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPerguntasRespondidas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnEncerrar)
					.addGap(308)
					.addComponent(lblCirurgiaNeurolgica)
					.addGap(6)
					.addComponent(lblExamesEndoscpios))
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Parte I", null, panel, null);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblQuestionrioCadidado = new JLabel("QUESTION\u00C1RIO CADIDADO \u00C0 DOA\u00C7\u00C2O DE SANGUE");
		panel.add(lblQuestionrioCadidado, "2, 2, right, default");
		
		JLabel lblPerguntas = new JLabel("Perguntas");
		panel.add(lblPerguntas, "2, 4");
		
		JLabel lblNewLabel = new JLabel("J\u00E1 doou sangue?");
		panel.add(lblNewLabel, "2, 8");
		
		JRadioButton radioButton = new JRadioButton("Sim");
		panel.add(radioButton, "6, 8");
		
		JRadioButton radioButton_1 = new JRadioButton("N\u00E3o");
		panel.add(radioButton_1, "10, 8");
		
		JLabel lblSentiuseMalEm = new JLabel("Sentiu-se mal em alguma doa\u00E7\u00E3o?");
		panel.add(lblSentiuseMalEm, "2, 10");
		
		JRadioButton radioButton_2 = new JRadioButton("Sim");
		panel.add(radioButton_2, "6, 10");
		
		JRadioButton radioButton_3 = new JRadioButton("N\u00E3o");
		panel.add(radioButton_3, "10, 10");
		
		JLabel lblVaiTrabalharEm = new JLabel("Vai trabalhar em altura(telhado, andaime), com m\u00E1quina pesada(sera, prensa), apos a doa\u00E7\u00E3o");
		panel.add(lblVaiTrabalharEm, "2, 12");
		
		JRadioButton radioButton_4 = new JRadioButton("Sim");
		panel.add(radioButton_4, "6, 12");
		
		JRadioButton radioButton_5 = new JRadioButton("N\u00E3o");
		panel.add(radioButton_5, "10, 12");
		
		JLabel lblEstSeSentindo = new JLabel("Est\u00E1 se sentindo bem?");
		panel.add(lblEstSeSentindo, "2, 14");
		
		JRadioButton radioButton_6 = new JRadioButton("Sim");
		panel.add(radioButton_6, "6, 14");
		
		JRadioButton radioButton_7 = new JRadioButton("N\u00E3o");
		panel.add(radioButton_7, "10, 14");
		
		JLabel lblDormiuBemNas = new JLabel("Dormiu bem nas \u00FAltimas 24horas");
		panel.add(lblDormiuBemNas, "2, 16");
		
		JRadioButton radioButton_8 = new JRadioButton("Sim");
		panel.add(radioButton_8, "6, 16");
		
		JRadioButton radioButton_9 = new JRadioButton("N\u00E3o");
		panel.add(radioButton_9, "10, 16");
		
		JLabel lblIngeriuBebidaAlcolica = new JLabel("Ingeriu bebida alco\u00F3lica h\u00E1 menos de 12 horas?");
		panel.add(lblIngeriuBebidaAlcolica, "2, 18");
		
		JRadioButton radioButton_10 = new JRadioButton("Sim");
		panel.add(radioButton_10, "6, 18");
		
		JRadioButton radioButton_11 = new JRadioButton("N\u00E3o");
		panel.add(radioButton_11, "10, 18");
		
		JLabel lblRecebeuAlgumaVacina = new JLabel("Recebeu alguma vacina nos ultimos 30 dias? Qual(is)?");
		panel.add(lblRecebeuAlgumaVacina, "2, 20");
		
		JRadioButton radioButton_12 = new JRadioButton("Sim");
		panel.add(radioButton_12, "6, 20");
		
		JRadioButton radioButton_13 = new JRadioButton("N\u00E3o");
		panel.add(radioButton_13, "10, 20");
		
		JLabel lblEstResfriadoCom = new JLabel("Est\u00E1 resfriado, com dor de garganta ou febre?");
		panel.add(lblEstResfriadoCom, "2, 22");
		
		JRadioButton radioButton_14 = new JRadioButton("Sim");
		panel.add(radioButton_14, "6, 22");
		
		JRadioButton radioButton_15 = new JRadioButton("N\u00E3o");
		panel.add(radioButton_15, "10, 22");
		
		JLabel lblEstTomandoAlgum = new JLabel("Est\u00E1 tomando algum tipo de medicamento? Qual(is)?");
		panel.add(lblEstTomandoAlgum, "2, 24");
		
		JRadioButton radioButton_16 = new JRadioButton("Sim");
		panel.add(radioButton_16, "6, 24");
		
		JRadioButton radioButton_17 = new JRadioButton("N\u00E3o");
		panel.add(radioButton_17, "10, 24");
		
		JLabel lblEstComAlguma = new JLabel("Est\u00E1 com alguma alergia no momento?");
		panel.add(lblEstComAlguma, "2, 26");
		
		JRadioButton radioButton_18 = new JRadioButton("Sim");
		panel.add(radioButton_18, "6, 26");
		
		JRadioButton radioButton_19 = new JRadioButton("N\u00E3o");
		panel.add(radioButton_19, "10, 26");
		
		JLabel lblExtraiuDenteOu = new JLabel("Extraiu dente ou fez tratamento de canal nos ultimos 07 dias?");
		panel.add(lblExtraiuDenteOu, "2, 28");
		
		JRadioButton radioButton_20 = new JRadioButton("Sim");
		panel.add(radioButton_20, "6, 28");
		
		JRadioButton radioButton_21 = new JRadioButton("N\u00E3o");
		panel.add(radioButton_21, "10, 28");
		
		JLabel lblFezTatuagemOu = new JLabel("Fez tatuagem ou maquiagem definitiva nos ultimos 12 meses?");
		panel.add(lblFezTatuagemOu, "2, 30");
		
		JRadioButton radioButton_22 = new JRadioButton("Sim");
		panel.add(radioButton_22, "6, 30");
		
		JRadioButton radioButton_23 = new JRadioButton("N\u00E3o");
		panel.add(radioButton_23, "10, 30");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Parte II", null, panel_1, null);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblMarqueSeJ = new JLabel("MARQUE SE J\u00C1 TEVE/TEM ALGUM DESTES PROBLEMAS ou CIRURGIAS:");
		panel_1.add(lblMarqueSeJ, "2, 2, right, default");
		
		JLabel lblAtaqueEpileticoConvulsodesmaio = new JLabel("Ataque epiletico, convuls\u00E3o/desmaio");
		panel_1.add(lblAtaqueEpileticoConvulsodesmaio, "2, 6");
		
		JRadioButton rdbtnSim_1 = new JRadioButton("Sim");
		panel_1.add(rdbtnSim_1, "6, 6");
		
		JRadioButton rdbtnNo_1 = new JRadioButton("N\u00E3o");
		panel_1.add(rdbtnNo_1, "10, 6");
		
		JLabel lblDiabetes = new JLabel("Diabetes");
		panel_1.add(lblDiabetes, "2, 8");
		
		JRadioButton radioButton_24 = new JRadioButton("Sim");
		panel_1.add(radioButton_24, "6, 8");
		
		JRadioButton radioButton_25 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_25, "10, 8");
		
		JLabel lblTuberculoseProblemasDe = new JLabel("Tuberculose, problemas de pulm\u00E3o, asma, broquite");
		panel_1.add(lblTuberculoseProblemasDe, "2, 10");
		
		JRadioButton radioButton_26 = new JRadioButton("Sim");
		panel_1.add(radioButton_26, "6, 10");
		
		JRadioButton radioButton_27 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_27, "10, 10");
		
		JLabel lblDorNoPeito = new JLabel("Dor no peito, problemas cardiacos");
		panel_1.add(lblDorNoPeito, "2, 12");
		
		JRadioButton radioButton_28 = new JRadioButton("Sim");
		panel_1.add(radioButton_28, "6, 12");
		
		JRadioButton radioButton_29 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_29, "10, 12");
		
		JLabel lblUsoContinuoDe = new JLabel("Uso continuo de \u00E1lcool");
		panel_1.add(lblUsoContinuoDe, "2, 14");
		
		JRadioButton radioButton_30 = new JRadioButton("Sim");
		panel_1.add(radioButton_30, "6, 14");
		
		JRadioButton radioButton_31 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_31, "10, 14");
		
		JLabel lblReumatismo = new JLabel("Reumatismo");
		panel_1.add(lblReumatismo, "2, 16");
		
		JRadioButton radioButton_32 = new JRadioButton("Sim");
		panel_1.add(radioButton_32, "6, 16");
		
		JRadioButton radioButton_33 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_33, "10, 16");
		
		JLabel lblUsoDeInsulina = new JLabel("Uso de insulina bovina ou Uso de horm\u00F4nio de crescimento                                                                  ");
		panel_1.add(lblUsoDeInsulina, "2, 18");
		
		JRadioButton radioButton_34 = new JRadioButton("Sim");
		panel_1.add(radioButton_34, "6, 18");
		
		JRadioButton radioButton_35 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_35, "10, 18");
		
		JLabel lblProblemaCirculatrio = new JLabel("Problema circulat\u00F3rio");
		panel_1.add(lblProblemaCirculatrio, "2, 20");
		
		JRadioButton radioButton_36 = new JRadioButton("Sim");
		panel_1.add(radioButton_36, "6, 20");
		
		JRadioButton radioButton_37 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_37, "10, 20");
		
		JLabel lblPeleOuOutros = new JLabel("Pele ou outros problemas dematol\u00F3gicos cr\u00F4nicos");
		panel_1.add(lblPeleOuOutros, "2, 22");
		
		JRadioButton radioButton_38 = new JRadioButton("Sim");
		panel_1.add(radioButton_38, "6, 22");
		
		JRadioButton radioButton_39 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_39, "10, 22");
		
		JLabel lblTireide = new JLabel("Tire\u00F3ide");
		panel_1.add(lblTireide, "2, 24");
		
		JRadioButton radioButton_40 = new JRadioButton("Sim");
		panel_1.add(radioButton_40, "6, 24");
		
		JRadioButton radioButton_41 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_41, "10, 24");
		
		JLabel lblSangramentoExcessivo = new JLabel("Sangramento excessivo");
		panel_1.add(lblSangramentoExcessivo, "2, 26");
		
		JRadioButton radioButton_42 = new JRadioButton("Sim");
		panel_1.add(radioButton_42, "6, 26");
		
		JRadioButton radioButton_43 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_43, "10, 26");
		
		JLabel lblCncer = new JLabel("C\u00E2ncer");
		panel_1.add(lblCncer, "2, 28");
		
		JRadioButton radioButton_44 = new JRadioButton("Sim");
		panel_1.add(radioButton_44, "6, 28");
		
		JRadioButton radioButton_45 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_45, "10, 28");
		
		JLabel lblTransplantesexCrnea = new JLabel("Transplantes(ex.: c\u00F3rnea)");
		panel_1.add(lblTransplantesexCrnea, "2, 30");
		
		JRadioButton radioButton_46 = new JRadioButton("Sim");
		panel_1.add(radioButton_46, "6, 30");
		
		JRadioButton radioButton_47 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_47, "10, 30");
		
		JLabel lblProblemaNoRim = new JLabel("Problema no rim");
		panel_1.add(lblProblemaNoRim, "2, 32");
		
		JRadioButton radioButton_48 = new JRadioButton("Sim");
		panel_1.add(radioButton_48, "6, 32");
		
		JRadioButton radioButton_49 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_49, "10, 32");
		
		JLabel lblCirugiaNeurolgica = new JLabel("Cirugia neurol\u00F3gica");
		panel_1.add(lblCirugiaNeurolgica, "2, 34");
		
		JRadioButton radioButton_50 = new JRadioButton("Sim");
		panel_1.add(radioButton_50, "6, 34");
		
		JRadioButton radioButton_51 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_51, "10, 34");
		
		JLabel lblExamesEndoscpicos = new JLabel("Exames endoscpicos");
		panel_1.add(lblExamesEndoscpicos, "2, 36");
		
		JRadioButton radioButton_52 = new JRadioButton("Sim");
		panel_1.add(radioButton_52, "6, 36");
		
		JRadioButton radioButton_53 = new JRadioButton("N\u00E3o");
		panel_1.add(radioButton_53, "10, 36");
		getContentPane().setLayout(groupLayout);

	}
}
