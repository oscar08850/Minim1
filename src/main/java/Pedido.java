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
    private List<String> productNames = new ArrayList<String>();
    private String user;
    //
    private int id;  //Hace falta???

    public Queue<Producto> listaPedido;

    public Pedido(String user, List<String> productNames){
        this.user = user;
        this.productNames = productNames;
    }


    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void addProducto(Producto o){
        listaPedido.add(o);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Queue<Producto> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(Queue<Producto> listaPedido) {
        this.listaPedido = listaPedido;
    }

}
