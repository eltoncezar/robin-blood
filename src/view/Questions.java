package view;




import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;


public class Questions extends JInternalFrame {

	
	private static final long serialVersionUID = 1L;

	public Questions() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setSize(755, 940);
		FormLayout formLayout = new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
				FormSpecs.DEFAULT_ROWSPEC,});
		getContentPane().setLayout(formLayout);
		
		JLabel lblQuestionrioCadidado = new JLabel("QUESTION\u00C1RIO CADIDADO \u00C0 DOA\u00C7\u00C2O DE SANGUE");
		getContentPane().add(lblQuestionrioCadidado, "2, 2, right, default");
		
		JLabel lblPerguntas = new JLabel("Perguntas");
		getContentPane().add(lblPerguntas, "2, 4");
		
		JLabel lblRespostas = new JLabel("Respostas");
		getContentPane().add(lblRespostas, "6, 4");
		
		JLabel lblNewLabel = new JLabel("J\u00E1 doou sangue?");
		getContentPane().add(lblNewLabel, "2, 8, left, default");
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		getContentPane().add(rdbtnSim, "4, 8");
		
		JRadioButton rdbtnNo = new JRadioButton("N\u00E3o");
		getContentPane().add(rdbtnNo, "8, 8");
		
		JLabel lblSentiuseMalEm = new JLabel("Sentiu-se mal em alguma doa\u00E7\u00E3o?");
		getContentPane().add(lblSentiuseMalEm, "2, 10, left, default");
		
		JRadioButton radioButton = new JRadioButton("Sim");
		getContentPane().add(radioButton, "4, 10");
		
		JRadioButton radioButton_ = new JRadioButton("N\u00E3o");
		getContentPane().add(radioButton_, "8, 10");
		
		JLabel lblVaiTrabalharEm = new JLabel("Vai trabalhar em altura(telhado, andaime), com m\u00E1quina pesada(sera, prensa), apos a doa\u00E7\u00E3o");
		getContentPane().add(lblVaiTrabalharEm, "2, 12");
		
		JRadioButton radioButton_1 = new JRadioButton("Sim");
		getContentPane().add(radioButton_1, "4, 12");
		
		JRadioButton radioButton_11 = new JRadioButton("N\u00E3o");
		getContentPane().add(radioButton_11, "8, 12");
		
		JLabel lblEstSeSentindo = new JLabel("Est\u00E1 se sentindo bem?");
		getContentPane().add(lblEstSeSentindo, "2, 14");
		
		JRadioButton radioButton_2 = new JRadioButton("Sim");
		getContentPane().add(radioButton_2, "4, 14");
		
		JRadioButton radioButton_12 = new JRadioButton("N\u00E3o");
		getContentPane().add(radioButton_12, "8, 14");
		
		JLabel lblDormiuBemNas = new JLabel("Dormiu bem nas \u00FAltimas 24horas");
		getContentPane().add(lblDormiuBemNas, "2, 16");
		
		JRadioButton radioButton_3 = new JRadioButton("Sim");
		getContentPane().add(radioButton_3, "4, 16");
		
		JRadioButton radioButton_13 = new JRadioButton("N\u00E3o");
		getContentPane().add(radioButton_13, "8, 16");
		
		JLabel lblIngeriuBebidaAlcolica = new JLabel("Ingeriu bebida alco\u00F3lica h\u00E1 menos de 12 horas?");
		getContentPane().add(lblIngeriuBebidaAlcolica, "2, 18");
		
		JRadioButton radioButton_4 = new JRadioButton("Sim");
		getContentPane().add(radioButton_4, "4, 18");
		
		JRadioButton radioButton_14 = new JRadioButton("N\u00E3o");
		getContentPane().add(radioButton_14, "8, 18");
		
		JLabel lblRecebeuAlgumaVacina = new JLabel("Recebeu alguma vacina nos ultimos 30 dias? Qual(is)?");
		getContentPane().add(lblRecebeuAlgumaVacina, "2, 20");
		
		JRadioButton radioButton_5 = new JRadioButton("Sim");
		getContentPane().add(radioButton_5, "4, 20");
		
		JRadioButton radioButton_15 = new JRadioButton("N\u00E3o");
		getContentPane().add(radioButton_15, "8, 20");
		
		JLabel lblEstResfriadoCom = new JLabel("Est\u00E1 resfriado, com dor de garganta ou febre?");
		getContentPane().add(lblEstResfriadoCom, "2, 22");
		
		JRadioButton radioButton_6 = new JRadioButton("Sim");
		getContentPane().add(radioButton_6, "4, 22");
		
		JRadioButton radioButton_16 = new JRadioButton("N\u00E3o");
		getContentPane().add(radioButton_16, "8, 22");
		
		JLabel lblEstTomandoAlgum = new JLabel("Est\u00E1 tomando algum tipo de medicamento? Qual(is)?");
		getContentPane().add(lblEstTomandoAlgum, "2, 24");
		
		JRadioButton radioButton_7 = new JRadioButton("Sim");
		getContentPane().add(radioButton_7, "4, 24");
		
		JRadioButton radioButton_17 = new JRadioButton("N\u00E3o");
		getContentPane().add(radioButton_17, "8, 24");
		
		JLabel lblEstComAlguma = new JLabel("Est\u00E1 com alguma alergia no momento?");
		getContentPane().add(lblEstComAlguma, "2, 26");
		
		JRadioButton radioButton_8 = new JRadioButton("Sim");
		getContentPane().add(radioButton_8, "4, 26");
		
		JRadioButton radioButton_18 = new JRadioButton("N\u00E3o");
		getContentPane().add(radioButton_18, "8, 26");
		
		JLabel lblExtraiuDenteOu = new JLabel("Extraiu dente ou fez tratamento de canal nos ultimos 07 dias?");
		getContentPane().add(lblExtraiuDenteOu, "2, 28");
		
		JRadioButton radioButton_9 = new JRadioButton("Sim");
		getContentPane().add(radioButton_9, "4, 28");
		
		JRadioButton radioButton_19 = new JRadioButton("N\u00E3o");
		getContentPane().add(radioButton_19, "8, 28");
		
		JLabel lblFezTatuagemOu = new JLabel("Fez tatuagem ou maquiagem definitiva nos ultimos 12 meses?");
		getContentPane().add(lblFezTatuagemOu, "2, 30");
		
		JRadioButton radioButton_10 = new JRadioButton("Sim");
		getContentPane().add(radioButton_10, "4, 30");
		
		JRadioButton radioButton_20 = new JRadioButton("N\u00E3o");
		getContentPane().add(radioButton_20, "8, 30");
		
		JLabel lblMarqueSeJ = new JLabel("MARQUE SE J\u00C1 TEVE/TEM ALGUM DESTES PROBLEMAS ou CIRURGIAS:");
		getContentPane().add(lblMarqueSeJ, "2, 34, right, default");
		
		JLabel lblAtaqueEpileticoConvulsodesmaio = new JLabel("Ataque epiletico, convuls\u00E3o/desmaio");
		getContentPane().add(lblAtaqueEpileticoConvulsodesmaio, "2, 36");
		
		JRadioButton radioButton_21 = new JRadioButton("Sim");
		getContentPane().add(radioButton_21, "4, 36");
		
		JLabel lblDiabetes = new JLabel("Diabetes");
		getContentPane().add(lblDiabetes, "2, 38");
		
		JRadioButton radioButton_22 = new JRadioButton("Sim");
		getContentPane().add(radioButton_22, "4, 38");
		
		JLabel lblTuberculoseProblemasDe = new JLabel("Tuberculose, problemas de pulm\u00E3o, asma, broquite");
		getContentPane().add(lblTuberculoseProblemasDe, "2, 40");
		
		JRadioButton radioButton_23 = new JRadioButton("Sim");
		getContentPane().add(radioButton_23, "4, 40");
		
		JLabel lblDorNoPeito = new JLabel("Dor no peito, problemas cardiacos");
		getContentPane().add(lblDorNoPeito, "2, 42");
		
		JRadioButton radioButton_24 = new JRadioButton("Sim");
		getContentPane().add(radioButton_24, "4, 42");
		
		JLabel lblUsoContinuoDe = new JLabel("Uso continuo de \u00E1lcool");
		getContentPane().add(lblUsoContinuoDe, "2, 44");
		
		JRadioButton radioButton_25 = new JRadioButton("Sim");
		getContentPane().add(radioButton_25, "4, 44");
		
		JLabel lblReumatismo = new JLabel("Reumatismo");
		getContentPane().add(lblReumatismo, "2, 46");
		
		JRadioButton radioButton_26 = new JRadioButton("Sim");
		getContentPane().add(radioButton_26, "4, 46");
		
		JLabel lblUsoDeInsulina = new JLabel("Uso de insulina bovina ou Uso de horm\u00F4nio de crescimento");
		getContentPane().add(lblUsoDeInsulina, "2, 48");
		
		JRadioButton radioButton_27 = new JRadioButton("Sim");
		getContentPane().add(radioButton_27, "4, 48");
		
		JLabel lblProblemaCirculatrio = new JLabel("Problema circulat\u00F3rio");
		getContentPane().add(lblProblemaCirculatrio, "2, 50");
		
		JRadioButton radioButton_28 = new JRadioButton("Sim");
		getContentPane().add(radioButton_28, "4, 50");
		
		JLabel lblPeleOuOutros = new JLabel("Pele ou outros problemas dematol\u00F3gicos cr\u00F4nicos");
		getContentPane().add(lblPeleOuOutros, "2, 52");
		
		JRadioButton radioButton_29 = new JRadioButton("Sim");
		getContentPane().add(radioButton_29, "4, 52");
		
		JLabel lblTireide = new JLabel("Tire\u00F3ide");
		getContentPane().add(lblTireide, "2, 54");
		
		JRadioButton radioButton_30 = new JRadioButton("Sim");
		getContentPane().add(radioButton_30, "4, 54");
		
		JLabel lblSangramentoExcessivo = new JLabel("Sangramento excessivo");
		getContentPane().add(lblSangramentoExcessivo, "2, 56");
		
		JRadioButton radioButton_31 = new JRadioButton("Sim");
		getContentPane().add(radioButton_31, "4, 56");
		
		JLabel lblCncer = new JLabel("C\u00E2ncer");
		getContentPane().add(lblCncer, "2, 58");
		
		JRadioButton radioButton_32 = new JRadioButton("Sim");
		getContentPane().add(radioButton_32, "4, 58");
		
		JLabel lblTransplantesexCrnea = new JLabel("Transplantes(ex.: c\u00F3rnea)");
		getContentPane().add(lblTransplantesexCrnea, "2, 60");
		
		JRadioButton radioButton_33 = new JRadioButton("Sim");
		getContentPane().add(radioButton_33, "4, 60");
		
		JLabel lblProblemaNoRim = new JLabel("Problema no rim");
		getContentPane().add(lblProblemaNoRim, "2, 62");
		
		JRadioButton radioButton_34 = new JRadioButton("Sim");
		getContentPane().add(radioButton_34, "4, 62");
		
		JLabel lblCirurgiaNeurolgica = new JLabel("Cirurgia neurol\u00F3gica");
		getContentPane().add(lblCirurgiaNeurolgica, "2, 64");
		
		JLabel lblExamesEndoscpios = new JLabel("Exames endosc\u00F3pios");
		getContentPane().add(lblExamesEndoscpios, "2, 66");

	}

}
