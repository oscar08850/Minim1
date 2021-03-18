import java.util.List;
import java.util.Queue;

public interface ProductManager {

    public Pedido addPedido (String producto, int cantidad, User usuario);
    public List<Productos> SortByPrice(); //Enviamos algo?
    public List<Productos> SortBySells(); //Enviamos??
    public List<Pedido> Realizados(User user); //String user? int id?
    public Queue<Pedido> Servir();


}
