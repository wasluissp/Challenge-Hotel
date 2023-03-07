package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
//import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
//import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.SystemColor;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class MenuUsuario extends JFrame {

	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel labelSair;
	private JLabel labelRegistro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/imagens/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(12, 138, 199));
		panelMenu.setBounds(0, 0, 257, 609);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(50, 58, 150, 150);
		panelMenu.add(logo);
		logo.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagens/aH-150px.png")));
		
		JPanel btnRegistro = new JPanel();
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistro.setBackground(new Color(12, 138, 199));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();
			}
		});
		btnRegistro.setBounds(0, 255, 257, 56);
		btnRegistro.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnRegistro);
		btnRegistro.setLayout(null);
		btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		labelRegistro = new JLabel("Registro da reservas");
		labelRegistro.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagens/reservado.png")));
		labelRegistro.setForeground(SystemColor.text);
		labelRegistro.setBounds(25, 11, 205, 34);
		labelRegistro.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistro.add(labelRegistro);
		
		JPanel btnBuscar = new JPanel();
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setBackground(new Color(12, 138, 199));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Buscar buscar = new Buscar();
				buscar.setVisible(true);
				dispose();
			}
		});
		btnBuscar.setBounds(0, 312, 257, 56);
		btnBuscar.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnBuscar);
		btnBuscar.setLayout(null);
		btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblBuscaDeReservas = new JLabel("Buscar");
		lblBuscaDeReservas.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagens/pessoas.png")));
		lblBuscaDeReservas.setBounds(27, 11, 200, 34);
		lblBuscaDeReservas.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscaDeReservas.setForeground(Color.WHITE);
		lblBuscaDeReservas.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnBuscar.add(lblBuscaDeReservas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);
		panelMenu.add(separator);
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 944, 36);
		contentPane.add(header);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelSair.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(Color.white);
			     labelSair.setForeground(Color.black);
			}
		});
		
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(891, 0, 53, 36);
		header.add(btnexit);
		
		labelSair = new JLabel("X");
		labelSair.setBounds(0, 0, 53, 36);
		btnexit.add(labelSair);
		labelSair.setHorizontalAlignment(SwingConstants.CENTER);
		labelSair.setFont(new Font("Roboto", Font.PLAIN, 18));
		
	    JPanel panelData = new JPanel();
	    panelData.setBackground(new Color(118, 187, 223));
	    panelData.setBounds(256, 84, 688, 121);
	    contentPane.add(panelData);
	    panelData.setLayout(null);
	    
	    JLabel lblTitulo = new JLabel("Sistema de reservas. Hotel Alura ");
	    lblTitulo.setBounds(180, 11, 356, 42);
	    panelData.add(lblTitulo);
	    lblTitulo.setForeground(Color.WHITE);
	    lblTitulo.setFont(new Font("Roboto", Font.PLAIN, 19));
	    
	    JLabel labelData = new JLabel("New label");
	    labelData.setBounds(35, 64, 294, 36);
	    panelData.add(labelData);
	    labelData.setForeground(Color.WHITE);
	    labelData.setFont(new Font("Roboto", Font.PLAIN, 33));
	    Date dataActual = new Date(); 
	    String data = new SimpleDateFormat("dd/MM/yyyy").format(dataActual); 
	    labelData.setText("Dia: " + data); 
	    
	    JLabel lblBemvindo = new JLabel("Bem Vindo");
	    lblBemvindo.setFont(new Font("Roboto", Font.BOLD, 24));
	    lblBemvindo.setBounds(302, 234, 147, 46);
	    contentPane.add(lblBemvindo);
	    
	    String textoDescripcion = "<html><body>Sistema de reserva do Hotel Alura. Controle e Administração de Reservas e Hospedes, de forma simples e prática. </body></html>";
	    JLabel labelDescripcion = new JLabel(textoDescripcion);
	    labelDescripcion.setFont(new Font("Roboto", Font.PLAIN, 17));
	   
	    labelDescripcion.setBounds(312, 291, 598, 66);
	    contentPane.add(labelDescripcion);
	    
	    String textoDescripcion1 = "<html><body> Esta ferramenta permitirá controle completo e detalhado das reservas e dos hospedes, com acesso a ferramentas especiais para tarefas específicas como:</body></html>";
	    JLabel labelDescripcion_1 = new JLabel(textoDescripcion1);
	    labelDescripcion_1.setFont(new Font("Roboto", Font.PLAIN, 17));
	    labelDescripcion_1.setBounds(311, 345, 569, 88);
	    contentPane.add(labelDescripcion_1);
	    
	    JLabel lblDescripcion_3 = new JLabel("- Registro das Reservas e dos Hospedes");
	    lblDescripcion_3.setFont(new Font("Roboto", Font.PLAIN, 17));
	    lblDescripcion_3.setBounds(312, 444, 295, 27);
	    contentPane.add(lblDescripcion_3);
	    
	    JLabel lblDescripcion_4 = new JLabel("- Edição das Reservas e dos Hospedes existentes");
	    lblDescripcion_4.setFont(new Font("Roboto", Font.PLAIN, 17));
	    lblDescripcion_4.setBounds(312, 482, 355, 27);
	    contentPane.add(lblDescripcion_4);
	    
	    JLabel lblDescripcion_5 = new JLabel("- Eliminar os registros necessários.");
	    lblDescripcion_5.setFont(new Font("Roboto", Font.PLAIN, 17));
	    lblDescripcion_5.setBounds(312, 520, 295, 27);
	    contentPane.add(lblDescripcion_5);
	}
	
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
