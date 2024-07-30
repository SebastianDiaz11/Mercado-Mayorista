package parcial2;

import static org.junit.Assert.*;
import org.junit.Test;

public class InventarioTest {
    private Inventario inventario;
    private Producto productoNormal;
    private Producto productoDeLujo;


    @Test
    public void queSePuedePedirImpuestoSobreProducto() {
    	productoNormal = new Producto("1", "Galletitas", 100.0, 10, false);
        Double precioConImpuesto = productoNormal.getPrecio() * 1.21;
        assertEquals(121.0, precioConImpuesto, 0.01);
    }

    @Test
    public void queSePuedePedirImpuestoSobreProductoDeLujo() {
    	productoDeLujo = new Producto("2", "Perfume", 200.0, 5, true);
        Double precioConImpuesto = productoDeLujo.getPrecio() * 1.21 * 1.15;
        assertEquals(278.3, precioConImpuesto, 0.01); 
    }

    @Test
    public void queSePuedeCalcularElTotalPorDetalle() {
        Factura factura = new Factura();
        productoNormal = new Producto("1", "Galletitas", 100.0, 10, false);
        factura.agregarProducto(productoNormal);
        Double precioConImpuesto = productoNormal.getPrecio() * 1.21;
        assertEquals(precioConImpuesto * productoNormal.getCantidad(), factura.calcularTotal(), 0.01);
    }

    @Test
    public void queSePuedaCalcularElTotalDeFactura() {
    	productoNormal = new Producto("1", "Galletitas", 100.0, 10, false);
    	productoDeLujo = new Producto("2", "Perfume", 200.0, 5, true);
        Factura factura = new Factura();
        factura.agregarProducto(productoNormal);
        factura.agregarProducto(productoDeLujo);
        Double totalEsperado = (productoNormal.getPrecio() * 1.21 * productoNormal.getCantidad()) +
                               (productoDeLujo.getPrecio() * 1.21 * 1.15 * productoDeLujo.getCantidad());
        assertEquals(totalEsperado, factura.calcularTotal(), 0.01);
    }

    @Test
    (expected = ProductoNoEncontradoException.class)
    public void quePuedaEliminarUnProductoDelInventario() throws ProductoNoEncontradoException {
    	inventario = new Inventario();
    	productoNormal = new Producto("1", "Galletitas", 100.0, 10, false);
    	inventario.eliminarProducto(productoNormal.getId());
        inventario.obtenerProducto(productoNormal.getId());
    }

    @Test
    public void queSePuedaActualizarLaCantidadDeUnProductoEnElInventario() throws ProductoNoEncontradoException {
    	inventario = new Inventario();
    	productoNormal = new Producto("1", "Galletitas", 100.0, 10, false);
    	inventario.añadirProducto(productoNormal);
    	inventario.actualizarCantidad(productoNormal.getId(), 20);
        assertEquals(20, inventario.obtenerProducto(productoNormal.getId()).getCantidad());
    }

    @Test
    (expected = ProductoNoEncontradoException.class)
    public void queSeLanceUnaExcepcionCuandoSeIntenteAccederAUnProductoInexistenteEnElInventario() throws ProductoNoEncontradoException {
    	inventario = new Inventario();
    	inventario.obtenerProducto("99");
    }
}





