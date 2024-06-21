package model;

import java.io.InputStream;

public class Product {
    
    int id;
    String nombre;
    int Categoria;
    InputStream foto;
    String description;
    double precio;
    int stock;

    public Product() {
    }

    public Product(int id, String nombre, InputStream foto, String description, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.Categoria = Categoria;
        this.foto = foto;
        this.description = description;
        this.precio = precio;
        this.stock = stock;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int Categoria) {
        this.Categoria = Categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
