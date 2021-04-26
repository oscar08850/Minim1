package edu.upc.dsa.clases;

public class Producto {

    public String producto;
    public double precio;
    public int ventas = 0;

    public Producto(String producto, double precio){
        this.producto = producto;
        this.precio = precio;
    }

    public Producto(){}

    //Añadimos numero de ventas del producto
    public void addVentas(int ventas){
        this.ventas = this.ventas + ventas;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }



    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
}
