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
import logico.Comercial;
import logico.Empleado;

public class PrincipalComercial extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenu;
	private JPanel panelContenido;
	private JButton btnInicio;
	private JButton btnClientes;
	private JButton btnContratarPlan;
	private JButton btnMisContratos;
	private JButton btnCerrarSesion;
	private CardLayout cartas;
	private JLabel lblCantContratos;
	private JLabel lblComision;
	private JLabel lblSalario;
	private PanelClientes panelClientes;
	private PanelContratarPlan panelContratarPlan;
	private PanelMisContratos panelMisContratos;

	public PrincipalComercial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Altice - Comercial");
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
		lblLogo.setIcon(new ImageIcon(PrincipalComercial.class.getResource("/visual/logo.png")));
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

		btnClientes = crearBotonMenu("Clientes", 210);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContenido.remove(panelClientes);
				panelClientes = new PanelClientes();
				panelContenido.add(panelClientes, "Clientes");
				seleccionarMenu(btnClientes, "Clientes");
			}
		});
		panelMenu.add(btnClientes);

		btnContratarPlan = crearBotonMenu("Contratar plan", 270);
		btnContratarPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContenido.remove(panelContratarPlan);
				panelContratarPlan = new PanelContratarPlan();
				panelContenido.add(panelContratarPlan, "ContratarPlan");
				seleccionarMenu(btnContratarPlan, "ContratarPlan");
			}
		});
		panelMenu.add(btnContratarPlan);

		btnMisContratos = crearBotonMenu("Mis contratos", 330);
		btnMisContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContenido.remove(panelMisContratos);
				panelMisContratos = new PanelMisContratos();
				panelContenido.add(panelMisContratos, "MisContratos");
				seleccionarMenu(btnMisContratos, "MisContratos");
			}
		});
		panelMenu.add(btnMisContratos);

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

		lblCantContratos = new JLabel("0");
		panelInicio.add(crearTarjeta("Contratos vendidos", lblCantContratos, 40, 140));

		lblComision = new JLabel("RD$0.0");
		panelInicio.add(crearTarjeta("Comisi\u00F3n por contrato", lblComision, 300, 140));

		lblSalario = new JLabel("RD$0.0");
		panelInicio.add(crearTarjeta("Salario actual", lblSalario, 560, 140));

		JLabel lblExplicacion = new JLabel("Tu salario = sueldo base + contratos vendidos \u00D7 comisi\u00F3n.");
		lblExplicacion.setForeground(Color.GRAY);
		lblExplicacion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblExplicacion.setBounds(40, 275, 800, 25);
		panelInicio.add(lblExplicacion);

		panelClientes = new PanelClientes();
		panelContenido.add(panelClientes, "Clientes");

		panelContratarPlan = new PanelContratarPlan();
		panelContenido.add(panelContratarPlan, "ContratarPlan");

		panelMisContratos = new PanelMisContratos();
		panelContenido.add(panelMisContratos, "MisContratos");

		actualizarInicio();
		seleccionarMenu(btnInicio, "Inicio");
	}

	private void actualizarInicio() {
		Empleado emp = Altice.getLoginUser();
		if(emp instanceof Comercial) {
			Comercial comercial = (Comercial) emp;
			lblCantContratos.setText("" + comercial.getCantContratos());
			lblComision.setText("RD$" + comercial.getComisionPorContrato());
			lblSalario.setText("RD$" + comercial.calcularSalario());
		}
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
		pintarNormal(btnClientes);
		pintarNormal(btnContratarPlan);
		pintarNormal(btnMisContratos);
		elegido.setBorderPainted(true);
		elegido.setBackground(new Color(42, 42, 42));
		elegido.setBorder(new CompoundBorder(new MatteBorder(0, 4, 0, 0, Color.WHITE), new EmptyBorder(0, 31, 0, 0)));
		cartas.show(panelContenido, hoja);
		panelContenido.revalidate();
		panelContenido.repaint();
	}

	private void pintarNormal(JButton boton) {
		boton.setOpaque(true);
		boton.setBorderPainted(false);
		boton.setFocusPainted(false);
		boton.setBackground(Color.BLACK);
		boton.setBorder(new EmptyBorder(0, 35, 0, 0));
	}
}