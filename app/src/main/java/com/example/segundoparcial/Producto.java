package com.example.segundoparcial;

public class Producto {
    private String id;
    private String nombre;
    private String precio;
    private String costo;

    public Producto(String id, String nombre, String precio, String costo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.costo = costo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", costo=" + costo +
                '}';
    }
}
