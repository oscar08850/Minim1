package edu.upc.dsa;

import edu.upc.dsa.clases.Pedido;
import edu.upc.dsa.clases.Producto;
import edu.upc.dsa.clases.User;

import java.util.Collection;
import java.util.List;

public interface ProductManager {

    public void addPedido (Pedido pedido);
    public void addUser(User user);
    public List<Producto> sortByPrice(); //Enviamos algo?
    public List<Producto> sortBySells(); //Enviamos??
    public List<Pedido> realizados(User user); //String user? int id?
    public Pedido servir();
    public void getPedidoByUser(String user);
    public void addProducto(Producto p);
    public void clear();
    public void muestraLista();
    public int getUserSize();
    public int getProductosSize();
    public int getPedidosSize();
    public Collection<User> usersDisp();
    public User addUserById(String id);
    public List<Pedido> getPedidoUser(String user);






    }
