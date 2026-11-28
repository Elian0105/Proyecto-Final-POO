package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import logico.Altice;
import logico.Administrativo;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logico.Empleado;
import logico.Comercial;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;

	public static void main(String[] args) {
		try {
			FileInputStream archivo = new FileInputStream("altice.dat");
			ObjectInputStream entrada = new ObjectInputStream(archivo);
			Altice.setAltice((Altice) entrada.readObject());
			Altice.setGeneradorEmpleado(entrada.readInt());
			Altice.generadorCliente = entrada.readInt();
			Altice.setGeneradorContrato(entrada.readInt());
			Altice.setGeneradorPlan(entrada.readInt());
			Altice.setGeneradorServicioInternet(entrada.readInt());
			Altice.setGeneradorServicioTelefono(entrada.readInt());
			Altice.setGeneradorServicioTv(entrada.readInt());
			Altice.setGeneradorFacturas(entrada.readInt());
			entrada.close();
		} catch (FileNotFoundException e) {
			Administrativo admin = new Administrativo("000-0000000-0", "Administrador", "809-000-0000", "admin@altice.com", "Santiago", new Date(), Altice.generarCodigo("E-", Altice.getGeneradorEmpleado()), "Admin", "Admin", 50000, "Administrador", "Santiago Centro", new Date(), "Administracion", 0);
			Altice.getInstance().registrarEmpleado(admin);
			guardarDatos();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});                         
	}

	public Login() {
		setResizable(false);
		setTitle("Altice - Iniciar sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/visual/logo.png")));
		lblNewLabel.setBounds(0, 20, 420, 106);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Sistema de Gesti\u00F3n");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(0, 135, 420, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(50, 175, 320, 20);
		contentPane.add(lblNewLabel_2);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(50, 197, 320, 30);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(50, 240, 320, 20);
		contentPane.add(lblNewLabel_3);

		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(50, 262, 320, 30);
		contentPane.add(txtContrasena);
		txtContrasena.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				String contrasena = new String(txtContrasena.getPassword());
				Empleado emp = Altice.getInstance().login(usuario, contrasena);
				if(emp == null) {
					JOptionPane.showMessageDialog(null, "Usuario o contrase\u00F1a incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(emp instanceof Administrativo) {
						new PrincipalAdmin().setVisible(true);
					}
					else if(emp instanceof Comercial) {
						new PrincipalComercial().setVisible(true);
					}
					else {
						new PrincipalEmpleado().setVisible(true);
					}
					dispose();
				}
			}
		});
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 14));
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setBounds(50, 315, 320, 36);
		btnEntrar.setBackground(Color.WHITE);
		contentPane.add(btnEntrar);
	}
	public static void guardarDatos() {
		try {
			FileOutputStream archivo = new FileOutputStream("altice.dat");
			ObjectOutputStream salida = new ObjectOutputStream(archivo);
			salida.writeObject(Altice.getInstance());
			salida.writeInt(Altice.getGeneradorEmpleado());
			salida.writeInt(Altice.generadorCliente);
			salida.writeInt(Altice.getGeneradorContrato());
			salida.writeInt(Altice.getGeneradorPlan());
			salida.writeInt(Altice.getGeneradorServicioInternet());
			salida.writeInt(Altice.getGeneradorServicioTelefono());
			salida.writeInt(Altice.getGeneradorServicioTv());
			salida.writeInt(Altice.getGeneradorFacturas());
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}