import Clases.Pedido;
import Clases.Producto;
import Clases.User;

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






    }
