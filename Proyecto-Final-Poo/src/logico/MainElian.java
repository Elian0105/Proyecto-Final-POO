package logico;

public class MainElian {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sucursal suc = new Sucursal("S-001", "Altice Santiago Centro", "Santiago", "Calle del Sol #25");

		Cliente cli = new Cliente("402-1234567-8", "C-001", "Juan Perez", "809-555-1234", "Licey al Medio");
		System.out.println("Cliente: " + cli.getNombre() + "  Cedula: " + cli.getCedula());

		Trabajador tra = new Trabajador("E-001", "031-1111111-1", "Pedro Lopez", "809-111-1111", "pedro", "1234", 30000, suc, "Instalaciones", 10);
		Administrativo adm = new Administrativo("E-002", "031-2222222-2", "Maria Diaz", "809-222-2222", "maria", "1234", 40000, suc, "Contabilidad", 5000);
		Comercial com = new Comercial("E-003", "031-3333333-3", "Luis Gomez", "809-333-3333", "luis", "1234", 25000, suc, 1500);

		System.out.println("Salario trabajador: " + tra.calcularSalario());
		System.out.println("Salario administrativo: " + adm.calcularSalario());
		System.out.println("Salario comercial sin ventas: " + com.calcularSalario());

		com.agregarContrato();
		com.agregarContrato();
		System.out.println("Contratos del comercial: " + com.getCantContratos());
		System.out.println("Salario comercial con 2 ventas: " + com.calcularSalario());

		System.out.println(tra.getNombreEmp() + " trabaja en: " + tra.getSucursal().getNombreSuc());
	}

}
