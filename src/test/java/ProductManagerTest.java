import edu.upc.dsa.clases.Pedido;
import edu.upc.dsa.clases.Producto;
import edu.upc.dsa.clases.User;
import edu.upc.dsa.ProductManager;
import edu.upc.dsa.ProductManagerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ProductManagerTest {

    ProductManager pm = ProductManagerImpl.getInstance(); // 3 comandas
    Pedido pedido1 = new Pedido();
    Pedido pedido2 = new Pedido();
    Pedido pedido3 = new Pedido();


    @Before
    public void init() {
        //Creamos los productos
        Producto producto1 = new Producto("Cocacola", 2); //Declaramos productos y precios
        Producto producto2 = new Producto("CafeLlet", 1.5);
        Producto producto3 = new Producto("Donut", 2.5);

        //Añadimos los productos (Carta)
        pm.addProducto(producto1);
        pm.addProducto(producto2);
        pm.addProducto(producto3);


        //Creamos los usuarios
        User usuario1 = new User("1111", 1);
        User usuario2 = new User("2222", 2);
        User usuario3 = new User("3333", 3);

        //Añadimos los usuarios al HashMap
        pm.addUser(usuario1);
        pm.addUser(usuario2);
        pm.addUser(usuario3);

        //Creamos Pedidos de prueba
        Pedido pedido1 = new Pedido();
        Pedido pedido2 = new Pedido();
        Pedido pedido3 = new Pedido();


    }

    @Test
    public void test1(){
        pedido1.addLP("Cocacola",2);
        pedido1.addLP("CafeLlet",3);
        pedido1.setUser("1111");
        //usuarios.put("1111",usuario1);

        pm.addPedido(pedido1); //Push1
        pm.servir();

    }

    @Test
    public void test2() {
        pm.muestraLista();

        pm.sortByPrice();
        pm.muestraLista();
    }

    @Test
    public void test3() {
        pedido1.addLP("Cocacola",2);
        pedido1.addLP("CafeLlet",3);
        pedido1.setUser("1111");
        pm.addPedido(pedido1); //Push1


        pedido2.addLP("Donut",6);
        pedido2.addLP("CafeLlet",7);
        pedido2.setUser("1111");
        pm.addPedido(pedido2); //Push2
        pm.servir();
        pm.servir();


        pm.getPedidoByUser("1111");

    }


    @After
    public void reset(){
        pm.clear();
    }
}
