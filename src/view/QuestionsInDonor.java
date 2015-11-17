package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class QuestionsInDonor extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private Questions questionsframe;


	
	public QuestionsInDonor() {
		setClosable(true);
		setSize(200,205);
		
		JLabel lblCpf = new JLabel("CPF");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnIniciarQuetionrio = new JButton("Iniciar Quetion\u00E1rio");
		btnIniciarQuetionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questionsframe = new Questions();
        		questionsframe.setVisible(true);
        		MainWindow.getInstancia().getContentPane().add(questionsframe);
        		
        		questionsframe.setBounds(0, 0, questionsframe.getWidth(), questionsframe.getHeight());
                int lDesk = MainWindow.getInstancia().getWidth();
                int aDesk = MainWindow.getInstancia().getHeight();
                int lIFrame = questionsframe.getWidth();
                int aIFrame = questionsframe.getHeight();
                questionsframe.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
                dispose();
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCpf))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(btnIniciarQuetionrio))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(lblCpf)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btnIniciarQuetionrio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
