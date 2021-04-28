package edu.upc.dsa;

import edu.upc.dsa.clases.LP;
import edu.upc.dsa.clases.Pedido;
import edu.upc.dsa.clases.Producto;
import edu.upc.dsa.clases.User;
import java.util.*;
import org.apache.log4j.Logger;

public class ProductManagerImpl implements ProductManager {

    List<Producto> productoList = new LinkedList<Producto>();
    Queue<Pedido> pendingPedido = new LinkedList<Pedido>();
    HashMap<String, User> usuarios = new HashMap<String, User>();

    static final Logger logger = Logger.getLogger(ProductManagerImpl.class.getName());

    private static ProductManagerImpl manager;

    public static ProductManagerImpl getInstance()  /*Singletone, puerta de entrada a la instancia*/ {
        if (manager == null) {
            manager = new ProductManagerImpl();
        }
        return manager;
    }


    public static void delete(){
        manager = null;    //Permite reiniciar la base de datos
        logger.info("Instancia ProductManagerImpl borrada");
    }



    public ProductManagerImpl() {}

    public void muestraLista(){
        for(Producto p: this.productoList){
            logger.info("Producto: "+ p.getProducto());
            logger.info("Precio: "+ p.getPrecio());
            logger.info("Ventas: "+ p.getVentas());
        }
    }

    public void addProducto(Producto p){
        this.productoList.add(p);
    }

    public void addUser(User user) {
        usuarios.put(user.getUser(), user);
    }

    public User addUserById(String id){
        usuarios.put(id,getUser(id));
        User user = getUser(id);
        return user;
    }

    public void addPedido(Pedido pedido) {
        this.pendingPedido.add(pedido);
    }

    //Ordenar de forma ascendente
    public List<Producto> sortByPrice() {
        List<Producto> listaProductos = productoList;
        Collections.sort(listaProductos, new Comparator<Producto>() {
            public int compare(Producto o1, Producto o2) {
                return Double.compare(o1.getPrecio(),o2.getPrecio());
            }
        });
        return listaProductos;
    }

    public List<Producto> sortBySells() {
        List<Producto> listaProductos = productoList;
        Collections.sort(listaProductos, new Comparator<Producto>() {
            public int compare(Producto o1, Producto o2) {
                return Double.compare(o2.getVentas(),o1.getVentas());
            }
        });
        return listaProductos;
    }

    public List<Pedido> realizados(User user) {
        return null;
    }

    //me da el primer pedido de la lista
    public void processPedido(Pedido pedido) {
        List<LP> listaAuxiliar = pedido.getLPs(); //
        for (LP lp : listaAuxiliar) {
            logger.info("Sirviendo pedido: " + lp.producto + ", " + lp.cantidad);
            Producto producto = getProducto(lp.producto);
            producto.addVentas(lp.cantidad);
        }
    }

    public Pedido servir() {
        Pedido p = this.pendingPedido.remove(); // lista pedidos ---> el primer pedido = p
        processPedido(p); //2Cocacola 2 donuts // añadir vendas a cada producto
        User user = getUser(p.getUser());
        user.listaPedido.add(p);
        return p;
    }

    private Producto getProducto(String nombreProducto) {
        for (Producto p : this.productoList) {
            if (p.getProducto().equals(nombreProducto))
                return p;
        }
        return null;
    }

    private User getUser(String user) {
        User p = usuarios.get(user);
        return p;
        //<String ("1111"),Clases.User 1111>
    }

    public void getPedidoByUser(String user) {
        //Clases.User---->ListaPedidos--->ListaProductos
        User usuario = getUser(user);
        List<Pedido> pedidos = usuario.getListaPedido();
        int i = 0;
        for (Pedido p : pedidos) {
            List<LP> LProductos =  p.getLPs();
            i++;
            logger.info("Pedido " + i + " del cliente: " + user + " ");
            for (LP producto : LProductos){
                logger.info(producto.producto + ", " + producto.cantidad);
            }
        }
    }

    public List<Pedido> getPedidoUser(String user) {
        //Clases.User---->ListaPedidos--->ListaProductos
        User usuario = getUser(user);
        List<Pedido> pedidos = usuario.getListaPedido();
        return pedidos;
    }


    public void clear(){
        productoList.clear();
        usuarios.clear();
        pendingPedido.clear();
    }

    public int getUserSize(){
        return usuarios.size();
    }

    public int getProductosSize(){
        return productoList.size();
    }

    public int getPedidosSize(){
        return pendingPedido.size();
    }

    public Collection<User> usersDisp() { /* ??*/

        logger.info("Users disponibles antes del return");
        logger.info(usuarios.values());
        return this.usuarios.values();
    }

}


