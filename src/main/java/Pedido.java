import java.util.List;
import java.util.Queue;

public class Pedido {

    /*
    1       2       3        4
    pepe|||juan|||Carlos|||Victor||

    pepe: 2346 : COCACOLA
    juan: 2347 : Bocata
     */

    public int id;  //Hace falta???

    Queue<Productos> listaPedido;


    public void addProducto(Productos o){
        listaPedido.add(o);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Queue<Productos> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(Queue<Productos> listaPedido) {
        this.listaPedido = listaPedido;
    }

}
