package logico;

import java.util.ArrayList;

public class Altice {
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Sucursal> misSucursales;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Servicio> misServicios;
	private ArrayList<Plan> misPlanes;
	public static int generadorEmpleado = 1;
	public static int generadorSucursal = 1;
	public static int generadorCliente = 1;
	
	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}
	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}
	public ArrayList<Sucursal> getMisSucursales() {
		return misSucursales;
	}
	public void setMisSucursales(ArrayList<Sucursal> misSucursales) {
		this.misSucursales = misSucursales;
	}
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}
	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}
	public ArrayList<Servicio> getMisServicios() {
		return misServicios;
	}
	public void setMisServicios(ArrayList<Servicio> misServicios) {
		this.misServicios = misServicios;
	}
	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}
	public void setMisPlanes(ArrayList<Plan> misPlanes) {
		this.misPlanes = misPlanes;
	}
	public Altice() {
		super();

		misEmpleados = new ArrayList<>();
		misSucursales = new ArrayList<>();
		misClientes = new ArrayList<>();
		misServicios = new ArrayList<>();
		misPlanes = new ArrayList<>();
	}
	
	public void registrarSucursal(Sucursal suc) {
		
		misSucursales.add(suc);
		generadorSucursal++;
	}
	
	public Sucursal buscarSucursal(String idSuc) {
		
		int i = 0;
		boolean encontrado = false;
		Sucursal aux = null;
		
		while(encontrado == false && i < misSucursales.size()) {
			
			if(misSucursales.get(i).getIdSucursal().equalsIgnoreCase(idSuc)) {
				
				aux = misSucursales.get(i);
				encontrado = true;
			}
			i++;
		}
		return aux;
	}
	
	public boolean modificarSucursal(Sucursal suc) {
		
		int i = 0;
		boolean encontrado = false;
		while(encontrado == false && i < misSucursales.size()) {
			
			if(misSucursales.get(i).getIdSucursal().equalsIgnoreCase(suc.getIdSucursal())) {
				
				misSucursales.set(i, suc);
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}
	
	public boolean eliminarSucursal(String idSuc) {
		
		int i = 0;
		boolean encontrado = false;
		while(encontrado == false && i < misSucursales.size()) {
			
			if(misSucursales.get(i).getIdSucursal().equalsIgnoreCase(idSuc)) {
				
				misSucursales.remove(i);
				encontrado = true;
			}
			i++;
		}
		
		return encontrado;
	}
	
	public void registrarEmpleado(Empleado emp) {
		
		misEmpleados.add(emp);
		generadorEmpleado++;
	}
	
	public Empleado buscarEmpleado(String idEmp) {
		
		int i = 0;
		boolean encontrado = false;
		Empleado aux = null;
		
		while(encontrado == false && i < misEmpleados.size()) {
			
			if(misEmpleados.get(i).getIdEmpleado().equalsIgnoreCase(idEmp)) {
				
				aux = misEmpleados.get(i);
				encontrado = true;
			}
			i++;
		}
		return aux;
	}
	
	public boolean modificarEmpleado(Empleado emp) {
		
		int i = 0;
		boolean encontrado = false;
		while(encontrado == false && i < misEmpleados.size()) {
			
			if(misEmpleados.get(i).getIdEmpleado().equalsIgnoreCase(emp.getIdEmpleado())) {
				
				misEmpleados.set(i, emp);
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}
	
	public boolean eliminarEmpleado(String idEmp) {
		
		int i = 0;
		boolean encontrado = false;
		while(encontrado == false && i < misEmpleados.size()) {
			
			if(misEmpleados.get(i).getIdEmpleado().equalsIgnoreCase(idEmp)) {
				
				misEmpleados.get(i).setEstado(false);
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}
	public boolean activarEmpleado(String idEmp) {
		
		int i = 0;
		boolean encontrado = false;
		while(encontrado == false && i < misEmpleados.size()) {
			
			if(misEmpleados.get(i).getIdEmpleado().equalsIgnoreCase(idEmp)) {
				
				misEmpleados.get(i).setEstado(true);
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}
	
	
	public Empleado login(String usuario, String contrasena) {
		
		int i = 0;
		boolean encontrado = false;
		Empleado aux = null;
		
		while(encontrado == false && i < misEmpleados.size()) {
			
			if(misEmpleados.get(i).getUsuario().equals(usuario) && misEmpleados.get(i).getContrasena().equals(contrasena) && misEmpleados.get(i).isEstado() == true) {
				
				aux = misEmpleados.get(i);
				encontrado = true;
			}
			i++;
		}
		return aux;
	}
	
	public void registrarCliente(Cliente cli) {
		
		misClientes.add(cli);
		generadorCliente++;
	}
	
	public Cliente buscarCliente(String cedula) {
		
		int i = 0;
		boolean encontrado = false;
		Cliente aux = null;
		
		while(encontrado == false && i < misClientes.size()) {
			
			if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula)) {
				
				aux = misClientes.get(i);
				encontrado = true;
			}
			i++;
		}
		return aux;
	}
	
	public boolean modificarCliente(Cliente cli) {
		
		int i = 0;
		boolean encontrado = false;
		while(encontrado == false && i < misClientes.size()) {
			
			if(misClientes.get(i).getCedula().equalsIgnoreCase(cli.getCedula())) {
				
				misClientes.set(i, cli);
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}
	
	public boolean eliminarCliente(String cedula) {
		
		int i = 0;
		boolean encontrado = false;
		while(encontrado == false && i < misClientes.size()) {
			
			if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula)) {
				
				misClientes.get(i).setEstado(false);
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}
	
	public boolean activarCliente(String cedula) {
		
		int i = 0;
		boolean encontrado = false;
		while(encontrado == false && i < misClientes.size()) {
			
			if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula)) {
				
				misClientes.get(i).setEstado(true);
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}
	

}
