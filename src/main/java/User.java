import java.util.List;

public class User {

    public String user;
    public int id;

    public List<Pedido> listaPedido;

    public void setListaPedido(List<Pedido> listaPedido) {
        this.listaPedido = listaPedido;
    }

    public List<Pedido> getListaPedido(){
        return listaPedido;
    }


    public User(String user, int id){
        this.user = user;
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
