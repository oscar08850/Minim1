package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Pedido {

    private List<LP> productNames = new ArrayList<LP>();
    private String user;
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
