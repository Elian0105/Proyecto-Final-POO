package logico;

import java.util.ArrayList;

public class Altice {
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Sucursal> misSucursales;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Servicio> misServicios;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Contrato> misContratos;
	private ArrayList<Factura> misFacturas;
	public static int generadorEmpleado = 1;
	public static int generadorSucursal = 1;
	public static int generadorCliente = 1;
	private static int generadorContrato = 1;
	private static int generadorPlan = 1;
	private static int generadorServicioInternet = 1;
	private static int generadorServicioTelefono = 1;
	private static int generadorServicioTv = 1;
	private static int generadorFacturas = 1;
	
	
	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}
	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}
	public static int getGeneradorEmpleado() {
		return generadorEmpleado;
	}
	public static void setGeneradorEmpleado(int generadorEmpleado) {
		Altice.generadorEmpleado = generadorEmpleado;
	}
	public static int getGeneradorContrato() {
		return generadorContrato;
	}
	public static void setGeneradorContrato(int generadorContrato) {
		Altice.generadorContrato = generadorContrato;
	}
	public static int getGeneradorPlan() {
		return generadorPlan;
	}
	public static void setGeneradorPlan(int generadorPlan) {
		Altice.generadorPlan = generadorPlan;
	}
	public static int getGeneradorServicioInternet() {
		return generadorServicioInternet;
	}
	public static void setGeneradorServicioInternet(int generadorServicioInternet) {
		Altice.generadorServicioInternet = generadorServicioInternet;
	}
	public static int getGeneradorServicioTelefono() {
		return generadorServicioTelefono;
	}
	public static void setGeneradorServicioTelefono(int generadorServicioTelefono) {
		Altice.generadorServicioTelefono = generadorServicioTelefono;
	}
	public static int getGeneradorServicioTv() {
		return generadorServicioTv;
	}
	public static void setGeneradorServicioTv(int generadorServicioTv) {
		Altice.generadorServicioTv = generadorServicioTv;
	}
	public static int getGeneradorFacturas() {
		return generadorFacturas;
	}
	public static void setGeneradorFacturas(int generadorFacturas) {
		Altice.generadorFacturas = generadorFacturas;
	}
	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}
	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}
	public ArrayList<Contrato> getMisContratos() {
		return misContratos;
	}
	public void setMisContratos(ArrayList<Contrato> misContratos) {
		this.misContratos = misContratos;
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
		misContratos = new ArrayList<>();
		misFacturas = new ArrayList<>();
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
	
	public Plan buscarPlan(String codigo)
	{
		int i = 0;
		boolean encontrado = false;
		Plan plan = null;
		
		while(!encontrado && misPlanes.size() > i)
		{
			if(misPlanes.get(i).getId().equalsIgnoreCase(codigo))
			{
				encontrado = true;
				plan = misPlanes.get(i);
			}
			i++;
		}
		
		return plan;
	}
	
	public static String generarCodigo(String prefijo, int num)
	{
		return prefijo + String.format("%04d", num);
	}
	
	public boolean registrarPlan(Plan plan)
	{
		if(plan == null || plan.getServicios().isEmpty())
		{
			return false;
		}
		
		String codigo = plan.getId();
		
		if(buscarPlan(codigo) != null)
		{
			return false;
		}
		
		misPlanes.add(plan);
		generadorPlan++;
		
		return true;
	}
	
	public boolean registrarServicioInternet(String nombre, String descripcion, float precio, String tipo, int velocidadSubida, int velocidadBajada)
	{
		Internet internet = new Internet(nombre, precio, descripcion, tipo, velocidadSubida, velocidadBajada);
		
		if(!internet.esValido())
		{
			return false;
		}
		
		misServicios.add(internet);
		generadorServicioInternet++;
		
		return true;
	}
	
	public boolean registrarServicioTelefonia(String nombre, String descripcion, float precio, int minutos, boolean llamadasIlimitadas, int cantidadGB, int vigenciaDias)
	{
		Telefonia telefonia = new Telefonia(nombre, precio, descripcion, minutos, llamadasIlimitadas, cantidadGB, vigenciaDias);
		
		if(!telefonia.esValido())
		{
			return false;
		}
		
		misServicios.add(telefonia);
		generadorServicioTelefono++;
		
		return true;
	}
	
	public boolean registrarServicioTelevision(String nombre, String descripcion, float precio, int cantCanales, String tipoConexion, int canalesHD)
	{
		Television television = new Television(nombre, precio, descripcion, cantCanales, tipoConexion, canalesHD);
		
		if(!television.esValido())
		{
			return false;
		}
		
		misServicios.add(television);
		generadorServicioTv++;
		
		return true;
	}
	
	public Servicio buscarServicio(String id)
	{
		boolean encontrado = false;
		int i = 0;
		Servicio servicio = null;
		
		while(!encontrado && i < misServicios.size())
		{
			if(misServicios.get(i).getId().equalsIgnoreCase(id))
			{
				encontrado = true;
				servicio = misServicios.get(i);
			}
			i++;
		}
		return servicio;
	}
	
	public boolean eliminarServicio(String id)
	{
		Servicio servicio = buscarServicio(id);
		
		if(servicio == null)
		{
			return false;
		}
		
		servicio.setEstado(false);
		
		return true;
	}
	
	public boolean contratarPlanes(Cliente cliente, Plan plan)
	{
		if(cliente == null || !cliente.isEstado())
		{
			return false;
		}
		
		if(buscarCliente(cliente.getCedula()) == null)
		{
			return false;
		}
		
		if(plan == null || buscarPlan(plan.getId()) != plan)
		{
			return false;
		}
		
		Contrato contrato = new Contrato(cliente, plan);
		
		
		misContratos.add(contrato);
		cliente.getContratos().add(contrato);
		generadorContrato++;
		
		return true;
		
	}
	
	public Factura buscarFactura(String id)
	{
		int i = 0;
		Factura factura = null;
		boolean encontrado = false;
		
		while(!encontrado && i < misFacturas.size())
		{
			if(misFacturas.get(i).getId().equalsIgnoreCase(id))
			{
				factura = misFacturas.get(i);
				encontrado = true;
			}
			i++;
		}
		
		return factura;
	}
	
	public boolean generarFactura(Contrato contrato, String sucursal)
	{
		if(contrato == null || !contrato.isEstado())
		{
			return false;
		}
		
		if(!misContratos.contains(contrato))
		{
			return false;
		}
		
		if(contrato.getPlan() == null)
		{
			return false;
		}
		
		if(sucursal == null || sucursal.trim().isEmpty())
		{
			return false;
		}
		
		Factura factura = new Factura(contrato, sucursal);
		
		misFacturas.add(factura);
		generadorFacturas++;
		
		return true;
	}
	
	public boolean pagarFactura(String id)
	{
		Factura factura = buscarFactura(id);
		
		if(factura == null)
		{
			return false;
		}
		
		return factura.pagar();
	}

}
