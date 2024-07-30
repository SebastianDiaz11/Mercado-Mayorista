package parcial2;

public class ReportadorBasico implements Reportador {
   
    public String reportar(Factura factura) {
        StringBuilder reporte = new StringBuilder();
        for (Producto producto : factura.getProductos()) {
            reporte.append(String.format("Producto: %s, Precio Unitario: %.2f, Cantidad: %d, Total: %.2f\n",
                    producto.getNombre(), producto.getPrecio(), producto.getCantidad(),
                    producto.getPrecio() * producto.getCantidad()));
        }
        reporte.append(String.format("Total Factura: %.2f\n", factura.calcularTotal()));
        return reporte.toString();
    }
}

