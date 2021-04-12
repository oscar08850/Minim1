import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Pedido {

    /*
    1       2       3        4
    pepe|||juan|||Carlos|||Victor||

    pepe: 2346 : COCACOLA
    juan: 2347 : Bocata
     */

    //
    private List<LP> productNames = new ArrayList<LP>();
    private String user;
    //

/*
    public Pedido(String user, List<String> productNames){
        this.user = user;
        this.productNames = productNames;
    }

*/

    public Pedido(){

    }



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
