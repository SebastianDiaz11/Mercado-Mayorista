package parcial2;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private List<Producto> productos;

    public Factura() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularTotal() {
        Double total = 0.0;
        for (Producto producto : productos) {
            Double precioConImpuesto = producto.getPrecio() * 1.21;
            if (producto.esDeLujo()) {
                precioConImpuesto *= 1.15;
            }
            total += precioConImpuesto * producto.getCantidad();
        }
        return total;
    }
}


