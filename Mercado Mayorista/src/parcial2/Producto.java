package parcial2;

import java.util.Objects;

public class Producto {
    private String id;
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private Boolean esDeLujo;

    public Producto(String id, String nombre, Double precio, Integer cantidad, Boolean esDeLujo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.esDeLujo = esDeLujo;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean esDeLujo() {
        return esDeLujo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id.equals(producto.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}

