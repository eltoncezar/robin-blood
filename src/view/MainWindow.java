package view;

import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import javafx.scene.image.Image;
 
public class MainWindow extends JFrame{

 
    private JDesktopPane desktopPane;
    private UserRegistration userResFrame;
    private DonorRegistration donorResFrame;
    private JMenuBar menuBar;
 
    public MainWindow(){
    	super("Robin Blood");
    	
    	
    	//Inicializa Jframe FullScrean
    	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	setSize(800,600);
	
        desktopPane = new JDesktopPane();
        menuBar = new JMenuBar();
        setContentPane(desktopPane);
        
        //Menu Cadastro
        JMenu mnNewMenu = new JMenu("Cadastro");
        menuBar.add(mnNewMenu);
        
        JMenuItem mUsuario = new JMenuItem("Usu\u00E1rio");
        mnNewMenu.add(mUsuario);
        mUsuario.addActionListener(new ActionListener() {        	
           	@Override
        	public void actionPerformed(ActionEvent e) {
           		//Verifica inicialização do Frame
           		if(userResFrame == null){
                	userResFrame = new UserRegistration();
                	userResFrame.setVisible(true);
                    desktopPane.add(userResFrame);
                }
                else if(!userResFrame.isVisible()){
                	userResFrame.setVisible(true);
                    desktopPane.add(userResFrame);
                }
           		//Inicializa Frame Centralizado
           		userResFrame.setBounds(0, 0, userResFrame.getWidth(), userResFrame.getHeight());
                int lDesk = desktopPane.getWidth();
                int aDesk = desktopPane.getHeight();
                int lIFrame = userResFrame.getWidth();
                int aIFrame = userResFrame.getHeight();
                userResFrame.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
            }
        		
        });
        
        JMenuItem mDoador = new JMenuItem("Doador");
        mnNewMenu.add(mDoador);
        mDoador.addActionListener(new ActionListener() {        	
           	@Override
        	public void actionPerformed(ActionEvent e) {
           		//Verifica inicialização do Frame
           		if(donorResFrame == null){
           			donorResFrame = new DonorRegistration();
           			donorResFrame.setVisible(true);
                    desktopPane.add(donorResFrame);
                }
                else if(!donorResFrame.isVisible()){
                	donorResFrame.setVisible(true);
                    desktopPane.add(donorResFrame);
                }
           		//Inicializa Frame Centralizado
           		donorResFrame.setBounds(0, 0, donorResFrame.getWidth(), donorResFrame.getHeight());
                int lDesk = desktopPane.getWidth();
                int aDesk = desktopPane.getHeight();
                int lIFrame = donorResFrame.getWidth();
                int aIFrame = donorResFrame.getHeight();
                donorResFrame.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
            }
        		
        });
        
        JMenuItem mntmHospital = new JMenuItem("Hospital");
        mnNewMenu.add(mntmHospital);
        
        JMenuItem mntmDoao = new JMenuItem("Doa\u00E7\u00E3o");
        mnNewMenu.add(mntmDoao);
        
        
        //Menu Serviços
        JMenu mnNewMenu_1 = new JMenu("Servi\u00E7os");
        menuBar.add(mnNewMenu_1);
        
        JMenuItem mntmDoao_1 = new JMenuItem("Doa\u00E7\u00E3o");
        mnNewMenu_1.add(mntmDoao_1);
        
        
        
        //Menu Relatórios
        JMenu mnNewMenu_2 = new JMenu("Relat\u00F3rios");
        menuBar.add(mnNewMenu_2);
        
        JMenuItem mntmEstoque = new JMenuItem("Estoque");
        mnNewMenu_2.add(mntmEstoque);
        
        JMenuItem mntmFila = new JMenuItem("Fila");
        mnNewMenu_2.add(mntmFila);
        
        JMenuItem mntmDoador = new JMenuItem("Doador");
        mnNewMenu_2.add(mntmDoador);
 
   
        setJMenuBar(menuBar);
 
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("/robin-blood/Imagens/IconBlood1.png").getImage());
        
    }
 
    
 
}