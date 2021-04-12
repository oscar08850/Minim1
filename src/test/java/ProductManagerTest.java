import java.util.List;

public class ProductManagerTest {

    public static void main(String[] args) {

        ProductManager pm = new ProductManagerImpl(); // 3 comandas

        List<Producto> productoList = pm.sortByPrice();

        for(Producto p: productoList){
            System.out.println(p.getProducto());
            System.out.println(p.getPrecio());
        }



        /*



        Pedido pedido = new Pedido();
        pedido.addLineaPedido(2,"CocaCola");
        pedido.addLineaPedido(3,"CafeLlet");
        pedido.setUser("1111");
        pm.addPedido(pedido); //Push1

        Pedido pedido2 = new Pedido();
        pedido2.addLineaPedido(4,"CocaCola");
        pedido2.addLineaPedido(1,"Donut");
        pedido2.setUser("2222");
        pm.addPedido(pedido2); //Push2

        Pedido pedido3 = pm.servir(); //Comanda feta per pedido1 (1111) //Pop1

        //List<Productos> productosList2 = pm.sortBySells();

        Pedido pedido4 = pm.servir();

        List<Productos> productosList2 = pm.sortBySells();

        List<Pedido> listaPedido1111 = pm.realizados("1111");
        */


    }
}
