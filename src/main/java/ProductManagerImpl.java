import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProductManagerImpl implements ProductManager {

    List<Producto> productoList;

    public ProductManagerImpl(){
        this.productoList = new LinkedList<Producto>();
        Producto producto1 = new Producto("Cocacola",2);
        Producto producto2 = new Producto("CafeLlet",1.5);
        Producto producto3 = new Producto("Donut",2.5);
        this.productoList.add(producto1);
        this.productoList.add(producto2);
        this.productoList.add(producto3);
    }

    public Pedido addPedido(String producto, int cantidad, User usuario) {
        return null;
    }

    public List<Producto> sortByPrice() {
        //Ordenar
        // Collections.sort Java (Comparator)
        return this.productoList;
    }

    public List<Producto> sortBySells() {
        return null;
    }

    public List<Pedido> realizados(User user) {
        return null;
    }

    public Pedido servir() {
        Pedido p = this.pendingPedido.pop();
        processPedido(p); //2Cocacola 2 donuts // añadir vendas a cada producto
        return p;
    }
}
