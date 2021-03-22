import java.util.List;
import java.util.Queue;

public interface ProductManager {

    public Pedido addPedido (String producto, int cantidad, User usuario);
    public List<Producto> sortByPrice(); //Enviamos algo?
    public List<Producto> sortBySells(); //Enviamos??
    public List<Pedido> realizados(User user); //String user? int id?
    public Pedido servir();


}
