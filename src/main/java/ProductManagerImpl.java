import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProductManagerImpl implements ProductManager {

    List<Producto> productoList;

    Queue<Pedido> pendingPedido;
    HashMap<String, User> usuarios;
    private static ProductManagerImpl manager;

    public static ProductManagerImpl getInstance()  /*Singletone, puerta de entrada a la instancia*/
    {
        if (manager==null) {
            manager = new ProductManagerImpl();
        }
        return manager;


    }




    /*

    Bocata 1 Alex
    cocacola 1 Alex


    //





    Queue<Pedido>
    List<Pedido>
    LinkedList<Producto>()
     */

    public ProductManagerImpl(){
        this.productoList = new LinkedList<Producto>();
        Producto producto1 = new Producto("Cocacola",2);
        Producto producto2 = new Producto("CafeLlet",1.5);
        Producto producto3 = new Producto("Donut",2.5);
        this.productoList.add(producto1);
        this.productoList.add(producto2);
        this.productoList.add(producto3);
        this.usuarios = new HashMap<String, User>();
        this.pendingPedido = new LinkedList<Pedido>();
    }


    /*
    public Pedido addPedido(List<String> listaProductos, int cantidad, User usuario) {
        //Pedido pedido1 = new Pedido()
        //pendingPedido.add();

        return null;
    }

     */


    public void addPedido(Pedido pedido) {
        this.pendingPedido.add(pedido);
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

    //me da el primer pedido de la lista
    public void processPedido(Pedido pedido){
        List<LP> listaAuxiliar = pedido.getLPs(); //
        System.out.println(listaAuxiliar);
        for(LP lp : listaAuxiliar){
            System.out.println(lp.producto);
            System.out.println(lp.cantidad);
            Producto producto = getProducto(lp.producto);
            producto.addVentas(lp.cantidad);
        }

    }


    public Pedido servir() {
        Pedido p = this.pendingPedido.remove(); // lista pedidos ---> el primer pedido = p
        processPedido(p); //2Cocacola 2 donuts // añadir vendas a cada producto
        return p;
    }

    private Producto getProducto(String nombreProducto){
        for(Producto p: this.productoList) {
            if(p.getProducto().equals(nombreProducto))
            return p;
        }
        return null;
    }
}