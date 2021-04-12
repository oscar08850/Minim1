import java.util.List;
import java.util.Queue;

public interface ProductManager {

    public void addPedido (Pedido pedido);
    public List<Producto> sortByPrice(); //Enviamos algo?
    public List<Producto> sortBySells(); //Enviamos??
    public List<Pedido> realizados(User user); //String user? int id?
    public Pedido servir();


}
