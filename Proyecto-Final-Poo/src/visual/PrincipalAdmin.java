package visual;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import logico.Altice;
import logico.Empleado;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrincipalAdmin extends JFrame {

	private JPanel contentPane;
	private JPanel panelContenido;
	private JButton btnInicio;
	private JButton btnEmpleados;
	private JButton btnClientes;
	private JButton btnPlanes;
	private JButton btnFacturas;
	private JButton btnReportes;
	private CardLayout cartas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalAdmin frame = new PrincipalAdmin();
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
	public PrincipalAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1216, 689);
		setTitle("Altice - Administraci\u00F3n");
		setResizable(false);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Login.guardarDatos();
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.BLACK);
		panelMenu.setBounds(0, 0, 200, 650);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(PrincipalAdmin.class.getResource("/visual/logo.png")));
		lblNewLabel.setBounds(0, 20, 200, 106);
		panelMenu.add(lblNewLabel);

		btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarMenu(btnInicio, "Inicio");
			}
		});
		btnInicio.setHorizontalAlignment(SwingConstants.LEFT);
		btnInicio.setBorderPainted(false);
		btnInicio.setFont(new Font("Arial", Font.BOLD, 16));
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setBackground(Color.BLACK);
		btnInicio.setBounds(0, 150, 200, 45);
		btnInicio.setOpaque(true);
		btnInicio.setBorderPainted(false);
		btnInicio.setHorizontalAlignment(SwingConstants.LEFT);
		btnInicio.setBorder(new EmptyBorder(0, 35, 0, 0));
		btnInicio.setContentAreaFilled(false);
		panelMenu.add(btnInicio);

		btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarMenu(btnClientes, "Clientes");
			}
		});
		btnClientes.setOpaque(true);
		btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientes.setForeground(Color.WHITE);
		btnClientes.setFont(new Font("Arial", Font.BOLD, 16));
		btnClientes.setContentAreaFilled(false);
		btnClientes.setBorderPainted(false);
		btnClientes.setBorder(new EmptyBorder(0, 35, 0, 0));
		btnClientes.setBackground(Color.BLACK);
		btnClientes.setBounds(0, 240, 200, 45);
		panelMenu.add(btnClientes);

		btnEmpleados = new JButton("Empleados");
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarMenu(btnEmpleados, "Empleados");
			}
		});
		btnEmpleados.setOpaque(true);
		btnEmpleados.setHorizontalAlignment(SwingConstants.LEFT);
		btnEmpleados.setForeground(Color.WHITE);
		btnEmpleados.setFont(new Font("Arial", Font.BOLD, 16));
		btnEmpleados.setContentAreaFilled(false);
		btnEmpleados.setBorderPainted(false);
		btnEmpleados.setBorder(new EmptyBorder(0, 35, 0, 0));
		btnEmpleados.setBackground(Color.BLACK);
		btnEmpleados.setBounds(0, 195, 200, 45);
		panelMenu.add(btnEmpleados);

		btnPlanes = new JButton("Planes");
		btnPlanes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarMenu(btnPlanes, "Planes");
			}
		});
		btnPlanes.setOpaque(true);
		btnPlanes.setHorizontalAlignment(SwingConstants.LEFT);
		btnPlanes.setForeground(Color.WHITE);
		btnPlanes.setFont(new Font("Arial", Font.BOLD, 16));
		btnPlanes.setContentAreaFilled(false);
		btnPlanes.setBorderPainted(false);
		btnPlanes.setBorder(new EmptyBorder(0, 35, 0, 0));
		btnPlanes.setBackground(Color.BLACK);
		btnPlanes.setBounds(0, 285, 200, 45);
		panelMenu.add(btnPlanes);

		btnFacturas = new JButton("Facturas");
		btnFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarMenu(btnFacturas, "Facturas");
			}
		});
		btnFacturas.setOpaque(true);
		btnFacturas.setHorizontalAlignment(SwingConstants.LEFT);
		btnFacturas.setForeground(Color.WHITE);
		btnFacturas.setFont(new Font("Arial", Font.BOLD, 16));
		btnFacturas.setContentAreaFilled(false);
		btnFacturas.setBorderPainted(false);
		btnFacturas.setBorder(new EmptyBorder(0, 35, 0, 0));
		btnFacturas.setBackground(Color.BLACK);
		btnFacturas.setBounds(0, 330, 200, 45);
		panelMenu.add(btnFacturas);

		btnReportes = new JButton("Reportes");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarMenu(btnReportes, "Reportes");
			}
		});
		btnReportes.setOpaque(true);
		btnReportes.setHorizontalAlignment(SwingConstants.LEFT);
		btnReportes.setForeground(Color.WHITE);
		btnReportes.setFont(new Font("Arial", Font.BOLD, 16));
		btnReportes.setContentAreaFilled(false);
		btnReportes.setBorderPainted(false);
		btnReportes.setBorder(new EmptyBorder(0, 35, 0, 0));
		btnReportes.setBackground(Color.BLACK);
		btnReportes.setBounds(0, 375, 200, 45);
		panelMenu.add(btnReportes);

		JButton btnCerrarSesion = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCerrarSesion.setBackground(new Color(60, 60, 60));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnCerrarSesion.setBackground(new Color(60, 60, 60));
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
		btnCerrarSesion.setOpaque(true);
		btnCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		btnCerrarSesion.setForeground(Color.LIGHT_GRAY);
		btnCerrarSesion.setFont(new Font("Arial", Font.BOLD, 16));
		btnCerrarSesion.setContentAreaFilled(false);
		btnCerrarSesion.setOpaque(true);
		btnCerrarSesion.setBorderPainted(false);
		btnCerrarSesion.setBorder(new EmptyBorder(0, 35, 0, 0));
		btnCerrarSesion.setBackground(Color.BLACK);
		btnCerrarSesion.setBounds(0, 600, 200, 50);
		btnCerrarSesion.setFocusPainted(false);
		panelMenu.add(btnCerrarSesion);

		cartas = new CardLayout();
		panelContenido = new JPanel();
		panelContenido.setBounds(200, 0, 1000, 650);
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

		JPanel tarjetaClientes = new JPanel();
		tarjetaClientes.setBackground(Color.WHITE);
		tarjetaClientes.setBorder(new LineBorder(new Color(204, 204, 204)));
		tarjetaClientes.setBounds(40, 140, 200, 110);
		tarjetaClientes.setLayout(null);
		panelInicio.add(tarjetaClientes);

		JLabel lblTituloClientes = new JLabel("Clientes");
		lblTituloClientes.setForeground(Color.GRAY);
		lblTituloClientes.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTituloClientes.setBounds(20, 15, 160, 20);
		tarjetaClientes.add(lblTituloClientes);

		JLabel lblCantClientes = new JLabel("0");
		lblCantClientes.setFont(new Font("Arial", Font.BOLD, 36));
		lblCantClientes.setBounds(20, 40, 160, 50);
		tarjetaClientes.add(lblCantClientes);

		JPanel tarjetaContratos = new JPanel();
		tarjetaContratos.setBackground(Color.WHITE);
		tarjetaContratos.setBorder(new LineBorder(new Color(204, 204, 204)));
		tarjetaContratos.setBounds(260, 140, 200, 110);
		tarjetaContratos.setLayout(null);
		panelInicio.add(tarjetaContratos);

		JLabel lblTituloContratos = new JLabel("Contratos");
		lblTituloContratos.setForeground(Color.GRAY);
		lblTituloContratos.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTituloContratos.setBounds(20, 15, 160, 20);
		tarjetaContratos.add(lblTituloContratos);

		JLabel lblCantContratos = new JLabel("0");
		lblCantContratos.setFont(new Font("Arial", Font.BOLD, 36));
		lblCantContratos.setBounds(20, 40, 160, 50);
		tarjetaContratos.add(lblCantContratos);

		JPanel tarjetaPendientes = new JPanel();
		tarjetaPendientes.setBackground(Color.WHITE);
		tarjetaPendientes.setBorder(new LineBorder(new Color(204, 204, 204)));
		tarjetaPendientes.setBounds(480, 140, 200, 110);
		tarjetaPendientes.setLayout(null);
		panelInicio.add(tarjetaPendientes);

		JLabel lblTituloPendientes = new JLabel("Facturas pendientes");
		lblTituloPendientes.setForeground(Color.GRAY);
		lblTituloPendientes.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTituloPendientes.setBounds(20, 15, 170, 20);
		tarjetaPendientes.add(lblTituloPendientes);

		JLabel lblCantPendientes = new JLabel("0");
		lblCantPendientes.setFont(new Font("Arial", Font.BOLD, 36));
		lblCantPendientes.setBounds(20, 40, 160, 50);
		tarjetaPendientes.add(lblCantPendientes);

		Empleado emp = Altice.getLoginUser();
		if(emp != null) {
			lblBienvenida.setText("Bienvenido, " + emp.getNombre());
			lblDatos.setText(emp.getPuesto() + "  \u00B7  " + emp.getSucursal());
		}

		int pendientes = 0;
		for(int i = 0; i < Altice.getInstance().getMisFacturas().size(); i++) {
			if(!Altice.getInstance().getMisFacturas().get(i).isPagado()) {
				pendientes++;
			}
		}
		lblCantClientes.setText("" + Altice.getInstance().getMisClientes().size());
		lblCantContratos.setText("" + Altice.getInstance().getMisContratos().size());
		lblCantPendientes.setText("" + pendientes);

		JPanel panelEmpleados = new JPanel();
		panelEmpleados.setBackground(Color.WHITE);
		panelContenido.add(panelEmpleados, "Empleados");

		JPanel panelClientes = new JPanel();
		panelClientes.setBackground(Color.WHITE);
		panelContenido.add(panelClientes, "Clientes");

		panelContenido.add(new PanelPlanesServicios(), "Planes");
		panelContenido.add(new PanelFacturas(), "Facturas");

		JPanel panelReportes = new JPanel();
		panelReportes.setBackground(Color.WHITE);
		panelContenido.add(panelReportes, "Reportes");

		seleccionarMenu(btnInicio, "Inicio");
	}
	private void seleccionarMenu(JButton elegido, String hoja) {
		pintarNormal(btnInicio);
		pintarNormal(btnEmpleados);
		pintarNormal(btnClientes);
		pintarNormal(btnPlanes);
		pintarNormal(btnFacturas);
		pintarNormal(btnReportes);
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
