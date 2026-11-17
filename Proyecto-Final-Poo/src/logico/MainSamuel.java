package logico;

public class MainSamuel {

	public static void main(String[] args) {

        Altice altice = new Altice();

        boolean servicioRegistrado = altice.registrarServicioInternet( "Internet 100 MB", "Internet residencial", 1500f, "Fibra optica", 50, 100);

        System.out.println("Servicio registrado: " + servicioRegistrado);

        Servicio servicio = altice.getMisServicios().get(0);

        Plan plan = new Plan("Plan Hogar", "Plan residencial de Internet", 10f, 12);

        plan.agregarServicio(servicio);

        boolean planRegistrado = altice.registrarPlan(plan);

        System.out.println("Plan registrado: " + planRegistrado);
        System.out.println("Precio del plan: RD$" + plan.calcularPrecio());

        Cliente cliente = new Cliente("00112345678", "CLI-0001", "Juan Perez", "8095551234", "Santiago");

        altice.registrarCliente(cliente);
        boolean contratado = altice.contratarPlanes(cliente, plan);

        System.out.println("Contrato registrado: " + contratado);

        Contrato contrato = cliente.getContratos().get(0);

        System.out.println("ID contrato: " + contrato.getId());
        System.out.println("Precio mensual: RD$" + contrato.getPrecioMensual());

        boolean generada = altice.generarFactura(contrato, "Sucursal Santiago");

        System.out.println("Factura generada: " + generada);

        Factura factura = altice.getMisFacturas().get(0);

        System.out.println("\n===== FACTURA =====");
        System.out.println("ID: " + factura.getId());
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Sucursal: " + factura.getSucursal());
        System.out.println("Subtotal: RD$" + factura.getSubtotal());
        System.out.println("ITBIS: RD$" + factura.getItbis());
        System.out.println("Total: RD$" + factura.getTotal());
        System.out.println("Pagada: " + factura.isPagado());

        boolean pago = altice.pagarFactura(factura.getId());

        System.out.println("\n===== PAGO =====");
        System.out.println("Pago realizado: " + pago);
        System.out.println("Pagada: " + factura.isPagado());

        boolean segundoPago = altice.pagarFactura(factura.getId());

        System.out.println("Segundo pago permitido: " + segundoPago);
    }

}
