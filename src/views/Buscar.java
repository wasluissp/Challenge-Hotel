package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import jdbc.controller.HospedesController;
import jdbc.controller.ReservasController;
import jdbc.modelo.Hospedes;
import jdbc.modelo.Reserva;
import javax.swing.JTable;
import javax.swing.JTextField;
//import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
//import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
//import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
//import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
//import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;

import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Buscar extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHospedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHospedes;
	private ReservasController reservaController;
	private HospedesController hospedesController;
	private JLabel labelVoltar;
	private JLabel labelSair;
	int xMouse, yMouse;
	String reserva;
	String hospedes;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar frame = new Buscar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Buscar() {
		this.reservaController = new ReservasController();
		this.hospedesController = new HospedesController();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Buscar.class.getResource("/imagens/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		new JScrollPane(tbReservas);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblTitulo = new JLabel("SISTEMA DE BUSCAS");
		lblTitulo.setBounds(331, 62, 280, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.BOLD, 24));
		contentPane.add(lblTitulo);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBounds(20, 169, 865, 328);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		contentPane.add(panel);

		tbHospedes = new JTable();
		tbHospedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Hospedes", new ImageIcon(Buscar.class.getResource("/imagens/pessoas.png")), tbHospedes, null);
		modeloHospedes = (DefaultTableModel) tbHospedes.getModel();
		modeloHospedes.addColumn("Numero de Hospedes");
		modeloHospedes.addColumn("Nome");
		modeloHospedes.addColumn("Sobrenome");
		modeloHospedes.addColumn("Data de Nascimento");
		modeloHospedes.addColumn("Nacionalidade");
		modeloHospedes.addColumn("Telefone");
		modeloHospedes.addColumn("Numero de Reserva");
		preencherTabelaHospedes();

		tbReservas = new JTable();
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Reservas", new ImageIcon(Buscar.class.getResource("/imagens/reservado.png")), tbReservas, null);
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Data do Check In");
		modelo.addColumn("Data do Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pagamento");
		tbReservas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		preencherTabelaHospedes();

		JLabel logo = new JLabel("");
		logo.setBounds(56, 51, 104, 107);
		logo.setIcon(new ImageIcon(Buscar.class.getResource("/imagens/Ha-100px.png")));
		contentPane.add(logo);

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
		contentPane.add(header);

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
		labelVoltar.setHorizontalAlignment(SwingConstants.CENTER);
		labelVoltar.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelVoltar.setBounds(0, 0, 53, 36);
		btnVoltar.add(labelVoltar);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
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
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelSair = new JLabel("X");
		labelSair.setHorizontalAlignment(SwingConstants.CENTER);
		labelSair.setForeground(Color.BLACK);
		labelSair.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelSair.setBounds(0, 0, 53, 36);
		btnexit.add(labelSair);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(539, 159, 193, 2);
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2);

		JPanel btnbuscar = new JPanel();
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparTabela();
				if (txtBuscar.getText().equals("")) {
					preencherTabelaHospedes();
					preencherTabelaReservas();
				} else {
					preencherTabelaReservasId();
					preencherTabelaHospedesId();
				}
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaReservas = tbReservas.getSelectedRow();
				int filaHospedes = tbHospedes.getSelectedRow();

				if (filaReservas >= 0) {
					AtualizarReservas();
					limparTabela();
					preencherTabelaReservas();
					preencherTabelaHospedes();
				} else if (filaHospedes >= 0) {
					AtualizarHospedes();
					limparTabela();
					preencherTabelaHospedes();
					preencherTabelaReservas();
				}
			}
		});
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);

		JPanel btnEliminar = new JPanel();
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaReservas = tbReservas.getSelectedRow();
				int filaHospedes = tbHospedes.getSelectedRow();

				if (filaReservas >= 0) {

					reserva = tbReservas.getValueAt(filaReservas, 0).toString();
					int confirmar = JOptionPane.showConfirmDialog(null, "Deseja excluir os dados selecionados?");

					if (confirmar == JOptionPane.YES_OPTION) {

						String valor = tbReservas.getValueAt(filaReservas, 0).toString();
						reservaController.Eliminar(Integer.valueOf(valor));
						JOptionPane.showMessageDialog(contentPane, "Registro Eliminado com Sucesso!");
						limparTabela();
						preencherTabelaReservas();
						preencherTabelaHospedes();
					}
				}

				else if (filaHospedes >= 0) {

					hospedes = tbHospedes.getValueAt(filaHospedes, 0).toString();
					int confirmarh = JOptionPane.showConfirmDialog(null, "Deseja excluir os dados selecionados?");

					if (confirmarh == JOptionPane.YES_OPTION) {

						String valor = tbHospedes.getValueAt(filaHospedes, 0).toString();
						hospedesController.Eliminar(Integer.valueOf(valor));
						JOptionPane.showMessageDialog(contentPane, "Registro Eliminado com Sucesso!");
						limparTabela();
						preencherTabelaHospedes();
						preencherTabelaReservas();
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Erro. Item não selecionado, por favor realize uma busca e selecione um item para exclusão!");
				}
			}
		});
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}

	private List<Reserva> BuscarReservas() {
		return this.reservaController.buscar();
	}

	private List<Reserva> BuscarReservasId() {
		return this.reservaController.buscarId(txtBuscar.getText());
	}

	private List<Hospedes> BuscarHospedes() {
		return this.hospedesController.listarHospedes();
	}

	private List<Hospedes> BuscarHospedesId() {
		return this.hospedesController.listarHospedesId(txtBuscar.getText());
	}

	private void limparTabela() {
		((DefaultTableModel) tbHospedes.getModel()).setRowCount(0);
		((DefaultTableModel) tbReservas.getModel()).setRowCount(0);
	}

	private void preencherTabelaReservas() {

		List<Reserva> reserva = BuscarReservas();
		try {
			for (Reserva reservas : reserva) {
				modelo.addRow(new Object[] { reservas.getId(), reservas.getdataE(), reservas.getdataS(),
						reservas.getvalor(), reservas.getforma_pagamento() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void preencherTabelaReservasId() {

		List<Reserva> reserva = BuscarReservasId();
		try {
			for (Reserva reservas : reserva) {
				modelo.addRow(new Object[] { reservas.getId(), reservas.getdataE(), reservas.getdataS(),
						reservas.getvalor(), reservas.getforma_pagamento() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void preencherTabelaHospedes() {

		List<Hospedes> hospedes = BuscarHospedes();
		try {
			for (Hospedes hospedes1 : hospedes) {
				modeloHospedes.addRow(new Object[] { hospedes1.getId(), hospedes1.getNome(), hospedes1.getSobrenome(),
						hospedes1.getDataNascimento(), hospedes1.getNacionalidade(), hospedes1.getTelefone(),
						hospedes1.getIdReserva() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void preencherTabelaHospedesId() {

		List<Hospedes> hospedes = BuscarHospedesId();
		try {
			for (Hospedes hospedes1 : hospedes) {
				modeloHospedes.addRow(new Object[] { hospedes1.getId(), hospedes1.getNome(), hospedes1.getSobrenome(),
						hospedes1.getDataNascimento(), hospedes1.getNacionalidade(), hospedes1.getTelefone(),
						hospedes1.getIdReserva() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void AtualizarReservas() {
		Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
				.ifPresentOrElse(fila -> {

					Date dataE = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString());
					Date dataS = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString());
					String valor = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 3);
					String forma_pagamento = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 4);
					Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
					this.reservaController.actualizar(dataE, dataS, valor, forma_pagamento, id);
					JOptionPane.showMessageDialog(this, String.format("Registro modificado com exito"));
				}, () -> JOptionPane.showMessageDialog(this, "Por favor, escolha um registro"));

	}

	private void AtualizarHospedes() {
		Optional.ofNullable(modeloHospedes.getValueAt(tbHospedes.getSelectedRow(), tbHospedes.getSelectedColumn()))
				.ifPresentOrElse(filaHospedes -> {

					String nome = (String) modeloHospedes.getValueAt(tbHospedes.getSelectedRow(), 1);
					String sobrenome = (String) modeloHospedes.getValueAt(tbHospedes.getSelectedRow(), 2);
					Date dataN = Date.valueOf(modeloHospedes.getValueAt(tbHospedes.getSelectedRow(), 3).toString());
					String nacionalidade = (String) modeloHospedes.getValueAt(tbHospedes.getSelectedRow(), 4);
					String telefone = (String) modeloHospedes.getValueAt(tbHospedes.getSelectedRow(), 5);
					Integer idReserva = Integer
							.valueOf(modeloHospedes.getValueAt(tbHospedes.getSelectedRow(), 6).toString());
					// Integer id =
					// Integer.valueOf(modeloHospedes.getValueAt(tbHospedes.getSelectedRow(),
					// 0).toString());
					this.hospedesController.atualizar(nome, sobrenome, dataN, nacionalidade, telefone, idReserva);
					JOptionPane.showMessageDialog(this, String.format("Registro modificado con éxito"));
				}, () -> JOptionPane.showMessageDialog(this, "Por favor, escolha um registro"));

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
