package visual;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import logico.Altice;
import logico.Empleado;

public class PrincipalEmpleado extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenu;
	private JPanel panelContenido;
	private JButton btnInicio;
	private JButton btnConsultarCliente;
	private JButton btnPagarFactura;
	private JButton btnCerrarSesion;
	private CardLayout cartas;
	private JLabel lblClientesActivos;
	private JLabel lblFacturasPendientes;
	private JLabel lblPeriodo;

	public PrincipalEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Altice - Empleado");
		setBounds(100, 100, 1256, 689);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Login.guardarDatos();
			}
			@Override
			public void windowOpened(WindowEvent e) {
				ajustarVentana();
			}
		});
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ajustarVentana();
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		panelMenu = new JPanel();
		panelMenu.setBackground(Color.BLACK);
		panelMenu.setBounds(0, 0, 240, 650);
		panelMenu.setLayout(null);
		contentPane.add(panelMenu);

		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(PrincipalEmpleado.class.getResource("/visual/logo.png")));
		lblLogo.setBounds(0, 20, 240, 106);
		panelMenu.add(lblLogo);

		btnInicio = crearBotonMenu("Inicio", 150);
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarInicio();
				seleccionarMenu(btnInicio, "Inicio");
			}
		});
		panelMenu.add(btnInicio);

		btnConsultarCliente = crearBotonMenu("Consultar cliente", 210);
		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarMenu(btnConsultarCliente, "ConsultarCliente");
			}
		});
		panelMenu.add(btnConsultarCliente);

		btnPagarFactura = crearBotonMenu("Pagar factura", 270);
		btnPagarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarMenu(btnPagarFactura, "PagarFactura");
			}
		});
		panelMenu.add(btnPagarFactura);

		btnCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCerrarSesion.setBackground(new Color(60, 60, 60));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnCerrarSesion.setBackground(Color.BLACK);
			}
		});
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.guardarDatos();
				Altice.setLoginUser(null);
				new Login().setVisible(true);
				dispose();
			}
		});
		btnCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		btnCerrarSesion.setForeground(Color.LIGHT_GRAY);
		btnCerrarSesion.setFont(new Font("Arial", Font.BOLD, 17));
		btnCerrarSesion.setContentAreaFilled(false);
		btnCerrarSesion.setOpaque(true);
		btnCerrarSesion.setBorderPainted(false);
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setBorder(new EmptyBorder(0, 35, 0, 0));
		btnCerrarSesion.setBackground(Color.BLACK);
		btnCerrarSesion.setBounds(0, 600, 240, 50);
		panelMenu.add(btnCerrarSesion);

		cartas = new CardLayout();
		panelContenido = new JPanel();
		panelContenido.setBounds(240, 0, 1000, 650);
		panelContenido.setLayout(cartas);
		contentPane.add(panelContenido);

		JPanel panelInicio = new JPanel();
		panelInicio.setBackground(Color.WHITE);
		panelInicio.setLayout(null);
		panelContenido.add(panelInicio, "Inicio");

		JLabel lblBienvenida = new JLabel("Bienvenido");
		lblBienvenida.setFont(new Font("Arial", Font.BOLD, 28));
		lblBienvenida.setBounds(40, 40, 900, 40);
		panelInicio.add(lblBienvenida);

		JLabel lblDatos = new JLabel("");
		lblDatos.setForeground(Color.GRAY);
		lblDatos.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDatos.setBounds(40, 85, 900, 25);
		panelInicio.add(lblDatos);

		Empleado emp = Altice.getLoginUser();
		if(emp != null) {
			lblBienvenida.setText("Bienvenido, " + emp.getNombre());
			lblDatos.setText(emp.getPuesto() + "  \u00B7  " + emp.getSucursal());
		}

		lblClientesActivos = new JLabel("0");
		panelInicio.add(crearTarjeta("Clientes activos", lblClientesActivos, 40, 140));

		lblFacturasPendientes = new JLabel("0");
		panelInicio.add(crearTarjeta("Facturas pendientes", lblFacturasPendientes, 300, 140));

		lblPeriodo = new JLabel("-");
		panelInicio.add(crearTarjeta("Per\u00EDodo actual", lblPeriodo, 560, 140));

		JLabel lblExplicacion = new JLabel("Desde aqu\u00ED puedes consultar los datos de un cliente y registrar el pago de sus facturas.");
		lblExplicacion.setForeground(Color.GRAY);
		lblExplicacion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblExplicacion.setBounds(40, 275, 900, 25);
		panelInicio.add(lblExplicacion);

		panelContenido.add(new PanelConsultarCliente(), "ConsultarCliente");
		panelContenido.add(new PanelPagarFactura(), "PagarFactura");

		actualizarInicio();
		seleccionarMenu(btnInicio, "Inicio");
	}

	private void actualizarInicio() {
		int activos = 0;
		for(int i = 0; i < Altice.getInstance().getMisClientes().size(); i++) {
			if(Altice.getInstance().getMisClientes().get(i).isEstado()) {
				activos++;
			}
		}
		int pendientes = 0;
		for(int i = 0; i < Altice.getInstance().getMisFacturas().size(); i++) {
			if(!Altice.getInstance().getMisFacturas().get(i).isPagado()) {
				pendientes++;
			}
		}
		String periodo = "-";
		int cant = Altice.getInstance().getMisFacturas().size();
		if(cant > 0) {
			periodo = Altice.getInstance().getMisFacturas().get(cant - 1).getPeriodo();
		}
		lblClientesActivos.setText("" + activos);
		lblFacturasPendientes.setText("" + pendientes);
		lblPeriodo.setText(periodo);
	}

	private void ajustarVentana() {
		int w = contentPane.getWidth();
		int h = contentPane.getHeight();
		int menuW = 240;

		panelMenu.setBounds(0, 0, menuW, h);
		panelContenido.setBounds(menuW, 0, w - menuW, h);
		btnCerrarSesion.setBounds(0, h - 50, menuW, 50);
		contentPane.revalidate();
		contentPane.repaint();
	}

	private JButton crearBotonMenu(String texto, int y) {
		JButton boton = new JButton(texto);
		boton.setHorizontalAlignment(SwingConstants.LEFT);
		boton.setFont(new Font("Arial", Font.BOLD, 17));
		boton.setForeground(Color.WHITE);
		boton.setBackground(Color.BLACK);
		boton.setBounds(0, y, 240, 48);
		boton.setContentAreaFilled(false);
		boton.setOpaque(true);
		boton.setBorderPainted(false);
		boton.setFocusPainted(false);
		boton.setBorder(new EmptyBorder(0, 35, 0, 0));
		return boton;
	}

	private JPanel crearTarjeta(String titulo, JLabel lblValor, int x, int y) {
		JPanel tarjeta = new JPanel();
		tarjeta.setBackground(Color.WHITE);
		tarjeta.setBorder(new LineBorder(new Color(204, 204, 204)));
		tarjeta.setBounds(x, y, 240, 110);
		tarjeta.setLayout(null);

		JLabel lblTitulo = new JLabel(titulo);
		lblTitulo.setForeground(Color.GRAY);
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTitulo.setBounds(20, 15, 210, 20);
		tarjeta.add(lblTitulo);

		lblValor.setFont(new Font("Arial", Font.BOLD, 30));
		lblValor.setBounds(20, 42, 210, 50);
		tarjeta.add(lblValor);

		return tarjeta;
	}

	private void seleccionarMenu(JButton elegido, String hoja) {
		pintarNormal(btnInicio);
		pintarNormal(btnConsultarCliente);
		pintarNormal(btnPagarFactura);
		elegido.setBorderPainted(true);
		elegido.setBackground(new Color(42, 42, 42));
		elegido.setBorder(new CompoundBorder(new MatteBorder(0, 4, 0, 0, Color.WHITE), new EmptyBorder(0, 31, 0, 0)));
		cartas.show(panelContenido, hoja);
	}

	private void pintarNormal(JButton boton) {
		boton.setOpaque(true);
		boton.setBorderPainted(false);
		boton.setFocusPainted(false);
		boton.setBackground(Color.BLACK);
		boton.setBorder(new EmptyBorder(0, 35, 0, 0));
	}
}