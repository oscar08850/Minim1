package edu.upc.dsa.clases;


public class LP { //extens Pedido

    public String producto;
    public int cantidad;

    public LP(String producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public LP(){}

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
