package parcial2;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<String, Producto> productos;

    public Inventario() {
        this.productos = new HashMap<>();
    }

    public void añadirProducto(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    public void eliminarProducto(String id) throws ProductoNoEncontradoException {
        if (!productos.containsKey(id)) {
            throw new ProductoNoEncontradoException("Producto no encontrado: " + id);
        }
        productos.remove(id);
    }

    public Producto obtenerProducto(String id) throws ProductoNoEncontradoException {
        if (!productos.containsKey(id)) {
            throw new ProductoNoEncontradoException("Producto no encontrado: " + id);
        }
        return productos.get(id);
    }

    public void actualizarCantidad(String id, Integer cantidad) throws ProductoNoEncontradoException {
        Producto producto = obtenerProducto(id);
        producto.setCantidad(cantidad);
    }
}


