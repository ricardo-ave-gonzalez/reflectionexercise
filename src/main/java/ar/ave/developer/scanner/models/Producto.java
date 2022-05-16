package ar.ave.developer.scanner.models;

public class Producto {
    
    private String codigo;
    private String nombre;
    private int stock;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "[" + this.getNombre() + ", " + this.getNombre() + "," + this.getStock() + "]";
    }
    
}
