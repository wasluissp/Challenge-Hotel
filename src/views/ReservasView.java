package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import jdbc.controller.ReservasController;
import jdbc.modelo.Reserva;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.text.Format;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;



@SuppressWarnings("serial")
public class ReservasView extends JFrame {

	private JPanel contentPane;
	public static JTextField txtValor;
	public static JDateChooser txtDataE;
	public static JDateChooser txtDataS;
	public static JComboBox<Format> txtForma_pagamento;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel lblNewLabel_3; 
	private JLabel labelVoltar;
	private ReservasController reservasController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservasView frame = new ReservasView();
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
	public ReservasView() {
		super("Reserva");
		this.reservasController = new ReservasController();

		setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/imagens/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		

		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(SystemColor.textHighlight);
		separator_1_2.setBounds(68, 195, 289, 2);
		separator_1_2.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setForeground(SystemColor.textHighlight);
		separator_1_3.setBackground(SystemColor.textHighlight);
		separator_1_3.setBounds(68, 453, 289, 2);
		panel.add(separator_1_3);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(SystemColor.textHighlight);
		separator_1_1.setBounds(68, 281, 289, 11);
		separator_1_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_1);
		
		txtDataE = new JDateChooser();
		txtDataE.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtDataE.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagens/icon-reservas.png")));
		txtDataE.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtDataE.setBounds(68, 161, 289, 35);
		txtDataE.getCalendarButton().setBounds(268, 0, 21, 33);
		txtDataE.setBackground(Color.WHITE);
		txtDataE.setBorder(new LineBorder(SystemColor.window));
		txtDataE.setDateFormatString("yyyy-MM-dd");
		txtDataE.setFont(new Font("Roboto", Font.PLAIN, 18));
		panel.add(txtDataE);
		
		lblNewLabel_3 = new JLabel("R$");
		lblNewLabel_3.setBounds(121, 332, 17, 25);
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 17));
		lblNewLabel_3.setEnabled(false);
		panel.add(lblNewLabel_3);
		
		JLabel lblCheckIn = new JLabel("DATA DO CHECK IN");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(68, 136, 169, 14);
		lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("DATA DO CHECK OUT");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(68, 221, 187, 14);
		lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckOut);
		
		txtDataS = new JDateChooser();
		txtDataS.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagens/icon-reservas.png")));
		txtDataS.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtDataS.setBounds(68, 246, 289, 35);
		txtDataS.getCalendarButton().setBounds(267, 1, 21, 31);
		txtDataS.setBackground(Color.WHITE);
		txtDataS.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtDataS.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				calcularValor(txtDataE,txtDataS);				
			}
		});
		txtDataS.setDateFormatString("yyyy-MM-dd");
		txtDataS.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtDataS.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		panel.add(txtDataS);
		
	
		
		txtValor = new JTextField();
		txtValor.setBackground(SystemColor.text);
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setForeground(Color.BLACK);
		txtValor.setBounds(78, 328, 43, 33);
		txtValor.setEditable(false);
		txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblValor = new JLabel("VALOR DA RESERVA");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(72, 303, 196, 14);
		lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblValor);
		
		txtForma_pagamento = new JComboBox();
		txtForma_pagamento.setBounds(68, 417, 289, 38);
		txtForma_pagamento.setBackground(SystemColor.text);
		txtForma_pagamento.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtForma_pagamento.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtForma_pagamento.setModel(new DefaultComboBoxModel(new String[] {"Cartão de Crédito", "Cartão de Débito", "Em Dinheiro, Pix"}));
		panel.add(txtForma_pagamento);
		
		JLabel lblForma_pagamento = new JLabel("FORMA DE PAGAMENTO");
		lblForma_pagamento.setForeground(SystemColor.textInactiveText);
		lblForma_pagamento.setBounds(68, 382, 187, 24);
		lblForma_pagamento.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblForma_pagamento);
		
		JLabel lblTitulo = new JLabel("SISTEMA DE RESERVAS");
		lblTitulo.setBounds(109, 60, 219, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(12, 138, 199));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Logo = new JLabel("");
		Logo.setBounds(197, 68, 104, 107);
		panel_1.add(Logo);
		Logo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagens/Ha-100px.png")));
		
		JLabel ImagemFundo = new JLabel("");
		ImagemFundo.setBounds(0, 140, 500, 409);
		panel_1.add(ImagemFundo);
		ImagemFundo.setBackground(Color.WHITE);
		ImagemFundo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagens/reservas-img-3.png")));
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setBounds(429, 0, 53, 36);
		panel_1.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
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
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		panel.add(header);
		
		JPanel btnVoltar = new JPanel();
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVoltar.setBackground(new Color(12, 138, 199));
				labelVoltar.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnVoltar.setBackground(Color.white);
			     labelVoltar.setForeground(Color.black);
			}
		});
		btnVoltar.setLayout(null);
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBounds(0, 0, 53, 36);
		header.add(btnVoltar);
		
		labelVoltar = new JLabel("<");
		labelVoltar.setBounds(0, 0, 53, 36);
		btnVoltar.add(labelVoltar);
		labelVoltar.setHorizontalAlignment(SwingConstants.CENTER);
		labelVoltar.setFont(new Font("Roboto", Font.PLAIN, 23));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(68, 362, 289, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1);
		
		JPanel btnseguinte = new JPanel();
		btnseguinte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ReservasView.txtDataE.getDate() != null && ReservasView.txtDataS.getDate() != null) {		
					guardarReserva();									
				} else {
					JOptionPane.showMessageDialog(null, "Por Favor, preencher todos os campos.");
				}
			}						
		});
		btnseguinte.setLayout(null);
		btnseguinte.setBackground(SystemColor.textHighlight);
		btnseguinte.setBounds(238, 493, 122, 35);
		panel.add(btnseguinte);
		btnseguinte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblSeguinte = new JLabel("SEGUINTE");
		lblSeguinte.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeguinte.setForeground(Color.WHITE);
		lblSeguinte.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblSeguinte.setBounds(0, 0, 122, 35);
		btnseguinte.add(lblSeguinte);
	}

	private void guardarReserva() {	
		try {
			String dataE = ((JTextField)txtDataE.getDateEditor().getUiComponent()).getText();
			String dataS = ((JTextField)txtDataS.getDateEditor().getUiComponent()).getText();			
			Reserva reserva = new Reserva(java.sql.Date.valueOf(dataE), java.sql.Date.valueOf(dataS), ReservasView.txtValor.getText(), ReservasView.txtForma_pagamento.getSelectedItem().toString());
			reservasController.guardar(reserva);
			
			RegistroDeHospedes hospedes = new RegistroDeHospedes(reserva.getId());
			hospedes.setVisible(true);
			dispose();
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(contentPane, "Error: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void calcularValor(JDateChooser dataE,JDateChooser dataS) {		
		if(dataE.getDate() != null && dataS.getDate() !=null) {
			Calendar inicio = dataE.getCalendar();
			Calendar fim = dataS.getCalendar();
			int dias = -1; // Usado -1 para contar a partir do dia seguinte
			int diaria = 180;
			int valor;
			
			while(inicio.before(fim)||inicio.equals(fim)) {
				dias++;
				inicio.add(Calendar.DATE,1); 
			}
			valor = dias * diaria;
			txtValor.setText("" + valor);
		}
	}
	
	
	
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
