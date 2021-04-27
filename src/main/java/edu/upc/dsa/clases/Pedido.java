package edu.upc.dsa.clases;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    public List<LP> productNames = new ArrayList<LP>();
    public String user;
    //

    public Pedido(){} // Constructor vacio

    public void addLP(String producto, int cantidad){
        LP liniaproducto = new LP(producto,cantidad);
        this.productNames.add(liniaproducto);
    }

    public List<LP> getLPs() {
        return productNames;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
