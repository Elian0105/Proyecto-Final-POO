package logico;

import java.util.Date;

public class MainElian {
	public static void main(String[] args) {
		
		Altice altice = Altice.getInstance();

		Cliente cli = new Cliente("402-1234567-8", "Juan Perez", "809-555-1234", "juan@gmail.com", "Licey al Medio", new Date(), "C-001");
		System.out.println("Cliente: " + cli.getNombre() + "  Cedula: " + cli.getCedula());

		Empleado emp = new Empleado("031-1111111-1", "Pedro Lopez", "809-111-1111", "pedro@gmail.com", "Santiago", new Date(), "E-001", "pedro", "1234", 30000, "Tecnico", "Santiago Centro", new Date());
		Administrativo adm = new Administrativo("031-2222222-2", "Maria Diaz", "809-222-2222", "maria@gmail.com", "Santiago", new Date(), "E-002", "maria", "1234", 40000, "Gerente", "Santiago Centro", new Date(), "Contabilidad", 5000);
		Comercial com = new Comercial("031-3333333-3", "Luis Gomez", "809-333-3333", "luis@gmail.com", "Santiago", new Date(), "E-003", "luis", "1234", 25000, "Vendedor", "Santiago Centro", new Date(), 1500);

		System.out.println("Salario empleado: " + emp.calcularSalario());
		System.out.println("Salario administrativo: " + adm.calcularSalario());
		System.out.println("Salario comercial sin ventas: " + com.calcularSalario());

		com.agregarContrato();
		com.agregarContrato();
		System.out.println("Contratos del comercial: " + com.getCantContratos());
		System.out.println("Salario comercial con 2 ventas: " + com.calcularSalario());

		System.out.println(emp.getNombre() + " es " + emp.getPuesto() + " en: " + emp.getSucursal());

		altice.registrarEmpleado(emp);
		altice.registrarEmpleado(adm);
		altice.registrarEmpleado(com);
		altice.registrarCliente(cli);

		System.out.println("Generador empleado: " + Altice.generadorEmpleado);
		System.out.println("Generador cliente: " + Altice.generadorCliente);

		System.out.println("Misma Altice: " + (altice == Altice.getInstance()));

		System.out.println("Buscar E-002: " + altice.buscarEmpleado("E-002").getNombre());
		System.out.println("Buscar E-009: " + altice.buscarEmpleado("E-009"));

		Empleado logueado = altice.login("luis", "1234");
		System.out.println("Login correcto: " + logueado.getNombre());
		System.out.println("Usuario en sesion: " + Altice.getLoginUser().getNombre());
		System.out.println("Login incorrecto: " + altice.login("luis", "9999"));

		if(logueado instanceof Comercial) {
			System.out.println("Entro un comercial");
		}

		System.out.println("Desactivar cliente: " + altice.eliminarCliente("402-1234567-8"));
		System.out.println("Estado cliente: " + altice.buscarCliente("402-1234567-8").isEstado());
		System.out.println("Activar cliente: " + altice.activarCliente("402-1234567-8"));
		System.out.println("Estado cliente: " + altice.buscarCliente("402-1234567-8").isEstado());

		altice.eliminarEmpleado("E-003");
		System.out.println("Login desactivado: " + altice.login("luis", "1234"));
		System.out.println("Fecha salida: " + altice.buscarEmpleado("E-003").getFechaSalida());
		altice.activarEmpleado("E-003");
		System.out.println("Login activado: " + altice.login("luis", "1234").getNombre());
		System.out.println("Fecha salida: " + altice.buscarEmpleado("E-003").getFechaSalida());
	}

}