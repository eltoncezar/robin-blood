package view;

import java.awt.event.*;

import javax.swing.*;

 
public class MainWindow extends JFrame{

 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JDesktopPane desktopPane;
    private DonorList donorlist;
    private DonationRegistration donationResFrame;
    private HospitalList hospitalFrame;
    private EstoqueEntrada estoqueestradaframe;
    private Distribution distributionframe;
    private ReportInventory reportInventory;
    private QuestionsInDonor questionsindonor;
    private UserList userlist;
    
    private JMenuBar menuBar;
    
    private static MainWindow mainwindow;
    
    public static MainWindow getInstancia(){
    	if(mainwindow == null){
    		mainwindow = new MainWindow();
    	}
		return mainwindow;
    	
    }
    
    public static JDesktopPane getDesktopPanel(){
    	
		getInstancia();
		return MainWindow.desktopPane;
    	
    }
 
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
        mnNewMenu.setIcon(new ImageIcon("/robin-blood/Imagens/IconForm.png"));
        menuBar.add(mnNewMenu);
        
        JMenuItem mUsuario = new JMenuItem("Usu\u00E1rio");
        mUsuario.setIcon(new ImageIcon("/robin-blood/Imagens/IconUser.png"));
        mnNewMenu.add(mUsuario);
        mUsuario.addActionListener(new ActionListener() {        	
           	@Override
        	public void actionPerformed(ActionEvent e) {
           		
           		if(userlist == null){
                	userlist = new UserList();
                	userlist.setVisible(true);
                	desktopPane.add(userlist);
                }
                else if(!userlist.isVisible()){
                	userlist.dispose();
                	userlist = new UserList();
                	userlist.setVisible(true);
                	desktopPane.add(userlist);;
                }
           		//Inicializa Frame Centralizado
           		userlist.setBounds(0, 0, userlist.getWidth(), userlist.getHeight());
           		int lDesk = desktopPane.getWidth();
                int aDesk = desktopPane.getHeight();
                int lIFrame = userlist.getWidth();
                int aIFrame = userlist.getHeight();
                userlist.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
                userlist.moveToFront();
			
            }
         		
        });
        
        JMenuItem mDoador = new JMenuItem("Doador");
        mDoador.setIcon(new ImageIcon("/robin-blood/Imagens/IconDonor.png"));
        mnNewMenu.add(mDoador);
        mDoador.addActionListener(new ActionListener() {        	
           	

			@Override
        	public void actionPerformed(ActionEvent e) {
					donorlist = new DonorList();
                	donorlist.setVisible(true);
                	desktopPane.add(donorlist);
                            
           		donorlist.setBounds(0, 0, donorlist.getWidth(), donorlist.getHeight());
           		int lDesk = MainWindow.getDesktopPanel().getWidth();
                int aDesk = MainWindow.getDesktopPanel().getHeight();
                int lIFrame = donorlist.getWidth();
                int aIFrame = donorlist.getHeight();
                donorlist.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
            }
        		
        });
        
        JMenuItem mntmHospital = new JMenuItem("Hospital");
        mntmHospital.setIcon(new ImageIcon("/robin-blood/Imagens/IconHospital.png"));
        mntmHospital.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		hospitalFrame = new HospitalList();
        		hospitalFrame.setVisible(true);
        		desktopPane.add(hospitalFrame);
        		
        		hospitalFrame.setBounds(0, 0, hospitalFrame.getWidth(), hospitalFrame.getHeight());
                int lDesk = desktopPane.getWidth();
                int aDesk = desktopPane.getHeight();
                int lIFrame = hospitalFrame.getWidth();
                int aIFrame = hospitalFrame.getHeight();
                hospitalFrame.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
        		
        	}
        });
        mnNewMenu.add(mntmHospital);
        
        
        //Menu Serviços
        JMenu mnNewMenu_1 = new JMenu("Servi\u00E7os");
        mnNewMenu_1.setIcon(new ImageIcon("/robin-blood/Imagens/Iconservico.png"));
        menuBar.add(mnNewMenu_1);
        
        JMenuItem mntmDoao_1 = new JMenuItem("Doa\u00E7\u00E3o");
        mntmDoao_1.setIcon(new ImageIcon("/robin-blood/Imagens/IconDoacao_1.png"));
        mntmDoao_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(donationResFrame == null){
           			donationResFrame = new DonationRegistration();
           			donationResFrame.setVisible(true);
                    desktopPane.add(donationResFrame);
                }
                else if(!donationResFrame.isVisible()){
                	donationResFrame.setVisible(true);
                    desktopPane.add(donationResFrame);
                }
           		//Inicializa Frame Centralizado
           		donationResFrame.setBounds(0, 0, donationResFrame.getWidth(), donationResFrame.getHeight());
                int lDesk = desktopPane.getWidth();
                int aDesk = desktopPane.getHeight();
                int lIFrame = donationResFrame.getWidth();
                int aIFrame = donationResFrame.getHeight();
                donationResFrame.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
        	}
        });
        mnNewMenu_1.add(mntmDoao_1);
        
        JMenu mnEstoque = new JMenu("Estoque");
        mnEstoque.setIcon(new ImageIcon("/robin-blood/Imagens/Iconestoque.png"));
        menuBar.add(mnEstoque);
        
        JMenuItem mntmReserva = new JMenuItem("Entrada");
        mntmReserva.setIcon(new ImageIcon("/robin-blood/Imagens/IconIn.png"));
        mntmReserva.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		estoqueestradaframe = new EstoqueEntrada();
        		estoqueestradaframe.setVisible(true);
        		desktopPane.add(estoqueestradaframe);
        		
        		estoqueestradaframe.setBounds(0, 0, estoqueestradaframe.getWidth(), estoqueestradaframe.getHeight());
                int lDesk = desktopPane.getWidth();
                int aDesk = desktopPane.getHeight();
                int lIFrame = estoqueestradaframe.getWidth();
                int aIFrame = estoqueestradaframe.getHeight();
                estoqueestradaframe.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
        	
        		
        	
        	}
        });
        mnEstoque.add(mntmReserva);
        
        JMenuItem mntmDistribuicao = new JMenuItem("Distribuição");
        mntmDistribuicao.setIcon(new ImageIcon("/robin-blood/Imagens/Icondistribuicao.png"));
        mntmDistribuicao.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		distributionframe = new Distribution();
        		distributionframe.setVisible(true);
        		desktopPane.add(distributionframe);
        		
        		distributionframe.setBounds(0, 0, distributionframe.getWidth(), distributionframe.getHeight());
                int lDesk = desktopPane.getWidth();
                int aDesk = desktopPane.getHeight();
                int lIFrame = distributionframe.getWidth();
                int aIFrame = distributionframe.getHeight();
                distributionframe.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
        	}
        });
        mnEstoque.add(mntmDistribuicao);
        
        
        
        //Menu Relatórios
        JMenu mnNewMenu_2 = new JMenu("Relat\u00F3rios");
        mnNewMenu_2.setIcon(new ImageIcon("/robin-blood/Imagens/IconRelatorio.png"));
        menuBar.add(mnNewMenu_2);
        
        JMenuItem mntmFila = new JMenuItem("Fila");
        mntmFila.setIcon(new ImageIcon("/robin-blood/Imagens/iconfila.png"));
        mnNewMenu_2.add(mntmFila);
        
        JMenuItem mntmDoador = new JMenuItem("Doador");
        mntmDoador.setIcon(new ImageIcon("Imagens/Icondonor_1.png"));
        mnNewMenu_2.add(mntmDoador);
        
        JMenuItem mntmEstoque = new JMenuItem("Estoque");
        mntmEstoque.setIcon(new ImageIcon("/robin-blood/Imagens/iconestoque_1.png"));
        mntmEstoque.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		reportInventory = new ReportInventory();
        		reportInventory.setVisible(true);
        		desktopPane.add(reportInventory);
        		
        		reportInventory.setBounds(0, 0, reportInventory.getWidth(), reportInventory.getHeight());
                int lDesk = desktopPane.getWidth();
                int aDesk = desktopPane.getHeight();
                int lIFrame = reportInventory.getWidth();
                int aIFrame = reportInventory.getHeight();
                reportInventory.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
        	}
        });
        mnNewMenu_2.add(mntmEstoque);
 
   
        setJMenuBar(menuBar);
        
        JMenu mnDoador = new JMenu("Doador");
        mnDoador.setIcon(new ImageIcon("Imagens/IconSponsor.png"));
        menuBar.add(mnDoador);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Questionario");
        mntmNewMenuItem.setIcon(new ImageIcon("Imagens/Iconq_and_a.png"));
        mnDoador.add(mntmNewMenuItem);
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		questionsindonor = new QuestionsInDonor();
        		questionsindonor.setVisible(true);
        		desktopPane.add(questionsindonor);
        		
        		questionsindonor.setBounds(0, 0, questionsindonor.getWidth(), questionsindonor.getHeight());
                int lDesk = desktopPane.getWidth();
                int aDesk = desktopPane.getHeight();
                int lIFrame = questionsindonor.getWidth();
                int aIFrame = questionsindonor.getHeight();
                questionsindonor.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
        	}
        });
 
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("Imagens/IconLogo.png").getImage());
        
    }
}