package view;


import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class Questions extends JInternalFrame {

	
	private static final long serialVersionUID = 1L;

	public Questions() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setSize(679, 545);
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

	}

}
